package com.laurenci.hydrotrack.service.record;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.record.Record;
import com.laurenci.hydrotrack.service.util.mapper.GeneralNewDtoMapper;

@Mapper
public interface RecordMapper extends GeneralNewDtoMapper<NewRecordDto, RecordDto, Record> {
    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);
}
