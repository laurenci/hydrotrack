package com.laurenci.hydrotrack.service.drink.custom;

import com.laurenci.hydrotrack.core.drink.DrinkType;

public record CustomDrinkDto(Long id, Long userId, DrinkType type, String brand, String name) {
}
