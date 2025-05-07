package com.laurenci.hydrotrack.core.drink;

import java.util.List;

import com.laurenci.hydrotrack.core.Repository;
import com.laurenci.hydrotrack.core.drink.system.Drink;

public interface GeneralDrinkRepository<T extends Drink> extends Repository<T, Long> {
    List<T> findByType(String type);
    List<T> findByGroup(String group);
}
