package com.laurenci.hydrotrack.infrastructure.dal.report;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.laurenci.hydrotrack.core.report.Report;
import com.laurenci.hydrotrack.core.report.ReportId;
import com.laurenci.hydrotrack.core.report.ReportRepository;

@Repository
@AllArgsConstructor
public class ConcreteReportRepository implements ReportRepository {
    private final ReportRepositoryJpa reportRepositoryJpa;

    @Override
    public Report create(Report report) {
        return ReportMapper.INSTANCE.fromEntityToModel(
                reportRepositoryJpa.save(ReportMapper.INSTANCE.fromModelToEntity(report))
        );
    }

    @Override
    public Report readById(ReportId id) {
        return ReportMapper.INSTANCE.fromEntityToModel(
                reportRepositoryJpa.findById(id).orElseThrow()
        );
    }

    @Override
    public Report update(Report report) {
        return ReportMapper.INSTANCE.fromEntityToModel(
                reportRepositoryJpa.save(ReportMapper.INSTANCE.fromModelToEntity(report))
        );
    }

    @Override
    public Report deleteById(ReportId id) {
        var deleted = readById(id);
        reportRepositoryJpa.deleteById(id);
        return deleted;
    }

    @Override
    public List<Report> findByUserId(Long userId) {
        return reportRepositoryJpa.findByUserId(userId).stream()
                .map(ReportMapper.INSTANCE::fromEntityToModel)
                .toList();
    }
}

