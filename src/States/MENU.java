package States;

import KeyInputs.MenuInputs;
import KeyInputs.MenuMouse;
import Main.Game;
import UI.BackGround;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class MENU extends GameState {
    private Handler handler;
    private int CurrentSelection = 0;
    private BackGround menuBack;

    public MENU(GameStateManager gsm)
    {
        super(gsm);
        menuBack = new BackGround("res/background.jpg",0,0);
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

        menuBack.render(g);




        g.setColor(Color.BLUE);
        //Play
        if (CurrentSelection == 1)
            g.setColor(Color.RED);
        g.fillRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 25, 200, 50);

        //Menu Title
        g.setColor(Color.BLACK);
        g.drawString("Final Project", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 100);

        //draw play text
        g.setColor(Color.BLACK);
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
        g.setColor(Color.BLACK);
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
