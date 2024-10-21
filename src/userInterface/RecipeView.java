package userInterface;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Recipe;

public class RecipeView extends VBox{
	private HBox topArea=new HBox();
	private HBox mainArea= new HBox();
	private VBox infoArea=new VBox();
	private ImageView imgView=new ImageView();
	private Recipe recipe;
	
	public RecipeView(Recipe recipe) {
		this.recipe=recipe;
		this.setLayout();
	}
	
	public void setLayout() {
		setTopAreaLayout();
		setMainAreaLayout();
		ScrollPane scrollPane=new ScrollPane(this);
		scrollPane.setFitToWidth(true);  // Ensure VBox takes the full width of the ScrollPane
		scrollPane.setPannable(true);//allow dragging  
		this.getChildren().addAll(topArea,mainArea);
	}
	
	public void setImageView() {
		this.imgView.setImage(new Image(this.recipe.getImageURL()));
		this.imgView.setFitHeight(150);
		this.imgView.setFitWidth(150);
		this.imgView.setPreserveRatio(true);	
	}
	
	public void setInfoArea() {
		
		Label name=new Label(recipe.getName());
		this.infoArea.getChildren().addAll(name);
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
		ingreArea.getChildren().addAll(ingreLabel,ingredients);
		ingreArea.setSpacing(10);
		
		VBox instruArea=new VBox();
		Label instrLabel=new Label("Instructions");
		TextArea instructions= new TextArea(recipe.getInstructions());
		instructions.setEditable(false);
		instruArea.getChildren().addAll(instrLabel,instructions);
		instruArea.setSpacing(10);
		
		
		this.mainArea.getChildren().addAll(ingreArea,instruArea);
		mainArea.setSpacing(10);
	}
}
