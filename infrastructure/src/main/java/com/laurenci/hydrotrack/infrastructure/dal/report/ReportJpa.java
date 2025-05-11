package com.laurenci.hydrotrack.infrastructure.dal.report;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reports")
@Data
public class ReportJpa {
    @EmbeddedId
    ReportIdJpa id;

    @Column(name = "expected_daily_amount", nullable = false)
    private Double expectedDailyAmount;

    @Column(name = "actual_daily_amount", nullable = false)
    private Double actualDailyAmount;
}

