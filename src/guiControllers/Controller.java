package guiControllers;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public interface Controller extends Initializable{
	 public void handleButton(ActionEvent event) throws IOException ;
	 public void assertControlsExist();
	 public void putNodesInHashMap();
	 public void setOnActions(HashMap<Button, Pane> hMap);
}
	 

