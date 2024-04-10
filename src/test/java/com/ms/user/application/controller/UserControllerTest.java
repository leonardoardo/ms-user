package com.ms.user.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.ms.user.core.dto.CreateUserRecordDto;

import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest()
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUser() throws Exception {
        CreateUserRecordDto user = new CreateUserRecordDto("teste@gmail.com", "teste");
        String jsonRequest = objectMapper.writeValueAsString(user);

        this.mockMvc.perform(post("/user/").contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("teste"))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void createUserWithInvalidEmail() throws Exception {
        CreateUserRecordDto user = new CreateUserRecordDto("teste.com", "teste email invalido");
        String jsonRequest = objectMapper.writeValueAsString(user);

        ResultActions createUserAction = this.mockMvc
                .perform(post("/user/").contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getUserById() throws Exception {
        CreateUserRecordDto user = new CreateUserRecordDto("teste@gmail.com", "teste");
        String jsonRequest = objectMapper.writeValueAsString(user);

        ResultActions createUserAction = this.mockMvc
                .perform(post("/user/").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));

        String createResponse = createUserAction.andReturn().getResponse().getContentAsString();
        String userIdString = JsonPath.parse(createResponse).read("$.id", String.class);
        UUID userId = UUID.fromString(userIdString);

        this.mockMvc.perform(get("/user/" + userId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId.toString()))
                .andExpect(jsonPath("$.email").value(user.email()));
    }

    @Test
    void getAllUsers() throws Exception {
        this.mockMvc
                .perform(get("/user/")).andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
        ;
    }
}
