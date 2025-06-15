package com.laurenci.hydrotrack.infrastructure.api.record;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.service.record.RecordDto;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
public class SearchUserRecordsByPeriodOfTimeTest {
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
    void shouldReturnRecordsForUserIdWithinDateRange() throws Exception {
        Long userId = 1L;
        LocalDateTime from = LocalDateTime.of(2025, 5, 10, 0, 0);
        LocalDateTime to = LocalDateTime.of(2025, 5, 10, 23, 59);

        var result = mockMvc.perform(get("/users/{id}/records/search", userId)
                        .param("from", from.format(DateTimeFormatter.ISO_DATE_TIME))
                        .param("to", to.format(DateTimeFormatter.ISO_DATE_TIME)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[*].userId", everyItem(is(userId.intValue()))))
                .andReturn()
                .getResponse()
                .getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<RecordDto> records = mapper.readValue(result, new TypeReference<>() {});

        for (RecordDto record : records) {
            assertThat(record.date()).isAfter(from).isBefore(to);
        }
    }
}
