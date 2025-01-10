package main.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {
    private JButton englishButton;
    private JButton frenchButton;

    public WelcomePanel() {
        setLayout(new BorderLayout());

        // Background Image
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("images/welcome_bg.png"));
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundIcon.getImage().getScaledInstance(1440, 1024, Image.SCALE_SMOOTH)));
        setLayout(new BorderLayout());
        add(backgroundLabel, BorderLayout.CENTER);

        // Panel for Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);  // Make panel background transparent
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // English Button
        ImageIcon englishIcon = new ImageIcon(getClass().getResource("images/eng_button.png"));
        englishButton = new JButton(new ImageIcon(englishIcon.getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH)));
        englishButton.setFocusPainted(false);
        englishButton.setContentAreaFilled(false);
        englishButton.setBorderPainted(false);
        englishButton.setBounds(470, 600, 500, 100);
        englishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change to the main panel with English language selected
                MainGui.getInstance().showMainPanel("EN");
            }
        });

        // French Button
        ImageIcon frenchIcon = new ImageIcon(getClass().getResource("images/fr_button.png"));
        frenchButton = new JButton(new ImageIcon(frenchIcon.getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH)));
        frenchButton.setFocusPainted(false);
        frenchButton.setContentAreaFilled(false);
        frenchButton.setBorderPainted(false);
        frenchButton.setBounds(470, 730, 500, 100);
        frenchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change to the main panel with French language selected
                MainGui.getInstance().showMainPanel("FR");
            }
        });

        // Add buttons to button panel
        buttonPanel.add(englishButton);
        buttonPanel.add(frenchButton);

        // Add button panel to the main panel
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
