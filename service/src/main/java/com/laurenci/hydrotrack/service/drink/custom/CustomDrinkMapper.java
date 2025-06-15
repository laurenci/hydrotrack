package com.laurenci.hydrotrack.service.drink.custom;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrink;
import com.laurenci.hydrotrack.service.util.mapper.GeneralNewDtoMapper;

@Mapper
public interface CustomDrinkMapper extends GeneralNewDtoMapper<NewCustomDrinkDto, CustomDrinkDto, CustomDrink> {
    CustomDrinkMapper INSTANCE = Mappers.getMapper(CustomDrinkMapper.class);
}
