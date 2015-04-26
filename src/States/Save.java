package States;



import java.io.*;import java.io.File;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.lang.Exception;

/**
 * Created by Calvin Ta on 1/4/2015.
 */
public class Save
{
    public static GameData gd;
    public static void save()
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("highscores.sav")
            );
            out.writeObject(gd);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

    public static void load()
    {
        try
        {
            if(!saveFileExists()) {
                init();
                return;
            }
            ObjectInputStream in = new ObjectInputStream( new FileInputStream("highscores.sav"));
            gd = (GameData) in.readObject();
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    public static boolean saveFileExists()
    {
        File f = new File ("highscores.sav");
        return f.exists();
    }

    public static void init()
    {
        gd = new GameData();
        gd.init();
        save();
    }

}
