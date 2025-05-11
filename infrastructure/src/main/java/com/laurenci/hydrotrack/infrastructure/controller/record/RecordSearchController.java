package com.laurenci.hydrotrack.infrastructure.controller.record;

import java.util.List;

import com.laurenci.hydrotrack.service.record.RecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
