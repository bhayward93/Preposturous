package guiControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public interface Controller extends Initializable{
	 public void handleButton(ActionEvent event) throws IOException ;
}
