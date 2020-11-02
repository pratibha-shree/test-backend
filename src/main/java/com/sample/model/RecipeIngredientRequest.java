package com.sample.model;

public class RecipeIngredientRequest {
	private Integer ingredientId;
	private Integer recipeId;
	private Integer amount;
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	

}
