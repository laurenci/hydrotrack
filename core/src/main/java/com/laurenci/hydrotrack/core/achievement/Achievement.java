package com.laurenci.hydrotrack.core.achievement;

public abstract class Achievement implements Subscriber<Long> {
    @Override
    public abstract void update(Long userId);
}
