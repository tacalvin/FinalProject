package GameLogic;

import GameObjects.BasicEnemy;
import GameObjects.Boss1;
import GameObjects.FastEnemy;
import GameObjects.GameObject;
import Main.Game;
import States.Handler;
import UI.HUD;

import java.util.Random;

/**
 * Created by 1817172 on 3/31/2015.
 */

public class Spawn {
    private Handler handler;



    private int scoreKeep = 0;
    private Random r;
    private boolean bossIn = false;

    public Spawn(Handler handler) {
        this.handler = handler;

        r = new Random();

    }
    public void clearEnemies()
    {
        for(int i =0; i < handler.object.size(); i++)
        {
            GameObject o = handler.object.get(i);
            if(o.getId() != ID.Player)
            handler.object.remove(i);

        }
    }


    public void tick() {
//        int level = handler.getLevel();
//        scoreKeep = handler.getPlayer().getScore();
//        if(scoreKeep > level * 1000)
//            handler.setLevel(handler.getLevel()+1);
//        if(handler.getLevel() == 1 && handler.getTime() > 10f)
//        {
//            handler.setTime(0);
//            for(int i = 0; i < handler.getLevel() * 2; i++)
//            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-100),r.nextInt(Game.HEIGHT-100),ID.BasicEnemy,handler));
//        }
//
//        if(handler.getLevel() == 2 && handler.getTime() > 25f)
//        {
//            handler.setTime(0);
//            for(int i = 0; i < handler.getLevel() * 3; i++)
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-100),r.nextInt(Game.HEIGHT-100),ID.BasicEnemy,handler));
//            for(int i = 0; i < handler.getLevel() * 2; i++)
//                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-100),r.nextInt(Game.HEIGHT-100),ID.BasicEnemy,handler));
//        }

        if(/*handler.getLevel() == 3 &&*/ bossIn == false)
        {
            //clearEnemies();
            handler.addObject(new Boss1((Game.WIDTH/2-100),(Game.HEIGHT/2-100),ID.BasicEnemy,handler));
            bossIn = true;
            //Spawn boss

        }




    }


}

