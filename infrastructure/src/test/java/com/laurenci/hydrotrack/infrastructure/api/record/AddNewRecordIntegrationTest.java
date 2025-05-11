package com.laurenci.hydrotrack.infrastructure.api.record;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laurenci.hydrotrack.core.drink.DrinkArea;
import com.laurenci.hydrotrack.service.record.NewRecordDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class AddNewRecordIntegrationTest {

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
        registry.add("spring.datasource.driver-class-name", mariaDB::getDriverClassName);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAddNewRecordSuccessfully() throws Exception {
        NewRecordDto request = new NewRecordDto(
                1L,        // userId - john_doe
                2L,        // drinkId - Orange Juice
                DrinkArea.SYSTEM,
                0.33
        );

        mockMvc.perform(post("/records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value(1L))
                .andExpect(jsonPath("$.drinkData.name").value("Orange Juice"))
                .andExpect(jsonPath("$.drinkData.brand").value("Tropicana"))
                .andExpect(jsonPath("$.drinkData.type.type").value("Orange Juice"))
                .andExpect(jsonPath("$.drinkData.type.group").value("BASIC"))
                .andExpect(jsonPath("$.amount").value(0.33))
                .andExpect(jsonPath("$.area").value("SYSTEM"))
                .andExpect(jsonPath("$.date").exists());
    }
}
