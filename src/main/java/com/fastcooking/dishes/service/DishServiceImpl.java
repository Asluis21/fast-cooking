package com.fastcooking.dishes.service;

import java.time.Duration;
import java.util.List;

import com.fastcooking.dishes.dto.DishRequest;
import com.fastcooking.dishes.dto.DishResponse;
import com.fastcooking.dishes.entity.Region;

public class DishServiceImpl implements DishService{

    @Override
    public DishResponse create(DishRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createDish'");
    }

    @Override
    public DishResponse update(Long id, DishRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upadteDish'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDish'");
    }

    @Override
    public DishResponse findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<DishResponse> findAll() {
        
        return List.of(
            new DishResponse(1L, "Lomo Saltado", "Plato sencillo", Region.COSTA, Duration.ofHours(2)),
            new DishResponse(2L, "Aji de Gallina", "Plato medio", Region.COSTA, Duration.ofHours(1))
        );
    }
    
}
