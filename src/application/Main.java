package application;
	
import guiControllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		    BorderPane root = FXMLLoader.load(getClass().getResource("/FXML/Main.fxml"));
			Scene scene = new Scene(root,658,401);			
			scene.getStylesheets().add(getClass().getResource("/cSS/application.css").toExternalForm());
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
