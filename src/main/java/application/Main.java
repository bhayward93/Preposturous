package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utils.utils;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	double screenHeight = utils.getScreenBounds().getHeight();
    double screenWidth  = utils.getScreenBounds().getWidth();
    
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = FXMLLoader.load(getClass().getResource("/FXML/Main.fxml"));
			Scene scene = new Scene(root,658,401);			
			scene.getStylesheets().add(getClass().getResource("/cSS/application.css").toExternalForm());
			primaryStage.setHeight(screenHeight - (screenHeight/5));
			primaryStage.setWidth(screenWidth - (screenWidth/5));	
			primaryStage.setMinHeight(557); //NOT WORKING
			primaryStage.setMinHeight(370); //NOT WORKING

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
