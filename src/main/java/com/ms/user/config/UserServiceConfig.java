package com.ms.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.user.core.ports.out.RepositoryPort;
import com.ms.user.infrastructure.repository.UserRepository;

@Configuration
public class UserServiceConfig {

    @Bean
    RepositoryPort userRepositoryInject() {
        return new UserRepository();
    }
}
