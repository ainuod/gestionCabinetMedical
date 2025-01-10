package main.gui;

import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {
    private static MainGui instance;
    private CardLayout cardLayout;
    private JPanel cardPanel;


    private MainGui() {
        setTitle("Medical Management System");
        setSize(1440, 824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(false);


        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new WelcomePanel(), "Welcome");

        cardPanel.add(new JPanel(), "Main");

        add(cardPanel);

        setVisible(true);
    }

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
