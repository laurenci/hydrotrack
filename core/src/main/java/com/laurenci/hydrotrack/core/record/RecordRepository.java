package com.laurenci.hydrotrack.core.record;

import java.util.List;

import com.laurenci.hydrotrack.core.Repository;

public interface RecordRepository extends Repository<Record, RecordId> {
    List<Record> findByUserId(Integer userId);
}
