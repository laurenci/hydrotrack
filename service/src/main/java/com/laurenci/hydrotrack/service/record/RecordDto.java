package com.laurenci.hydrotrack.service.record;

import java.time.LocalDateTime;

import com.laurenci.hydrotrack.core.drink.DrinkArea;
import com.laurenci.hydrotrack.core.drink.DrinkType;

public record RecordDto(Long userId, Long drinkId, RecordDrinkDataDto drinkData, DrinkArea area, LocalDateTime date, Double amount) {
    public record RecordDrinkDataDto(DrinkType type, String brand, String name) {
    }
}