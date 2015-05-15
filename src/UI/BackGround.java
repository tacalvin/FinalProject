package UI;

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
    int i = 10;//offset
    int posX,posY;
//    private  final int  MAX_WIDTH;
//    private  final int MAX_HEIGHT;

    public BackGround(String url) {
        URL image = this.getClass().getClassLoader().getResource("res/background.jpg");
        posX = 0;
        posY = 0;
//        MAX_HEIGHT = im.getHeight();
//        MAX_WIDTH = im.getWidth();
        //use when images exist
        //URL image = this.getClass().getClassLoader().getResource(url);
        try
        {
            im = ImageIO.read(image);
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
        }
    }

    public void tick()
    {

        im = im.getSubimage(posX+i,posY+i,im.getWidth(),im.getHeight());

    }

    public void render(Graphics g) {
        g.drawImage(im,0,0,null);
    }
















}
