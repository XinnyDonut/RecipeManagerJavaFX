package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import logic.Recipe;
import logic.RecipeBook;
import logic.RecipeDAO;
import userInterface.LeftNav;
import userInterface.Root;
import userInterface.RecipeListView;
import userInterface.ControllerBar;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	public void start(Stage primaryStage) {
		try {
			RecipeDAO data=new RecipeDAO();
			RecipeBook recipeBook=new RecipeBook(data);
			Root root=new Root(recipeBook);
			
//			data.dbisConnected();
			Scene scene = new Scene(root,600,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
	}
}
