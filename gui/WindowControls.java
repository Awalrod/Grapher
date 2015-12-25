package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by alex on 12/20/15.
 */
public class WindowControls extends JPanel implements ActionListener {
    JTextField xLower;
    JTextField xUpper;
    JTextField yLower;
    JTextField yUpper;

    JTextField xInterval;
    JTextField yInterval;

    JTextField definition;

    JButton updateWindow;

    Graph graph;
    public WindowControls(Graph graph){
        GridLayout layout = new GridLayout(8,2);
        setLayout(layout);

        this.graph = graph;

        add(new JLabel("X Lower Bound"));
        xLower = new JTextField("-350",5);
        add(xLower);
        add(new JLabel("X Upper Bound"));
        xUpper = new JTextField("350",5);
        add(xUpper);
        add(new JLabel("Y Lower Bound"));
        yLower = new JTextField("-350",5);
        add(yLower);
        add(new JLabel("Y Upper Bound"));
        yUpper = new JTextField("350",5);
        add(yUpper);
        add(new JLabel("X Interval"));
        xInterval = new JTextField("10",5);
        add(xInterval);
        add(new JLabel("Y Interval"));
        yInterval = new JTextField("10",5);
        add(yInterval);
        add(new JLabel("Definition"));
        definition = new JTextField(".01",5);
        add(definition);
        updateWindow = new JButton("Update");
        updateWindow.addActionListener(this);
        add(updateWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double xl = Double.parseDouble(xLower.getText());
        double xu = Double.parseDouble(xUpper.getText());
        double yl = Double.parseDouble(yLower.getText());
        double yu = Double.parseDouble(yUpper.getText());

        graph.setWindow(xl,xu,yl,yu);

        double xi = Double.parseDouble(xInterval.getText());
        double yi = Double.parseDouble(yInterval.getText());
        graph.setInterval(xi,yi);

        double d = Double.parseDouble(definition.getText());
        graph.setDefinition(d);
    }
}
