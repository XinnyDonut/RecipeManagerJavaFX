package userInterface;

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

public class AddRecipeView extends VBox{
	Root root;
	HBox topArea=new HBox();
	HBox mainArea=new HBox();
	HBox bottomArea=new HBox();
	VBox imageArea=new VBox();
	GridPane infoArea=new GridPane();
	
	
	public AddRecipeView(Root root) {
		this.setLayout();
		this.root=root;
		
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
	
	public void setMainAreaLayout() {
		
		TextArea ingre=new TextArea();
		TextArea instru=new TextArea();
		mainArea.getChildren().addAll(ingre,instru);
		
	}
	
	public void setImageAreaLayout() {
		ImageView img=new ImageView();
		img.setImage(new Image("file:img/placeholder.png"));
		img.setFitWidth(70);
		img.setFitHeight(70);
		
		Button uploadBtn=new Button("upload image");
		this.imageArea.getChildren().addAll(img,uploadBtn);
	}
	
	public void setInfoAreaLayout() {
		Label nameLabel=new Label("name:");
		TextField nameField=new TextField();
		CheckBox bakingCheck=new CheckBox("Baking recipe");
		CheckBox vegeCheck=new CheckBox("Vegetarian");
		CheckBox tested=new CheckBox("tested Recipe");
		
		
		
		
		
		
		this.infoArea.add(nameLabel,0,0);
		this.infoArea.add(nameField, 1, 0);
		this.infoArea.add(bakingCheck, 0, 1);
		this.infoArea.add(vegeCheck, 1, 1);
		this.infoArea.add(tested, 0, 2);
		
	}
	
	
	
	
	
	
	
	public void setBottomLayout() {
		
		Button save=new Button("save");
		Button cancel=new Button("cancel");
		cancel.setOnAction(e->root.setCenter(root.getRecipesNav()));
		bottomArea.getChildren().addAll(save,cancel);
	}
	
}
