package States;

import KeyInputs.ScoreInput;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 */
public class GameOverState extends GameState
{

    private boolean newHighScore;
    public GameOverState(GameStateManager gsm)
    {
        super(gsm);

        newHighScore = Save.gd.isHighScore(Save.gd.getTentativeScore());
        if(newHighScore) {
            Save.gd.addHighScore(
                    Save.gd.getTentativeScore(),
                    gsm.getName()
            );
            Save.save();
        }
        gsm.setState(GameStateManager.MENUS);
    }




    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.RED);

        Font font = new Font("arial", 1, 50);
        g.setFont(font);

        g.drawString("YOU SUCK", Game.WIDTH / 2, Game.HEIGHT / 2);



    }


    @Override
    public KeyListener getKeyListener() {
        return new ScoreInput(gsm);
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
