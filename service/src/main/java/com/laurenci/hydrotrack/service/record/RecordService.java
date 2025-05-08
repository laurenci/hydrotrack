package com.laurenci.hydrotrack.service.record;

import java.util.List;

import lombok.AllArgsConstructor;

import com.laurenci.hydrotrack.core.record.RecordRepository;

@AllArgsConstructor
public class RecordService {
    private final RecordRepository repository;

    public RecordDto addNewRecord(NewRecordDto newRecord) {
        return RecordMapper.INSTANCE.fromModelToDto(
                repository.create(RecordMapper.INSTANCE.fromNewDtoToModel(newRecord))
        );
    }

    public List<RecordDto> getRecordsByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(RecordMapper.INSTANCE::fromModelToDto)
                .toList();
    }

    public void deleteRecordById(RecordIdDto recordId) {
        repository.deleteById(RecordIdMapper.INSTANCE.fromDtoToModel(recordId));
    }
}
