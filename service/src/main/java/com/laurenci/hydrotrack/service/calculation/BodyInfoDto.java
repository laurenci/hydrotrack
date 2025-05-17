package com.laurenci.hydrotrack.service.calculation;

import com.laurenci.hydrotrack.core.calculation.ActivityLevel;

public record BodyInfoDto(Integer age, Double weight, ActivityLevel activityLevel) {
}
