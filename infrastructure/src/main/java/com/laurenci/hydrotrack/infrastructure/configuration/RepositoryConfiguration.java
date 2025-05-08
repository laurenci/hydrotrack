package com.laurenci.hydrotrack.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.laurenci.hydrotrack.infrastructure.dal")
@EnableJpaRepositories("com.laurenci.hydrotrack.infrastructure.dal")
public class RepositoryConfiguration {
}
