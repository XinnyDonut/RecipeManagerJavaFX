package logic;

import java.sql.*;


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
	
	public void saveRecipe() {
		
	}
}
