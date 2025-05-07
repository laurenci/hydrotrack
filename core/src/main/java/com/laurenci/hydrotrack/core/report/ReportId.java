package com.laurenci.hydrotrack.core.report;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportId {
    private Long userId;
    private LocalDate date;
}
