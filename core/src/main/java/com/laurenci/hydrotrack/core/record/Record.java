package com.laurenci.hydrotrack.core.record;

import lombok.Data;

import com.laurenci.hydrotrack.core.drink.DrinkArea;
import com.laurenci.hydrotrack.core.drink.system.Drink;

@Data
public class Record {
    private RecordId id;
    private Drink drink;
    private DrinkArea area;
    private Double amount;
}
