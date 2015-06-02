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

//    int i = 0;//offset
    int posX, posY, x, y;
    boolean reset;
//    private  final int  MAX_WIDTH;
//    private  final int MAX_HEIGHT;


    public BackGround(String url,int x, int y) {
        URL image = this.getClass().getClassLoader().getResource("res/background.jpg");
        posX = 0;
        posY = 0;
        reset = false;
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

        im = full.getSubimage(x,y,Game.WIDTH,Game.HEIGHT);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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


    public void resetPosY()
    {
        if(!reset)
        y = Game.HEIGHT;
    }





    public void tick() {


        y--;

    }



    public void render(Graphics g) {
        g.drawImage(im, x, y, null);
    }


}
