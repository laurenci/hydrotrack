package com.laurenci.hydrotrack.infrastructure.controller.record;

import com.laurenci.hydrotrack.service.record.RecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.service.record.NewRecordDto;
import com.laurenci.hydrotrack.service.record.RecordService;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @PostMapping
    public ResponseEntity<RecordDto> addNewRecord(@RequestBody NewRecordDto newRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recordService.addNewRecord(newRecordDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecordById(@RequestBody RecordId recordId) {
        recordService.deleteRecordById(recordId);
        return ResponseEntity.noContent().build();
    }
}