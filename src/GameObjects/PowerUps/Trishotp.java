package GameObjects.PowerUps;

import GameLogic.ID;
import GameObjects.GameObject;
import GameObjects.Player;
import States.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by 1817172 on 5/6/2015.
 */
public class Trishotp extends GameObject
{
    private BufferedImage im;
    private int POWER = 3;
    public Trishotp(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);

        URL url = this.getClass().getClassLoader().getResource("res/PowerUp.png");
        try {
            im = ImageIO.read(url);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public void tick()
    {
        collision();
    }

    private void collision()
    {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.Player && this.getBounds().intersects(temp.getBounds())) {
                //checks for collisions of player and enemies
                ((Player)temp).setCurrentPower(POWER);
                handler.removeObject(this);

            }
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(im,(int)x,(int)y,null);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,im.getWidth(),im.getHeight());
    }
}
