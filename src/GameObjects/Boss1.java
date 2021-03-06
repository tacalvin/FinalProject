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
 * Created by 1817172 on 4/30/2015.
 */
public class Boss1 extends GameObject
{
    private int HEALTH = 10000;
    private BufferedImage[] im;
    private BufferedImage sheet;
    private Animate an;
    public Boss1(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);

        im = new BufferedImage[3];
        URL url = this.getClass().getClassLoader().getResource("res/BossFinal.png");
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
            im[i] = sheet.getSubimage(pos, 0, 150, 139);
            pos += 150;
        }

        an = new Animate(im);

        velY = 5;
        velX = 5;
    }
    private void collision()
    {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.BULLET) {
                //checks for collisions of player and enemies
                if (getBounds().intersects(temp.getBounds())) {
                    HEALTH-=50;
                    y-=1;
                    if(HEALTH <= 0)
                    {

                        handler.removeObject(this);
                        handler.removeObject(temp);
                        handler.addPoint(1000);
                    }
//

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

        shoot();

        collision();
    }


    public void shoot()
    {

        Bullet b = new Bullet(this.x +im[1].getWidth()/2,this.y+ im[1].getHeight()/2,ID.EnemyBullet,handler);


            float diffx = x - handler.getPlayer().getX();
            float diffy = y - handler.getPlayer().getY();
            float distance = (float) Math.sqrt((x - handler.getPlayer().getX()) * (x - handler.getPlayer().getX()) + (y - handler.getPlayer().getY()) * (y - handler.getPlayer().getY()));

            float velX1 = ((-1 / distance) * diffx);
            float velY1 = ((-1 / distance) * diffy);


            b.setVelX(velX1 * 5);
            b.setVelY(velY1 * 5);
            handler.addObject(b);



        // possibly spawn enemy bullet using sqrt of x^2 + y^2
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
