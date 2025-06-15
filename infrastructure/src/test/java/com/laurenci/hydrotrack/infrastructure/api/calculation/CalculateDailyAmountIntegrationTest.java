package com.laurenci.hydrotrack.infrastructure.api.calculation;

import com.laurenci.hydrotrack.core.user.User;
import com.laurenci.hydrotrack.core.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class CalculateDailyAmountIntegrationTest {

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
    void shouldCalculateDailyAmount() throws Exception {
        String bodyInfo = """
                    {
                        "age": 21,
                        "weight": 73,
                        "activityLevel": "HIGH"
                    }
                """;

        mockMvc.perform(post("/calculations/daily-amount")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyInfo))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    try {
                        Double.parseDouble(result.getResponse().getContentAsString());
                    } catch (NumberFormatException e) {
                        throw new AssertionError("Expected a double value in response", e);
                    }
                });
    }
}

