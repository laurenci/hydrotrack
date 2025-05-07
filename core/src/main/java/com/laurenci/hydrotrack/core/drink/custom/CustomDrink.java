package com.laurenci.hydrotrack.core.drink.custom;

import com.laurenci.hydrotrack.core.drink.system.Drink;
import lombok.Data;

@Data
public class CustomDrink extends Drink {
    private Long userId;
}
