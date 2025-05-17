package com.laurenci.hydrotrack.core.calculation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AgeCorrectionCoefficient {
    public static Double getCoefficient(Integer age) {
        if (age == null || age < 0) {
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        }

        if (age < 30) return 1.0;
        if (age <= 54) return 0.95;
        if (age <= 65) return 0.90;
        return 0.85;
    }
}
