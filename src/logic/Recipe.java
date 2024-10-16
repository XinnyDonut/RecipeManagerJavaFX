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
	private Boolean baking;
	private Boolean vegetarian;
	private Boolean tested;
	private Image img;
	private ImageView imgView=new ImageView();
	
	public Recipe() {
		
	}
	
	public void setRecipePic(Image img) {
		this.img=img;
	}
	public Image getRecipePic() {
		return this.img;
	}
	
	public void setRecipePicView(Image img) {
		this.imgView.setImage(img);
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
	
	public void deleteIngre(String s) {
		this.ingredients.replace(s, "");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String,String> getIngre() {
		return ingreMap;
	}


	public String getInstructions() {
		return instructions;
	}

	
	public Boolean getVegetarian() {
		return this.vegetarian;
	}

	public void setVegetarian(Boolean b) {
		this.vegetarian = b;
	}
	
	public void setBaking(Boolean b) {
		this.baking=b;
	}
	
	public boolean getBaking() {
		return this.baking;
	}
	public void setTested(Boolean b) {
		this.tested=b;
	}
	
	public Boolean getTested(Boolean b) {
		return this.tested;
	}

	public double getServing() {
		return serving;
	}
	public void setServing(double serving) {
		this.serving = serving;
	}
	
	
	
	
	
}

