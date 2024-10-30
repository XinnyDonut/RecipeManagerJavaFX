package userInterface;

import javafx.scene.layout.BorderPane;
import logic.RecipeBook;

public class Root extends BorderPane{
	RecipeBook recipeBook;
	RecipeListView recipeListView;
	LeftNav leftNav;
	ControllerBar controllerBar;
	AddRecipeView addRecipeView;
	
	public Root(RecipeBook recipeBook) {
		this.recipeBook=recipeBook;		
		this.addRecipeView=new AddRecipeView(this,recipeBook);
		this.recipeListView=new RecipeListView(this,recipeBook);
		this.leftNav=new LeftNav(this);
		this.controllerBar =new ControllerBar(this,recipeBook);
		this.setInitialLayout();
		
		this.centerProperty().addListener((observable, oldValue, newValue) -> {
	            if (newValue instanceof RecipeListView) {
	                this.controllerBar.setDisable(false);  // Enable control bar if RecipeListView is shown
	            } else {
	                controllerBar.setDisable(true);   // Disable control bar if another view is shown
	            }
	        });
		
	}
	
	
	public void setInitialLayout() {					
		this.setLeft(leftNav);
		this.setTop(controllerBar);
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


	public ControllerBar getcontrollarBar() {
		return controllerBar;
	}


	public void setcontrollarBar(ControllerBar controllarBar) {
		this.controllerBar = controllarBar;
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

