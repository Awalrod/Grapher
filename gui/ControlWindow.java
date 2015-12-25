package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 12/19/15.
 */
public class ControlWindow extends JFrame {
    JTabbedPane menus;


    JTextField[] functionFields;

    public ControlWindow(Graph graph){
        menus = new JTabbedPane();
        menus.addTab("Functions", new FunctionControls(graph));
        menus.addTab("Constants", new ConstantControlls(graph));
        menus.addTab("Window", new WindowControls(graph));
        add(menus);
        setSize(350,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Controls");
        setResizable(false);
        setVisible(true);
    }
}
