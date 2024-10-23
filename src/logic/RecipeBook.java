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
	
	public boolean containRecipe(String name) {
		return this.recipeMap.containsKey(name);
	}
	
	//do i need to deal with the data base here??
	public Recipe getRecipe(String name) {
		return this.recipeMap.get(name);
	}
	
	public boolean isBakingRecipe(Recipe r) {
		return r.getBaking();
	}
	
	public ObservableList<Recipe> getList(){
		return this.recipeList;
	}
	
	public RecipeDAO getRecipeDAO() {
		return this.recipeData;
	}
	
	public Boolean recipeExist(String s) {
		return recipeMap.containsKey(s);
	}
	
	
	public void delete(String str) {
		this.recipeMap.remove(str);
	}
	
	public void printAllrecipeName() {
		this.recipeMap.forEach((key,value)->{
			System.out.println(key);	
		});
	}
	
	
	
//	public void listRecipesByCategory(Category category) {
//		//list all the recipe by catogory (either baking or cooking)
//		List<String>recipeNames=new ArrayList<String>();
//		if(category==Category.BAKING) {
//			this.bakingRecipes.forEach((s,r)->recipeNames.add(s));
//		}else {
//			this.recipes.forEach((s,r)->recipeNames.add(s));
//		}
//	}
	
	
	/**
	 * 
	 * @param ingredient as a String
	 * @return a list of recipes that include that ingredients
	 */
	public List<Recipe> findRecipeByName(String ingre) {
		
		return null;
	}

	
	/**
	 * 
	 * @return a list of recipes that are vegetarian
	 */
	public List<Recipe> listALLVegRecipe(){
		List<Recipe>vegRecipes=new ArrayList<>();
		for(String s:this.recipeMap.keySet()) {
			if(recipeMap.get(s).getVegetarian()) {
				vegRecipes.add(recipeMap.get(s));
			}
		}		
		return vegRecipes;
	}
		
	

	
	//add picture to a recipe
	//modify a recipe
	//how often I use one recipe
}
