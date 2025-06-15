package com.laurenci.hydrotrack.core.observer.achievement;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.observer.Subscriber;

@AllArgsConstructor
public abstract class Achievement implements Subscriber<Long> {
    protected final String name;
    protected final String description;

    @Override
    public abstract void update(Long userId);
}
