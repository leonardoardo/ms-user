package com.ms.user.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRecordDto(@NotBlank(message = "Email is required") @Email(message = "Should be a valid email") String email, @NotBlank(message = "Name is required") String name) {
}
