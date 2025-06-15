package com.laurenci.hydrotrack.core.report;

import lombok.Data;

@Data
public class Report {
    private ReportId id;
    private Double actualDailyAmount;
    private Double expectedDailyAmount;
}
