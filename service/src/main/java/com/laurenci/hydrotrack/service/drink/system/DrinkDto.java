package com.laurenci.hydrotrack.service.drink.system;

import com.laurenci.hydrotrack.service.drink.DrinkTypeDto;

public record DrinkDto(Long id, DrinkTypeDto type, String brand, String name) {
}
