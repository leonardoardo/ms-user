package com.ms.user.infrastructure.model;

import java.io.Serializable;
import java.util.UUID;

import com.ms.user.core.domain.UserDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "TB_USERS")
@Entity
@Setter
@Getter
public class UserModel extends UserDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    String email;

    String name;

    public UserModel(UUID id) {
        this.id = id;
    }

    public UserModel() {
    }
}
