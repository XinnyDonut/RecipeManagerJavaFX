package logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RecipeDAO {
	private static final String DATABASE_URL="jdbc:sqlite:recipe.db";
	
	private Connection connect()throws SQLException{
		
		return DriverManager.getConnection(DATABASE_URL);
	}
	
	public boolean dbisConnected() {
		try {
			Connection conn=this.connect();
			System.out.println("db is connected");
			return !conn.isClosed();
		
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("not connected");
			return false;
		}
	}
	
	public void saveRecipeDB(Recipe recipe) {
	    String sql = "INSERT INTO recipes (name, baking, vegetarian, tested, serving, ingredients, instructions, img_URL) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, recipe.getName()); 
	        
	        // Use null for optional fields if they are not provided
	        pstmt.setInt(2, recipe.getBaking()==true ? 1 : 0);
	        pstmt.setInt(3, recipe.getVegetarian()==true ? 1 : 0);
	        pstmt.setInt(4, recipe.getTested()==true ? 1 : 0);
	        pstmt.setObject(5, recipe.getServing() > 0 ? recipe.getServing() : null);  // Example of conditionally checking values
	        pstmt.setString(6, recipe.getIngre() != null ? recipe.getIngre() : null);
	        pstmt.setString(7, recipe.getInstructions() != null ? recipe.getInstructions() : null);
	        pstmt.setString(8, recipe.getImageURL() != null ? recipe.getImageURL() : null);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	public void updateRecipeDB(Recipe recipe, String oldName) {
	    String sql = "UPDATE recipes SET name = ?, baking = ?, vegetarian = ?, tested = ?, serving = ?, ingredients = ?, instructions = ?, img_URL = ? WHERE name = ?";
	    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, recipe.getName());  // New or unchanged name
	        pstmt.setInt(2, recipe.getBaking() ? 1 : 0);
	        pstmt.setInt(3, recipe.getVegetarian() ? 1 : 0);
	        pstmt.setInt(4, recipe.getTested() ? 1 : 0);
	        pstmt.setObject(5, recipe.getServing() > 0 ? recipe.getServing() : null);
	        pstmt.setString(6, recipe.getIngre() != null ? recipe.getIngre() : null);
	        pstmt.setString(7, recipe.getInstructions() != null ? recipe.getInstructions() : null);
	        pstmt.setString(8, recipe.getImageURL() != null ? recipe.getImageURL() : null);
	        pstmt.setString(9, oldName);  // Match the recipe by its old name
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void deleteRecipeByName(String name) {
        String sql = "DELETE FROM recipes WHERE name = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting recipe: " + e.getMessage());
        }
    }

    // Method to get all recipes from the database
    public ObservableList<Recipe> getAllRecipes() {
        ObservableList<Recipe> recipes = FXCollections.observableArrayList();
        String sql = "SELECT * FROM recipes";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setName(rs.getString("name"));
                recipe.setBaking(rs.getBoolean("baking"));
                recipe.setVegetarian(rs.getBoolean("vegetarian"));
                recipe.setTested(rs.getBoolean("tested"));
                recipe.setServing(rs.getDouble("serving"));
                recipe.setIngre(rs.getString("ingredients"));
                recipe.setInstructions(rs.getString("instructions"));
                recipe.setImageURl(rs.getString("img_URL")); // Assuming image path is stored
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving recipes: " + e.getMessage());
        }
        return recipes;
    }
	
	
	
	
}
