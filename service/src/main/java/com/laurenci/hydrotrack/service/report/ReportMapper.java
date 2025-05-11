package com.laurenci.hydrotrack.service.report;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.laurenci.hydrotrack.core.report.Report;
import com.laurenci.hydrotrack.service.util.mapper.GeneralMapper;

@Mapper
public interface ReportMapper extends GeneralMapper<ReportDto, Report> {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    @Override
    @Mapping(target = "date", source = "report.id.date")
    ReportDto fromModelToDto(Report report);
}
