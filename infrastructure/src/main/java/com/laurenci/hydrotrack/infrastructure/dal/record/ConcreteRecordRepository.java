package com.laurenci.hydrotrack.infrastructure.dal.record;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import com.laurenci.hydrotrack.core.record.Record;
import com.laurenci.hydrotrack.core.record.RecordId;
import com.laurenci.hydrotrack.core.record.RecordRepository;

@Repository
@AllArgsConstructor
public class ConcreteRecordRepository implements RecordRepository {
    private final RecordRepositoryJpa recordRepositoryJpa;

    @Override
    public Record create(Record record) {
        return RecordMapper.INSTANCE.fromEntityToModel(
                recordRepositoryJpa.save(RecordMapper.INSTANCE.fromModelToEntity(record))
        );
    }

    @Override
    public Record readById(RecordId id) {
        return RecordMapper.INSTANCE.fromEntityToModel(
                recordRepositoryJpa.findById(id).orElseThrow()
        );
    }

    @Override
    public Record update(Record record) {
        return RecordMapper.INSTANCE.fromEntityToModel(
                recordRepositoryJpa.save(RecordMapper.INSTANCE.fromModelToEntity(record))
        );
    }

    @Override
    public Record deleteById(RecordId id) {
        var deleted = readById(id);
        recordRepositoryJpa.deleteById(id);
        return deleted;
    }

    @Override
    public List<Record> findByUserId(Long userId) {
        return recordRepositoryJpa.findByUserId(userId).stream()
                .map(RecordMapper.INSTANCE::fromEntityToModel)
                .toList();
    }
}

