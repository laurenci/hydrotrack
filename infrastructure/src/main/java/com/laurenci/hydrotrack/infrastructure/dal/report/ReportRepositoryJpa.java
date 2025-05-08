package com.laurenci.hydrotrack.infrastructure.dal.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laurenci.hydrotrack.core.report.ReportId;

public interface ReportRepositoryJpa extends JpaRepository<ReportJpa, ReportId> {

    // Custom JPQL query to find reports by userId
    @Query("SELECT r FROM ReportJpa r WHERE r.userId = :userId")
    List<ReportJpa> findByUserId(@Param("userId") Long userId);
}