package com.laurenci.hydrotrack.core.calculation;

import lombok.Getter;

@Getter
public enum ActivityLevel {
    LOW(36),
    MODERATE(40),
    HIGH(46);

    private final int mlPerKg;

    ActivityLevel(int mlPerKg) {
        this.mlPerKg = mlPerKg;
    }
}
