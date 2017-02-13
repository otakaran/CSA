import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Class ButtonPanel:  holds buttons to pick the current shape and to clear
 * the shapes.
 * @author Barb Ericson
 */
public class ButtonPanel extends JPanel
{
  
  ///////////////////// Public Attributes ////////////////////////
  
  ////////////////////// Private Attributes //////////////////////
  private String[] shapeNames = {"Rectangle",}; // modify this if you add more shapes
  private JButton clearButton;  // clear button
  private ShapeInterface handler = null; // the shape interface handler
  
  //////////////////////// Constructors ////////////////////////////
  
  /** A constructor that takes no arguments */
  public ButtonPanel ()
  {
    // initialize the panel
    init();
  }
  
  /** A constructor that uses the default size but takes the handler
   * @param theHandler    the handler of shape interface type
   */
  public ButtonPanel (ShapeInterface theHandler)
  {
    // set the handler
    handler = theHandler;
    
    // initialize the panel
    init();
  }
  
  /////////////////// Private Methods ///////////////////////////////
  
  /** Method to initialize the panel */
  private void init()
  {
    JButton currButton = null;
    
    for (String name: shapeNames)
    {
      currButton = new JButton(name);
      add(currButton);
      currButton.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
          if (handler != null)
            handler.setShape(e.getActionCommand());
      }
    });
    }
    
    // create the clear button
    clearButton = new JButton("Clear");
    add(clearButton);
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed (ActionEvent e) {
        if (handler != null)
          handler.clearShapes();
      }
    });
  }
  
  ///////////////////// Main Method for Testing /////////////////////////
  public static void main (String argv[])
  {
    // create a frame
    JFrame frame = new JFrame();
    
    // create a ButtonPanel
    ButtonPanel buttonPanel = new ButtonPanel();
    
    // add the buttonPanel to the frame
    frame.add(buttonPanel);
    frame.pack(); // shrink to fit preferred size
    frame.setVisible(true); // show the frame
  }
  
}


