package com.laurenci.hydrotrack.service.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.user.User;
import com.laurenci.hydrotrack.service.util.mapper.GeneralNewDtoMapper;

@Mapper
public interface UserMapper extends GeneralNewDtoMapper<NewUserDto, UserDto, User> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
