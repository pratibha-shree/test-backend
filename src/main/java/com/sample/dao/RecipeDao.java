package com.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sample.entity.Recipe;

@Repository
public class RecipeDao {
	 private static final Logger log = LoggerFactory.getLogger(RecipeDao.class);
	    @PersistenceContext
	    private EntityManager entityManager;
	    
	    /**
	     * Save recipe
	     * @param recipe
	     */
	    public void persist(Recipe recipe){
	        try{
	            entityManager.persist(recipe);
	        }catch(Exception e){
	            log.error("Error occured during save", e);
	            throw e;
	        }
	    }
	    /**
	     * delete recipe by id
	     * @param recipe
	     */
	    public void remove(Recipe recipe){
	        try{
	            entityManager.remove(recipe);
	        }catch(Exception e){
	            log.error("Error occured during remove", e);
	            throw e;
	        }
	    }
	    public Recipe findById(Integer id){
	        try{
	            Recipe requiredRecipe = entityManager.find(Recipe.class, id);
	            return requiredRecipe;
	        }catch(Exception e){
	            log.error("Error occured While fetching by id", e);
	            throw e;
	        }
	    }
	    
	    public Recipe updateRecipeDetails(Recipe recipe){
	        try{
	            Recipe updatedRecipe = entityManager.merge(recipe);
	            return updatedRecipe;
	        }catch(Exception e){
	            log.error("Error occured While updating recipe", e);
	            throw e;
	        }
	    }
	    public List<Recipe> findAll(){
	        try{
	            Query query = entityManager.createQuery("select re from Recipe re");
	           List<Recipe> recipeList = query.getResultList();
	           return recipeList;
	        }catch(Exception e){
	            log.error("Error occured While fetching all recipe", e);
	            throw e;
	        }
	    }

}
