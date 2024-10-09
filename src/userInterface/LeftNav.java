package userInterface;




import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class LeftNav extends VBox{
	MenuButton recipe=new MenuButton("Recipe");
	Button randRecipe=new Button("supriseMe");
	RecipeButton recipeNav=new RecipeButton();
	
	
	public LeftNav() {
		this.getChildren().addAll(recipeNav,randRecipe);
		this.setSpacing(10);
//		setUpRecipeBtn();
	}

	public void setUpRecipeBtn() {
		MenuItem all= new MenuItem("All Recipes");
		MenuItem recent= new MenuItem("most Recent");
		MenuItem fav= new MenuItem("Tested");
		MenuItem toBeTested= new MenuItem("to Be Tested");	
		MenuItem baking=new MenuItem("Baking/Dessert");
		MenuItem cooking =new MenuItem("Cooking");
		recipe.getItems().addAll(all,recent,fav,toBeTested,baking,cooking);		
	}
}
