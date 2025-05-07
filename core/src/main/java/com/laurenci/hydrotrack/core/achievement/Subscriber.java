package com.laurenci.hydrotrack.core.achievement;

public interface Subscriber<T> {
    void update(T t);
}
