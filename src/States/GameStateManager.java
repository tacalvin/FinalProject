package States;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Calvin Ta on 3/27/2015.
 *
 */
public class GameStateManager {
    public boolean changedState;
    public GameState gameState;
    public static final int MENUS = 0;
    public static final int PLAY = 1;
    public static final int HIGHSCORE = 2;
    public static final int GMOVER = 3;//game over

    public Save save;
    private boolean nameSelected;
    private String Name;


    public GameStateManager() {
        setState(MENUS);
        save = new Save();
        save.load();
        nameSelected = false;
        changedState = false;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNameSelected(boolean nameSelected) {
        this.nameSelected = nameSelected;
    }

    public void setState(int state) {

        if (state == MENUS) {
            gameState = new MENU(this);
            //switch to menu state
            //TODO: change states
            changedState = true;
        }

        if (state == PLAY) {
            gameState = new NameSelect(this);
            changedState = true;
            if(nameSelected) {
                gameState = new Handler(this,save);

                //switch to play state
                //TODO: Change states
                changedState = true;
            }
        }
        if (state == HIGHSCORE) {
            gameState = new HighScoreState(this);
            changedState = true;
        }
        if (state == GMOVER) {
            gameState = new GameOverState(this);
            changedState = true;
        }



    }

    public String getName()
    {
        return Name;
    }



        public GameState getGameState() {
        return gameState;
    }

    public void tick() {
        gameState.tick();
    }

    public void render(Graphics g) {
        gameState.render(g);
    }


    public MouseListener getMouseinputListener() {
        return gameState.getMouseListener();
    }

}
