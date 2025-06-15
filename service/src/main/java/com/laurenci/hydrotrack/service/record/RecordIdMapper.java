package com.laurenci.hydrotrack.service.record;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.service.util.mapper.GeneralNewDtoMapper;

@Mapper
public interface RecordIdMapper extends GeneralNewDtoMapper<NewRecordDto, EditRecordDto, RecordId> {
    RecordIdMapper INSTANCE = Mappers.getMapper(RecordIdMapper.class);
}
