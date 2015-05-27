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
    private BufferedImage full;

    int i = 100;//offset
    int posX, posY, x, y;
//    private  final int  MAX_WIDTH;
//    private  final int MAX_HEIGHT;

    public BackGround(String url) {
        URL image = this.getClass().getClassLoader().getResource("res/background.jpg");
        posX = 0;
        posY = 0;
        x = 0;
        y = 0;
//        MAX_HEIGHT = im.getHeight();
//        MAX_WIDTH = im.getWidth();
        //use when images exist
        //URL image = this.getClass().getClassLoader().getResource(url);
        try {

            full = ImageIO.read(image);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        im = full.getSubimage(0,0,Game.WIDTH,Game.HEIGHT);
    }


    public BufferedImage getIm() {
        return im;
    }

    public BufferedImage getFull() {
        return full;
    }

    public void setIm(BufferedImage im) {
        this.im = im;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void tick() {


        im = full.getSubimage(posX, posY + i, Game.WIDTH, Game.HEIGHT);
        i++;

    }

    public void render(Graphics g) {
        g.drawImage(im, 0, 0, null);
    }


}
