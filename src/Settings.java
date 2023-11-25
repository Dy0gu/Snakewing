import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Settings extends JPanel {

    public Settings() {
        setOpaque(true);
        setFocusable(true);
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Style combobox
        JLabel styleLabel = new JLabel("Style:");
        String[] styles = { "CLASSIC", "SYSTEM" };
        JComboBox<String> styleComboBox = new JComboBox<String>(styles);
        styleComboBox.setSelectedIndex(Preferences.getStyle().ordinal());
        styleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setStyle(Styles.values()[styleComboBox.getSelectedIndex()]);
                SwingUtilities.updateComponentTreeUI(Router.getFrame());
            }
        });
        styleLabel.setLabelFor(styleComboBox);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 5, 15, 40);
        add(styleLabel, gbc);
        gbc.insets = new Insets(15, 150, 15, 0);
        add(styleComboBox, gbc);

        // Theme combo box
        JLabel themeLabel = new JLabel("Theme:");
        String[] themes = { "DARK", "LIGHT" };
        JComboBox<String> themeComboBox = new JComboBox<String>(themes);
        themeComboBox.setSelectedIndex(Preferences.getTheme().ordinal());
        themeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setTheme(Themes.values()[themeComboBox.getSelectedIndex()]);
                Router.reload();
            }
        });
        themeLabel.setLabelFor(themeComboBox);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 5, 15, 30);
        add(themeLabel, gbc);
        gbc.insets = new Insets(15, 150, 15, 0);
        add(themeComboBox, gbc);

        // Borderless checkbox
        JLabel borderlessLabel = new JLabel("Borderless:");
        JCheckBox borderlessCheckbox = new JCheckBox();
        borderlessCheckbox.setSelected(Preferences.isBorderless());
        borderlessCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setBorderless(borderlessCheckbox.isSelected());
                JFrame frame = Router.getFrame();
                frame.dispose();
                frame.setUndecorated(borderlessCheckbox.isSelected());
                frame.setVisible(true);
            }
        });
        borderlessLabel.setLabelFor(borderlessCheckbox);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 5, 15, 0);
        add(borderlessLabel, gbc);
        gbc.insets = new Insets(15, 150, 15, 0);
        add(borderlessCheckbox, gbc);

        // Walls Loop checkbox
        JLabel wallsLoopLabel = new JLabel("Walls loop:");
        JCheckBox wallsLoopCheckbox = new JCheckBox();
        wallsLoopCheckbox.setSelected(Preferences.isWallsLoop());
        wallsLoopCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setWallsLoop(wallsLoopCheckbox.isSelected());
            }
        });
        wallsLoopLabel.setLabelFor(wallsLoopCheckbox);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(15, 5, 15, 0);
        add(wallsLoopLabel, gbc);
        gbc.insets = new Insets(15, 150, 15, 0);
        add(wallsLoopCheckbox, gbc);

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
        gbc.insets = new Insets(30, 40, 15, 0);
        add(backButton, gbc);
    }
}
