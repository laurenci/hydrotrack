package com.laurenci.hydrotrack.infrastructure.dal.report;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.report.ReportId;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface ReportIdMapper extends GeneralMapper<ReportId, ReportIdJpa> {
    ReportIdMapper INSTANCE = Mappers.getMapper(ReportIdMapper.class);
}
