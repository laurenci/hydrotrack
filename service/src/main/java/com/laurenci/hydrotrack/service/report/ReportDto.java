package com.laurenci.hydrotrack.service.report;

import java.time.LocalDate;

public record ReportDto(Double actualDailyAmount, Double expectedDailyAmount, LocalDate date) {
}
