package com.ms.user.core.useCases;

import java.util.List;
import java.util.UUID;

import com.ms.user.core.domain.UserDomain;

public interface UserUseCase {
    UserDomain getUserById(UUID id);

    List<UserDomain> getUsers();

    int deleteUserById(UUID id);

    UserDomain saveUser(UserDomain user);

    int updateUser(UserDomain user);
}
