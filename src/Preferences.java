import java.awt.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Preferences {
    private static final String PATHNAME = "snakewing.prefs";

    public static final Font BODY = new Font(null, Font.BOLD, 15);
    public static final Font TITLE = new Font(null, Font.BOLD, 100);

    private static final Preferences instance = new Preferences();

    private Data data;

    private Preferences() {
        this.data = load();
        Style.setCurrent(data.style);
        Theme.setCurrent(data.theme);
    }

    private static Data load() {
        Data data;
        File file = new File(PATHNAME);

        if (file.exists() && file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                data = (Data) ois.readObject();
                return data;
            } catch (Exception e) {
                file.delete();
                data = new Data();
            }
        } else {
            data = new Data();
        }

        return data;
    }

    public static void save() {
        File file = new File(PATHNAME);

        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(instance.data);
            return;
        } catch (Exception e) {
        }
    }

    public static void reset() {
        instance.data = new Data();
        Preferences.setTheme(getTheme());
        Preferences.setStyle(getStyle());
        Preferences.setBorderless(isBorderless());
        Preferences.setFocusPause(isFocusPause());
        Preferences.setWallsLoop(isWallsLoop());
        Preferences.setTickRate(getTickRate());
    }

    public static Themes getTheme() {
        return instance.data.theme;
    }

    public static void setTheme(Themes theme) {
        Theme.setCurrent(theme);
        Router.reload();
        instance.data.theme = theme;
        save();
    }

    public static Styles getStyle() {
        return instance.data.style;
    }

    public static void setStyle(Styles style) {
        Style.setCurrent(style);
        SwingUtilities.updateComponentTreeUI(Router.getFrame());
        instance.data.style = style;
        save();
    }

    public static boolean isBorderless() {
        return instance.data.borderless;
    }

    public static void setBorderless(boolean borderless) {
        JFrame frame = Router.getFrame();
        frame.dispose();
        frame.setUndecorated(borderless);
        frame.setVisible(true);
        instance.data.borderless = borderless;
        save();
    }

    public static boolean isFocusPause() {
        return instance.data.focusPause;
    }

    public static void setFocusPause(boolean focusPause) {
        instance.data.focusPause = focusPause;
        save();
    }

    public static boolean isWallsLoop() {
        return instance.data.wallsloop;
    }

    public static void setWallsLoop(boolean walls_loop) {
        instance.data.wallsloop = walls_loop;
        save();
    }

    public static int getTickRate() {
        return instance.data.tickRate;
    }

    public static void setTickRate(int tickRate) {
        instance.data.tickRate = tickRate;
        save();
    }

    private static class Data implements Serializable {
        private Themes theme;
        private Styles style;
        private boolean borderless;
        private boolean focusPause;
        private boolean wallsloop;
        private int tickRate;

        public Data() {
            this.theme = Themes.DARK;
            this.style = Styles.CLASSIC;
            this.borderless = true;
            this.focusPause = true;
            this.wallsloop = false;
            this.tickRate = 20;
        }
    }
}
