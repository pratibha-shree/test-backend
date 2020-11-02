package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.RecipeDao;
import com.sample.entity.Recipe;
import com.sample.model.RecipeRequest;
import com.sample.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeDao recipedao;

	@Override
	@Transactional
	public void createRecipe(RecipeRequest recipeRequest) {
		Recipe recipe = new Recipe();
		recipe.setName(recipeRequest.getName());
		recipe.setDescription(recipeRequest.getDescription());
		recipe.setImageUrl(recipeRequest.getImageUrl());
		recipedao.persist(recipe);

	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Recipe recipe = recipedao.findById(id);
		recipedao.remove(recipe);

	}

	@Override
	@Transactional
	public Recipe findById(Integer id) {
		return recipedao.findById(id);

	}

	@Override
	@Transactional
	public List<Recipe> findAll() {
		return recipedao.findAll();

	}

	@Override
	@Transactional
	public Recipe updateRecipe(Integer RecipeId, RecipeRequest recipeRequest) {
		Recipe recipe = recipedao.findById(RecipeId);
		recipe.setName(recipeRequest.getName());
		recipe.setDescription(recipeRequest.getDescription());
		recipe.setImageUrl(recipeRequest.getImageUrl());
		return recipedao.updateRecipeDetails(recipe);

	}

}
