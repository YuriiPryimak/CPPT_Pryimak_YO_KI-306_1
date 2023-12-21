import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static AudioPlayer[] audioPlayers;

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer(new Screen(7.8, "720x1980"), new HardDisk(2000, "Harman"));

        audioPlayer.AddSong("Stepan Giga - Zoloto Karpat");
        audioPlayer.AddSong("Stepan Giga - Yvoruna");
        audioPlayer.AddSong("Victor Pavlic - Shikidim");
        audioPlayer.AddSong("Zhadan i Sobaku - Madona");
        audioPlayer.AddSong("Zhadan i Sobaku - Kobzon");

        audioPlayer.TurnOnPrevSong();
        audioPlayer.TurnOnPrevSong();
        audioPlayer.TurnOnPrevSong();

        audioPlayer.TurnOnPrevSong();
        audioPlayer.TurnOnPrevSong();
        audioPlayer.TurnOnPrevSong();
        audioPlayer.TurnOnPrevSong();



        System.out.println(audioPlayer);


        AudioPlayer audioPlayer2 = new AudioPlayer(new Screen(7, "720x1980"), new HardDisk(1000, "Harman99"));
//        main1();

    }

    public static void main1() {
        AudioPlayer audioPlayer3 = new AudioPlayer(new Screen(8, "720x1980"), new HardDisk(1000, "Harman1"));
        AudioPlayer audioPlayer1 = new AudioPlayer(new Screen(9, "720x1980"), new HardDisk(1000, "Harman0"));
        AudioPlayer audioPlayer4 = new AudioPlayer(new Screen(7, "720x1980"), new HardDisk(2000, "Harman9"));
        AudioPlayer audioPlayer5 = new AudioPlayer(new Screen(7, "720x1980"), new HardDisk(1000, "Harman100"));

        int totalMaxCapacityCount = 0;

        for (AudioPlayer player : audioPlayers) {
            player.printCapacity();
            totalMaxCapacityCount += AudioPlayer.getMaxCapacityCount();
        }

        // Вивести у консоль загальну кількість аудіоплеєрів з найбільшим capacity
        System.out.println("Кількість аудіоплеєрів з найбільшим capacity: " + totalMaxCapacityCount);
        
    }
}

