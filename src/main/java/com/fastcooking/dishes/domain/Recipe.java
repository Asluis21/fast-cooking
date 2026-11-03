package com.fastcooking.dishes.domain;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    
    private Long id;
    private Dish dish;
    private Map<Ingredient, Integer> ingredients = new HashMap<>();
    private String preparation;
    
    public Recipe(Long id, Dish dish, Map<Ingredient, Integer> ingredients, String preparation) {
        this.id = id;
        this.dish = dish;
        this.ingredients = ingredients;
        this.preparation = preparation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    
}
