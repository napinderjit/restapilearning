package com.learning.restapilearning.model;

import javax.persistence.Entity;
import java.util.Date;

public class User {

    private Long id;
    private String name;
    private Date birthdate;

    public User(Long id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
