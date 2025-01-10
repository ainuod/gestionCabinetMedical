package main.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {
    private JButton englishButton;

    public WelcomePanel() {
        setLayout(new BorderLayout());

        // Background Image
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("images/welcome_bg.png"));
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundIcon.getImage().getScaledInstance(1440, 1024, Image.SCALE_SMOOTH)));
        setLayout(new BorderLayout());
        add(backgroundLabel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(new Color(0, 0, 0, 0));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));


        ImageIcon englishIcon = new ImageIcon(getClass().getResource("images/proceed.png"));
        englishButton = new JButton(new ImageIcon(englishIcon.getImage().getScaledInstance(500, 100, Image.SCALE_SMOOTH)));
        englishButton.setFocusPainted(false);
        englishButton.setContentAreaFilled(false);
        englishButton.setBorderPainted(false);
        englishButton.setBounds(470, 600, 500, 100);
        englishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGui.getInstance().showMainPanel("EN");
            }
        });

        // Add button to button panel
        buttonPanel.add(englishButton);

        // Add button panel to the main panel
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
