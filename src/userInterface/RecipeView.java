package userInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
		name.getStyleClass().add("recipe-title");
		Label serving=new Label();
		Label info=new Label();
		serving.setText(recipe.getServing()!=null?"Serving: "+recipe.getServing():"Serving: ");
		
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
		
		
		info.setStyle("-fx-font-style: italic");
		HBox infoBox=new HBox(info);
		infoBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		this.infoArea.getChildren().addAll(name,serving,info);
		infoArea.setSpacing(20);
		
	}
		
	public void setTopAreaLayout() {
		setImageView();
		setInfoArea();
		this.topArea.getChildren().addAll(this.imgView,this.infoArea);
		topArea.setPadding(new Insets(10));
		
		
	}
	
	public void setMainAreaLayout() {
		VBox ingreArea=new VBox();
		Label ingreLabel=new Label("Ingredients");
		ingreLabel.getStyleClass().add("recipe-label");
		TextArea ingredients=new TextArea(recipe.getIngre());
		ingredients.setEditable(false);
		ingredients.getStyleClass().add("read-only-textArea"); 
		ingreArea.getChildren().addAll(ingreLabel,ingredients);
		ingreArea.setSpacing(10);		
		ingredients.setWrapText(true);
	    ingredients.setPrefHeight(300); // Ensure consistent height
	    ingreArea.setPadding(new Insets(10));
	    HBox.setHgrow(ingreArea, Priority.ALWAYS);
	    ingreArea.setAlignment(Pos.CENTER);
		
		VBox instruArea=new VBox();
		Label instrLabel=new Label("Instructions");
		instrLabel.getStyleClass().add("recipe-label");
		TextArea instructions= new TextArea(recipe.getInstructions());
		instructions.setEditable(false);
		instructions.getStyleClass().add("read-only-textArea");
		instruArea.getChildren().addAll(instrLabel,instructions);
		instruArea.setSpacing(10);
		instructions.setWrapText(true);
	    instructions.setPrefHeight(300);
	    instruArea.setPadding(new Insets(10));
	    HBox.setHgrow(instruArea, Priority.ALWAYS); 
	    instruArea.setAlignment(Pos.CENTER);
		
//		this.autoResizeTextArea(instructions);
//		this.autoResizeTextArea(ingredients);
		
		this.mainArea.getChildren().addAll(ingreArea,instruArea);
		mainArea.setSpacing(10);
		mainArea.setPadding(new Insets(3));
		
	}
	
	public void setBottomAreaLayout() {
		editBtn.setOnAction(e->{
			root.setCenter(this.editRecipeView);
		});
		recipeBtn.setOnAction(e->{
			root.setCenter(root.getRecipeListView());
		});
		this.bottomArea.getChildren().addAll(editBtn,recipeBtn);
		bottomArea.setPadding(new Insets(10));
	}
	
	private void autoResizeTextArea(TextArea textArea) {
        textArea.setWrapText(true); // Enable text wrapping
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            // Set the preferred height based on the text content
            textArea.setPrefHeight(textArea.getPrefRowCount() * textArea.getFont().getSize() + 20);
        });
    }
}
