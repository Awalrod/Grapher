package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 12/20/15.
 */
public class ConstantInfoForm extends JPanel implements ActionListener{
    String name;
    double value;
    JLabel infoLabel;
    JButton delete;
    ConstantControlls parent;

    public ConstantInfoForm(String name, double value, ConstantControlls parent){
        this.name = name;
        this.value = value;
        this.parent = parent;
        infoLabel = new JLabel(name+"="+Double.toString(value));
        delete = new JButton("X");
        delete.addActionListener(this);
        delete.setBackground(Color.RED);
        add(infoLabel);
        add(delete);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.deleteConstant(this);
    }
}
