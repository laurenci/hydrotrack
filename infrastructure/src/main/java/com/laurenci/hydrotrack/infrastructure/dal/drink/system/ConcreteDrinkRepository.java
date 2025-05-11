package com.laurenci.hydrotrack.infrastructure.dal.drink.system;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.core.drink.system.Drink;
import com.laurenci.hydrotrack.core.drink.system.DrinkRepository;

@Repository
@AllArgsConstructor
public class ConcreteDrinkRepository implements DrinkRepository {
    private final DrinkRepositoryJpa drinkRepositoryJpa;

    @Override
    public Drink create(Drink drink) {
        return DrinkMapper.INSTANCE.fromEntityToModel(
                drinkRepositoryJpa.save(DrinkMapper.INSTANCE.fromModelToEntity(drink))
        );
    }

    @Override
    public Drink readById(Long id) {
        return DrinkMapper.INSTANCE.fromEntityToModel(
                drinkRepositoryJpa.findById(id).orElseThrow()
        );
    }

    @Override
    public Drink update(Drink drink) {
        return DrinkMapper.INSTANCE.fromEntityToModel(
                drinkRepositoryJpa.save(DrinkMapper.INSTANCE.fromModelToEntity(drink))
        );
    }

    @Override
    public Drink deleteById(Long id) {
        var deleted = readById(id);
        drinkRepositoryJpa.deleteById(id);
        return deleted;
    }

    @Override
    public List<Drink> findByDrinkType(DrinkType drinkType) {
        return drinkRepositoryJpa.findByOptionalTypeAndGroup(drinkType.getType(), drinkType.getGroup()).stream()
                .map(DrinkMapper.INSTANCE::fromEntityToModel)
                .toList();
    }
}
