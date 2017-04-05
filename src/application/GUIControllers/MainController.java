package application.GUIControllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javafx.scene.control.Button;

/**
 * Controller of the main screen of the GUI.
 * @author Ben Hayward
 */
public class MainController implements MouseListener{
	
	private Button findPatientButton, addAppointmentsButton, findAppointmentsButton, 
	addPatientButton, exportResultsButton, notesButton, diagramButton;

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == findPatientButton){
		
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
	
}
