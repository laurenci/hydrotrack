package com.laurenci.hydrotrack.infrastructure.dal.drink;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface DrinkTypeMapper extends GeneralMapper<DrinkType, DrinkTypeJpa> {
    DrinkTypeMapper INSTANCE = Mappers.getMapper(DrinkTypeMapper.class);
}
