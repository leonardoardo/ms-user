package com.ms.user.application.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.core.domain.UserDomain;
import com.ms.user.core.dto.CreateUserRecordDto;
import com.ms.user.core.dto.UpdateUserRecordDto;
import com.ms.user.core.ports.in.UserHttpPort;
import com.ms.user.core.useCases.UserUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/")
public class UserControllerAdapter implements UserHttpPort {
    public final UserUseCase useCase;

    public UserControllerAdapter(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public UserDomain save(@Valid CreateUserRecordDto userData) {
        UserDomain user = new UserDomain(userData.email(), userData.name());
        return this.useCase.saveUser(user);
    }

    @Override
    public List<UserDomain> getAll() {
        return this.useCase.getUsers();
    }

    @Override
    public UserDomain getUserById(UUID id) {
        return this.useCase.getUserById(id);
    }

    @Override
    public UserDomain updateUserById(UUID id, @Valid UpdateUserRecordDto userData) {
        UserDomain user = new UserDomain();

        user.setId(id);

        if (!userData.email().isEmpty()) {
            user.setEmail(userData.email());
        }

        if (!userData.name().isEmpty()) {
            user.setName(userData.name());
        }

        this.useCase.updateUser(user);

        return user;
    }

    @Override
    public int deleteUserById(UUID id) {
        return this.useCase.deleteUserById(id);
    }

    // @PostMapping("/users")
    // public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto
    // userRecordDto) {
    // var userModel = new UserModel();
    // BeanUtils.copyProperties(userRecordDto, userModel);

    // return
    // ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(userModel));
    // }
}
