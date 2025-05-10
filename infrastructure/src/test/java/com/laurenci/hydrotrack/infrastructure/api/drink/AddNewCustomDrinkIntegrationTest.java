package com.laurenci.hydrotrack.infrastructure.api.drink;

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
public class AddNewCustomDrinkIntegrationTest {

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
    void shouldAddNewCustomDrink() throws Exception {
        String newDrinkJson = """
            {
                "userId": 1,
                "type": { "type": "Energy drink", "group": "ENERGY_DRINK" },
                "brand": "Hell",
                "name": "Hell Blueberry"
            }
        """;

        mockMvc.perform(post("/custom-drinks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newDrinkJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.brand").value("Hell"))
                .andExpect(jsonPath("$.name").value("Hell Blueberry"))
                .andExpect(jsonPath("$.type.group").value("ENERGY_DRINK"));
    }
}

