package com.laurenci.hydrotrack.core.record;

import com.laurenci.hydrotrack.core.drink.system.Drink;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RecordId implements Serializable {
    private Long userId;
    private Long drinkId;
    private LocalDateTime date;
}
