package com.laurenci.hydrotrack.infrastructure.api.record;

import com.laurenci.hydrotrack.core.record.RecordId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class GetRecordByIdIntegrationTest {

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

    @Test
    void shouldReturnRecordByCompositeId() throws Exception {
        RecordId id = new RecordId();
        id.setUserId(1L);
        id.setDrinkId(1L);
        id.setDate(LocalDateTime.of(2025, 5, 10, 18, 10, 0));

        mockMvc.perform(get("/records")
                        .param("userId", id.getUserId().toString())
                        .param("drinkId", id.getDrinkId().toString())
                        .param("date",id.getDate().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(id.getUserId()))
                .andExpect(jsonPath("$.drinkId").value(id.getDrinkId()))
                .andExpect(jsonPath("$.date").value(id.getDate().format(DateTimeFormatter.ISO_DATE_TIME)))
                .andExpect(jsonPath("$.area").value("CUSTOM"))
                .andExpect(jsonPath("$.amount").value(0.2))

                // DrinkData nested object
                .andExpect(jsonPath("$.drinkData.type.type").value("Chamomile"))
                .andExpect(jsonPath("$.drinkData.type.group").value("TEA"))
                .andExpect(jsonPath("$.drinkData.brand").isEmpty())
                .andExpect(jsonPath("$.drinkData.name").value("Chamomile Relax"));
    }
}