package com.laurenci.hydrotrack.infrastructure.api.drink.custom;

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
public class EditCustomDrinkIntegrationTest {

    @Container
    static final MariaDBContainer<?> mariaDB = new MariaDBContainer<>("mariadb:10.5")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void setDatasourceProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariaDB::getJdbcUrl);
        registry.add("spring.datasource.username", mariaDB::getUsername);
        registry.add("spring.datasource.password", mariaDB::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldEditCustomDrink() throws Exception {
        String updatedDrink = """
            {
              "id": 2,
              "userId": 2,
              "type": {
                "type": "Cold Brew",
                "group": "COFFEE"
              },
              "brand": "Updated Brand",
              "name": "Updated Cold Brew"
            }
        """;

        mockMvc.perform(put("/custom-drinks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedDrink))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Cold Brew"))
                .andExpect(jsonPath("$.brand").value("Updated Brand"));
    }
}