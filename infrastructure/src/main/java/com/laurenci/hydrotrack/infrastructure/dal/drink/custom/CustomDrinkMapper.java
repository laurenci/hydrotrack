package com.laurenci.hydrotrack.infrastructure.dal.drink.custom;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.drink.custom.CustomDrink;
import com.laurenci.hydrotrack.infrastructure.dal.user.UserJpa;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface CustomDrinkMapper extends GeneralMapper<CustomDrink, CustomDrinkJpa> {
    CustomDrinkMapper INSTANCE = Mappers.getMapper(CustomDrinkMapper.class);

    @Override
    @Mapping(target = "user.id", source = "customDrink.userId")
    CustomDrinkJpa fromModelToEntity(CustomDrink customDrink);

    @Override
    @Mapping(target = "userId", source = "customDrinkJpa.user.id")
    CustomDrink fromEntityToModel(CustomDrinkJpa customDrinkJpa);

    @AfterMapping
    default void setBackReferences(CustomDrink customDrink, @MappingTarget CustomDrinkJpa customDrinkJpa) {
        var userJpa = new UserJpa();
        userJpa.setId(customDrink.getUserId());
        customDrinkJpa.setUser(userJpa);
    }
}
