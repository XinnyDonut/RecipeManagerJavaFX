package logic;
import java.util.HashMap;

import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Recipe {
	private String name;
	private Map<String,String>ingreMap;
	private String instructions;
	private String ingredients;
	private double serving;
	private boolean baking=false;
	private boolean vegetarian=false;
	private boolean tested=false;
	
	private String imgURL;
	private ImageView imgView=new ImageView();
	
	public Recipe() {
		
	}
	
	public void setImageURl(String url) {
		this.imgURL=url;
	}
	public String getImageURL() {
		return this.imgURL;
	}
	
	public void setRecipePicView(String imgURL) {
		imgView.setImage(new Image(imgURL));
		imgView.setFitHeight(100);
		imgView.setFitWidth(100);
		imgView.setPreserveRatio(true);
	}
	
	public void setIngre(String s) {
		this.ingredients=s;
	}
	public void setInstructions(String s) {
		this.instructions=s;
	}
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngre() {
		return ingredients;
	}


	public String getInstructions() {
		return instructions;
	}

	
	public boolean getVegetarian() {
		return this.vegetarian;
	}

	public void setVegetarian(boolean b) {
		this.vegetarian = b;
	}
	
	public void setBaking(boolean b) {
		this.baking=b;
	}
	
	public boolean getBaking() {
		return this.baking;
	}
	public void setTested(boolean b) {
		this.tested=b;
	}
	
	public boolean getTested() {
		return this.tested;
	}

	public double getServing() {
		return serving;
	}
	public void setServing(double serving) {
		this.serving = serving;
	}
	
	
	
	
	
}

