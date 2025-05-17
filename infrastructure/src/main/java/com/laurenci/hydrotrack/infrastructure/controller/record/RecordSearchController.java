package com.laurenci.hydrotrack.infrastructure.controller.record;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.service.record.RecordDto;
import com.laurenci.hydrotrack.service.record.RecordService;

@RestController
@RequestMapping("/users/{id}/records")
@RequiredArgsConstructor
public class RecordSearchController {
    private final RecordService recordService;

    @GetMapping()
    public ResponseEntity<List<RecordDto>> getRecordsByUserId(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(recordService.getRecordsByUserId(userId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecordDto>> getRecordsByUserIdAndPeriodOfTime(
            @PathVariable("id") Long userId,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime to) {
        return ResponseEntity.ok(recordService.getRecordsByUserIdAndDateRange(userId, from, to));
    }
}
