package com.laurenci.hydrotrack.service.drink.system;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.system.Drink;
import com.laurenci.hydrotrack.service.util.mapper.GeneralMapper;

@Mapper
public interface DrinkMapper extends GeneralMapper<DrinkDto, Drink> {
    DrinkMapper INSTANCE = Mappers.getMapper(DrinkMapper.class);
}
