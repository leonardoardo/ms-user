package com.ms.user.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.TransactionException;
import org.springframework.beans.BeanUtils;

import com.ms.user.core.domain.UserDomain;
import com.ms.user.core.ports.out.RepositoryPort;
import com.ms.user.infrastructure.model.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class UserRepository implements RepositoryPort {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDomain findUser(UUID id) {
        try {
            return this.entityManager.find(UserModel.class, id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<UserDomain> findUser() {
        return this.entityManager.createQuery("SELECT u FROM UserModel u").getResultList();
    }

    @Override
    @Transactional
    public UserDomain updateUser(UUID id, UserDomain userData) {
        UserModel user = this.entityManager.find(UserModel.class, id);
        BeanUtils.copyProperties(userData, user);
        this.entityManager.flush();
        return userData;
    }

    @Override
    @Transactional
    public int deleteUser(UUID id) {
        try {
            UserModel user = this.entityManager.find(UserModel.class, id);
            this.entityManager.remove(user);
            return 1;
        } catch (TransactionException exception) {
            return 0;
        }
    }

    @Override
    @Transactional
    public UserDomain saveUser(UserDomain userData) {
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userData, user);

        this.entityManager.persist(user);
        this.entityManager.flush();

        userData.setId(user.getId());
        return userData;
    }

}
