package States;

import Main.Game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 */
public class GameOverState extends GameState
{
    private int score;
    private boolean newHighScore;
    public GameOverState(GameStateManager gsm, int score)
    {
        super(gsm);
//        this.score = score;
//        newHighScore = Save.gd.isHighScore(Save.gd.getTentativeScore());
//        if(newHighScore) {
//            Save.gd.addHighScore(
//                    Save.gd.getTentativeScore(),
//                    new String(gsm.getName)
//            );
//            Save.save();
//        }
//        gsm.setState(GameStateManager.MENUS);
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
        return null;
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
