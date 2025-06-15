package com.laurenci.hydrotrack.infrastructure.messaging.nats;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.laurenci.hydrotrack.core.messaging.MessageBrokerService;

@Service
@RequiredArgsConstructor
public class NatsMessageBrokerService implements MessageBrokerService<MessageHandler> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NatsMessageBrokerService.class);
    private final Connection connection;
    private Dispatcher dispatcher;

    @Override
    public void publish(String subject, String message) {
        connection.publish(subject, message.getBytes());
        LOGGER.info("Published message to subject {}: {}", subject, message);
    }

    @Override
    public void subscribe(String subject, MessageHandler handler) {
        initDispatcher().subscribe(subject, handler);
    }

    private Dispatcher initDispatcher() {
        if (dispatcher == null) {
            dispatcher = connection.createDispatcher();
        }
        return dispatcher;
    }
}
