package application.GUIControllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.text.html.HTMLDocument.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller of the main screen of the GUI.
 * @author Ben Hayward
 */
public class MainController implements MouseListener, Initializable{
    HashMap<Button, VBox> buttonsToPaneHashMap = new HashMap<>(); //storing the data in a hashmap to create a link between types

    //Add updates to assertControllerExists() manually.
	private final Button findPatientButton, addAppointmentsButton, findAppointmentsButton, 
	addPatientButton, exportResultsButton, notesButton, diagramButton;
	
	private final VBox welcomePane, cameraPane, findPatientPane;
	private final BorderPane mainPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		assertControlsExist();
		buttonsToPaneHashMap.put(findPatientButton, findPatientPane);
		buttonsToPaneHashMap.put(findPatientButton, cameraPane);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
		//http://stackoverflow.com/questions/29735703/how-to-make-fxml-generated-buttons-work
		if (e.getSource() == findPatientButton){
			changeMainPane(findPatientPane.getId());
		}
		if (e.getSource() == addAppointmentsButton){
			
		}
		if (e.getSource() ==  findAppointmentsButton){
			
		}
		if (e.getSource() ==  addPatientButton){
				
		}			
		if (e.getSource() ==  exportResultsButton){
				
		} 			
		if (e.getSource() ==  notesButton){
				
		}	
		if (e.getSource() ==  diagramButton){
				
		}			
	}

	private void changeManePane() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	 
	private final boolean assertControlsExist(){
		assert findPatientButton != null; 
		assert addAppointmentsButton != null;
		assert findAppointmentsButton != null;
		assert addPatientButton != null;
		assert exportResultsButton != null;
		assert notesButton != null;
		assert diagramButton != null;
		assert welcomePane != null;
		assert cameraPane != null;
		assert findPatientPane != null;
				
		return true;
	}
}



