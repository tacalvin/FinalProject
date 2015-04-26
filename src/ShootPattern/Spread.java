package ShootPattern;

import GameLogic.ID;
import GameObjects.Bullet;
import GameObjects.Player;
import States.Handler;

/**
 * Created by 1817172 on 4/2/2015.
 */
public class Spread
{
    public static float timer = 10f;
    public static void shoot(Handler handler, Player player)
    {
        Bullet b1 = new Bullet(player.getX()+ player.getIm().getWidth()/2,player.getY() + player.getIm().getHeight()/2, ID.BULLET,handler);
        b1.setVelX(25);
        b1.setVelY(-25);
        Bullet b2 = new Bullet(player.getX()+ player.getIm().getWidth()/2,player.getY() + player.getIm().getHeight()/2, ID.BULLET,handler);
        Bullet b3 = new Bullet(player.getX()+ player.getIm().getWidth()/2,player.getY() + player.getIm().getHeight()/2, ID.BULLET,handler);
        b3.setVelX(-25);
        b3.setVelY(-25);
        handler.addObject(b1);
        handler.addObject(b2);
        handler.addObject(b3);
    }
}
