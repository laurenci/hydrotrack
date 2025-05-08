package com.laurenci.hydrotrack.infrastructure.dal.drink.custom;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrink;
import com.laurenci.hydrotrack.core.drink.custom.CustomDrinkRepository;

@Repository
@AllArgsConstructor
public class ConcreteCustomDrinkRepository implements CustomDrinkRepository {
    private final CustomDrinkRepositoryJpa drinkRepositoryJpa;

    @Override
    public CustomDrink create(CustomDrink drink) {
        return CustomDrinkMapper.INSTANCE.fromEntityToModel(
                drinkRepositoryJpa.save(CustomDrinkMapper.INSTANCE.fromModelToEntity(drink))
        );
    }

    @Override
    public CustomDrink readById(Long id) {
        return CustomDrinkMapper.INSTANCE.fromEntityToModel(
                drinkRepositoryJpa.findById(id).orElseThrow()
        );
    }

    @Override
    public CustomDrink update(CustomDrink drink) {
        return CustomDrinkMapper.INSTANCE.fromEntityToModel(
                drinkRepositoryJpa.save(CustomDrinkMapper.INSTANCE.fromModelToEntity(drink))
        );
    }

    @Override
    public CustomDrink deleteById(Long id) {
        var deleted = readById(id);
        drinkRepositoryJpa.deleteById(id);
        return deleted;
    }

    @Override
    public List<CustomDrink> findByType(String type) {
        return drinkRepositoryJpa.findByType(type).stream()
                .map(CustomDrinkMapper.INSTANCE::fromEntityToModel)
                .toList();
    }

    @Override
    public List<CustomDrink> findByGroup(String group) {
        return drinkRepositoryJpa.findByGroup(group).stream()
                .map(CustomDrinkMapper.INSTANCE::fromEntityToModel)
                .toList();
    }
}
