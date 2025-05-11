package com.laurenci.hydrotrack.infrastructure.dal.drink.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laurenci.hydrotrack.core.drink.DrinkGroup;

public interface CustomDrinkRepositoryJpa extends JpaRepository<CustomDrinkJpa, Long> {

    @Query("SELECT d FROM CustomDrinkJpa d " +
            "WHERE d.user.id = :userId " +
            "AND (:type IS NULL OR d.type.type = :type) " +
            "AND (:group IS NULL OR d.type.group = :group)")
    List<CustomDrinkJpa> findByUserIdAndOptionalTypeAndGroup(@Param("userId") Long userId, @Param("type") String type, @Param("group") DrinkGroup group);

    // Custom JPQL query to find custom drinks by userId
    @Query("SELECT c FROM CustomDrinkJpa c WHERE c.user.id = :userId")
    List<CustomDrinkJpa> findByUserId(@Param("userId") Long userId);
}
