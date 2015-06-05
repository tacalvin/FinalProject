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
public class GameOverState extends GameState
{

    private boolean newHighScore;
    private BackGround bk;
    public GameOverState(GameStateManager gsm)
    {
        super(gsm);
        bk = new BackGround("res/background2.png",0,0);

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

        g.setColor(Color.RED);

        Font font = new Font("arial", 1, 50);
        g.setFont(font);

        bk.render(g);
        g.drawString("Game Over", Game.WIDTH / 2, Game.HEIGHT / 2);



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
