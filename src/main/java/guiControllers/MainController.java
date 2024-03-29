package guiControllers;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.BlockingDeque;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import application.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
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
    private Button addAppointmentsButton, startAppointmentButton,
				   addPatientButton, exportResultsButton; // need to be handled separate: notesButton, diagramButton;
    @FXML private Pane  welcomePane;
    //welcomePane, cameraPane, findPatientPane, addPatientPane, 
  //  				   addAppointmentsPane, exportResultsPane, findAppointmentsPane;
    @FXML private BorderPane mainWindow;
    @FXML private TabPane tabPane;
    @FXML private VBox buttonBar;
    @FXML private AnchorPane centerAP;
    @FXML private Tab notesTab, diagramTab;

    @FXML private TextField searchBox;
    public MainController() {
    	//Default Constructor
    } 
  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		putNodesInHashMap();
		assertControlsExist();
		setOnActions();
		try {
			loadWelcomePane(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	/**
	 * Part of initialisation, be sure to add to this when components are added/removed. Style taken from 
	 * https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
	 * @return returns true if all passed
	 */
	   public final void assertControlsExist(){
//		assert findPatientButton != null  : "fx:id=\"findPatientButton\" was not injected: check your FXML file 'simple.fxml'.";; 
		assert addAppointmentsButton != null : "fx:id=\"addAppointmentsButton\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert findAppointmentsButton != null : "fx:id=\"findAppointmentsButton\" was not injected: check your FXML file 'simple.fxml'.";;
		assert addPatientButton != null : "fx:id=\"addPatientButton\" was not injected: check your FXML file 'simple.fxml'.";;
		assert exportResultsButton != null : "fx:id=\"exportResultsButton\" was not injected: check your FXML file 'simple.fxml'.";;
		assert notesTab != null : "fx:id=\"notesTab\" was not injected: check your FXML file 'simple.fxml'.";;
		assert diagramTab != null : "fx:id=\"diagramTab\" was not injected: check your FXML file 'simple.fxml'.";;
		assert welcomePane != null : "fx:id=\"welcomePane\" was not injected: check your FXML file 'simple.fxml'.";;
		assert centerAP != null : "fx:id=\"centerAP\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert addAppointmentsPane!=null;
//		assert findAppointmentsPane!=null;
//		assert addPatientPane!=null;
//		assert exportResultsPane!=null;
	}

	

	/**
	 * Helps with button management. This currently needs to be done manually.
	 */
//	public final void putNodesInHashMap(){
//		 buttonsPaneHMap.put(addAppointmentsButton, addAppointmentsPane);
//		 buttonsPaneHMap.put(addPatientButton, addPatientPane);
//		 buttonsPaneHMap.put(exportResultsButton, exportResultsPane);
//		 buttonsPaneHMap.put(findAppointmentsButton, findAppointmentsPane);
//		 buttonsPaneHMap.put(findPatientButton, findPatientPane);
//	}
	
	public void clearCenterNode(){
		this.centerAP.getChildren().clear();	   
	}	

	
	public final ObservableList<Node> getCenterNode(){
		return (this.centerAP.getChildren());
	}
	
	@FXML 
	public void loadCameraPane(ActionEvent e)	{
		loadPane("/FXML/CameraPane.fxml");
	}
	@FXML
	public void loadAddAppointmentsPane(ActionEvent e){
		loadPane("/FXML/AddAppointmentsPane.fxml");
	}
	
	@FXML
	private void loadWelcomePane(ActionEvent e){ //private so it can only be loaded from this class.
		loadPane("/FXML/welcomePane.fxml");
	}
	
	@FXML
	public void loadAddPatientPane(ActionEvent e){ //may need changing to patients
		loadPane("/FXML/AddPatientPane.fxml");
	}
//	@FXML
//	public void loadFindAppointmentsPane(ActionEvent e){
//		loadPane("/FXML/FindAppointmentsPane.fxml");
//	}
	
	@FXML
	public void loadExportResultsPane(ActionEvent e){
		loadPane("/FXML/ExportResultsPane.fxml");
	}
	@FXML
	public void loadFindPatientPane(ActionEvent e){
		loadPane("/FXML/findPatientPane.fxml");
	}
	
	private final void loadPane(String fxmlPath){	
		try {
				AnchorPane newCenter = FXMLLoader.load(getClass().getResource(fxmlPath));
				System.out.println("Trying to open: "+fxmlPath);
				mainWindow.setCenter(newCenter); //maybe this 
			} catch (Exception e) {
				e.printStackTrace();		
			}
	}
	
	/**
	 * On search box, enter being pressed.
	 */

	@Override
	public void setOnActions() {		
		
		searchBox.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.ENTER) {
		    	loadFindPatientPane(null);		    
		    }});
		
		addPatientButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	loadAddPatientPane(e);
		    }});
		
		startAppointmentButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	loadCameraPane(e);
		    }});
       
//		findAppointmentsButton.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override public void handle(ActionEvent e) {
//		    	loadFindAppointmentsPane(e);
//		    }});
		addAppointmentsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	loadAddAppointmentsPane(e);
		    }});
		exportResultsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	loadExportResultsPane(e);
		    }});

		
		
		//, addAppointmentsButton, findAppointmentsButton, 
		//, exportResultsButton;
		
		}

	//returns the root node
	public Parent getRoot() {
		return addAppointmentsButton.getParent();
	}

}
	


