package com.laurenci.hydrotrack.core.report;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReportId implements Serializable {
    private Long userId;
    private LocalDate date;
}
