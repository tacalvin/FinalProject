package KeyInputs;


import States.GameStateManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Calvin Ta on 4/27/2015.
 */
public class ScoreInput extends KeyAdapter
{
    private GameStateManager gsm;
    public ScoreInput(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            gsm.setState(gsm.MENUS);
    }
}
