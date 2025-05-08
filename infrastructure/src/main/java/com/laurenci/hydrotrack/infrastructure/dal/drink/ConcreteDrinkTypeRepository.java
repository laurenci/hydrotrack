package com.laurenci.hydrotrack.infrastructure.dal.drink;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.core.drink.DrinkTypeRepository;

@Repository
@AllArgsConstructor
public class ConcreteDrinkTypeRepository implements DrinkTypeRepository {
    private final DrinkTypeRepositoryJpa drinkTypeRepositoryJpa;

    @Override
    public DrinkType create(DrinkType drinkType) {
        return DrinkTypeMapper.INSTANCE.fromEntityToModel(
                drinkTypeRepositoryJpa.save(DrinkTypeMapper.INSTANCE.fromModelToEntity(drinkType))
        );
    }

    @Override
    public DrinkType readById(String id) {
        return DrinkTypeMapper.INSTANCE.fromEntityToModel(
                drinkTypeRepositoryJpa.findById(id).orElseThrow()
        );
    }

    @Override
    public DrinkType update(DrinkType drinkType) {
        return DrinkTypeMapper.INSTANCE.fromEntityToModel(
                drinkTypeRepositoryJpa.save(DrinkTypeMapper.INSTANCE.fromModelToEntity(drinkType))
        );
    }

    @Override
    public DrinkType deleteById(String id) {
        var deleted = readById(id);
        drinkTypeRepositoryJpa.deleteById(id);
        return deleted;
    }
}

