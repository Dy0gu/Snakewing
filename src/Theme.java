import java.awt.Color;

import javax.swing.UIManager;

enum Themes {
    DARK, LIGHT;
}

public class Theme {
    private static Theme instance = new Theme();

    private Themes current;

    private Theme() {
        current = null;
    }

    public static void setCurrent(Themes theme) {
        instance.current = theme;
        Color primary = getPrimary(theme);
        Color secondary = getSecondary(theme);
        UIManager.put("Panel.background", primary);
        UIManager.put("Label.foreground", secondary);
        UIManager.put("CheckBox.background", primary);
        UIManager.put("CheckBox.foreground", secondary);
    }

    public static Themes getCurrent() {
        return instance.current;
    }

    public static Color getPrimary(Themes theme) {
        switch (theme) {
            case DARK:
                return new Color(15, 15, 15);
            case LIGHT:
                return new Color(243, 243, 243);
            default:
                throw new IllegalStateException();
        }
    }

    public static Color getSecondary(Themes theme) {
        switch (theme) {
            case DARK:
                return new Color(243, 243, 243);
            case LIGHT:
                return new Color(15, 15, 15);
            default:
                throw new IllegalStateException();
        }
    }
}
