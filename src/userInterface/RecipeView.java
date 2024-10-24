package userInterface;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Recipe;
import logic.RecipeBook;

public class RecipeView extends VBox{
	private HBox topArea=new HBox();
	private HBox mainArea= new HBox();
	private VBox infoArea=new VBox();
	private ImageView imgView=new ImageView();
	
	private HBox bottomArea=new HBox();
	private Button editBtn=new Button("Edit");
	private Button recipeBtn=new Button("back to recipes");
	private Root root;
	private AddRecipeView editRecipeView;
	private RecipeBook recipeBook;
	private Recipe recipe;
	
	public RecipeView(Recipe recipe,Root root,RecipeBook rb) {
		this.root=root;
		this.recipe=recipe;
		this.setLayout();
		this.editRecipeView=new AddRecipeView(recipe,root,rb);
		
	}
	
	public void setLayout() {
		setTopAreaLayout();
		setMainAreaLayout();
		setBottomAreaLayout();
		ScrollPane scrollPane=new ScrollPane(this);
		scrollPane.setFitToWidth(true);  // Ensure VBox takes the full width of the ScrollPane
		scrollPane.setPannable(true);//allow dragging  
		this.getChildren().addAll(topArea,mainArea,bottomArea);
	}
	
	public void setImageView() {
		this.imgView.setImage(new Image(this.recipe.getImageURL()));
		this.imgView.setFitHeight(150);
		this.imgView.setFitWidth(150);
		this.imgView.setPreserveRatio(true);	
	}
	
	public void setInfoArea() {		
		Label name=new Label(recipe.getName());
		Label serving=new Label();
		Label info=new Label();
		serving.setText(serving!=null?"Serving: "+recipe.getServing():"Serving: ");
		
		String infoString="";
		if(recipe.getBaking()==true) {
			infoString+="Baking  ";
		}
		if(recipe.getTested()==true) {
			infoString+="Tested ";
		}
		if(recipe.getVegetarian()==true) {
			infoString+="Vegetarian";
		}
		info.setText(infoString);
		
		this.infoArea.getChildren().addAll(name,serving,info);
	}
		
	public void setTopAreaLayout() {
		setImageView();
		setInfoArea();
		this.topArea.getChildren().addAll(this.imgView,this.infoArea);		
		
	}
	
	public void setMainAreaLayout() {
		VBox ingreArea=new VBox();
		Label ingreLabel=new Label("Ingredients");
		TextArea ingredients=new TextArea(recipe.getIngre());
		ingredients.setEditable(false);
		ingredients.getStyleClass().add("read-only-textArea"); 
		ingreArea.getChildren().addAll(ingreLabel,ingredients);
		ingreArea.setSpacing(10);
		
		VBox instruArea=new VBox();
		Label instrLabel=new Label("Instructions");
		TextArea instructions= new TextArea(recipe.getInstructions());
		instructions.setEditable(false);
		instructions.getStyleClass().add("read-only-textArea");
		instruArea.getChildren().addAll(instrLabel,instructions);
		instruArea.setSpacing(10);
		
		
		this.mainArea.getChildren().addAll(ingreArea,instruArea);
		mainArea.setSpacing(10);
	}
	
	public void setBottomAreaLayout() {
		editBtn.setOnAction(e->{
			root.setCenter(this.editRecipeView);
		});
		recipeBtn.setOnAction(e->{
			root.setCenter(root.getRecipeListView());
		});
		this.bottomArea.getChildren().addAll(editBtn,recipeBtn);
	}
}
