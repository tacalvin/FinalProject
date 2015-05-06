package Specials;

import GameLogic.ID;
import GameObjects.Bullet;
import GameObjects.Player;
import States.Handler;

/**
 * Created by Calvin Ta on 5/5/2015.
 */
public class Burst
{

    public static void shoot(Handler handler, Player player)
    {
        Bullet[] b = new Bullet[18];
        //corresponds to unit circle
        System.out.println("Reached");
        for(int i =0; i < 16; i++)
        {
            b[i] = new Bullet(player.getX()+i,player.getY(),ID.BULLET,handler);
            if(i < 9)
            {
                b[i].setVelX(-5);
            }
                else
            {
                b[i].setVelX(5);
            }
            handler.addObject(b[i]);
        }


    }



}
