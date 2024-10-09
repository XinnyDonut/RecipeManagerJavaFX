package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import userInterface.LeftNav;
import userInterface.RecipeNav;
import userInterface.SearchBar;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			LeftNav fcPane=new LeftNav();
			SearchBar searchBar =new SearchBar();
			BorderPane root = new BorderPane();
			RecipeNav recipesNav=new RecipeNav();
			
			root.setLeft(fcPane);
			root.setTop(searchBar);
			root.setCenter(recipesNav);
			
			Scene scene = new Scene(root,400,400);
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
