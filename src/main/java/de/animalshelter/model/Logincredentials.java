package de.animalshelter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Logincredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lid;
    private String name;
    private String password;

    public Logincredentials(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Logincredentials() {

    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
