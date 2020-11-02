package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.IngredientDao;
import com.sample.entity.Ingredient;
import com.sample.model.IngredientRequest;
import com.sample.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
	@Autowired
	private IngredientDao ingredientDao;

	@Override
	@Transactional
	public void createIngredient(IngredientRequest ingredientRequest) {
		Ingredient ingredient = new Ingredient();
		ingredient.setName(ingredientRequest.getName());
		ingredientDao.persist(ingredient);

	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Ingredient ingredient = ingredientDao.findById(id);
		ingredientDao.remove(ingredient);
	}

	@Override
	@Transactional
	public Ingredient findById(Integer id) {
		Ingredient ingredient = ingredientDao.findById(id);
		return ingredient;

	}

	@Override
	@Transactional
	public List<Ingredient> findAll() {
		List<Ingredient> ingredientList = ingredientDao.findAll();
		return ingredientList;
	}

	@Override
	@Transactional
	public Ingredient updateIngredient(Integer ingredientId, IngredientRequest ingredientRequest) {
		Ingredient ingredient = ingredientDao.findById(ingredientId);
		ingredient.setName(ingredientRequest.getName());
		return ingredientDao.updateIngredientDetails(ingredient);
	}

}
