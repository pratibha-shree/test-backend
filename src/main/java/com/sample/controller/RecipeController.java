package com.sample.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Recipe;
import com.sample.model.RecipeRequest;
import com.sample.service.RecipeService;

@RequestMapping("/recipe")
@RestController
public class RecipeController {
	@Autowired
	public RecipeService recipeService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public JSONObject createRecipe(@RequestBody RecipeRequest recipeRequest) {
		recipeService.createRecipe(recipeRequest);
		JSONObject response = new JSONObject();
		response.put("is_success", true);
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{recipe_id}")
	public Recipe getRecipe(@PathVariable("recipe_id") Integer recipeId) {
		return recipeService.findById(recipeId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{recipe_id}")
	public JSONObject deleteRecipe(@PathVariable("recipe_id") Integer recipeId) {
		recipeService.remove(recipeId);
		JSONObject response = new JSONObject();
		response.put("is_success", true);
		return response;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{recipe_id}")
	public Recipe updateRecipe(@PathVariable("recipe_id") Integer recipeId, @RequestBody RecipeRequest recipeRequest) {
		return recipeService.updateRecipe(recipeId, recipeRequest);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<Recipe> getAllRecipe() {
		return recipeService.findAll();
	}

}
