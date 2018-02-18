import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
/*
Main is the controller class for the DFCI visualizer, attaching GUI and Canvas to a Frame.
@author: Pietro
*/
public class Main
{
    
    /*
    This is the main driver class that connects the model to alla the interactive patterns
    */

    public static void main(String[] args){
        JFrame myFrame = new JFrame();
        myFrame.setTitle("DFCI Visualizer");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas Graph = new Canvas();
        ControlPanel userInterface = new ControlPanel(Graph);
        Container cp = myFrame.getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(userInterface,BorderLayout.WEST);
        cp.add(Graph, BorderLayout.CENTER);

        //Must use getContentPane() with JFrame.
        myFrame.add(Graph);
        myFrame.pack(); //resizes to preferred size for components.
        myFrame.setResizable(true);
        myFrame.setVisible(true);
    }
} 