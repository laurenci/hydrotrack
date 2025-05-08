package com.laurenci.hydrotrack.infrastructure.dal.drink.custom;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrink;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface CustomDrinkMapper extends GeneralMapper<CustomDrink, CustomDrinkJpa> {
    CustomDrinkMapper INSTANCE = Mappers.getMapper(CustomDrinkMapper.class);
}
