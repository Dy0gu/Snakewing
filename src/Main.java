import java.awt.Color;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Snakewing");
        setSize(500, 500);
        setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(Preferences.isBorderless());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(Utils.icon());

        Router.initialize(this, Routes.MENU);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
