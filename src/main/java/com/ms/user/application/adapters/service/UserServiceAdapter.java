package com.ms.user.application.adapters.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ms.user.core.domain.UserDomain;
import com.ms.user.core.ports.out.QueuePort;
import com.ms.user.core.ports.out.RepositoryPort;
import com.ms.user.core.useCases.UserUseCase;

@Service
public class UserServiceAdapter implements UserUseCase {

    final RepositoryPort userRepository;
    final QueuePort emailProducer;

    public UserServiceAdapter(RepositoryPort userRepository, @Qualifier("queuePortBean") QueuePort emailProducer) {
        this.userRepository = userRepository;
        this.emailProducer = emailProducer;
    }

    @Override
    public UserDomain getUserById(UUID id) {

        try {
            if (id.equals(null)) {
                throw new Exception("Id is required");
            }

            var user = this.userRepository.findUser(id);

            if (user == null) {
                throw new Exception(String.format("User not found for id %s", id));
            }

            return user;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<UserDomain> getUsers() {
        return this.userRepository.findUser();
    }

    @Override
    public int deleteUserById(UUID id) {
        int deleteCount = 0;

        try {

            if (id.equals(null)) {
                throw new Exception("Id is required for delete operations");
            }

            this.userRepository.deleteUser(id);

            deleteCount += 1;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return deleteCount;
    }

    @Override
    public UserDomain saveUser(UserDomain user) {
        try {
            UserDomain newUser = this.userRepository.saveUser(user);
            this.emailProducer.publicMessage(newUser);
            return newUser;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public int updateUser(UserDomain user) {
        int updateCount = 0;

        try {
            this.userRepository.updateUser(user.getId(), user);
            updateCount += 1;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return updateCount;
    }
}
