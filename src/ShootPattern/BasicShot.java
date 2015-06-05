package ShootPattern;

import GameLogic.ID;
import GameObjects.Bullet;
import GameObjects.Player;
import States.Handler;

/**
 * Created by Calvin Ta on 4/1/2015.
 */
public class BasicShot
{
    public static void shoot(Handler handler, Player player)
    {

        handler.addObject(new Bullet(player.getX()+ player.getIm()[0].getWidth()/2,player.getY() + player.getIm()[0].getHeight()/2, ID.BULLET,handler));
        handler.getMp().playSound("shot");
    }
}
