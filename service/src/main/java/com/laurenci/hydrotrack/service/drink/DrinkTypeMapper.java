package com.laurenci.hydrotrack.service.drink;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.service.util.mapper.GeneralMapper;

@Mapper
public interface DrinkTypeMapper extends GeneralMapper<DrinkTypeDto, DrinkType> {
    DrinkTypeMapper INSTANCE = Mappers.getMapper(DrinkTypeMapper.class);
}
