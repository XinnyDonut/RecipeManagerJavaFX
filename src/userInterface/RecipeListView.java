package userInterface;

import javafx.scene.control.ListView;
import logic.Recipe;
import logic.RecipeBook;


public class RecipeListView extends ListView<Recipe>{
	RecipeBook recipeBook;
	
	public RecipeListView(RecipeBook recipeBook) {
		this.recipeBook=recipeBook;
		this.setItems(recipeBook.getData().getAllRecipes());
		this.setCellFactory(listView -> new RecipeListCell());
	}
	
	
}


