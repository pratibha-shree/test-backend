package com.sample.service;

import java.util.List;

import com.sample.entity.Recipe;
import com.sample.model.RecipeRequest;


public interface RecipeService {
	public void createRecipe(RecipeRequest recipeRequest);
    public void remove(Integer id);
    public Recipe findById(Integer id);
    public List<Recipe> findAll();
    public Recipe updateRecipe(Integer RecipeId, RecipeRequest recipeRequest);

}
