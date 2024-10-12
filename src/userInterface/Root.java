package userInterface;

import javafx.scene.layout.BorderPane;

public class Root extends BorderPane{
	LeftNav leftNav=new LeftNav();
	SearchBar searchBar =new SearchBar(this);
	RecipeNav recipesNav=new RecipeNav();
	AddRecipeView addRecipeView=new AddRecipeView(this);
	
	public Root() {
		this.setInitialLayout();
	}
	
	
	public void setInitialLayout() {					
		this.setLeft(leftNav);
		this.setTop(searchBar);
		this.setCenter(recipesNav);
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


	public RecipeNav getRecipesNav() {
		return recipesNav;
	}


	public void setRecipesNav(RecipeNav recipesNav) {
		this.recipesNav = recipesNav;
	}


	public AddRecipeView getAddRecipeView() {
		return addRecipeView;
	}


	public void setAddRecipeView(AddRecipeView addRecipeView) {
		this.addRecipeView = addRecipeView;
	}
	
	

}

