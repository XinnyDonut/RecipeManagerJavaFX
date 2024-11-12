package userInterface;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Recipe;
import logic.RecipeBook;

public class ControllerBar extends VBox{
	HBox deleteBar=new HBox();
	Button deleteSelectedBtn=new Button("Delete selected");
	Button cancelBtn=new Button("Cancel");
	
	HBox SearchBar=new HBox();
	TextField searchField= new TextField();
	Button addRecipeBtn=new Button("+");
	Button toggleDeleteBtn=new Button();
	
	RecipeBook recipeBook;
	Root root;
		
	public ControllerBar(Root root,RecipeBook recipeBook) {
		this.root=root;
		this.recipeBook=recipeBook;
		setLayout();
	}
	
	
	public void setLayout() {
		this.setSearchBar();
		this.setDeleteBar();
		this.toggleDeleteBar(false);
		this.getChildren().addAll(SearchBar,deleteBar);
	
	}
	
	public void setSearchBar() {
		searchField.setPromptText("Enter to Search a recipe");
		searchField.setFocusTraversable(false);
		
		this.SearchBar.setSpacing(40);;
		this.SearchBar.setAlignment(Pos.BASELINE_RIGHT);
		this.SearchBar.getChildren().addAll(searchField,addRecipeBtn,toggleDeleteBtn);
		this.SearchBar.getStyleClass().add("controller-bar");
		addRecipeBtn.setOnAction(e->{
			this.root.getAddRecipeView().clearFields();
			this.root.setCenter(root.getAddRecipeView());
		
		});
		searchField.setOnAction(e->{
			String searchedString=this.searchField.getText();
			root.getRecipeListView().showSearchedRecipe(searchedString);
			root.setCenter(root.getRecipeListView());
		});
		toggleDeleteBtn.setOnAction(e->{
			this.getRoot().getRecipeListView().setCheckBoxVisibility(true);
			this.toggleDeleteBar(true);
			this.getRoot().getRecipeListView().toggleDeleteMode(true);
			this.SearchBar.setDisable(true);
		   
		});
		
		this.setBtnStyleHelper();
		
	}
	
	public void setDeleteBar() {
		this.deleteBar.getChildren().addAll(deleteSelectedBtn,cancelBtn);
		this.deleteBar.setAlignment(Pos.BASELINE_RIGHT);
		this.deleteBar.setSpacing(40);
		this.SearchBar.getStyleClass().add("controller-bar");
		cancelBtn.setOnAction(e->{
			this.getRoot().getRecipeListView().setCheckBoxVisibility(false);
			toggleDeleteBar(false);
			this.SearchBar.setDisable(false);
			this.getRoot().getRecipeListView().toggleDeleteMode(false);
			   
			
		});
		deleteSelectedBtn.setOnAction(e->{
			
			ObservableList<Recipe>recipeToDelete=this.getRoot().getRecipeListView().getSelectedRecipe();
			
			recipeToDelete.forEach(r->System.out.println(r.getName()));
			this.recipeBook.deleteMultipleRecipe(recipeToDelete);
			this.getRoot().getRecipeListView().setCheckBoxVisibility(false);
			toggleDeleteBar(false);
			this.SearchBar.setDisable(false);
			this.getRoot().getRecipeListView().toggleDeleteMode(false);
			
		});
		
		
		
	}
	
	public void toggleDeleteBar(Boolean b) {
		this.deleteBar.setVisible(b);
		this.deleteBar.setManaged(b);
	}
	
	public void setBtnStyleHelper() {
		Image img = new Image("file:img/delete.png");
		ImageView imgView=new ImageView();
		imgView.setFitHeight(15);
		imgView.setFitWidth(15);
		imgView.setImage(img);				
		toggleDeleteBtn.setGraphic(imgView);
		toggleDeleteBtn.getStyleClass().add("controllerBar-btn");
		addRecipeBtn.getStyleClass().add("controllerBar-btn");
		
		
	}
	
	public Root getRoot() {
		return this.root;
	}
	
	public Button getToggleDeButton() {
		return this.toggleDeleteBtn;
	}
}
