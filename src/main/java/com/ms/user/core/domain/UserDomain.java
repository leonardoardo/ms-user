package com.ms.user.core.domain;

import java.util.UUID;

public class UserDomain {
    UUID id;
    String email;
    String name;

    public UserDomain() {
    }

    public UserDomain(String email, String name) {
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
