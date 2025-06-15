package com.laurenci.hydrotrack.service.record;

import com.laurenci.hydrotrack.core.drink.DrinkArea;

public record NewRecordDto(Long userId, Long drinkId, DrinkArea area, Double amount) {
}
