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
	
	Map<String,Recipe>recipes;
	ObservableList<Recipe> recipeList;
	
	public RecipeBook() {
		
		this.recipes=new HashMap<>();
		this.recipeList = FXCollections.observableArrayList();
		
	}
	
	public boolean isBakingRecipe(Recipe r) {
		return r.getBaking();
	}
	
	public ObservableList<Recipe> getList(){
		return this.recipeList;
	}
	
	public void add(Recipe recipe) {		
		this.recipes.put(recipe.getName(), recipe);
		this.recipeList.add(recipe);
	}
	
	public Boolean recipeExist(String s) {
		return recipes.containsKey(s);
	}
	
	
	public void delete(String str) {
		this.recipes.remove(str);
	}
	
	public void printAllrecipeName() {
		this.recipes.forEach((key,value)->{
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
		for(String s:this.recipes.keySet()) {
			if(recipes.get(s).getVegetarian()) {
				vegRecipes.add(recipes.get(s));
			}
		}		
		return vegRecipes;
	}
		
	

	
	//add picture to a recipe
	//modify a recipe
	//how often I use one recipe
}
