package userInterface;




import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logic.RecipeBook;

public class LeftNav extends VBox{
	Root root;
	
	
	Button all= new Button("All recipes");
	Button recent= new Button("Most Recent");
	Button tested= new Button("Favorite");
	Button toBeTested= new Button("Improvable");	
	Button baking=new Button("Baking");
	Button cooking =new Button("Cooking");
	Button vege=new Button("Vegetarian");
	//Button randRecipe=new Button("supriseMe");
	RecipeListView recipeListView;
		
	
	public LeftNav(Root root) {
		this.getChildren().addAll(all,recent,tested,toBeTested,baking,cooking,vege);
		this.setSpacing(10);
		this.setRecipeNavLayout();		
		this.recipeListView=root.getRecipeListView();
		this.root=root;
		this.setSpacing(10);		
		this.setBtns();
		this.getStyleClass().add("left-nav");
	}
	
	public void setBtns() {
		setBtnHelper(all,"recipeBook.png");
		setBtnHelper(tested,"fav.png");
		setBtnHelper(toBeTested,"questionable.png");
		setBtnHelper(vege,"vege.png");
		setBtnHelper(baking,"baking.png");
		setBtnHelper(cooking,"cooking.png");
		setBtnHelper(recent,"recent.png");
	
	}
	public void setBtnHelper(Button btn,String fileName) {
		
		//Image img = new Image("file:img/recipeBook.png");
		Image img = new Image("file:img/"+fileName);
		ImageView imgView=new ImageView();
		imgView.setFitHeight(40);
		imgView.setFitWidth(40);
		imgView.setImage(img);				
		btn.setGraphic(imgView);
		btn.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
		btn.getStyleClass().add("nav-btn");
		this.setMargin(btn, new Insets(5,5,5,5));
		
		
		
	}
	
	public void setRecipeNavLayout() {
			
		
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
