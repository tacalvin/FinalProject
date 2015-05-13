package States;

import KeyInputs.ScoreInput;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 */
public class HighScoreState extends GameState {

    private long[] highScores;
    private String[] names;
    public HighScoreState(GameStateManager gsm) {
        super(gsm);
        highScores = Save.gd.getHighScores();
        names = Save.gd.getNames();

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g)
    {

        g.setColor(Color.WHITE);
        Font font = new Font("arial",1,60);
        g.setFont(font);
        //save position
        g.drawString("HighScores", 100, 100);

        String s;



        font = new Font("arial",1,30);
        g.setFont(font);

        for(int i = 0; i < highScores.length; i++)
        {
            s = String.format(
                    "%2d. %7s %s", i+1, highScores[i],names[i]
            );

            g.drawString(s,((Game.WIDTH ) /2)-100, 260 + 20 * i*2);
        }




    }


    public KeyListener getKeyListener() {
        return new ScoreInput(gsm);
    }


    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
