package userInterface;

import java.util.Map;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseButton;
import logic.Recipe;
import logic.RecipeBook;


public class RecipeListView extends ListView<Recipe>{
	RecipeBook recipeBook;
	ObservableList<Recipe>selectdRecipes=FXCollections.observableArrayList();
	Root root;
	private boolean deleteMode=false;
	
	public RecipeListView(Root root,RecipeBook recipeBook) {
		this.recipeBook=recipeBook;
		this.root=root;
		
		this.setItems(recipeBook.getList());
		this.setCellFactory(listView -> new RecipeListCell(selectdRecipes));		
		this.selectAndShowRecipe();
	}
	
	public void selectAndShowRecipe() {		
		this.setOnMouseClicked(event -> {			
			Recipe selectedRecipe = this.getSelectionModel().getSelectedItem();			
		    if (selectedRecipe != null&&!deleteMode) {
		        RecipeView recipeView=new RecipeView(selectedRecipe,root,recipeBook);
		        root.setCenter(recipeView);
		    }
		});
	
	}
	
	 public void setCheckBoxVisibility(boolean b) {
	        // Lookup all visible cells based on the CSS class selector ".list-cell"
	        for (Node cell : this.lookupAll(".list-cell")) {
	            if (cell instanceof RecipeListCell) { // Ensure we’re working with RecipeListCell instances
	                ((RecipeListCell) cell).setCheckBoxVisible(b);
	            }
	        }
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
	
	public ObservableList<Recipe> showBakingRecipe() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe> bakingList = list.stream()
			    .filter(recipe -> recipe.getBaking() == true)
			    .collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(bakingList);
		return bakingList;
	}
	public void showCookingRecipe() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe>bakingList=this.showBakingRecipe();
		list.removeAll(bakingList);
		this.setItems(list);
	}
	
	public void showTestedRecipe() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe> testedList = list.stream()
			    .filter(recipe -> recipe.getTested() == true)
			    .collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(testedList);
	}
	
	public void showUntestedRecipe() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe> unTestedList = list.stream()
			    .filter(recipe -> recipe.getTested() == false)
			    .collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(unTestedList);
	}
	
	public void showVegetarianRecipe() {
		ObservableList<Recipe>list=recipeBook.getList();
		ObservableList<Recipe> vegeList = list.stream()
			    .filter(recipe -> recipe.getVegetarian() == true)
			    .collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(vegeList);
	}
	
	public void showSearchedRecipe(String s) {
		String sanitizedString=s.trim().toLowerCase();
		Map<String,Recipe>recipeMap=this.recipeBook.getRecipeMap();
		ObservableList<Recipe> searchedList = recipeMap.keySet().stream()
				.filter(key->key.trim().toLowerCase().contains(sanitizedString))
				.map(key->recipeMap.get(key))
				.collect(Collectors.toCollection(FXCollections::observableArrayList));
		this.setItems(searchedList);
		
	}
	
	public ObservableList<Recipe> getSelectedRecipe(){
		return this.selectdRecipes;
	}
	
	public void toggleDeleteMode(boolean b) {
		this.deleteMode=b;
	}
	
	public boolean getDeleteMode() {
		return this.deleteMode;
	}

		
}


