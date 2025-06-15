package com.laurenci.hydrotrack.core.observer;

public interface Subscriber<T> {
    void update(T t);
}
