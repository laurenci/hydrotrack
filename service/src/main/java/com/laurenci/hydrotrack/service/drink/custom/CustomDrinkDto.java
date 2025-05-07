package com.laurenci.hydrotrack.service.drink.custom;

import com.laurenci.hydrotrack.service.drink.DrinkTypeDto;

public record CustomDrinkDto(Long id, Long userId, DrinkTypeDto type, String brand, String name) {
}
