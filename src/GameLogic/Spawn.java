package GameLogic;

import GameObjects.BasicEnemy;
import Main.Game;
import States.Handler;
import UI.HUD;

import java.util.Random;

/**
 * Created by 1817172 on 3/31/2015.
 */

public class Spawn {
    private Handler handler;

    private HUD hud;

    private int scoreKeep = 0;
    private Random r;

    public Spawn(Handler handler) {
        this.handler = handler;

        r = new Random();

    }


    public void tick() {
        scoreKeep++;


        if (scoreKeep >= 100) {

            scoreKeep = 0;

            for (int i = 0; i < 10; i++) {
//                if (hud.getLevel() >= 1)
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16)
                            , ID.BasicEnemy, handler));
//                if (hud.getLevel() >= 2)
//                    handler.addObject(new FasterEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16)
//                            , ID.FastEnemy, handler));
//                if (hud.getLevel() >= 3)
//                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16)
//                            , ID.SmartEnemy, handler));
//                if (hud.getLevel() >= 4)
//                    handler.addObject(new Boss(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16)
//                            , ID.Boss, handler));
            }


            //hud.setLevel(hud.getLevel() + 1);
        }


    }


}

