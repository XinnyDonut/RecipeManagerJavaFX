package userInterface;



import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
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
	private HBox labelbox=new HBox();
	private Label titleLabel=new Label();
	private Label servingLabel=new Label("Makes: ");
	private CheckBox checkBox=new CheckBox();
	private ObservableList<Recipe> selectedRecipes;
	
	
		
	public RecipeListCell(ObservableList<Recipe> selectedRecipes) {
		this.setLayout();
		this.setImageView();
		this.setInfoArea();
		this.getStyleClass().add(".list-cell");
		this.selectedRecipes=selectedRecipes;
		
		checkBox.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
	            Recipe recipe = getItem();
	            if (recipe != null) {
	                if (isSelected) {
	                    selectedRecipes.add(recipe); 
	                } else {
	                    selectedRecipes.remove(recipe); 
	                }
	            }
	            
	        });
		
	}
		
	public void setLayout() {
		this.setCheckBoxVisible(false);
		this.container.getChildren().addAll(checkBox,thumbnail,infoArea);
		this.container.setSpacing(10);
	}
	
	public void setImageView() {		
		this.thumbnail.setFitHeight(100);
		this.thumbnail.setFitWidth(100);
		//this.thumbnail.setPreserveRatio(true);	
	}
	public void setInfoArea() {		
		this.labelbox.getChildren().addAll(servingLabel);
		labelbox.setSpacing(5);
		this.infoArea.getChildren().addAll(titleLabel,labelbox);
		infoArea.setSpacing(20);
		
		titleLabel.getStyleClass().add("recipe-title");
		servingLabel.getStyleClass().add("listView-label");
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
				  this.servingLabel.setText("Makes: "+ recipe.getServing());
			  }			
			  			  
			  //this is to set the HBOX container as the cell
			  this.setGraphic(container);
			  //important to check this due to how listview is using the cell
			  checkBox.setSelected(selectedRecipes.contains(recipe));
			 
		  }
	}
	
	public void setCheckBoxVisible(Boolean b) {
		this.checkBox.setVisible(b);
		//use setManaged to false so the checkbox doesn't occupy space when invisible
		this.checkBox.setManaged(b);
	}


}
