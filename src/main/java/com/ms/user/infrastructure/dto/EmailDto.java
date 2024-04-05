package com.ms.user.infrastructure.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class EmailDto {
    String emailTo;
    String subject;
    String text;
    UUID userId;
}
