package com.laurenci.hydrotrack.infrastructure.configuration;

import java.io.IOException;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NatsConfiguration {

    @Value("${messaging.nats.url}")
    private String natsUrl;

    @Bean
    public Connection natsConnection() throws IOException, InterruptedException {
        Options options = new Options.Builder()
                .server(natsUrl)
                .build();
        return Nats.connect(options);
    }
}
