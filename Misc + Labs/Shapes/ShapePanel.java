import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Class ShapePanel:  holds a ShapeComponent and a ButtonPanel for drawing shapes
 * @author Barb Ericson
 * @since 1.1
 */
public class ShapePanel extends JPanel
{
  
  /////////////////////// Private Attributes /////////////////////
  
  private ShapeIComponent shapeComponent = 
    new ShapeIComponent(500,500);
  private ButtonPanel buttonPanel = new ButtonPanel(shapeComponent);
  
  ////////////////////// Constructors /////////////////////////////
  
  /** A constructor that takes no arguments */
  public ShapePanel ()
  {
    init();
  }
  
  //////////////////// Private Methods /////////////////////////////////
  
  /* Method to initialize the panel */
  private void init()
  {
    // use a border layout
    setLayout(new BorderLayout());
    
    // add the button panel to the north section of the border layout
    add("North", buttonPanel);
    
    // add the shape canvas to the center section of the border layout
    add("Center", shapeComponent);
  }
  
  ////////////////////// Main Method for Testing ////////////////////////
  public static void main (String argv[])
  {
    // create a frame (main application window)
    Frame frame = new JFrame();
    
    // create a Shape Panel
    ShapePanel shapePanel = new ShapePanel();
    
    // add the shapePanel to the frame
    frame.add(shapePanel);
    frame.pack();         // shrink to fit preferred size
    frame.setVisible(true); // show the frame
  }
  
}


