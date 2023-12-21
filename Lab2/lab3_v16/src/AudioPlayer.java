
import java.util.ArrayList;
import javax.sound.midi.Soundbank;
import org.w3c.dom.ls.LSOutput;
/**
 * Class AudioPlayer
 * @author
 * @version 1.0
 */
public class AudioPlayer
{
    private final Button nextSong = new Button("next song");
    private final Button prevSong = new Button("prev song");
    private final Button pause = new Button("pause");
    public int capacity;
    private Logger logger = Logger.getLogger("logs.txt");
    private Screen screen;
    private HardDisk hardDisk;
    private ArrayList<String> songs = new ArrayList<>();
    private int curSong = 0;
    static String name = "";
    private static double maxCapacity = 0;
    private static int maxCapacityCount = 0;

    public void printCapacity() {
        if (this.getHardDisk().getCapacity() == 1000) {
            System.out.println("AudioPlayer capacity with 1000: " + this.getHardDisk().getCapacity());
            // Оновіть лічильник, якщо поточний об'єкт має максимальний capacity
            if (this.getHardDisk().getCapacity() > getMaxCapacity()) {
                maxCapacity = this.getHardDisk().getCapacity();
                maxCapacityCount = 1;
            } else if (this.getHardDisk().getCapacity() == getMaxCapacity()) {
                maxCapacityCount++;
            }
        }
    }

    public static double getMaxCapacity() {
        return maxCapacity;
    }

    public static int getMaxCapacityCount() {
        return maxCapacityCount;
    }


    public static void printMaxDiagonalLength(AudioPlayer... players) {
        double maxDiagonal = 0;

        for (AudioPlayer player : players) {
            double diagonal = Math.sqrt(Math.pow(player.getScreen().getDiagonal(), 2) +
                    Math.pow(player.getScreen().getExpansion().length(), 2));

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
            }
        }

        System.out.println("Maximum diagonal length: " + maxDiagonal);
    }

    /**
     * Method to be called in Main class to print max diagonal length
     */
    public static void printMaxDiagonalLengthFromMain() {
        AudioPlayer audioPlayer = new AudioPlayer(new Screen(7.8, "720x1980"), new HardDisk(1000, "Harman"));
        AudioPlayer audioPlayer1 = new AudioPlayer(new Screen(9, "720x1980"), new HardDisk(1000, "Harman0"));
        AudioPlayer audioPlayer2 = new AudioPlayer(new Screen(7, "720x1980"), new HardDisk(1000, "Harman9"));
        AudioPlayer audioPlayer3 = new AudioPlayer(new Screen(8, "720x1980"), new HardDisk(1000, "Harman1"));

        printMaxDiagonalLength(audioPlayer, audioPlayer1, audioPlayer2, audioPlayer3);
    }

    /**
     * Constructor
     * @param screen
     * @param hardDisk
     */
    public AudioPlayer(Screen screen, HardDisk hardDisk) {
        logger.log(logger.infoFlag + "AudioPlayer constructor called");
        this.screen = screen;
        this.hardDisk = hardDisk;
    }

    /**
     * Method to add new song to player
     * @param song
     */
    public void AddSong(String song)
    {
        songs.add(song);
        System.out.println(song + " was added to audio player");
        logger.log(logger.infoFlag + "AudioPlayer AddSong method was called");
    }


    /**
     * Method to turn on next song
     */
    public void TurnOnNextSong()
    {
        logger.log(logger.infoFlag + "TurnOnNextSong AudioPlayer method was called");
        if(curSong == songs.size() - 1)
        {
            System.out.println("You push button " + nextSong.getAction());
            System.out.println("Now playing " + songs.get(curSong));
            curSong = 0;
        } else if (curSong < songs.size() - 1) {
            System.out.println("You push button " + nextSong.getAction());
            System.out.println("Now playing " + songs.get(curSong));
            curSong++;
        }
    }

    /**
     * Method to turn on prev song
     */
    public void TurnOnPrevSong()
    {
        logger.log(logger.infoFlag + "TurnPrevNextSong AudioPlayer method was called");
        if(curSong == 0)
        {
            System.out.println("You push button " + prevSong.getAction());
            System.out.println("Now playing " + songs.get(curSong));
            curSong = songs.size() - 1;
        } else if (curSong > 0) {
            System.out.println("You push button " + prevSong.getAction());
            System.out.println("Now playing " + songs.get(curSong));
            curSong--;
        }
    }

    public Button getNextSong() {
        return nextSong;
    }

    public Button getPrevSong() {
        return prevSong;
    }

    public Button getPause() {
        return pause;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    public int getCurSong() {
        return curSong;
    }

    public void setCurSong(int curSong) {
        this.curSong = curSong;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioPlayer{ ")
                .append(" screen=").append(screen).append("\n")
                .append(", hardDisk=").append(hardDisk).append("\n")
                .append(", songs=").append(songs).append("\n")
                .append(", curSong=").append(curSong).append("\n");

        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void printCapacity1000() {
    }
}
