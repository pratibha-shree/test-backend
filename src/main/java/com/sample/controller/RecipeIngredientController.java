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
import com.sample.entity.Recipe;
import com.sample.entity.RecipeIngredient;
import com.sample.model.RecipeIngredientRequest;
import com.sample.model.RecipeRequest;
import com.sample.service.RecipeIngredientService;

@RequestMapping("/recipeIngredient")
@RestController
public class RecipeIngredientController {
	@Autowired
	public RecipeIngredientService recipeIngredientService;
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public JSONObject createRecipeIngredient( @RequestBody RecipeIngredientRequest recipeIngredientRequest) {
		recipeIngredientService.createRecipeIngredient(recipeIngredientRequest);
		JSONObject response = new JSONObject();
		response.put("is_success", true);
		return response;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{recipe_ingredient_id}")
	public RecipeIngredient getRecipeIngredient(@PathVariable("recipe_ingredient_id")Integer recipeIngredientId) {
		return recipeIngredientService.findById(recipeIngredientId);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{recipe_ingredient_id}")
	public JSONObject deleteRecipeIngredient(@PathVariable("recipe_ingredient_id") Integer recipeIngredientId) {
		 recipeIngredientService.remove(recipeIngredientId);
		 JSONObject response = new JSONObject();
			response.put("is_success", true);
			return response;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{recipe_ingredient_id}")
	public RecipeIngredient updateRecipeIngredient(@PathVariable("recipe_ingredient_id")Integer recipeIngredientId, @RequestBody RecipeIngredientRequest recipeIngredientRequest) {
		return recipeIngredientService.updateRecipeIngredient(recipeIngredientId, recipeIngredientRequest);
	}
	@RequestMapping(method = RequestMethod.GET,  value = "/list")
	public List<RecipeIngredient> getAllRecipeIngredients() {
		return recipeIngredientService.findAll();
	}
	

}
