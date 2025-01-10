package main.gui;

import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {
    private static MainGui instance;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    // Private constructor for Singleton pattern
    private MainGui() {
        setTitle("Medical Management System");
        setSize(1440, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Prevent resizing
        setResizable(false);

        // Set up CardLayout to switch between panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add WelcomePanel as the first panel
        cardPanel.add(new WelcomePanel(), "Welcome");

        // Add the main panel (initially empty)
        cardPanel.add(new JPanel(), "Main");

        add(cardPanel);

        setVisible(true);
    }

    // Singleton getInstance method
    public static MainGui getInstance() {
        if (instance == null) {
            instance = new MainGui();
        }
        return instance;
    }

    // Method to show the Main Panel based on the selected language
    public void showMainPanel(String language) {
        // Remove the current main panel and add a new one based on the language
        cardPanel.remove(1); // Remove the existing "Main" panel

        MainPanel mainPanel = new MainPanel(language);
        cardPanel.add(mainPanel, "Main");

        // Show the "Main" panel
        cardLayout.show(cardPanel, "Main");
    }
}
