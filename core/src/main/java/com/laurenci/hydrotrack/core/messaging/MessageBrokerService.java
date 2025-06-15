package com.laurenci.hydrotrack.core.messaging;

public interface MessageBrokerService<T> {
    void publish(String subject, String message);
    void subscribe(String subject, T handler);
}
