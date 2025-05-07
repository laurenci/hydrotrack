package com.laurenci.hydrotrack.core.drink.system;

import com.laurenci.hydrotrack.core.drink.DrinkType;
import lombok.Data;

@Data
public class Drink {
    private Long id;
    private DrinkType type;
    private String brand;
    private String name;
}
