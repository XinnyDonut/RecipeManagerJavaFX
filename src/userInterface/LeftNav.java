package userInterface;




import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import logic.RecipeBook;

public class LeftNav extends VBox{
	//MenuButton recipe=new MenuButton("Recipe");
	
	TitledPane recipeNav=new TitledPane();
	Button all= new Button("All Recipes");
	Button recent= new Button("most Recent");
	Button tested= new Button("Tested");
	Button toBeTested= new Button("to Be Tested");	
	Button baking=new Button("Baking/Dessert");
	Button cooking =new Button("Cooking");
	Button randRecipe=new Button("supriseMe");
	RecipeListView recipeListView;
	
	
	
	
	
	public LeftNav(RecipeListView recipeListView) {
		this.getChildren().addAll(recipeNav,randRecipe);
		this.setSpacing(10);
		this.setRecipeNavLayout();		
		this.recipeListView=recipeListView;
	}
	
	public void setRecipeNavLayout() {
		VBox recipeBtns=new VBox();	
		recipeBtns.getChildren().addAll(all,recent,tested,toBeTested,baking,cooking);	
		recipeBtns.setSpacing(10);
		recipeNav.setText("Recipe");		
		recipeNav.setContent(recipeBtns);
		
		all.setOnAction(e->{
			this.recipeListView.showAllRecipe();
		});
		recent.setOnAction(e->{
			this.recipeListView.showRecipeRecent();
		});
		tested.setOnAction(e->{
			this.recipeListView.showTestedRecipe();
		});
		
		
		
		
	}
	

//	public void setUpRecipeBtn() {
//		MenuItem all= new MenuItem("All Recipes");
//		MenuItem recent= new MenuItem("most Recent");
//		MenuItem fav= new MenuItem("Tested");
//		MenuItem toBeTested= new MenuItem("to Be Tested");	
//		MenuItem baking=new MenuItem("Baking/Dessert");
//		MenuItem cooking =new MenuItem("Cooking");
//		recipe.getItems().addAll(all,recent,fav,toBeTested,baking,cooking);		
//	}
}
