import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

enum Styles {
    CLASSIC, SYSTEM;
}

public class Style {
    private static Style instance = new Style();

    private Styles current;

    private Style() {
        UIManager.put("Button.focus", Color.TRANSLUCENT);
        UIManager.put("Button.font", Preferences.BODY);
        UIManager.put("Label.font", Preferences.BODY);
        UIManager.put("CheckBox.font", Preferences.BODY);
        UIManager.put("CheckBox.focus", Color.TRANSLUCENT);
        UIManager.put("ComboBox.font", Preferences.BODY);
        UIManager.put("TextField.font", Preferences.BODY);
        UIManager.put("Button.focus", new ColorUIResource(Color.TRANSLUCENT));
        UIManager.put("CheckBox.focus", new ColorUIResource(Color.TRANSLUCENT));
        UIManager.put("ComboBox.focus", new ColorUIResource(Color.TRANSLUCENT));
        current = null;
    }

    public static void setCurrent(Styles style) {
        instance.current = style;
        try {
            switch (style) {
                case CLASSIC:
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    break;
                case SYSTEM:
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                default:
                    throw new IllegalStateException();
            }
        } catch (Exception e) {
        }
    }

    public static Styles getCurrent() {
        return instance.current;
    }
}
