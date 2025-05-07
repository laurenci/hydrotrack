package com.laurenci.hydrotrack.service.drink.custom;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrinkRepository;
import com.laurenci.hydrotrack.core.drink.DrinkGroup;

@AllArgsConstructor
public class CustomDrinkService {
    private final CustomDrinkRepository repository;

    public CustomDrinkDto addNewCustomDrink(NewCustomDrinkDto newCustomDrink) {
        return null;
    }

    public List<CustomDrinkDto> getCustomDrinksByType(String type) {
        return null;
    }

    public List<CustomDrinkDto> getCustomDrinksByGroup(DrinkGroup group) {
        return null;
    }

    public CustomDrinkDto editCustomDrink(CustomDrinkDto editedCustomDrink) {
        return null;
    }

    public void deleteCustomDrinkById(Long customDrinkId) {

    }
}
