package com.laurenci.hydrotrack.service.drink.system;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.core.drink.system.DrinkRepository;

@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository repository;

    public List<DrinkDto> getDrinksByDrinkType(DrinkType drinkType) {
        return repository.findByDrinkType(drinkType).stream()
                .map(DrinkMapper.INSTANCE::fromModelToDto)
                .toList();
    }
}
