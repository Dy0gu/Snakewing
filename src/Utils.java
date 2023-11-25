import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.*;

public class Utils {
    public static Image icon() {
        int width = 250;
        int height = 250;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();

        g.setColor(Color.RED);
        g.fillOval(0, 0, width, height);

        g.dispose();

        return image;
    }

    public static int dialog(Component parent, String message, ArrayList<String> buttons) {
        int option;
        switch (buttons.size()) {
            case 1:
                option = JOptionPane.DEFAULT_OPTION;
                UIManager.put("OptionPane.okButtonText", buttons.get(0));
                break;
            case 2:
                option = JOptionPane.YES_NO_OPTION;
                UIManager.put("OptionPane.yesButtonText", buttons.get(0));
                UIManager.put("OptionPane.noButtonText", buttons.get(1));
                break;
            case 3:
                option = JOptionPane.YES_NO_CANCEL_OPTION;
                UIManager.put("OptionPane.yesButtonText", buttons.get(0));
                UIManager.put("OptionPane.noButtonText", buttons.get(1));
                UIManager.put("OptionPane.cancelButtonText", buttons.get(2));
                break;
            default:
                throw new IllegalArgumentException();
        }

        message = message.replaceAll("\n", "<br>");
        String html = "<html><body><div width='300px' align='center'>" + message + "</div></body></html>";
        JOptionPane pane = new JOptionPane(html, JOptionPane.PLAIN_MESSAGE, option);
        pane.setOpaque(true);

        JDialog dialog = pane.createDialog(parent, "Snakewing");
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setAlwaysOnTop(true);
        dialog.setIconImage(icon());

        Component[] components = dialog.getContentPane().getComponents();
        while (components.length > 0) {
            for (int i = 0; i < components.length; i++) {
                if (components[i] instanceof Container) {
                    Container container = (Container) components[i];
                    Component[] subComponents = container.getComponents();
                    for (int j = 0; j < subComponents.length; j++) {
                        if (subComponents[j].getClass() != JButton.class) {
                            subComponents[j].setBackground(new Color(243, 243, 243));
                        }
                    }
                }
            }
            components = components[0] instanceof Container ? ((Container) components[0]).getComponents()
                    : new Component[0];
        }

        dialog.setVisible(true);
        return (int) pane.getValue();
    }
}
