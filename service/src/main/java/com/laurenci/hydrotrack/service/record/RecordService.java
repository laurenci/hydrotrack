package com.laurenci.hydrotrack.service.record;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.record.RecordRepository;

@AllArgsConstructor
public class RecordService {
    private final RecordRepository repository;

    public RecordDto addNewRecord(NewRecordDto newRecord) {
        return null;
    }

    public List<RecordDto> getRecordsByUserId(Long userId) {
        return null;
    }

    public void deleteRecordById(RecordIdDto recordId) {

    }
}
