package main.gui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Use the getInstance() method to get the single instance of MainGui
                MainGui window = MainGui.getInstance();
                window.setVisible(true);
            }
        });
    }
}
