import javax.swing.*;

enum Routes {
    MENU, GAME, HISTORY, SETTINGS, CREDITS
}

public class Router {
    private static final Router intance = new Router();

    private JFrame frame;
    private Routes previous;
    private Routes current;

    private Router() {
    }

    // Initialization method to be called with the frame and initial route
    public static void initialize(JFrame frame, Routes initial) {
        intance.frame = frame;
        intance.current = initial;

        intance.frame.getContentPane().removeAll();
        intance.frame.getContentPane().add(getPanel(initial));
    }

    public static void goTo(Routes route) {
        intance.previous = intance.current;
        intance.current = route;

        intance.frame.getContentPane().removeAll();
        intance.frame.getContentPane().add(getPanel(intance.current));
        intance.frame.validate();
        intance.frame.repaint();
    }

    public static void goBack() {
        if (intance.previous != null) {
            goTo(intance.previous);
        }
    }

    public static void reload() {
        intance.frame.getContentPane().removeAll();
        intance.frame.getContentPane().add(getPanel(intance.current));
        intance.frame.validate();
        intance.frame.repaint();
    }

    public static JFrame getFrame() {
        return intance.frame;
    }

    private static JPanel getPanel(Routes route) {
        switch (route) {
            case MENU:
                return new Menu();
            case GAME:
                return new Game();
            case SETTINGS:
                return new Settings();
            case HISTORY:
                return new History();
            case CREDITS:
                return new Credits();
            default:
                throw new IllegalStateException();
        }
    }
}
