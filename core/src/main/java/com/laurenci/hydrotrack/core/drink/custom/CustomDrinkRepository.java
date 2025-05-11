package com.laurenci.hydrotrack.core.drink.custom;

import java.util.List;

import com.laurenci.hydrotrack.core.Repository;
import com.laurenci.hydrotrack.core.drink.DrinkType;

public interface CustomDrinkRepository extends Repository<CustomDrink, Long> {
    List<CustomDrink> findByUserId(Long userId);
    List<CustomDrink> findByUserIdAndDrinkType(Long userId, DrinkType drinkType);
}
