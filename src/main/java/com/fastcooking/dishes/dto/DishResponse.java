package com.fastcooking.dishes.dto;

import java.time.Duration;

import com.fastcooking.dishes.entity.Region;

public record DishResponse(
    Long id,
    String name,
    String description,
    Region region,
    Duration preparationTime
) {
    
}
