package userInterface;




import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import logic.RecipeBook;

public class LeftNav extends VBox{
	Root root;
	
	TitledPane recipeNav=new TitledPane();
	Button all= new Button("All Recipes");
	Button recent= new Button("most Recent");
	Button tested= new Button("Tested");
	Button toBeTested= new Button("to Be Tested");	
	Button baking=new Button("Baking/Dessert");
	Button cooking =new Button("Cooking");
	Button vege=new Button("vegetarian");
	Button randRecipe=new Button("supriseMe");
	RecipeListView recipeListView;
	
	
	
	
	
	public LeftNav(Root root) {
		this.getChildren().addAll(recipeNav,randRecipe);
		this.setSpacing(10);
		this.setRecipeNavLayout();		
		this.recipeListView=root.getRecipeListView();
		this.root=root;
	}
	
	public void setRecipeNavLayout() {
		VBox recipeBtns=new VBox();	
		recipeBtns.getChildren().addAll(all,recent,tested,toBeTested,baking,cooking,vege);	
		recipeBtns.setSpacing(10);
		recipeNav.setText("Recipe");		
		recipeNav.setContent(recipeBtns);
		
		all.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showAllRecipe();
		});
		recent.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showRecipeRecent();
		});
		tested.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showTestedRecipe();
		});
		toBeTested.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showUntestedRecipe();
		});
		baking.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showBakingRecipe();
		});
		cooking.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showCookingRecipe();
		});
		vege.setOnAction(e->{
			root.setCenter(recipeListView);
			this.recipeListView.showVegetarianRecipe();
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
