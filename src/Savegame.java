import java.io.*;

public class Savegame {
    private static final String PATHNAME = "snakewing.save";

    private static final Savegame instance = new Savegame();

    private Data data;

    private Savegame() {
        this.data = load();
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

    public static int getHighScore() {
        return instance.data.highScore;
    }

    public static void setHighScore(int highscore) {
        instance.data.highScore = highscore;
        save();
    }

    public static int getGamesPlayed() {
        return instance.data.gamesPlayed;
    }

    public static void setGamesPlayed(int gamesPlayed) {
        instance.data.gamesPlayed = gamesPlayed;
        save();
    }

    public static int getGamesWon() {
        return instance.data.gamesWon;
    }

    public static void setGamesWon(int gamesWon) {
        instance.data.gamesWon = gamesWon;
        save();
    }

    public static int getLongestGame() {
        return instance.data.longestGame;
    }

    public static void setLongestGame(int longestGame) {
        instance.data.longestGame = longestGame;
        save();
    }

    private static class Data implements Serializable {
        private int highScore;
        private int gamesPlayed;
        private int gamesWon;
        private int longestGame;

        public Data() {
            this.highScore = 0;
            this.gamesPlayed = 0;
            this.gamesWon = 0;
            this.longestGame = 0;
        }
    }
}
