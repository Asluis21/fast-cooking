package com.fastcooking.dishes.service;

import java.util.List;

import com.fastcooking.dishes.dto.DishRequest;
import com.fastcooking.dishes.dto.DishResponse;

public interface DishService {
    
    List<DishResponse> findAll();
    DishResponse create (DishRequest request);
    DishResponse update (Long id, DishRequest request);
    void delete (Long id);
    DishResponse findById(Long id);
}
