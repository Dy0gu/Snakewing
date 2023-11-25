import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class Settings extends JPanel {

    public Settings() {
        setOpaque(true);
        setFocusable(true);
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Style combobox
        JLabel styleLabel = new JLabel("Style:");
        ArrayList<String> styleArrayList = new ArrayList<String>();
        for (int i = 0; i < Styles.values().length; i++) {
            styleArrayList.add(Styles.values()[i].toString());
        }
        String[] styles = new String[styleArrayList.size()];
        styles = styleArrayList.toArray(styles);
        JComboBox<String> styleComboBox = new JComboBox<String>(styles);
        styleComboBox.setFocusable(false);
        styleComboBox.setSelectedIndex(Preferences.getStyle().ordinal());
        styleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setStyle(Styles.values()[styleComboBox.getSelectedIndex()]);
            }
        });
        styleLabel.setLabelFor(styleComboBox);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 15, 40);
        add(styleLabel, gbc);
        gbc.insets = new Insets(15, 250, 15, 0);
        add(styleComboBox, gbc);

        // Theme combo box
        JLabel themeLabel = new JLabel("Theme:");
        ArrayList<String> themeArrayList = new ArrayList<String>();
        for (int i = 0; i < Themes.values().length; i++) {
            themeArrayList.add(Themes.values()[i].toString());
        }
        String[] themes = new String[themeArrayList.size()];
        themes = themeArrayList.toArray(themes);
        JComboBox<String> themeComboBox = new JComboBox<String>(themes);
        themeComboBox.setFocusable(false);
        themeComboBox.setSelectedIndex(Preferences.getTheme().ordinal());
        themeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setTheme(Themes.values()[themeComboBox.getSelectedIndex()]);
            }
        });
        themeLabel.setLabelFor(themeComboBox);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 5, 15, 30);
        add(themeLabel, gbc);
        gbc.insets = new Insets(15, 250, 15, 0);
        add(themeComboBox, gbc);

        // Borderless checkbox
        JLabel borderlessLabel = new JLabel("Borderless:");
        JCheckBox borderlessCheckbox = new JCheckBox();
        borderlessCheckbox.setSelected(Preferences.isBorderless());
        borderlessCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setBorderless(borderlessCheckbox.isSelected());
            }
        });
        borderlessLabel.setLabelFor(borderlessCheckbox);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 5, 15, 0);
        add(borderlessLabel, gbc);
        gbc.insets = new Insets(15, 250, 15, 0);
        add(borderlessCheckbox, gbc);

        // Focus pause checkbox
        JLabel focusPauseLabel = new JLabel("Focus loss pause:");
        JCheckBox focusPauseCheckbox = new JCheckBox();
        focusPauseCheckbox.setSelected(Preferences.isFocusPause());
        focusPauseCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.setFocusPause(focusPauseCheckbox.isSelected());
            }
        });
        focusPauseLabel.setLabelFor(focusPauseCheckbox);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(15, 55, 15, 0);
        add(focusPauseLabel, gbc);
        gbc.insets = new Insets(15, 250, 15, 0);
        add(focusPauseCheckbox, gbc);

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
        gbc.gridy = 4;
        gbc.insets = new Insets(15, 0, 15, 0);
        add(wallsLoopLabel, gbc);
        gbc.insets = new Insets(15, 250, 15, 0);
        add(wallsLoopCheckbox, gbc);

        // Tick rate slider
        JLabel tickRateLabel = new JLabel("Tick rate:");
        JSlider tickRateSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, Preferences.getTickRate());
        tickRateSlider.setFocusable(false);
        JLabel tickRateValueLabel = new JLabel(String.valueOf(tickRateSlider.getValue()));
        JLabel tickRateWarning = new JLabel("WARNING: Changing tick rate is experimental!");
        tickRateWarning.setForeground(Color.RED);
        tickRateSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = tickRateSlider.getValue();
                Preferences.setTickRate(value);
                tickRateValueLabel.setText(String.valueOf(value));
            }
        });

        tickRateLabel.setLabelFor(tickRateSlider);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(15, 0, 15, 15);
        add(tickRateLabel, gbc);
        gbc.insets = new Insets(15, 300, 15, 0);
        add(tickRateSlider, gbc);
        gbc.insets = new Insets(0, 530, 2, 0);
        add(tickRateValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 225, 15, 0);
        add(tickRateWarning, gbc);

        // Back button
        JButton backButton = new JButton("BACK");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goBack();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(30, 100, 15, 0);
        add(backButton, gbc);

        // Reset button
        JButton resetButton = new JButton("RESET");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences.reset();

            }
        });
        gbc.insets = new Insets(30, 300, 15, 0);
        add(resetButton, gbc);
    }
}
