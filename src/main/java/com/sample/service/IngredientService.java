package com.sample.service;

import java.util.List;

import com.sample.entity.Ingredient;
import com.sample.model.IngredientRequest;

public interface IngredientService {
	public void createIngredient(IngredientRequest ingredientRequest);
    public void remove(Integer id);
    public Ingredient findById(Integer id);
    public List<Ingredient> findAll();
    public Ingredient updateIngredient(Integer ingredientId, IngredientRequest ingredientRequest);

    

}
