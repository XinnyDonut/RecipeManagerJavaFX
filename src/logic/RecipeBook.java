package logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RecipeBook {
	RecipeDAO recipeData;
	Map<String,Recipe>recipeMap;
	ObservableList<Recipe> recipeList;
	
	public RecipeBook(RecipeDAO db) {
		this.recipeList=FXCollections.observableArrayList();
		this.recipeMap=new HashMap<>();	
		this.recipeData=db;		
		this.recipeList = recipeData.getAllRecipes();
		recipeList.forEach(recipe->recipeMap.put(recipe.getName(),recipe));
		
	}
	
	public void add(Recipe recipe) {		
		this.recipeMap.put(recipe.getName(), recipe);
		this.recipeList.add(recipe);
		this.recipeData.saveRecipeDB(recipe);
	}
	
	public void updateRecipe(Recipe recipe,String oldName) {
				
		if(recipe.getName()!=oldName) {
			this.recipeMap.remove(oldName);			
		}
		this.recipeMap.put(recipe.getName(), recipe);
		this.recipeData.updateRecipeDB(recipe, oldName);
		
		
		int i =this.recipeList.indexOf(recipe);
		if(i>=0) {
			this.recipeList.set(i, recipe);
		}else {
			recipeList.add(recipe);
		}
					
	}
	
	public Boolean recipeExist(String s) {
		return recipeMap.containsKey(s);
	}
	
	
	public void deleteSingleRecipe(Recipe recipe) {
		recipeList.remove(recipe);
		recipeMap.remove(recipe.getName());
		this.recipeData.deleteRecipeByName(recipe.getName());
	}
	
	public void deleteMultipleRecipe(ObservableList<Recipe>recipesToDelete) {
		this.recipeList.removeAll(recipesToDelete);
		recipesToDelete.forEach(r->recipeMap.remove(r.getName()));
		recipesToDelete.forEach(r->this.recipeData.deleteRecipeByName(r.getName()));
	}
	
	public boolean containRecipe(String name) {
		return this.recipeMap.containsKey(name);
	}
	
	
	
	
	public Map<String,Recipe> getRecipeMap() {
		return this.recipeMap;
	}
	
	
	public Recipe getRecipe(String name) {
		return this.recipeMap.get(name);
	}
	
	
	public ObservableList<Recipe> getList(){
		return this.recipeList;
	}
	
	public RecipeDAO getRecipeDAO() {
		return this.recipeData;
	}
	
	
	
	
	
	

}
