package userInterface;

import javafx.scene.control.ListView;
import logic.Recipe;
import logic.RecipeBook;


public class RecipeListView extends ListView<Recipe>{
	RecipeBook recipeBook;
	Root root;
	
	public RecipeListView(Root root,RecipeBook recipeBook) {
		this.recipeBook=recipeBook;
		this.root=root;
		this.setItems(recipeBook.getList());
		this.setCellFactory(listView -> new RecipeListCell());		
		this.showRecipe();
	}
	
	
	
	public void showRecipe() {
		this.setOnMouseClicked(event -> {
			
			Recipe selectedRecipe = this.getSelectionModel().getSelectedItem();
			System.out.println(selectedRecipe.getName());	
		    if (selectedRecipe != null) {
		        RecipeView recipeView=new RecipeView(selectedRecipe,root,recipeBook);
		        root.setCenter(recipeView);
		    }
		});
	
	}
}


