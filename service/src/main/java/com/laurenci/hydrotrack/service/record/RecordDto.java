package com.laurenci.hydrotrack.service.record;

import com.laurenci.hydrotrack.core.drink.DrinkArea;
import com.laurenci.hydrotrack.service.drink.system.DrinkDto;

import java.time.LocalDateTime;

public record RecordDto(Long userId, DrinkDto drinkDto, DrinkArea area, LocalDateTime date, Double amount) {
}
