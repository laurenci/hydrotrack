package com.laurenci.hydrotrack.infrastructure.controller.record;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.service.record.NewRecordDto;
import com.laurenci.hydrotrack.service.record.RecordDto;
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

    @GetMapping
    public ResponseEntity<RecordDto> getRecordById(
            @RequestParam Long userId, @RequestParam Long drinkId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date) {
        return ResponseEntity.ok(recordService.getRecordById(createRecordId(userId, drinkId, date)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecordById(
            @RequestParam Long userId, @RequestParam Long drinkId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date) {
        recordService.deleteRecordById(createRecordId(userId, drinkId, date));
        return ResponseEntity.noContent().build();
    }

    private RecordId createRecordId(Long userId, Long drinkId, LocalDateTime date) {
        var recordId = new RecordId();
        recordId.setUserId(userId);
        recordId.setDrinkId(drinkId);
        recordId.setDate(date);
        return recordId;
    }
}