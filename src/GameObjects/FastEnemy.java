package GameObjects;

import GameLogic.ID;
import Main.Game;
import States.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by 1817172 on 4/28/2015.
 */
public class FastEnemy extends GameObject
{
    private BufferedImage im;
    public FastEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);

        URL url = this.getClass().getClassLoader().getResource("res/Fast Enemy.png");
        try {
            im = ImageIO.read(url);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        velY = 15;
        velX = 15;
    }
    private void collision()
    {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.BULLET) {
                //checks for collisions of player and enemies
                if (getBounds().intersects(temp.getBounds())) {
                    handler.removeObject(this);
                    handler.removeObject(temp);
                    handler.addPoint(50);
//                    if(HUD.HEALTH ==0)
//                    {
//                        System.out.println("You Lose");
//                        System.exit(1);
//
//                    }
                    //HUD.HEALTH -= 2;

                }
            }
        }
    }


    @Override
    public void tick()
    {
        x += velX;
        y += velY;



        if(y <= 0 || y >= Game.HEIGHT -40)
            velY *= -1;

        if(x <= 0 || x >= Game.WIDTH -40)
            velX *= -1;

        collision();
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(im, (int) x, (int) y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, im.getWidth(), im.getHeight());
    }
}
