package userInterface;


import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class RecipeButton extends TitledPane{
	Button all= new Button("All Recipes");
	Button recent= new Button("most Recent");
	Button fav= new Button("Tested");
	Button toBeTested= new Button("to Be Tested");	
	Button baking=new Button("Baking/Dessert");
	Button cooking =new Button("Cooking");
	
	public RecipeButton() {
		setLayout();
	}
	
	public void setLayout() {
		VBox recipeBtns=new VBox();	
		recipeBtns.getChildren().addAll(all,recent,fav,toBeTested,baking,cooking);	
		recipeBtns.setSpacing(10);
		this.setText("Recipe");		
		this.setContent(recipeBtns);
	}
	
	
}
