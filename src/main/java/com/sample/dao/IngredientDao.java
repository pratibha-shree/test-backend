package com.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sample.entity.Ingredient;


@Repository
public class IngredientDao {
	 private static final Logger log = LoggerFactory.getLogger(IngredientDao.class);
	    @PersistenceContext
	    private EntityManager entityManager;
	    
	    /**
	     * Save ingredient
	     * @param ingredient
	     */
	    public void persist(Ingredient ingredient){
	        try{
	            entityManager.persist(ingredient);
	        }catch(Exception e){
	            log.error("Error occured during save", e);
	            throw e;
	        }
	    }
	    /**
	     * delete ingredient by id
	     * @param ingredient
	     */
	    public void remove(Ingredient ingredient){
	        try{
	            entityManager.remove(ingredient);
	        }catch(Exception e){
	            log.error("Error occured during remove", e);
	            throw e;
	        }
	    }
	    public Ingredient findById(Integer id){
	        try{
	            Ingredient requiredIngredient = entityManager.find(Ingredient.class, id);
	            return requiredIngredient;
	        }catch(Exception e){
	            log.error("Error occured While fetching by id", e);
	            throw e;
	        }
	    }
	    
	    public Ingredient updateIngredientDetails(Ingredient ingredient){
	        try{
	        	Ingredient updatedIngredient = entityManager.merge(ingredient);
	            return updatedIngredient;
	        }catch(Exception e){
	            log.error("Error occured While updating recipe", e);
	            throw e;
	        }
	    }
	    public List<Ingredient> findAll(){
	        try{
	            Query query = entityManager.createQuery("select i from Ingredient i");
	           List<Ingredient> ingredientsList = query.getResultList();
	           return ingredientsList;
	        }catch(Exception e){
	            log.error("Error occured While fetching all ingredient", e);
	            throw e;
	        }
	    }

}
