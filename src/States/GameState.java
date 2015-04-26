package States;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 */
public abstract class GameState {

    protected GameStateManager gsm;

    protected GameState(GameStateManager gsm) {
        this.gsm = gsm;

    }


    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract KeyListener getKeyListener();

    public abstract MouseListener getMouseListener();

}
