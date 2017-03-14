/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preposturous;

import javax.swing.JFrame;
import javax.swing.JPanel;
import preposturous.GUI.LoginFrame;

/**
 *
 * @author nemo
 */
public class Preposturous {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        displayLoginGUI();    
    }
   
    /**
     * Displays the login panel. 
     */
    private static void displayLoginGUI(){       
        
        JFrame jLoginFrame = new JFrame();
        JPanel jLoginPanel = new LoginFrame();
        jLoginFrame.add(jLoginPanel);
        jLoginFrame.setSize(430,222);
        jLoginFrame.setResizable(false);
        jLoginFrame.setVisible(true);
    }
    
    
}
