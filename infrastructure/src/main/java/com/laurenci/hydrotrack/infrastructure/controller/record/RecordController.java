package com.laurenci.hydrotrack.infrastructure.controller.record;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.service.record.NewRecordDto;
import com.laurenci.hydrotrack.service.record.RecordDto;
import com.laurenci.hydrotrack.service.record.RecordIdDto;
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecordDto>> getRecordsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(recordService.getRecordsByUserId(userId));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecordById(@RequestBody RecordIdDto recordIdDto) {
        recordService.deleteRecordById(recordIdDto);
        return ResponseEntity.noContent().build();
    }
}