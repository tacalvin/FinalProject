package GameObjects;

import Frameworks.Animate;
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
    private BufferedImage sheet;
    private BufferedImage[] im;
    private Animate an;

    public FastEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);
        im = new BufferedImage[3];

        URL url = this.getClass().getClassLoader().getResource("res/FastEnemy.png");
        try {
            sheet = ImageIO.read(url);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        int pos = 0;

        for(int i = 0; i < 3; i++)
        {
            im[i] = sheet.getSubimage(pos, 0, 40, 41);
            pos += 40;
        }
        an = new Animate(im);

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
                    handler.addPoint(100);
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
        if(velX > 0)
            g.drawImage(an.moveLeft(), (int) x, (int) y, null);
        else if(velX < 0)
            g.drawImage(an.straight(), (int) x, (int) y, null);
        else
            g.drawImage(an.moveRight(), (int) x, (int) y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, im[1].getWidth(), im[1].getHeight());
    }
}
