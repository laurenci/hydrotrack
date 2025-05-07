package com.laurenci.hydrotrack.core.record;

import com.laurenci.hydrotrack.core.drink.system.Drink;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordId {
    private Long userId;
    private Drink drink;
    private LocalDateTime date;
}
