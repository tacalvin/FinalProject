package States;

import KeyInputs.ScoreInput;
import Main.Game;
import UI.BackGround;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 */
public class HighScoreState extends GameState {

    private long[] highScores;
    private String[] names;
    private BackGround bk;
    public HighScoreState(GameStateManager gsm) {
        super(gsm);
        highScores = Save.gd.getHighScores();
        names = Save.gd.getNames();
      bk = new BackGround("res/background.jpg",0,0);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g)
    {

        bk.render(g);
        g.setColor(Color.BLACK);
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

            g.drawString(s,((Game.WIDTH ) /2)-100, 200 + 20 * i*2);
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
