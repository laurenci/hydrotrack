package com.laurenci.hydrotrack.infrastructure.api.drink.system;

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
public class SearchDrinksIntegrationTest {

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
    void shouldReturnDrinksByTypeOnly() throws Exception {
        mockMvc.perform(get("/drinks/search")
                        .param("type", "Green Tea"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].type.type", everyItem(is("Green Tea"))));
    }

    @Test
    void shouldReturnDrinksByGroupOnly() throws Exception {
        mockMvc.perform(get("/drinks/search")
                        .param("group", "BASIC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].type.group", everyItem(is("BASIC"))));
    }

    @Test
    void shouldReturnDrinksByTypeAndGroup() throws Exception {
        mockMvc.perform(get("/drinks/search")
                        .param("type", "Orange Juice")
                        .param("group", "BASIC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].type.type", everyItem(is("Orange Juice"))))
                .andExpect(jsonPath("$[*].type.group", everyItem(is("BASIC"))));
    }

    @Test
    void shouldReturnEmptyWhenNoMatchingDrinks() throws Exception {
        mockMvc.perform(get("/drinks/search")
                        .param("type", "Nonexistent")
                        .param("group", "COFFEE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isEmpty());
    }

    @Test
    void shouldReturnAllDrinksWhenNoParamsProvided() throws Exception {
        mockMvc.perform(get("/drinks/search"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty());
    }
}
