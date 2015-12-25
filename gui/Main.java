package gui;

import math.Function;

import javax.swing.*;

/**
 * Created by alex on 12/19/15.
 */
public class Main {
    public static void main(String[] args)  throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Graph g = new Graph(700,700);
                ControlWindow c = new ControlWindow(g);

            }
        });
    }
}
