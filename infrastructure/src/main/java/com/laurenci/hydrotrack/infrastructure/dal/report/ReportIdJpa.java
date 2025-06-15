package com.laurenci.hydrotrack.infrastructure.dal.report;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ReportIdJpa {
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "date", nullable = false, insertable = false, updatable = false)
    private LocalDate date;
}
