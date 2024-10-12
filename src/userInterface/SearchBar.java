package userInterface;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SearchBar extends HBox{
	TextField searchField= new TextField();
	Button addRecipeBtn=new Button("+");
	Root root;
	
	public SearchBar() {
		setLayout();
	}
	
	public SearchBar(Root root) {
		this.root=root;
		setLayout();
	}
	
	public void setLayout() {
		searchField.setPromptText("Enter a key word to Search Recipe");
		searchField.setFocusTraversable(false);
		
		this.setSpacing(40);;
		this.setAlignment(Pos.BASELINE_RIGHT);
		this.getChildren().addAll(searchField,addRecipeBtn);
		this.setAddRecipeBtn();
	}
	
	public void setAddRecipeBtn() {
		addRecipeBtn.setOnAction(e->this.root.setCenter(root.getAddRecipeView()));
	}
}
