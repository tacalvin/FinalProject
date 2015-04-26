package KeyInputs;

import Main.Game;
import States.GameStateManager;
import States.MENU;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class MenuInputs extends KeyAdapter {

    private GameStateManager gsm;
    private MENU menu;

    public MenuInputs(GameStateManager gsm) {
        this.gsm = gsm;
        menu = (MENU) gsm.getGameState();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                menu.decreaseSelection();
                break;
            case KeyEvent.VK_DOWN:
                menu.incrementSelection();
                break;
            case KeyEvent.VK_ENTER:
                menu.selectState();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
