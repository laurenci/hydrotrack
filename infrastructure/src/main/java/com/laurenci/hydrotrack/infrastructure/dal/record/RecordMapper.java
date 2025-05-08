package com.laurenci.hydrotrack.infrastructure.dal.record;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.record.Record;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface RecordMapper extends GeneralMapper<Record, RecordJpa> {
    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);
}
