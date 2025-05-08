package com.laurenci.hydrotrack.infrastructure.dal.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.user.User;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface UserMapper extends GeneralMapper<User, UserJpa> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
