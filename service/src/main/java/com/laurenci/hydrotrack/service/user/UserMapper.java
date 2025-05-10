package com.laurenci.hydrotrack.service.user;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.user.User;
import com.laurenci.hydrotrack.service.util.mapper.GeneralNewDtoMapper;

@Mapper(uses = ProfileMapper.class)
public interface UserMapper extends GeneralNewDtoMapper<NewUserDto, UserDto, User> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @AfterMapping
    default void setUserIdAsProfileId(Object sourceDto, @MappingTarget User user) {
        if (sourceDto instanceof UserDto) {
            user.getProfile().setUserId(user.getId());
        }
    }
}
