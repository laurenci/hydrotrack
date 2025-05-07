package com.laurenci.hydrotrack.service.drink.system;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.drink.DrinkGroup;
import com.laurenci.hydrotrack.core.drink.system.DrinkRepository;

@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository repository;

    public List<DrinkDto> getDrinksByType(String type) {
        return null;
    }

    public List<DrinkDto> getDrinksByGroup(DrinkGroup group) {
        return null;
    }
}
