package userInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import logic.Recipe;
import logic.RecipeBook;

public class AddRecipeView extends VBox{
	public static final String PLACE_HOLDER_URL="file:img/placeholder.png";
	Root root;
	HBox topArea=new HBox();
	HBox mainArea=new HBox();	
	HBox bottomArea=new HBox();
	VBox imageArea=new VBox();
	
	TextField nameField=new TextField();
	TextField servingField= new TextField();
	TextArea ingreContent=new TextArea();
	TextArea instruContent=new TextArea();
	CheckBox bakingCheck=new CheckBox("Baking");
	CheckBox vegeCheck=new CheckBox("Vegetarian");
	CheckBox tested=new CheckBox("Favorite");	
	GridPane infoArea=new GridPane();
	RecipeBook recipeBook;
	String uploadedURL;
	Recipe recipe;
	RecipeView recipeView;
	
	ImageView imgView=new ImageView();
	
	
	//this is the view when user created a new recipe
	public AddRecipeView(Root root,RecipeBook rb) {
		
		this.setLayout();
		this.root=root;
		this.recipeBook=rb;
		
	}
	
	//this is the view when user wants to edit a recipe, it loads the existing recipe's data 
	public AddRecipeView(Recipe recipe,Root root,RecipeBook recipeBook) {		
		this.root=root;
		this.recipe=recipe;
		this.recipeBook=recipeBook;
		
		this.setLayout();
		this.bakingCheck.setSelected(recipe.getBaking());
		this.vegeCheck.setSelected(recipe.getVegetarian());
		this.tested.setSelected(recipe.getTested());
		this.nameField.setText(recipe.getName());
		this.ingreContent.setText(recipe.getIngre());
		this.instruContent.setText(recipe.getInstructions());
		this.servingField.setText(recipe.getServing());
		this.imgView.setImage(new Image(recipe.getImageURL()));
	}
	
	public void setLayout() {
		this.setTopAreaLayout();
		this.setMainAreaLayout();
		this.setBottomLayout();
		this.getChildren().addAll(topArea,mainArea,bottomArea);
	}
	
	
	public void setTopAreaLayout() {
		setImageAreaLayout();
		setInfoAreaLayout();	
		this.topArea.getChildren().addAll(imageArea,infoArea);
		this.topArea.setSpacing(20);
		topArea.setPadding(new Insets(10));
		
	}
	
	public void setImageAreaLayout() {
		
		imgView.setImage(new Image(PLACE_HOLDER_URL));
		imgView.setFitWidth(150);
		imgView.setFitHeight(150);
		imgView.setPreserveRatio(true);
		
		Button uploadBtn=new Button("upload image");
		
		uploadBtn.setOnAction(e->{
			FileChooser fileChooser=new FileChooser();
			File selectefFile=fileChooser.showOpenDialog(null);
			if(selectefFile!=null) {
				try {
					Image foodImg=new Image(new FileInputStream(selectefFile));
					imgView.setImage(foodImg);
					this.uploadedURL=selectefFile.toURI().toString();
					
				}catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}else {
				imgView.setImage(new Image(PLACE_HOLDER_URL));
			}
		});
		
		
		this.imageArea.getChildren().addAll(imgView,uploadBtn);
		this.imageArea.setSpacing(10);
		
	}
	
	
	public void setMainAreaLayout() {
		VBox ingreArea=new VBox();
		VBox instruArea=new VBox();
		Label ingreLabel= new Label("Ingredients:");
		ingreLabel.getStyleClass().add("recipe-label");
		Label instruLabel=new Label("instructions:");
		instruLabel.getStyleClass().add("recipe-label");
		
		ingreArea.getChildren().addAll(ingreLabel,ingreContent);
		instruArea.getChildren().addAll(instruLabel,instruContent);
		ingreArea.setSpacing(10);
		instruArea.setSpacing(10);
		ingreContent.setPrefHeight(300);
		ingreContent.setWrapText(true);
		instruContent.setPrefHeight(300);
		instruContent.setWrapText(true);
		
		
		ingreArea.setPadding(new Insets(10));
	    instruArea.setPadding(new Insets(10));
	    HBox.setHgrow(instruArea, Priority.ALWAYS); 
	    HBox.setHgrow(ingreArea, Priority.ALWAYS); 
	     
		ingreArea.setAlignment(Pos.TOP_CENTER);
		instruArea.setAlignment(Pos.TOP_CENTER);
		mainArea.getChildren().addAll(ingreArea,instruArea);
		mainArea.setSpacing(10);
		mainArea.setPadding(new Insets(3));
				
	}
		
	public void setInfoAreaLayout() {
		Label nameLabel=new Label("Name:");
		Label servingLabel=new Label("Serving:");
		this.infoArea.add(nameLabel,0,0);
		this.infoArea.add(nameField, 1, 0);		
		this.infoArea.add(bakingCheck, 0, 2);
		this.infoArea.add(vegeCheck, 1, 2);
		this.infoArea.add(tested, 0, 3);	
		this.infoArea.add(servingLabel,0, 1);
		this.infoArea.add(servingField, 1, 1);
		
		infoArea.setHgap(4);
		infoArea.setVgap(8);
		
		
	}
			
	public void setBottomLayout() {
		
		Button save=new Button("save");
		Button cancel=new Button("cancel");
		cancel.setOnAction(e->root.setCenter(root.getRecipesNav()));
		
		save.setOnAction(e->{
			//In the future might need to add function that if recipe already exist, not adding
			String name=nameField.getText();
			
			if(nameField.getText().isEmpty()) {
				return;
			}
			if(this.recipe==null) {
				recipe=new Recipe();				
				recipe.setName(name);	
				recipe.setBaking(bakingCheck.isSelected());			
				recipe.setVegetarian(vegeCheck.isSelected());
				recipe.setTested(tested.isSelected());
				//need to handle exceptions here,or should i use combo box so user can only select a num
				if(!servingField.getText().isEmpty()) {
					recipe.setServing(servingField.getText());
				}
				recipe.setIngre(ingreContent.getText());
				recipe.setInstructions(instruContent.getText());
				if(this.uploadedURL!=null) {
					recipe.setImageURl(this.uploadedURL);
				}else {
					recipe.setImageURl(PLACE_HOLDER_URL);
				}
				recipe.setRecipePicView(recipe.getImageURL());
				this.recipeBook.add(recipe);
				
				
			}else {
				String oldName=recipe.getName();
				recipe.setName(name);	
				recipe.setBaking(bakingCheck.isSelected());			
				recipe.setVegetarian(vegeCheck.isSelected());
				recipe.setTested(tested.isSelected());
				
				if(servingField.getText()!=null) {
					recipe.setServing(servingField.getText());
				}
				recipe.setIngre(ingreContent.getText());
				recipe.setInstructions(instruContent.getText());
				if(this.uploadedURL!=null) {
					recipe.setImageURl(this.uploadedURL);
				}			
				recipe.setRecipePicView(recipe.getImageURL());
				this.recipeBook.updateRecipe(recipe, oldName);
											
			}
			
			root.setCenter(root.getRecipesNav());
								
		});
		bottomArea.getChildren().addAll(save,cancel);
		bottomArea.setPadding(new Insets(10));
	}
	
	public void clearFields() {
	    this.recipe = null;  
	    this.bakingCheck.setSelected(false);
	    this.vegeCheck.setSelected(false);
	    this.tested.setSelected(false);
	    this.nameField.clear();
	    this.ingreContent.clear();
	    this.instruContent.clear();
	    this.servingField.clear();
	    this.imgView.setImage(new Image(PLACE_HOLDER_URL));
	    this.uploadedURL=null;
	}
	
}
