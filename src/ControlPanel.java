import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

/*
Control Panel is the JPanel class that implements all of the different buttons and the control panel
that are shown in the EastSide GUI shown in the main frame. It's a robust but simple GUI that gives
all the parts drawn transformation and filling functionalities.
@author Pietro
 */
class ControlPanel extends JPanel implements ActionListener, ChangeListener {

    //Instantiation of all the elements that are used in the GUI
    Canvas cPanel;
    JSpinner probConfidence;
    JComboBox<String> framedWire;
    JLabel relationshipLabel;
    AntigenFabric antigenStructure = new AntigenFabric();
    ArrayList<AntigenFabric.Antigen> AntigenData = antigenStructure.parseData();

    /*The constructor of this GUI instanciates all of the elements utilizing the BoxLayout
    and adds the event Listener respective to each button, combo box and color panel.*/
    public ControlPanel(Canvas cp) {
        cPanel = cp;

        probConfidence = new JSpinner(new SpinnerNumberModel(0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.1));
        probConfidence.addChangeListener(this);

        //List of all of the genes with correlations in here
        framedWire = new JComboBox();
        framedWire.addItem("EntrezID1 example1");
        framedWire.addItem("EntrezID1 example2");
        framedWire.addActionListener(this);

        relationshipLabel = new JLabel("Minimum relationship confidence: ");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel head = new JPanel();
        head.add(framedWire);
        add(head);
        JPanel r = new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.X_AXIS));
        r.add(relationshipLabel);
        r.add(probConfidence);
        add(r);
        JPanel r2 = new JPanel();
        r2.setLayout(new BoxLayout(r2, BoxLayout.X_AXIS));
        add(r2);
        JPanel r3 = new JPanel();
        r3.setLayout(new BoxLayout(r3, BoxLayout.X_AXIS));
        add(r3);

    }//end contructor

    //TODO: Add a method that actively updates the Gene arrayList to include only those within the range of probConfidence.


    //Update grapph once selected
    private void updateGeneMap(){
        cPanel.repaint();
    }

    //Overrides both of the elements in the GUI, combobox and spinners
    public void actionPerformed(ActionEvent evt) {
        if (framedWire.getSelectedItem().equals("Frame Wire Cube")) { //update graph once another Gene is selected
            cPanel.repaint();
        } else {
            cPanel.repaint();
        }
        updateGeneMap();
    }

    /*

     */
    @Override
    public void stateChanged(ChangeEvent e) {
        updateGeneMap();
    }
}