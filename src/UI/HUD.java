package UI;

import GameObjects.Player;
import Main.Game;
import States.Handler;

import java.awt.*;

/**
 * Created by 1817172 on 3/27/2015.
 */

/**
 * Created by Calvin Ta on 3/17/2015.
 */
public class HUD {


    private float GreenValue = 255;
    private Player player;

    private int level;
    private int HEALTH;
    private int Score;
    private Handler handler;
    public HUD(Player player, Handler h)
    {
        this.player = player;
        this.handler = h;
        level = handler.getLevel();
        HEALTH = player.getHEALTH();
        Score = player.getScore();
    }

    public void tick() {


        HEALTH = player.getHEALTH();
        Score = player.getScore();
        level = handler.getLevel();
        HEALTH = (int)Game.clamp(HEALTH, 0, 100);
        GreenValue = Game.clamp(GreenValue, 0, 255);
        GreenValue = HEALTH * 2;


//        if(HEALTH ==0)
//            System.exit(1);


    }





    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, (int) GreenValue, 0));
        g.fillRect(15, 15, (int) HEALTH * 2, 32);

        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + Score, 15, 58);
        g.drawString("Level: " + level, 15, 68);

        if(player.specialTimer <= 0)
        g.drawString("Special Ready ", 15, 78);

        else
            g.drawString("Special Not Ready ", 15, 78);
    }
}
