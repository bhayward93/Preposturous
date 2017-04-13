package guiControllers;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Controller of the main screen of the GUI.
 * @author Ben Hayward
 */
public class MainController implements Controller{
    //Add updates to assertControllerExists() manually.
    @FXML 
    private Button findPatientButton, addAppointmentsButton, findAppointmentsButton, 
				   addPatientButton, exportResultsButton; // need to be handled separate: notesButton, diagramButton;
    @FXML private Pane welcomePane, cameraPane, findPatientPane, addPatientPane, 
    				   addAppointmentsPane, exportResultsPane, findAppointmentsPane;
    @FXML private BorderPane mainWindow;
    @FXML private StackPane stackPane; 
    @FXML private TabPane tabPane;
    @FXML private VBox buttonBar;
    @FXML private AnchorPane centerAP;
    HashMap<Button, Pane> buttonsPaneHMap = new HashMap<>(); //storing the data in a HashMap to create a link between types

    public MainController() {
    	//Default Constructor
    } 
  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		putNodesInHashMap();
		assertControlsExist();
		mainWindow.setCenter(welcomePane);
		setOnActions(buttonsPaneHMap);	
		try {
			loadWelcomePane();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handles any button presses.
	 */
	public final void handleButton(ActionEvent event) throws IOException {
		Node newCenter = new AnchorPane();	
		
		if (event.getSource() ==  addAppointmentsButton){
			loadAddAppointmentsPane();		}	
		if (event.getSource() ==  addPatientButton){
			newCenter = FXMLLoader.load(getClass().getResource("/FXML/AddPatientPane.fxml"));
		}				
		if (event.getSource() ==  findAppointmentsButton){
			newCenter = FXMLLoader.load(getClass().getResource("/FXML/FindAppointmentsPane.fxml"));
		}				
		if (event.getSource() ==  exportResultsButton){
			newCenter = FXMLLoader.load(getClass().getResource("/FXML/ExportResultsPane.fxml"));
		} 
		if (event.getSource() ==  findPatientPane){
			newCenter = FXMLLoader.load(getClass().getResource("/FXML/FindPatientPane.fxml"));
		}				
//		 
//		try{
//			this.mainWindow.setCenter(newCenter); 
//			centerAP.getChildren().clear();
//	        centerAP.getChildren().add(newCenter);//add new display
//		 }
//		 catch (NullPointerException e){
//			 e.printStackTrace();
//		 }	 
//		 if (event.getSource() ==  notesButton){}	
//		 if (e.getSource() ==  diagramButton){}	
	 }
	 
	/**
	 * Part of initialisation, be sure to add to this when components are added/removed
	 * @return returns true if all passed
	 */
	public final void assertControlsExist(){
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
		assert centerAP != null;
	}
	
	/**
	 * Sets buttons linked panes onAction methods.
	 * @param hMap Button and linked pane
	 */

	//Not entirely my code
	public final void setOnActions(HashMap<Button, Pane> hMap){
		for (Button button : hMap.keySet()){
			((ButtonBase) button).setOnAction(arg0 -> {
				try {
					handleButton(arg0);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			});
		}		
	}

	/**
	 * Helps with button management. This currently needs to be done manually.
	 */
	public final void putNodesInHashMap(){
		 buttonsPaneHMap.put(addAppointmentsButton, addAppointmentsPane);
		 buttonsPaneHMap.put(addPatientButton, addPatientPane);
		 buttonsPaneHMap.put(exportResultsButton, exportResultsPane);
		 buttonsPaneHMap.put(findAppointmentsButton, findAppointmentsPane);
		 buttonsPaneHMap.put(findPatientButton, findPatientPane);
	}
	
	public final void clearCenterNode(){
		this.centerAP.getChildren().clear();	   
	}	
	
	private final void loadAddAppointmentsPane() throws IOException{
		try {
	        centerAP.getChildren().remove(0);
			AnchorPane newCenter = FXMLLoader.load(getClass().getResource("/FXML/AddAppointmentsPane.fxml"));
			mainWindow.getChildren().add(newCenter); //maybe this 
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	
	private final void loadWelcomePane() throws IOException{
		try {
			centerAP.getChildren().remove(0);
			AnchorPane newCenter = FXMLLoader.load(getClass().getResource("welcomePane.fxml"));
			mainWindow.getChildren().add(newCenter); //maybe this 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




