package com.laurenci.hydrotrack.infrastructure.dal.drink.system;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.system.Drink;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface DrinkMapper extends GeneralMapper<Drink, DrinkJpa> {
    DrinkMapper INSTANCE = Mappers.getMapper(DrinkMapper.class);
}
