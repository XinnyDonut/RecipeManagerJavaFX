package logic;
import java.util.HashMap;

import java.util.Map;

public class Recipe {
	private String name;
	private Map<String,String>ingreMap;
	private String instructions;
	private String ingredients;
	private double serving;
	private Boolean baking;
	private Boolean vegetarian;
	private Boolean tested;
	
	public Recipe(String name) {
		this.name=name;		
		this.ingreMap=new HashMap<String, String>();
//		this.tested=false;
//		this.baking=false;
//		this.vegetarian=false;
		
	}
//
//	public void addIngre(String ingreName,String quantity) {
//		this.ingreMap.putIfAbsent(ingreName, quantity);
//	}
	
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

