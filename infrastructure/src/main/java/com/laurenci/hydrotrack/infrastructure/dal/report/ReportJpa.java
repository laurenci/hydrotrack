package com.laurenci.hydrotrack.infrastructure.dal.report;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import com.laurenci.hydrotrack.core.report.ReportId;
import com.laurenci.hydrotrack.infrastructure.dal.user.UserJpa;

@Entity
@Table(name = "reports")
@Data
@IdClass(ReportId.class)
public class ReportJpa {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Id
    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "expected_daily_amount", nullable = false)
    private Double expectedDailyAmount;

    @Column(name = "actual_daily_amount", nullable = false)
    private Double actualDailyAmount;
}

