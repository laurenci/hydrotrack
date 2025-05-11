package com.laurenci.hydrotrack.infrastructure.api.record;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laurenci.hydrotrack.core.record.RecordId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class DeleteRecordIntegrationTest {

    @Container
    static final MariaDBContainer<?> mariaDB = new MariaDBContainer<>("mariadb:lts")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureDatasource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariaDB::getJdbcUrl);
        registry.add("spring.datasource.username", mariaDB::getUsername);
        registry.add("spring.datasource.password", mariaDB::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldDeleteRecordSuccessfully() throws Exception {
        var recordId = new RecordId();
        recordId.setUserId(1L);
        recordId.setDrinkId(1L);
        recordId.setDate(LocalDateTime.of(2025, 5, 10, 8, 15));

        mockMvc.perform(delete("/records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recordId)))
                .andExpect(status().isNoContent());
    }

    @Disabled
    @Test
    void shouldNotDeleteNonexistentRecord() throws Exception {// Doesn't exist
        var nonExistentRecordId = new RecordId();
        nonExistentRecordId.setUserId(999L);
        nonExistentRecordId.setDrinkId(20L);
        nonExistentRecordId.setDate(LocalDateTime.MAX);

        mockMvc.perform(delete("/records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nonExistentRecordId)))
                .andExpect(status().isNotFound());
    }

}