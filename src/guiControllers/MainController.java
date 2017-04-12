package guiControllers;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.utils;

/**
 * Controller of the main screen of the GUI.
 * @author Ben Hayward
 */
public class MainController implements Controller{
    //Add updates to assertControllerExists() manually.
    @FXML 
    private Button findPatientButton, addAppointmentsButton, findAppointmentsButton, 
	addPatientButton, exportResultsButton; // need to be handled separate: notesButton, diagramButton;
    @FXML private Pane welcomePane, cameraPane, findPatientPane;
    @FXML private BorderPane mainWindow;
    @FXML private StackPane stackPane; 
    @FXML private TabPane tabPane;
    @FXML private VBox buttonBar;
    HashMap<Button, Pane> buttonsPaneHMap = new HashMap<>(); //storing the data in a HashMap to create a link between types

    public MainController() {}//Default Constructor
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
 		System.out.println("Initializing");
		assertControlsExist();
		 mainWindow.setCenter(welcomePane);
		
	     setOnActions(buttonsPaneHMap);
		 
//		 primaryStage.setX(utils.getScreenBounds().getWidth()); 
//		 primaryStage.setY(utils.getScreenBounds().getHeight());
//		 primaryStage.setWidth(utils.getScreenBounds().getWidth());
//		 primaryStage.setHeight(utils.getScreenBounds().getHeight());
		
		 System.out.println("Finished initialization");
		
	}
	
	 public void handleButton(ActionEvent event) throws IOException {
		 
		 AnchorPane newCenter = FXMLLoader.load(getClass().getResource("/FXML/cameraPane.fxml"));
		 this.mainWindow.setCenter(newCenter); 
		 
//		if (event.getSource() ==  addPatientButton){}				
//		if (event.getSource() ==  exportResultsButton){} 			
//		if (event.getSource() ==  notesButton){}	
//		if (e.getSource() ==  diagramButton){}	
	 }
	 	
	/**
	 * Part of initialisation, be sure to add to this when components are added/removed
	 * @return returns true if all passed
	 */
	private final void assertControlsExist(){
		assert findPatientButton != null; 
		assert addAppointmentsButton != null;
		assert findAppointmentsButton != null;
		assert addPatientButton != null;
		assert exportResultsButton != null;
//		assert notesButton != null;
//		assert diagramButton != null;
		assert welcomePane != null;
		assert cameraPane != null;
		assert findPatientPane != null;	
		assert stackPane != null;  
	}
	
	/**
	 * Sets buttons linked panes onAction methods.
	 * @param hMap Button and linked pane
	 */
	private final void setOnActions(HashMap<Button, Pane> hMap){
		for (Button button : hMap.keySet()){
			((ButtonBase) button).setOnAction(arg0 -> {
				try {
					handleButton(arg0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		
	}
	/**
	 * Makes the window match the maximum screen bounds.
	 */
	private final void makeFullScreen(){
		 Scene primaryScene = mainWindow.getScene();

		 mainWindow.setMaxHeight(primaryScene.getHeight());
		 mainWindow.setMinHeight(primaryScene.getHeight());
		 mainWindow.setMaxWidth(primaryScene.getWidth());
		 mainWindow.setMinWidth(primaryScene.getWidth());
	}
	
	/**
	 * Helps with button management
	 */
	private final void putButtonsInHashMap(){
		 buttonsPaneHMap.put(findPatientButton, findPatientPane);
		 buttonsPaneHMap.put(findPatientButton, cameraPane);
	}
	
	
	
}




