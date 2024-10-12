package logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author xinxin
 */
public class RecipeBook {
	Map<String,Recipe>bakingRecipes;
	Map<String,Recipe>cookingRecipes;
	
	public RecipeBook() {
		this.bakingRecipes=new HashMap<>();
		this.cookingRecipes=new HashMap<>();
	}
	
	public boolean isBakingRecipe(Recipe r) {
		return r.getCategory()==Category.BAKING;
	}
	
	/**
	 *add a recipe either in the baking category or cooking category
	 */	
	public void add(Recipe recipe) {		
		if(this.isBakingRecipe(recipe)){
			bakingRecipes.putIfAbsent(recipe.getName(),recipe);
		}else {
			cookingRecipes.putIfAbsent(recipe.getName(),recipe);
		}
	}
	
	/**
	 *delete a recipe either in the baking category or cooking category
	 * @param str
	 */
	public void delete(String str) {
		
		if(this.bakingRecipes.containsKey(str)) {
			this.bakingRecipes.remove(str);
		}else {
			this.cookingRecipes.remove(str);
		}
	}
	
	/**
	 *enter a category and print out all the recipes that belong to that category
	 * @param ENUM category
	 */
	public void listRecipesByCategory(Category category) {
		//list all the recipe by catogory (either baking or cooking)
		List<String>recipeNames=new ArrayList<String>();
		if(category==Category.BAKING) {
			this.bakingRecipes.forEach((s,r)->recipeNames.add(s));
		}else {
			this.cookingRecipes.forEach((s,r)->recipeNames.add(s));
		}
	}
	
	
	/**
	 * 
	 * @param ingredient as a String
	 * @return a list of recipes that include that ingredients
	 */
	public List<Recipe> findRecipeByIngredient(String ingre) {
		
		List<Recipe>recipesToReturn=new ArrayList<Recipe>();
		
		for(String recipeStr:this.cookingRecipes.keySet()) {
			Set<String>ingredients=this.cookingRecipes.get(recipeStr).getIngre().keySet();
			for(String ingreStr:ingredients) {
				if(ingre.equals(ingreStr)) {
					recipesToReturn.add(this.cookingRecipes.get(recipeStr));
				}
			}
		}
		return recipesToReturn;
	}

	
	/**
	 * 
	 * @return a list of recipes that are vegetarian
	 */
	public List<Recipe> listALLVegRecipe(){
		List<Recipe>vegRecipes=new ArrayList<>();
		for(String s:this.cookingRecipes.keySet()) {
			if(cookingRecipes.get(s).getVegetarian()) {
				vegRecipes.add(cookingRecipes.get(s));
			}
		}		
		return vegRecipes;
	}
		
	

	
	//add picture to a recipe
	//modify a recipe
	//how often I use one recipe
}
