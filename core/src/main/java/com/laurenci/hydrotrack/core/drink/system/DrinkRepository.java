package com.laurenci.hydrotrack.core.drink.system;

import java.util.List;

import com.laurenci.hydrotrack.core.Repository;
import com.laurenci.hydrotrack.core.drink.DrinkType;

public interface DrinkRepository extends Repository<Drink, Long> {
    List<Drink> findByDrinkType(DrinkType drinkGroup);
    List<Drink> findAll();
}
