package States;

import KeyInputs.MenuInputs;
import KeyInputs.MenuMouse;
import Main.Game;
import States.Handler;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class MENU extends GameState {
    private Handler handler;
    private int CurrentSelection = 0;

    public MENU(GameStateManager gsm) {
        super(gsm);
    }


    public void incrementSelection() {
        if (CurrentSelection < 2)
            CurrentSelection++;
    }

    public void setCurrentSelection(int x) {
        CurrentSelection = x;
    }

    public void selectState() {
        if (CurrentSelection == 1)
            gsm.setState(gsm.PLAY);
        if(CurrentSelection == 2)
            gsm.setState(gsm.HIGHSCORE);
    }

    public void decreaseSelection() {
        if (CurrentSelection >= 0)
            CurrentSelection--;
    }

    public void render(Graphics g) {
        Font font = new Font("arial", 1, 50);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);


        g.setColor(Color.BLUE);
        //Play
        if (CurrentSelection == 1)
            g.setColor(Color.RED);
        g.fillRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 25, 200, 50);

        //Menu Title
        g.setColor(Color.WHITE);
        g.drawString("Final Project", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 100);

        //draw play text
        g.setColor(Color.WHITE);
        g.drawString("Play", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 15);

        //name
        //Play
        g.setColor(Color.BLUE);
        if (CurrentSelection == 2)
            g.setColor(Color.RED);

        g.fillRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2)+30 , 200, 50);

        //setName
        font = new Font("arial", 1, 36);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("HighScores", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2)+75);
    }

    public void tick() {

    }

    @Override
    public KeyListener getKeyListener() {
        return new MenuInputs(gsm);
    }

    public MouseListener getMouseListener() {
        return new MenuMouse(this);
    }
}
