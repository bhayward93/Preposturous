package guiControllers;
import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.ServerCloneException;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.RootPaneContainer;
import javax.swing.text.AsyncBoxView.ChildLocator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Controller of the main screen of the GUI.
 * @author Ben Hayward
 */
public class MainController implements Controller{
    HashMap<Button, Pane> buttonsPaneHMap = new HashMap<>(); //storing the data in a HashMap to create a link between types

    //Add updates to assertControllerExists() manually.
    @FXML 
    private Button findPatientButton, addAppointmentsButton, findAppointmentsButton, 
	addPatientButton, exportResultsButton; // need to be handled separate: notesButton, diagramButton;
	
    @FXML
	private Pane welcomePane, cameraPane, findPatientPane;
	//private BorderPane mainPane;

    @FXML Group group;
    
    @FXML BorderPane mainWindow;
    
    @FXML StackPane centralStackPane;
    
    public MainController() {}//Default Constructor
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Initializing");
		assertControlsExist();
		
		buttonsPaneHMap.put(findPatientButton, findPatientPane);
		buttonsPaneHMap.put(findPatientButton, cameraPane);
		
		setOnActions(buttonsPaneHMap);
		mainWindow.setCenter(welcomePane);
		System.out.println("Finished initialization");
		
	}
	
	 public void handleButton(ActionEvent event) throws IOException {
		if (event.getSource() == findPatientButton){
			Node source = (Node) event.getSource();
			javafx.stage.Window thisStage = source.getScene().getWindow();
		    BorderPane root = FXMLLoader.load(getClass().getResource("/FXML/Main.fxml"));
		//    root.getCenter().//.lookup("")
		    try {

		    	for(Node childNodes : centralStackPane.getChildren()){
		    		if(!childNodes.isDisable()){
		    			childNodes.setDisable(true);
		    		}
		    		cameraPane.setDisable(false);
		    		cameraPane.setVisible(true);		   	
		    	}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    
		   

//			mainWindow.setCenter(cameraPane);
//			cameraPane.setVisible(true);
//			welcomePane.setVisible(false);
		}	
//			if (event.getSource() == 			addAppointmentsButton){changeMainPane(welcomePane.getId());System.out.println("HELLO");}
		if (event.getSource() ==  findAppointmentsButton){

		}
		if (event.getSource() ==  addPatientButton){}				
		if (event.getSource() ==  exportResultsButton){} 			
		//if (event.getSource() ==  notesButton){}	
		//if (e.getSource() ==  diagramButton){}	
	 }
	 	
	/**
	 * Part of initialization, be sure to add to this when components are added/removed
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
}



