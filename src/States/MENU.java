package States;

import KeyInputs.Keyboard;

import KeyInputs.MenuMouse;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class MENU extends GameState {
    private Handler handler;
    private int selected = 1;
    private boolean up = false;
    private boolean down = false;

    public MENU(GameStateManager gsm) {
        super(gsm);
    }






    public void selectState() {
        if (selected == 1) gsm.setState(gsm.PLAY);
        if (selected == 2) gsm.setState(gsm.HIGHSCORE);
    }

    public void selectState(int select) {
        if (select == 1) gsm.setState(gsm.PLAY);
        if (select == 2) gsm.setState(gsm.HIGHSCORE);
    }



    public void render(Graphics g) {
        Font font = new Font("arial", 1, 50);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);


        g.setColor(Color.GRAY);
        //Play
        if (selected == 1) g.setColor(Color.RED);
        g.fillRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 25, 200, 50);

        //Menu Title
        g.setColor(Color.WHITE);
        g.drawString("Final Project", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 100);

        //draw play text
        g.setColor(Color.WHITE);
        g.drawString("Play", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 15);

        //name
        //Play
        g.setColor(Color.GRAY);
        if (selected == 2) g.setColor(Color.RED);

        g.fillRect((Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 30, 200, 50);

        //setName
        font = new Font("arial", 1, 36);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("HighScores", (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 75);
    }

    public void tick() {
        keyInput();

    }


    private void keyInput() {

        if (Keyboard.isKeyDown(KeyEvent.VK_DOWN)) {
            if (!up) {
                up = true;
                if (selected + 1 > 2) {
                    selected = 2;
                } else {
                    selected++;
                }
            }
        } else {
            up = false;
        }

        if (Keyboard.isKeyDown(KeyEvent.VK_UP)) {
            if (!down) {
                down = true;
                if (selected - 1 < 0) {
                    selected = 1;
                } else {
                    selected--;
                }
            }
        } else {
            down = false;
        }



        if (Keyboard.isKeyDown(KeyEvent.VK_ENTER)) selectState();

    }

    @Override


    public MouseListener getMouseListener() {
        return new MenuMouse(this);
    }
}
