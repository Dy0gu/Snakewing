import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel {

    public Menu() {
        setOpaque(true);
        setFocusable(true);
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Title label
        JLabel titleLabel = new JLabel("Snakewing");
        titleLabel.setFont(Preferences.TITLE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 30, 0);
        add(titleLabel, gbc);

        // Play button
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goTo(Routes.GAME);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 0);
        add(playButton, gbc);

        // History button
        JButton historyButton = new JButton("History");
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goTo(Routes.HISTORY);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 0, 15, 0);
        add(historyButton, gbc);

        // Settings button
        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goTo(Routes.SETTINGS);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(15, 0, 15, 0);
        add(settingsButton, gbc);

        // Credits button
        JButton creditsButton = new JButton("Credits");
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goTo(Routes.CREDITS);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(15, 0, 15, 0);
        add(creditsButton, gbc);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(15, 0, 15, 0);
        add(exitButton, gbc);
    }
}
