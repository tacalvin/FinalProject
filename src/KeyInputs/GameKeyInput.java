package KeyInputs;

import GameLogic.ID;
import GameObjects.Bullet;
import GameObjects.GameObject;
import GameObjects.Player;
import States.GameStateManager;
import States.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Created by 1817172 on 3/27/2015.
 */
public class GameKeyInput extends KeyAdapter {
    private GameStateManager gsm;
    private Handler handler;
    private boolean[] keyDown = new boolean[5];

    public GameKeyInput(GameStateManager gsm) {
        this.gsm = gsm;
        handler = (Handler) gsm.getGameState();
    }


    //gives access to handler to alter values in gameObjects


    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);

            if (temp.getId() == ID.Player) {

                switch (key) {
                    case KeyEvent.VK_W:
                        keyDown[0] = false;
                        //temp.setVelY(0);
                        break;
                    case KeyEvent.VK_S:
                        keyDown[1] = false;
                        //temp.setVelY(0);
                        break;

                    case KeyEvent.VK_D:
                        keyDown[2] = false;
                        //temp.setVelX(0);
                        break;
                    case KeyEvent.VK_A:
                        keyDown[3] = false;
                        //temp.setVelX(0);
                        break;
                    case KeyEvent.VK_SPACE:
                        keyDown[4] = false;

                        break;


                }
                if (!keyDown[0] && !keyDown[1])
                    temp.setVelY(0);
                if (!keyDown[2] && !keyDown[3])
                    temp.setVelX(0);


            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);

            if (temp.getId() == ID.Player) {




                switch (key) {
                    case KeyEvent.VK_W:
                        temp.setVelY(-5);
                        keyDown[0] = true;
                        break;
                    case KeyEvent.VK_S:
                        temp.setVelY(5);
                        keyDown[1] = true;
                        break;
                    case KeyEvent.VK_D:

                        temp.setVelX(5);
                        keyDown[2] = true;
                        break;
                    case KeyEvent.VK_A:

                        temp.setVelX(-5);
                        keyDown[3] = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        keyDown[4] = true;
                        if(keyDown[4])((Player)temp).shoot();
                        break;


                }


            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();

    }
}
