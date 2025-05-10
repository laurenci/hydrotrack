package com.laurenci.hydrotrack.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.laurenci.hydrotrack.infrastructure.dal")
@EnableTransactionManagement
@EnableJpaRepositories("com.laurenci.hydrotrack.infrastructure.dal")
public class RepositoryConfiguration {
}
