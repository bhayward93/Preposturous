package utils;

import java.awt.Dimension;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

/** 
 * A collection of utilities.
 * @author Ben Hayward
 *
 */
public class utils {
	
	/**
	 * Return the screens bound.
	 * @return Rectangle2D containing the windows maximum bounds.
	 */
	public final static Rectangle2D getScreenBounds(){
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		return primaryScreenBounds;
	}
	
	/**
	 * Utility to return the first node thats isVisible() property is set to true, out of a StackPane.
	 * @param stack the StackPane containing nodes.
	 * @return the first visible node.
	 */
	public final static Node visibleNodeFinder(StackPane stack){
		for (Node n : stack.getChildren()){
			if(n.isVisible() == true){
				return n;
			}
		}
		return null;
	}

}
