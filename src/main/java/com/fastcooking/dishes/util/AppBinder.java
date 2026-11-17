package com.fastcooking.dishes.util;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.fastcooking.dishes.service.DishService;
import com.fastcooking.dishes.service.DishServiceImpl;

import jakarta.inject.Singleton;

public class AppBinder extends AbstractBinder{

    
    @Override
    protected void configure() {
        
        bind(DishServiceImpl.class).to(DishService.class).in(Singleton.class);
    }
}
