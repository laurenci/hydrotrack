package com.laurenci.hydrotrack.core.achievement;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Publisher<T, E extends  Enum<E>, S extends Subscriber<T>> {
    private final Map<E, List<S>> subscribers = new TreeMap<>();

    public void addSubscriber(E event, S subscriber) {
        subscribers.compute(event, (existedEvent, list) -> {
            var newList = list == null ? new LinkedList<S>() : list;
            newList.add(subscriber);
            return newList;
        });
    }

    public void notifySubscribers(T t, E event) {
        subscribers.get(event).forEach(subscriber -> subscriber.update(t));
    }
}
