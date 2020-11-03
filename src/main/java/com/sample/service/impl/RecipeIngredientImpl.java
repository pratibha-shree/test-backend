package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.IngredientDao;
import com.sample.dao.RecipeDao;
import com.sample.dao.RecipeIngredientDao;
import com.sample.entity.Ingredient;
import com.sample.entity.Recipe;
import com.sample.entity.RecipeIngredient;
import com.sample.model.RecipeIngredientRequest;
import com.sample.service.RecipeIngredientService;

@Service
public class RecipeIngredientImpl implements RecipeIngredientService {
	@Autowired
	private RecipeIngredientDao recipeIngredientDao;
	@Autowired
	private  IngredientDao ingredientDao;
	@Autowired
	private RecipeDao recipeDao;

	@Override
	@Transactional
	public void createRecipeIngredient(RecipeIngredientRequest recipeIngredientRequest) {
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		Ingredient ingredient=ingredientDao.findById(recipeIngredientRequest.getIngredientId());
		Recipe recipe=recipeDao.findById(recipeIngredientRequest.getRecipeId());
		recipeIngredient.setAmount(recipeIngredientRequest.getAmount());
		recipeIngredient.setIngredient(ingredient);
		recipeIngredient.setRecipe(recipe);
		recipeIngredientDao.persist(recipeIngredient);

	}

	@Override
	@Transactional
	public void remove(Integer id) {
		RecipeIngredient recipeIngredient = recipeIngredientDao.findById(id);
		recipeIngredientDao.remove(recipeIngredient);

	}

	@Override
	@Transactional
	public RecipeIngredient findById(Integer id) {
		return recipeIngredientDao.findById(id);

	}

	@Override
	@Transactional
	public List<RecipeIngredient> findAll() {
		return recipeIngredientDao.findAll();

	}

	@Override
	@Transactional
	public RecipeIngredient updateRecipeIngredient(Integer RecipeIngredientId,
			RecipeIngredientRequest recipeIngredientRequest) {
		RecipeIngredient recipeIngredient = recipeIngredientDao.findById(RecipeIngredientId);
		Ingredient ingredient=ingredientDao.findById(recipeIngredientRequest.getIngredientId());
		Recipe recipe=recipeDao.findById(recipeIngredientRequest.getRecipeId());
		recipeIngredient.setAmount(recipeIngredientRequest.getAmount());
		recipeIngredient.setIngredient(ingredient);
		recipeIngredient.setRecipe(recipe);
		
		return recipeIngredientDao.updateRecipeIngredientDetails(recipeIngredient);
	}

}
