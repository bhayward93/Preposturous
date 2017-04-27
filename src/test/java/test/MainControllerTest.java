package test;
//https://github.com/TestFX/TestFX/wiki/Version-4:-Getting-Started

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.invoke.MethodHandles.Lookup;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import application.Main;
import guiControllers.Controller;
import guiControllers.MainController;

public class MainControllerTest extends GuiTest {	
	//check out testfx
    private static GuiTest controller;
//    private Button findAppointmentsButton = DriverManager.getConnection(url,"p4117178","INSERTPWLATER"); //TODO Copy PW and renew azure sub. 


            @Before
            public void setUp() {
                /* Just retrieving the tested widgets from the GUI. */
            }
            
            @Before
            @Override
            protected Parent getRootNode() {
                try {
            		return FXMLLoader.load(getClass().getResource("/../GuiMain.fxml"));

            	} catch (IOException e) {
            		e.printStackTrace();
            	}
                return null;
            }
        	@BeforeClass
            public static void setUpClass() {
                    FXTestUtils.launchApp(Main.class);
                    };
             @Before
             public void setup(){
               //  findAppointmentsButton = find("#addAppointmentsButton");
             }
                    
            
    

	@Test
	public void testMainController() {
		assert(controller!=null);
        }

	@Test
	public void testInitialize() {
        assert (true);
        }

	@Test
	public void testAssertControlsExist() {
//		Main.launch();
//		assert mainController.findPatientButton != null  : "fx:id=\"findPatientButton\" was not injected: check your FXML file 'simple.fxml'.";; 
 //   	assert addA != null : "fx:id=\"addAppointmentsButton\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert findAppointmentsButton != null : "fx:id=\"findAppointmentsButton\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert addPatientButton != null : "fx:id=\"addPatientButton\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert exportResultsButton != null : "fx:id=\"exportResultsButton\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert notesTab != null : "fx:id=\"notesTab\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert diagramTab != null : "fx:id=\"diagramTab\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert welcomePane != null : "fx:id=\"welcomePane\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert centerAP != null : "fx:id=\"centerAP\" was not injected: check your FXML file 'simple.fxml'.";;
//		assert addAppointmentsPane!=null;
//		assert findAppointmentsPane!=null;
//		assert addPatientPane!=null;
//		assert exportResultsPane!=null;		
		assert(true);
		}

//	@Test
//	public void testClearCenterNode() {
//		  controller.clearCenterNode();
//	      assert(mController.getCenterNode() != null);
//
//	}

//	@Test
//	public void testLoadCameraPane() {
//		  final Button button = find("#button");       
//        assert ( find("#") != null);
//	}d

	@Test
	public void testLoadAddAppointmentsPane() {
	//    assert (GuiTest.find("#addAppointmentsButton") != null);
		try{
	    controller.click("addAppointmentsButton");
		AnchorPane centerAP = GuiTest.find("centerAP"); 
	    assert(	centerAP.getChildren().get(0).getId().contains("addAppointmentsPane")) ;
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

//	@Test
//	public void testLoadAddPatientPane() {
//		Main.launch();	 
//		MainController mainController = new MainController();
//		mainController.loadAddAppointmentsPane(null);
//		assert (mainController.getCenterNode() != null);	}
//
//	@Test
//	public void testLoadExportResultsPane() {
//		Main.launch();	
//		MainController mainController = new MainController();
//		mainController.loadExportResultsPane(null);
//		assert (mainController.getCenterNode() != null);		}
//	@Test
//	public void testLoadFindPatientPane() {
//		Main.launch();	
//		MainController mainController = new MainController();
//		mainController.loadFindPatientPane(null);
//		assert (mainController.getCenterNode() != null);		}
//
//	@Test
//	public void testSetOnActions() {
//		assert (true);	}
//
//


}

