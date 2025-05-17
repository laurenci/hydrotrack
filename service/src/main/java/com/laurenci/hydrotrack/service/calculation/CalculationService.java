package com.laurenci.hydrotrack.service.calculation;

import static com.laurenci.hydrotrack.core.calculation.AgeCorrectionCoefficient.getCoefficient;

public class CalculationService {
    public Double determineDailyAmount(BodyInfoDto bodyInfoDto) {
        return bodyInfoDto.activityLevel().getMlPerKg() * getCoefficient(bodyInfoDto.age()) * bodyInfoDto.weight();
    }
}
