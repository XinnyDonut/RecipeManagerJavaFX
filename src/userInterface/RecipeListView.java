package userInterface;

import java.util.Map;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		this.selectAndShowRecipe();
	}
	
	public void selectAndShowRecipe() {
		this.setOnMouseClicked(event -> {			
			Recipe selectedRecipe = this.getSelectionModel().getSelectedItem();			
		    if (selectedRecipe != null) {
		        RecipeView recipeView=new RecipeView(selectedRecipe,root,recipeBook);
		        root.setCenter(recipeView);
		    }
		});
	
	}
	
	public void showAllRecipe() {
		this.setItems(recipeBook.getList());
	}
	
	
	public void showRecipeRecent() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe>reveseList=FXCollections.observableArrayList();
		for(int i =list.size()-1;i>=0;i--) {
			reveseList.add(list.get(i));
		}
		
		this.setItems(reveseList);
	}
	
	public void showBakingRecipe() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe> bakingList = list.stream()
			    .filter(recipe -> recipe.getBaking() == true)
			    .collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(bakingList);
	}
	
	public void showTestedRecipe() {
		
	}
	
	public void showVegetarianRecipe() {
		
	}
	
	public void showSearchedRecipe(String s) {
		Map<String,Recipe>recipeMap=this.recipeBook.getRecipeMap();
		ObservableList<Recipe> searchedList = recipeMap.keySet().stream()
				.filter(key->key.contains(s))
				.map(key->recipeMap.get(key))
				.collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(searchedList);
		
	}
		
}


