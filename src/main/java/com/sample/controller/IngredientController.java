package com.sample.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Ingredient;
import com.sample.model.IngredientRequest;
import com.sample.service.IngredientService;

@RequestMapping("/ingredient")
@RestController
public class IngredientController {
	@Autowired
	public IngredientService ingredientService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public JSONObject createIngredient(@RequestBody IngredientRequest ingredientRequest) {
		ingredientService.createIngredient(ingredientRequest);
		JSONObject response = new JSONObject();
		response.put("is_success", true);
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{ingredient_id}")
	public Ingredient getIngredient(@PathVariable("ingredient_id") Integer ingredientId) {
		return ingredientService.findById(ingredientId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{ingredient_id}")
	public JSONObject deleteIngredient(@PathVariable("ingredient_id") Integer ingredientId) {
		ingredientService.remove(ingredientId);
		JSONObject response = new JSONObject();
		response.put("is_success", true);
		return response;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{ingredient_id}")
	public Ingredient updateIngredient(@PathVariable("ingredient_id") Integer ingredientId,
			@RequestBody IngredientRequest ingredientRequest) {
		return ingredientService.updateIngredient(ingredientId, ingredientRequest);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<Ingredient> getAllIngredients() {
		return ingredientService.findAll();
	}

}
