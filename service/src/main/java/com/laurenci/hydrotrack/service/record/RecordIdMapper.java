package com.laurenci.hydrotrack.service.record;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.service.util.mapper.GeneralMapper;

@Mapper
public interface RecordIdMapper extends GeneralMapper<RecordIdDto, RecordId> {
    RecordIdMapper INSTANCE = Mappers.getMapper(RecordIdMapper.class);
}
