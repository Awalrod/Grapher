package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by alex on 12/20/15.
 */
public class ConstantControlls extends JPanel implements ActionListener {
    ArrayList<ConstantInfoForm> constants;
//    GridBagLayout layout;
//    GridBagConstraints constraints;
    JPanel inputPanel;
    JTextField newName;
    JTextField newValue;
    JButton addConstant;
    Graph graph;
    public ConstantControlls(Graph graph){
        this.graph = graph;


        constants = new ArrayList<>();
        inputPanel = new JPanel(new GridLayout(1,4));
        newName = new JTextField(4);
        newValue = new JTextField(4);
        addConstant = new JButton("Add");
        addConstant.addActionListener(this);
        inputPanel.add(newName);
        inputPanel.add(new JLabel("="));
        inputPanel.add(newValue);
        inputPanel.add(addConstant);


        add(inputPanel);




    }

    public void deleteConstant(ConstantInfoForm kForm){
        constants.remove(kForm);
        graph.removeConstant(kForm.name);
        remove(kForm);
        updateUI();
    }
    public void addConstant(ConstantInfoForm kForm){
        constants.add(kForm);
        add(kForm);
        graph.addConstant(kForm.name,kForm.value);
        updateUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if((JButton) e.getSource() == addConstant){
            boolean foundmatch = false;
            for(ConstantInfoForm kForm: constants){
                if(newName.getText().equals(kForm.name)){
                    deleteConstant(kForm);
                    addConstant(new ConstantInfoForm(newName.getText(),Double.parseDouble(newValue.getText()),this));
                    foundmatch = true;
                    updateUI();
                }
            }
            if(!foundmatch){
                addConstant(new ConstantInfoForm(newName.getText(),Double.parseDouble(newValue.getText()),this));

            }
        }
    }
}
