package com.laurenci.hydrotrack.infrastructure.api.drink.custom;

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

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class SearchCustomDrinksIntegrationTest {

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
    void shouldReturnCustomDrinksByUserId() throws Exception {
        mockMvc.perform(get("/users/1/custom-drinks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].userId", everyItem(is(1))));
    }

    @Test
    void shouldReturnAllWhenNoParamsProvided() throws Exception {
        mockMvc.perform(get("/users/1/custom-drinks/search"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty());
    }

    @Test
    void shouldReturnCustomDrinksByTypeOnly() throws Exception {
        mockMvc.perform(get("/users/1/custom-drinks/search")
                        .param("type", "Chamomile"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].type.type", everyItem(is("Chamomile"))));
    }

    @Test
    void shouldReturnCustomDrinksByGroupOnly() throws Exception {
        mockMvc.perform(get("/users/1/custom-drinks/search")
                        .param("group", "TEA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].type.group", everyItem(is("TEA"))));
    }

    @Test
    void shouldReturnCustomDrinksByTypeAndGroup() throws Exception {
        mockMvc.perform(get("/users/1/custom-drinks/search")
                        .param("type", "Chamomile")
                        .param("group", "TEA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].type.type", everyItem(is("Chamomile"))))
                .andExpect(jsonPath("$[*].type.group", everyItem(is("TEA"))));
    }

    @Test
    void shouldReturnEmptyWhenNothingMatches() throws Exception {
        mockMvc.perform(get("/users/1/custom-drinks/search")
                        .param("type", "Nonexistent")
                        .param("group", "COFFEE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isEmpty());
    }
}
