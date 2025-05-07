package com.laurenci.hydrotrack.service.report;

import java.util.List;
import java.time.LocalDate;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.report.ReportRepository;

@AllArgsConstructor
public class ReportService {
    private final ReportRepository repository;

    public List<ReportDto> getReportsByUserId(Long userId) {
        return null;
    }

    public List<ReportDto> getReportsByPeriodOfTime(LocalDate from, LocalDate to) {
        return null;
    }
}
