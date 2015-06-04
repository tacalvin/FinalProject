package Frameworks;

import java.util.HashMap;

/**
 * Created by Calvin Ta on 6/1/2015.
 */
public class MusicPlayer
{
    private HashMap<String,Audio> sounds;

    public MusicPlayer()
    {
        sounds = new HashMap<>();
    }

    public void addSound(String sound, Audio a)
    {
        sounds.put(sound , a);
    }


    public void playSound(String sound)
    {
        Audio clip = sounds.get(sound);
        clip.playSound();
    }

    public void loopSound(String sound)
    {
        Audio clip = sounds.get(sound);
        clip.loopSound();
    }

    public void stopSound(String sound)
    {
        Audio clip = sounds.get(sound);
        clip.stopSound();
    }
}
