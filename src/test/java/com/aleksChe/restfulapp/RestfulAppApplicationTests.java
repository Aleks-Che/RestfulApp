package com.aleksChe.restfulapp;

import com.aleksChe.restfulapp.controller.LogController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class RestfulAppApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LogController logController;

    @Test
    @Sql(value = {"/delete-log.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/delete-log.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void sendLogTest() throws Exception {
        assertThat(logController).isNotNull();
        this.mockMvc.perform(post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"Test message\",\"type\":\"test type\",\"level\":\"low\"}"))
                .andExpect(status()
                        .isOk());
        this.mockMvc.perform(get("/log/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"message\":\"Test message\",\"type\":\"test type\",\"level\":\"low\",\"time\":null,\"hibernateLazyInitializer\"}"));
    }
}
