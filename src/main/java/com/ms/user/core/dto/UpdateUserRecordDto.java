package com.ms.user.core.dto;

import jakarta.validation.constraints.Email;

public record UpdateUserRecordDto(@Email String email, String name) {
}