package userInterface;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchBar extends HBox{
	TextField searchField= new TextField();
	Button addRecipe=new Button("+");
	
	
	public SearchBar() {
		setLayout();
	}
	
	public void setLayout() {
		searchField.setPromptText("Enter a key word to Search Recipe");
		searchField.setFocusTraversable(false);
		
		this.setSpacing(40);;
		this.setAlignment(Pos.BASELINE_RIGHT);
		this.getChildren().addAll(searchField,addRecipe);
	}
}
