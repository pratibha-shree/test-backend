package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.RecipeIngredientDao;
import com.sample.entity.RecipeIngredient;
import com.sample.model.RecipeIngredientRequest;
import com.sample.service.RecipeIngredientService;

@Service
public class RecipeIngredientImpl implements RecipeIngredientService {
	@Autowired
	private RecipeIngredientDao recipeIngredientDao;

	@Override
	@Transactional
	public void createRecipeIngredient(RecipeIngredientRequest recipeIngredientRequest) {
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		recipeIngredient.setAmount(recipeIngredientRequest.getAmount());
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
		recipeIngredient.setAmount(recipeIngredientRequest.getAmount());
		return recipeIngredientDao.updateRecipeIngredientDetails(recipeIngredient);
	}

}
