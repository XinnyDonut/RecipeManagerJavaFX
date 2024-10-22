package userInterface;

import javafx.scene.layout.BorderPane;
import logic.RecipeBook;

public class Root extends BorderPane{
	RecipeBook recipeBook;
	RecipeListView recipeListView;
	LeftNav leftNav=new LeftNav();
	SearchBar searchBar =new SearchBar(this);
//	RecipeView recipeView;
	AddRecipeView addRecipeView;
	
	public Root(RecipeBook recipeBook) {
		this.recipeBook=recipeBook;
		this.addRecipeView=new AddRecipeView(this,recipeBook);
		this.recipeListView=new RecipeListView(this,recipeBook);
		this.setInitialLayout();
		
	}
	
	
	public void setInitialLayout() {					
		this.setLeft(leftNav);
		this.setTop(searchBar);
		this.setCenter(recipeListView);
	}


	
	
	
	
	public RecipeListView getRecipeListView() {
		return recipeListView;
	}


	public void setRecipeListView(RecipeListView recipeListView) {
		this.recipeListView = recipeListView;
	}


	public LeftNav getLeftNavPane() {
		return leftNav;
	}


	public void setLeftNavPane(LeftNav leftNav) {
		this.leftNav = leftNav;
	}


	public SearchBar getSearchBar() {
		return searchBar;
	}


	public void setSearchBar(SearchBar searchBar) {
		this.searchBar = searchBar;
	}


	public RecipeListView getRecipesNav() {
		return recipeListView;
	}


	public void setRecipesNav(RecipeListView recipesNav) {
		this.recipeListView = recipesNav;
	}


	public AddRecipeView getAddRecipeView() {
		return addRecipeView;
	}


	public void setAddRecipeView(AddRecipeView addRecipeView) {
		this.addRecipeView = addRecipeView;
	}
	
	

}

