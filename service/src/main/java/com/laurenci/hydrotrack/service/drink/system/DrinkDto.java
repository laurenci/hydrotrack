package com.laurenci.hydrotrack.service.drink.system;

import com.laurenci.hydrotrack.core.drink.DrinkType;

public record DrinkDto(Long id, DrinkType type, String brand, String name) {
}
