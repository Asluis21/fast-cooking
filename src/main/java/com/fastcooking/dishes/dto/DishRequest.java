package com.fastcooking.dishes.dto;

import java.time.Duration;

import javax.swing.plaf.synth.Region;

public record DishRequest(
    String name,
    String description,
    Region region,
    Duration preparationTime
) {
    
}
