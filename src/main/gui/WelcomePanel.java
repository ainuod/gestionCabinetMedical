package main.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {
    private JButton proceedButton;

    public WelcomePanel() {
        setLayout(new BorderLayout());

        // Background Image
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("images/welcome_bg.png"));
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundIcon.getImage().getScaledInstance(1440, 824, Image.SCALE_SMOOTH)));
        add(backgroundLabel, BorderLayout.CENTER);  // Background added to the center

        // Button panel setup for the South section
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);  // Make it transparent
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));  // Centering the button in the panel
        

        // Create the proceed button (text-based, no ImageIcon)
        proceedButton = new JButton("Proceed");
        proceedButton.setPreferredSize(new Dimension(500,100));
        proceedButton.setBackground(new Color(255, 255, 255));
        proceedButton.setBorder(BorderFactory.createLineBorder(new Color(2, 154, 152), 5)); 
        proceedButton.setFont(new Font("Arial", Font.BOLD, 50)); 
        proceedButton.setForeground(new Color(2, 155, 152)); 
        proceedButton.setPreferredSize(new Dimension(500, 100)); 
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGui.getInstance().showMainPanel("EN");
            }
        });

        // Add the button to the button panel
        buttonPanel.add(proceedButton);

        // Add button panel to the South area of the main panel
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
