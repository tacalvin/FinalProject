package GameObjects;

import GameLogic.ID;
import Main.Game;
import States.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

/**
 * Created by 1817172 on 3/30/2015.
 */
public class BasicEnemy extends GameObject
{

    private BufferedImage im;
    private boolean moved = false;//true when enemy is moved down from screen

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);

        URL url = this.getClass().getClassLoader().getResource("res/EnemyONACID.png");
        try {
            im = ImageIO.read(url);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        velY = 5;
        velX =5;
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
        Random r = new Random();
        x += velX;
        if(moved == false)
        {
            for(int i =0; i <r.nextInt(20)+15;i++)
            y += velY;

            moved = true;
        }



        if(y <= 0 || y >= Game.HEIGHT -40)
            velY *= -1;

        if(x <= 0 || x >= Game.WIDTH -40)
            velX *= -1;

        collision();
    }

    public void shoot()
    {
        //TODO: Shoot towards player position

        // possibly spawn enemy bullet using sqrt of x^2 + y^2
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
