package com.sample.service;

import java.util.List;

import com.sample.entity.RecipeIngredient;
import com.sample.model.RecipeIngredientRequest;

public interface RecipeIngredientService {
	public void createRecipeIngredient(RecipeIngredientRequest recipeIngredientRequest);
    public void remove(Integer id);
    public RecipeIngredient findById(Integer id);
    public List<RecipeIngredient> findAll();
    public RecipeIngredient updateRecipeIngredient(Integer RecipeIngredientId, RecipeIngredientRequest recipeIngredientRequest);

}
