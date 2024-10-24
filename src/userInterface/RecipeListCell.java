package userInterface;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.Recipe;

public class RecipeListCell extends ListCell<Recipe> {
	private HBox container=new HBox();
	private ImageView thumbnail=new ImageView();
	private VBox infoArea=new VBox();
	private Label titleLabel=new Label();
	private Label servingLabel=new Label();
	private Label infoLabel=new Label();
	
	
	public RecipeListCell() {
		this.setLayout();
		this.setImageView();
		this.setInfoArea();
	}
	
	
	public void setLayout() {
		this.container.getChildren().addAll(thumbnail,infoArea);
		this.container.setSpacing(10);
	}
	
	public void setImageView() {
		
		this.thumbnail.setFitHeight(100);
		this.thumbnail.setFitWidth(100);
		this.thumbnail.setPreserveRatio(true);
		
		
	}
	public void setInfoArea() {				
		this.infoArea.getChildren().addAll(titleLabel,servingLabel,infoLabel);
	}
	
	public void updateItem(Recipe recipe,boolean empty) {
		  super.updateItem(recipe, empty);
		  if(empty||recipe==null) {
			  this.setGraphic(null);
		  }else {
			  Image img=new Image(recipe.getImageURL());
			  this.thumbnail.setImage(img);
			  this.titleLabel.setText(recipe.getName());
			  if(recipe.getServing()!=null) {
				  this.servingLabel.setText("Serving: "+ recipe.getServing());
			  }
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
				this.infoLabel.setText(infoString);
			  			  
			  //this is to set the HBOX container as the cell
			  this.setGraphic(container);
		  }
	}
}
