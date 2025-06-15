package com.laurenci.hydrotrack.core.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PublisherBuilder<T, E extends  Enum<E>, S extends Subscriber<T>> {
    private final Map<E, List<S>> subscribers = new TreeMap<>();
    public PublisherEventEntryFiller<T, E, S> addEventEntry(E event) {
        var list = subscribers.get(event);
        var newList = list == null ? new LinkedList<S>() : list;
        return new PublisherEventEntryFiller<>(this, newList, event);
    }

    public PublisherBuilder<T, E, S> setEventEntry(E event, List<S> subscribers) {
        this.subscribers.put(event, subscribers);
        return this;
    }

    public PublisherBuilder<T, E, S> addSubscribers(E event, List<S> subscribers) {
        var list = this.subscribers.get(event);
        if (list == null) {
            this.subscribers.put(event, subscribers);
        } else {
            list.addAll(subscribers);
        }
        return this;
    }

    public Publisher<T, E, S> build() {
        var newPublisher = new Publisher<T, E, S>();
        subscribers.forEach((event, list) ->
                list.forEach(subscriber -> newPublisher.addSubscriber(event, subscriber)));
        return newPublisher;
    }
}
