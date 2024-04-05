package com.ms.user.core.ports.in;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.user.core.domain.UserDomain;
import com.ms.user.core.dto.CreateUserRecordDto;
import com.ms.user.core.dto.UpdateUserRecordDto;

import jakarta.validation.Valid;

public interface UserHttpPort {
    @PostMapping("/")
    public UserDomain save(@Valid @RequestBody CreateUserRecordDto userData);

    @GetMapping("/")
    public List<UserDomain> getAll();

    @GetMapping("/{id}")
    public UserDomain getUserById(@PathVariable UUID id);

    @PatchMapping("/{id}")
    public UserDomain updateUserById(@PathVariable UUID id, @Valid @RequestBody UpdateUserRecordDto userData);

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable UUID id);
}