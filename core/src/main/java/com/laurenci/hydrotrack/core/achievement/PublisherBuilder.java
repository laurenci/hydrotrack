package com.laurenci.hydrotrack.core.achievement;

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
}
