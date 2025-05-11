package com.laurenci.hydrotrack.service.record;

import java.time.LocalDateTime;

import com.laurenci.hydrotrack.core.drink.DrinkArea;

public record EditRecordDto(Long userId, Long drinkId, DrinkArea area, LocalDateTime date, Double amount) {
}
