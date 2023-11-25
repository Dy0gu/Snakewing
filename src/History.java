import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class History extends JPanel {

    public History() {
        setOpaque(true);
        setFocusable(true);
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // High score
        JLabel highScoreLabel = new JLabel("High score:");
        JLabel highScoreValueLabel = new JLabel("" + Savegame.getHighScore());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 15, 30);
        add(highScoreLabel, gbc);
        gbc.insets = new Insets(15, 200, 15, 0);
        add(highScoreValueLabel, gbc);

        // Games played
        JLabel gamesPlayedLabel = new JLabel("Games played:");
        JLabel gamesPlayedValueLabel = new JLabel("" + Savegame.getGamesPlayed());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 10);
        add(gamesPlayedLabel, gbc);
        gbc.insets = new Insets(15, 200, 15, 0);
        add(gamesPlayedValueLabel, gbc);

        // Games won
        JLabel gamesWonLabel = new JLabel("Games won:");
        JLabel gamesWonValueLabel = new JLabel("" + Savegame.getGamesWon());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 0, 15, 30);
        add(gamesWonLabel, gbc);
        gbc.insets = new Insets(15, 200, 15, 0);
        add(gamesWonValueLabel, gbc);

        // Longest game
        JLabel longestGameLabel = new JLabel("Longest game:");
        JLabel longestGameValueLabel = new JLabel(Savegame.getLongestGame() + "s");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(15, 0, 15, 10);
        add(longestGameLabel, gbc);
        gbc.insets = new Insets(15, 200, 15, 0);
        add(longestGameValueLabel, gbc);

        // Back button
        JButton backButton = new JButton("◄");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goBack();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(30, 50, 15, 0);
        add(backButton, gbc);
    }

}
