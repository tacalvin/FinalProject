package GameObjects;

import GameLogic.ID;
import Main.Game;
import States.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by 1817172 on 3/30/2015.
 */
public class Bullet extends GameObject
{
    private BufferedImage im;

    public Bullet(float x, float y, ID id, Handler handler)
    {
        super(x, y, id,handler);
        URL url = this.getClass().getClassLoader().getResource("res/Fire.png");
        try {
            im = ImageIO.read(url);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        im = im.getSubimage(0,0,16,16);

        velY = -25;
    }

    @Override
    public void tick()
    {
        y += velY;
        x += velX;

        if(y >= Game.HEIGHT)
            handler.removeObject(this);


    }

    @Override
    public void render(Graphics g)
    {

        g.drawImage(im, (int) x, (int) y, null);

    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, im.getWidth(), im.getHeight());
    }
}
