package com.laurenci.hydrotrack.service.report;

import java.util.List;
import java.time.LocalDate;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.report.ReportRepository;

@AllArgsConstructor
public class ReportService {
    private final ReportRepository repository;

    public List<ReportDto> getReportsByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(ReportMapper.INSTANCE::fromModelToDto)
                .toList();
    }

    public List<ReportDto> getReportsByUserIdAndPeriodOfTime(Long userId, LocalDate from, LocalDate to) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
