package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import userInterface.LeftNav;
import userInterface.Root;
import userInterface.RecipeNav;
import userInterface.SearchBar;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();
			
			
			
//			LeftNav fcPane=new LeftNav();
//			SearchBar searchBar =new SearchBar(root);
//			RecipeNav recipesNav=new RecipeNav();			
//			root.setLeft(fcPane);
//			root.setTop(searchBar);
//			root.setCenter(recipesNav);
			
			Root root=new Root();
			
			Scene scene = new Scene(root,600,500);
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
