package com.laurenci.hydrotrack.service.drink.custom;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.core.drink.custom.CustomDrinkRepository;

@AllArgsConstructor
public class CustomDrinkService {
    private final CustomDrinkRepository repository;

    public CustomDrinkDto addNewCustomDrink(NewCustomDrinkDto newCustomDrink) {
        return CustomDrinkMapper.INSTANCE.fromModelToDto(
                repository.create(CustomDrinkMapper.INSTANCE.fromNewDtoToModel(newCustomDrink))
        );
    }

    public List<CustomDrinkDto> getCustomDrinksByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(CustomDrinkMapper.INSTANCE::fromModelToDto)
                .toList();
    }

    public List<CustomDrinkDto> getCustomDrinksByUserIdAndDrinkType(Long userId, DrinkType drinkType) {
        return repository.findByUserIdAndDrinkType(userId, drinkType).stream()
                .map(CustomDrinkMapper.INSTANCE::fromModelToDto)
                .toList();
    }

    public CustomDrinkDto editCustomDrink(CustomDrinkDto editedCustomDrink) {
        return CustomDrinkMapper.INSTANCE.fromModelToDto(
                repository.update(CustomDrinkMapper.INSTANCE.fromDtoToModel(editedCustomDrink))
        );
    }

    public void deleteCustomDrinkById(Long customDrinkId) {
        repository.deleteById(customDrinkId);
    }
}
