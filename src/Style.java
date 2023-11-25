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
        Color invisible = new Color(0, 0, 0, 0);
        UIManager.put("Button.font", Preferences.BODY);
        UIManager.put("Label.font", Preferences.BODY);
        UIManager.put("CheckBox.font", Preferences.BODY);
        UIManager.put("ComboBox.font", Preferences.BODY);
        UIManager.put("TextField.font", Preferences.BODY);
        UIManager.put("Button.focus", new ColorUIResource(invisible));
        UIManager.put("CheckBox.focus", new ColorUIResource(invisible));
        UIManager.put("ComboBox.focus", new ColorUIResource(invisible));
        UIManager.put("CheckBox.focus", new ColorUIResource(invisible));
        UIManager.put("TextField.focus", new ColorUIResource(invisible));
        UIManager.put("Label.focus", new ColorUIResource(invisible));
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
