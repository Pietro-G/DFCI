import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Arrays;
import javafx.geometry.Point3D;

/*
Canvas is the class the contains the paint component which will paint the model depending on the relationship confidence
selected by the user.
*/
public class Canvas extends JPanel {

    public class GraphInstance {

        Path2D.Double shapeOutline = new Path2D.Double();
    }
    GraphInstance graph = new GraphInstance();
    //Cube myCube = new Cube(); -> Graph myGraph = new Graph();

    //The constructor simply sets the drawing canvas and its background color
    public Canvas() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.lightGray);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; //cast so we can use JAVA2D.
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }
}