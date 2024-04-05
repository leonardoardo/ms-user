package com.ms.user.core.ports.out;

import java.util.List;
import java.util.UUID;

import com.ms.user.core.domain.UserDomain;

public interface RepositoryPort {
    public UserDomain findUser(UUID id);

    public List<UserDomain> findUser();

    public UserDomain updateUser(UUID id, UserDomain userData);

    public int deleteUser(UUID id);

    public UserDomain saveUser(UserDomain userData);
}
