import java.io.*;
import sun.audio.*;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 * @author alvin alexander, devdaily.com.
 */
public class SoundAttempt
{
  public static void main(String[] args) 
  throws Exception
  {
    // open the sound file as a Java input stream
    String gormott = "/media/hershey/BEN/Xenoblade2SoundSelection/Gormott.wav";
    InputStream in = new FileInputStream(gormott);

    String ancientVessle = "/media/hershey/BEN/Xenoblade2SoundSelection/TheAncientVessle.wav";
    InputStream in = new FileInputStream(ancientVessle);

    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
  }
}
/*
byte[] buffer = new byte[4096];
    for (File file : files) {
        try {
            AudioInputStream is = AudioSystem.getAudioInputStream(file);
            AudioFormat format = is.getFormat();
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();
            while (is.available() > 0) {
                int len = is.read(buffer);
                line.write(buffer, 0, len);
            }
            line.drain(); //**[DEIT]** wait for the buffer to empty before closing the line
            line.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
