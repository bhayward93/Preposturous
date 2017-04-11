package guiControllers;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

    @FXML StackPane stackPane;
    public MainController() {}//Default Constructor
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("init");
		assertControlsExist();
		
		buttonsPaneHMap.put(findPatientButton, findPatientPane);
		buttonsPaneHMap.put(findPatientButton, cameraPane);
		
		setOnActions(buttonsPaneHMap);
		System.out.println("Finished init");
		
	}
	
	 public void handleButton(ActionEvent event) throws IOException {
		if (event.getSource() == findPatientButton){
			cameraPane.toFront();
		
		}	
	    //	if (event.getSource() == addAppointmentsButton){changeMainPane(welcomePane.getId());System.out.println("HELLO");}
		if (event.getSource() ==  findAppointmentsButton){}
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



