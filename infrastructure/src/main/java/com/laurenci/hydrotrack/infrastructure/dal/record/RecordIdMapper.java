package com.laurenci.hydrotrack.infrastructure.dal.record;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface RecordIdMapper extends GeneralMapper<RecordId, RecordIdJpa> {
    RecordIdMapper INSTANCE = Mappers.getMapper(RecordIdMapper.class);
}
