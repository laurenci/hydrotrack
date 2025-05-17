package com.laurenci.hydrotrack.core.record;

import java.time.LocalDateTime;
import java.util.List;

import com.laurenci.hydrotrack.core.Repository;

public interface RecordRepository extends Repository<Record, RecordId> {
    List<Record> findByUserId(Long userId);
    List<Record> findByUserIdAndDateRange(Long userId, LocalDateTime from, LocalDateTime to);
}
