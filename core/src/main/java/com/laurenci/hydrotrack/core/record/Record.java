package com.laurenci.hydrotrack.core.record;

import com.laurenci.hydrotrack.core.drink.DrinkArea;
import lombok.Data;

@Data
public class Record {
    private RecordId recordId;
    private DrinkArea drinkArea;
    private Double amount;
}
