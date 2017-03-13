import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;

/**
 * Sound.java
 *
 * Author: Liam Lawrence
 * Date: 1.26.17
 *
 * Plays specific sound.wav files
 */
public class Sound {

    // The main sound player method
    private static void play(String fileName) {
        try {
            // Gets the audio clip and starts to play it
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
            clip.start();
            //clip.drain();     // Supposed to prevent mem leaks / overflows but is buggy and broken

            // Prevents memory leaks and overflows
            clip.addLineListener(evt -> {
                if (evt.getType() == LineEvent.Type.STOP) {
                    evt.getLine().close();
                }
            });
        }

        // Just in case anything goes wrong, print it out
        catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }


    // plays the sound of a bow shooting
    public static void bow() {
        String fileLocation = "resources/bow.wav";
        play(fileLocation);
    }

    // plays the sound of a door opening/closing
    public static void door() {
        String fileLocation = "resources/door.wav";
        play(fileLocation);
    }

    // plays the sound of a laser shooting
    public static void laser() {
        String fileLocation = "resources/laser.wav";
        play(fileLocation);
    }

    // plays the sound of a sweeping thing
    public static void sweep() {
        String fileLocation = "resources/sweep.wav";
        play(fileLocation);
    }

    // plays the sound of a loading loop I found online
    public static void loading() {
        String fileLocation = "resources/loading.wav";
        play(fileLocation);
    }
}