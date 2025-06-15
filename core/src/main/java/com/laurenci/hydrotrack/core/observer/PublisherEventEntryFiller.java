package com.laurenci.hydrotrack.core.observer;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PublisherEventEntryFiller<T, E extends  Enum<E>, S extends Subscriber<T>> {
    private PublisherBuilder<T, E, S> publisherBuilder;
    private List<S> eventSubscribers;
    private E event;

    public PublisherEventEntryFiller<T, E, S>addSubscriber(S subscriber) {
        eventSubscribers.add(subscriber);
        return this;
    }

    public PublisherBuilder<T, E, S> close() {
        return publisherBuilder.setEventEntry(event, eventSubscribers);
    }
}
