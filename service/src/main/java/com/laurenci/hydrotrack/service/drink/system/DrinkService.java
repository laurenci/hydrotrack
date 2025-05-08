package com.laurenci.hydrotrack.service.drink.system;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.drink.DrinkGroup;
import com.laurenci.hydrotrack.core.drink.system.DrinkRepository;

@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository repository;

    public List<DrinkDto> getDrinksByType(String type) {
        return repository.findByType(type).stream()
                .map(DrinkMapper.INSTANCE::fromModelToDto)
                .toList();
    }

    public List<DrinkDto> getDrinksByGroup(String group) {
        return repository.findByGroup(group).stream()
                .map(DrinkMapper.INSTANCE::fromModelToDto)
                .toList();
    }
}
