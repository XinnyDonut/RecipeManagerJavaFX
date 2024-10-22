package userInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import logic.Recipe;
import logic.RecipeBook;

public class AddRecipeView extends VBox{
	Root root;
	HBox topArea=new HBox();
	HBox mainArea=new HBox();	
	HBox bottomArea=new HBox();
	VBox imageArea=new VBox();
	
	TextField nameField=new TextField();
	TextField servingField= new TextField();
	TextArea ingreContent=new TextArea();
	TextArea instruContent=new TextArea();
	CheckBox bakingCheck=new CheckBox("Baking recipe");
	CheckBox vegeCheck=new CheckBox("Vegetarian");
	CheckBox tested=new CheckBox("tested Recipe");	
	GridPane infoArea=new GridPane();
	String imageURL;
	RecipeBook recipeBook;
	Recipe recipe;
	ImageView imgView=new ImageView();
	
	
	//this is the view when user created a new recipe
	public AddRecipeView(Root root,RecipeBook rb) {
		this.setLayout();
		this.root=root;
		this.recipeBook=rb;		
	}
	
	//this is the view when user wants to edit a recipe, it loads the existing recipe's data 
	public AddRecipeView(Recipe recipe) {
		this.setLayout();
		this.nameField.setText(recipe.getName());
		this.ingreContent.setText(recipe.getIngre());
		this.instruContent.setText(recipe.getInstructions());
		//still need to handle checkBox
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
		
	}
	
	public void setImageAreaLayout() {
		
		imgView.setImage(new Image("file:img/placeholder.png"));
		imgView.setFitWidth(100);
		imgView.setFitHeight(100);
		imgView.setPreserveRatio(true);
		
		Button uploadBtn=new Button("upload image");
		
		uploadBtn.setOnAction(e->{
			FileChooser fileChooser=new FileChooser();
			File selectefFile=fileChooser.showOpenDialog(null);
			if(selectefFile!=null) {
				try {
					Image foodImg=new Image(new FileInputStream(selectefFile));
					imgView.setImage(foodImg);
					this.imageURL=selectefFile.toURI().toString();
					
				}catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}else {
				imgView.setImage(new Image("file:img/placeholder.png"));
			}
		});
		
		
		this.imageArea.getChildren().addAll(imgView,uploadBtn);
	}
	
	
	public void setMainAreaLayout() {
		VBox ingreArea=new VBox();
		VBox instruArea=new VBox();
		Label ingreLabel= new Label("Ingredients:");
		Label instruLabel=new Label("instructions:");
		
		ingreArea.getChildren().addAll(ingreLabel,ingreContent);
		instruArea.getChildren().addAll(instruLabel,instruContent);
		mainArea.getChildren().addAll(ingreArea,instruArea);
		mainArea.setSpacing(10);
				
	}
		
	public void setInfoAreaLayout() {
		Label nameLabel=new Label("name:");				
		this.infoArea.add(nameLabel,0,0);
		this.infoArea.add(nameField, 1, 0);		
		this.infoArea.add(bakingCheck, 0, 1);
		this.infoArea.add(vegeCheck, 1, 1);
		this.infoArea.add(tested, 0, 2);
		Label servingLabel=new Label("Serving");
		this.infoArea.add(servingLabel,0, 3);
		this.infoArea.add(servingField, 1, 3);
		
	}
			
	public void setBottomLayout() {
		
		Button save=new Button("save");
		Button cancel=new Button("cancel");
		cancel.setOnAction(e->root.setCenter(root.getRecipesNav()));
		
		save.setOnAction(e->{
			//In the future might need to add functiona that if recipe already exist, not adding
			String name=nameField.getText();	
			if(nameField.getText().isEmpty()) {
				return;
			}
			if(this.recipeBook.containRecipe(name)) {
				this.recipe=this.recipeBook.getRecipe(name);
			}else {
				this.recipe=new Recipe();
				this.recipeBook.add(recipe);
			}
				recipe.setName(name);	
				recipe.setBaking(bakingCheck.isSelected());			
				recipe.setVegetarian(vegeCheck.isSelected());
				recipe.setTested(tested.isSelected());
				//need to handle exceptions here,or should i use combo box so user can only select a num
				if(!servingField.getText().isEmpty()) {
					recipe.setServing(Double.parseDouble(servingField.getText()));
				}
				recipe.setIngre(ingreContent.getText());
				recipe.setInstructions(instruContent.getText());
				recipe.setImageURl(this.imageURL);
				recipe.setRecipePicView(recipe.getImageURL());
				
				
				
				
				//recipeBook.printAllrecipeName();
				root.setCenter(root.getRecipesNav());
					
		});
		bottomArea.getChildren().addAll(save,cancel);
	}
	
}
