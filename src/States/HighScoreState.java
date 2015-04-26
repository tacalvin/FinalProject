package States;

import Main.Game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 */
public class HighScoreState extends GameState {


    public HighScoreState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.WHITE);
        Font font = new Font("arial",1,60);
        g.setFont(font);
        //save position
        g.drawString("Nothing Works Here Yet",100,100);
    }


    public KeyListener getKeyListener() {
        return null;
    }


    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
