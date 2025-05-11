package com.laurenci.hydrotrack.infrastructure.dal.drink.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laurenci.hydrotrack.core.drink.DrinkGroup;

public interface DrinkRepositoryJpa extends JpaRepository<DrinkJpa, Long> {

    @Query("SELECT d FROM DrinkJpa d " +
            "WHERE (:type IS NULL OR d.type.type = :type) " +
            "AND (:group IS NULL OR d.type.group = :group)")
    List<DrinkJpa> findByOptionalTypeAndGroup(@Param("type") String type, @Param("group") DrinkGroup group);
}
