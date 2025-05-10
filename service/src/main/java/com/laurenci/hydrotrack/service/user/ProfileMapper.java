package com.laurenci.hydrotrack.service.user;

import com.laurenci.hydrotrack.core.user.Profile;
import com.laurenci.hydrotrack.service.util.mapper.GeneralMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper extends GeneralMapper<ProfileDto, Profile> {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);
}
