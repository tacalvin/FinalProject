package Frameworks;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Created by Calvin Ta on 6/1/2015.
 */
public class Audio
{

    private AudioClip clip;
    public Audio(String s)
    {

        try {
            URL url = this.getClass().getClassLoader().getResource(s);
             clip = Applet.newAudioClip(url);
            System.out.println("ITHINK THERES NO ERROR BUT...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playSound()
    {

        clip.play();
    }

    public void loopSound()
    {
        clip.loop();
    }

    public void stopSound()
    {
        clip.stop();
    }
}
