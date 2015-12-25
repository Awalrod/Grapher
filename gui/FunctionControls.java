package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 12/20/15.
 */
public class FunctionControls extends JPanel implements ActionListener {
    JTextField[] functionFields;
    Graph graph;
    public FunctionControls(Graph controlledObject){
        this.graph = controlledObject;
        setLayout(new SpringLayout());
        functionFields = new JTextField[10];

        for(int x = 0; x < 10; x+=1){
            functionFields[x] = new JTextField(5);
            JLabel fName = new JLabel("f"+Integer.toString(x));
            add(fName);
            add(functionFields[x]);
        }
        JButton updateFunctions = new JButton("Update Functions");
        updateFunctions.addActionListener(this);
        JLabel shhBB = new JLabel("");//Shhhh bby is ok
        add(shhBB);
        add(updateFunctions);
        SpringUtilities.makeGrid(this, 11,2,0,3,3,3);
    }


    @Override
    public void actionPerformed(ActionEvent e){

        String[] functionStringList = new String[10];
        for(int x = 0; x < 10; x += 1){
            functionStringList[x]=functionFields[x].getText();
        }

        graph.setFunctions(functionStringList);
    }
}
