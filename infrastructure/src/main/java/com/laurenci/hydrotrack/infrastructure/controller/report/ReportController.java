package com.laurenci.hydrotrack.infrastructure.controller.report;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.service.report.ReportDto;
import com.laurenci.hydrotrack.service.report.ReportService;

@RestController
@RequestMapping("/users/{id}/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ReportDto>> getReportsByUserId(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(reportService.getReportsByUserId(userId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ReportDto>> getReportsByPeriod(
            @PathVariable("id") Long userId,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseEntity.ok(reportService.getReportsByUserIdAndPeriodOfTime(userId, from, to));
    }
}
