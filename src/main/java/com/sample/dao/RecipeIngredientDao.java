package com.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sample.entity.Ingredient;
import com.sample.entity.Recipe;
import com.sample.entity.RecipeIngredient;

@Repository
public class RecipeIngredientDao {
	 private static final Logger log = LoggerFactory.getLogger(RecipeIngredientDao.class);
	    @PersistenceContext
	    private EntityManager entityManager;
	    
	    /**
	     * Save recipeIngredientDetails
	     * @param recipeIngredientDeatils
	     */
	    public void persist(RecipeIngredient recipeIngredient){
	        try{
	            entityManager.persist(recipeIngredient);
	        }catch(Exception e){
	            log.error("Error occured during save", e);
	            throw e;
	        }
	    }
	    /**
	     * delete recipeIngredient by id
	     * @param recipeIngredient
	     */
	    public void remove(RecipeIngredient recipeIngredient){
	        try{
	            entityManager.remove(recipeIngredient);
	        }catch(Exception e){
	            log.error("Error occured during remove", e);
	            throw e;
	        }
	    }
	    public RecipeIngredient findById(Integer id){
	        try{
	            RecipeIngredient requiredRecipeIngredient = entityManager.find(RecipeIngredient.class, id);
	            return requiredRecipeIngredient;
	        }catch(Exception e){
	            log.error("Error occured While fetching by id", e);
	            throw e;
	        }
	    }
	    
	    public RecipeIngredient updateRecipeIngredientDetails(RecipeIngredient recipeIngredient){
	        try{
	        	RecipeIngredient updatedRecipeIngredient = entityManager.merge(recipeIngredient);
	            return updatedRecipeIngredient;
	        }catch(Exception e){
	            log.error("Error occured While updating recipe", e);
	            throw e;
	        }
	    }
	    public List<RecipeIngredient> findAll(){
	        try{
	            Query query = entityManager.createQuery("select ri from RecipeIngredient ri");
	           List<RecipeIngredient> recipeIngredientsList = query.getResultList();
	           return recipeIngredientsList;
	        }catch(Exception e){
	            log.error("Error occured While fetching all recipeIngredient", e);
	            throw e;
	        }
	    }



}
