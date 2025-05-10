package com.laurenci.hydrotrack.infrastructure.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "HydroTrack API",
                version = "1.0",
                description = "API documentation for HydroTrack backend"
        )
)
@Configuration
public class OpenApiConfig {
}
