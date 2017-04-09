package guiControllers;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller of the main screen of the GUI.
 * @author Ben Hayward
 */
public class MainController implements Controller{
    HashMap<Button, VBox> buttonsPaneHMap = new HashMap<>(); //storing the data in a HashMap to create a link between types

    //Add updates to assertControllerExists() manually.
    @FXML 
    private Button findPatientButton, addAppointmentsButton, findAppointmentsButton, 
	addPatientButton, exportResultsButton; // need to be handled separate: notesButton, diagramButton;
	
    @FXML
	private VBox welcomePane, cameraPane, findPatientPane;
	//private BorderPane mainPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("init");
		assertControlsExist();
		
		buttonsPaneHMap.put(findPatientButton, findPatientPane);
		buttonsPaneHMap.put(findPatientButton, cameraPane);
		
		setOnActions(buttonsPaneHMap);
		System.out.println("Finished init");
		
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("Into MouseClicked");
		//https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
		//http://stackoverflow.com/questions/29735703/how-to-make-fxml-generated-buttons-work
		if (e.getSource() == findPatientButton){System.out.println("HELLO"); changeMainPane(findPatientPane.getId());}
		if (e.getSource() == addAppointmentsButton){changeMainPane(welcomePane.getId());System.out.println("HELLO");}
		if (e.getSource() ==  findAppointmentsButton){}
		if (e.getSource() ==  addPatientButton){}			
		if (e.getSource() ==  exportResultsButton){} 			
	//	if (e.getSource() ==  notesButton){}	
	//	if (e.getSource() ==  diagramButton){}			
	}
	

	
	 public void handleButton(ActionEvent event) {
	     //Button was clicked, do something...
		if (event.getSource() == findPatientButton){changeMainPane(findPatientPane.getId());}
		if (event.getSource() == addAppointmentsButton){changeMainPane(welcomePane.getId());System.out.println("HELLO");}
		if (event.getSource() ==  findAppointmentsButton){}
		if (event.getSource() ==  addPatientButton){}				
		if (event.getSource() ==  exportResultsButton){} 			
		//if (event.getSource() ==  notesButton){}	
		//	if (e.getSource() ==  diagramButton){}	
	 }
	 	
	/**
	 * Changes the main "central" panes contents
	 * @param path
	 */
	private final void changeMainPane(String id) {
        try {
        	FXMLLoader newMainPane = FXMLLoader.load(getClass().getResource(id));  
        	//content.getChildren().setAll(FXMLLoader.load("vista2.fxml"));
            //http://stackoverflow.com/questions/18619394/loading-new-fxml-in-the-same-scene
        	//here now
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }	
	}
	
	/**
	 * Links Buttons to their respective central panes.
	 * @param buttonPaneHM A hashmap of buttons and their respective panes. 
	 */
	private final void buttonLinker(HashMap buttonPaneHM)	{		
		for (Object button : buttonPaneHM.keySet()) {
	        ((ButtonBase) button).setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                ((ButtonBase) button).setOnAction(new EventHandler<ActionEvent>() {
	                    @Override
	                    public void handle(ActionEvent event) {
	                    VBox connectedVbox = (VBox)buttonPaneHM.get(button);                    
	                    Stage stage = (Stage) connectedVbox.getScene().getWindow(); //does this close too much? get child nodes?
	                    stage.close();
	                    changeMainPane(connectedVbox.idProperty().toString());
	                    }       
	            });}
        });
       }
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
	//	assert notesButton != null;
	//	assert diagramButton != null;
		assert welcomePane != null;
		assert cameraPane != null;
		assert findPatientPane != null;				
	}
	
	private final void setOnActions(HashMap<Button, VBox> hMap){
		for (Button button : hMap.keySet()){
			((ButtonBase) button).setOnAction(this::handleButton);
		}
	}
}



