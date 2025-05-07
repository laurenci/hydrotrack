package com.laurenci.hydrotrack.core.report;

import java.util.List;

import com.laurenci.hydrotrack.core.Repository;

public interface ReportRepository extends Repository<Report, ReportId> {
    List<Report> findByUserId(Integer userId);
}
