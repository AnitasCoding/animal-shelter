package de.animalshelter.dao;

import de.animalshelter.model.Logincredentials;
import de.animalshelter.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserPrincipal loadUserByUsername(String name) throws UsernameNotFoundException {
        Logincredentials loginCredentials = repository.findByName(name);

        if (loginCredentials == null) {
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(loginCredentials);
    }
}
