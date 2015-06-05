package ShootPattern;

import GameLogic.ID;
import GameObjects.Bullet;
import GameObjects.Player;
import States.Handler;

/**
 * Created by Calvin Ta on 5/4/2015.
 */
public class TriShot
{

    public static void shoot(Handler handler, Player player)
    {
        Bullet b1 = new Bullet(player.getX()+ player.getIm()[0].getWidth()/2,player.getY() + player.getIm()[0].getHeight()/2, ID.BULLET,handler);
//        b1.setVelX(25);
//        b1.setVelY(-25);
        Bullet b2 = new Bullet((player.getX()+ player.getIm()[0].getWidth()/2)-20,player.getY() + player.getIm()[0].getHeight()/2, ID.BULLET,handler);
        Bullet b3 = new Bullet((player.getX()+ player.getIm()[0].getWidth()/2)+20,player.getY() + player.getIm()[0].getHeight()/2, ID.BULLET,handler);
//        b3.setVelX(-25);
//        b3.setVelY(-25);
        handler.getMp().playSound("shot");
        handler.addObject(b1);
        handler.getMp().playSound("shot");
        handler.addObject(b2);
        handler.getMp().playSound("shot");
        handler.addObject(b3);
    }
}
