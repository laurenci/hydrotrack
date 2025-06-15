package com.laurenci.hydrotrack.infrastructure.api.user;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class EditUserIntegrationTest {

    @Container
    static MariaDBContainer<?> mariaDB = new MariaDBContainer<>("mariadb:lts")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariaDB::getJdbcUrl);
        registry.add("spring.datasource.username", mariaDB::getUsername);
        registry.add("spring.datasource.password", mariaDB::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldEditUser() throws Exception {
        String updatedUser = """
                    {
                        "id": 1,
                        "username": "newName",
                        "expectedDailyAmount": 3123.02,
                        "profile": {
                           "firstName": "string",
                           "lastName": "string",
                           "sex": "MALE"
                        }
                    }
                """;

        mockMvc.perform(put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedUser))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("newName"))
                .andExpect(jsonPath("$.profile.firstName").value("string"))
                .andExpect(jsonPath("$.profile.lastName").value("string"))
                .andExpect(jsonPath("$.profile.sex").value("MALE"));
    }
}
