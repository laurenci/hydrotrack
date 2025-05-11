package com.laurenci.hydrotrack.service.drink.custom;

import com.laurenci.hydrotrack.core.drink.DrinkType;

public record NewCustomDrinkDto(Long userId, DrinkType type, String brand, String name) {
}
