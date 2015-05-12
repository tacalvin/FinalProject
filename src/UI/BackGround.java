package UI;

import Main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class BackGround {
    /*
     *
     * Still need to do with images and scrolling
     */


    private BufferedImage im;

    public BackGround() {
        URL image = this.getClass().getClassLoader().getResource("res/background.jpeg");
        try
        {
            im = ImageIO.read(image);
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
        }
    }

    public void render(Graphics g) {
        g.drawImage(im,0,0,null);
    }
















}
