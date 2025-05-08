package com.laurenci.hydrotrack.infrastructure.dal.report;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.report.Report;
import com.laurenci.hydrotrack.infrastructure.mapper.GeneralMapper;

@Mapper
public interface ReportMapper extends GeneralMapper<Report, ReportJpa> {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);
}
