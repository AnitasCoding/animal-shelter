package de.animalshelter.dao;

import de.animalshelter.model.Logincredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Logincredentials, Long> {

    Logincredentials findByName(String name);
}
