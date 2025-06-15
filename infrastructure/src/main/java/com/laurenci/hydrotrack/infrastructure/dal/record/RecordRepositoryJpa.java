package com.laurenci.hydrotrack.infrastructure.dal.record;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepositoryJpa extends JpaRepository<RecordJpa, RecordIdJpa> {

    // Custom JPQL query to find records by userId
    @Query("SELECT r FROM RecordJpa r WHERE r.id.userId = :userId")
    List<RecordJpa> findByUserId(@Param("userId") Long userId);

    // Custom JPQL query to find records within a date range
    @Query("SELECT r FROM RecordJpa r WHERE r.id.userId = :userId AND r.id.date BETWEEN :startDate AND :endDate")
    List<RecordJpa> findByUserIdAndDateRange(@Param("userId") Long userId,
                                             @Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);
}
