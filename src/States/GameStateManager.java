package States;

import Frameworks.Audio;
import Frameworks.MusicPlayer;

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
    private MusicPlayer mp;


    public GameStateManager() {
        setState(MENUS);

        //load sounds here
        mp = new MusicPlayer();
        mp.addSound("shot", new Audio("res/laser.wav"));


        save = new Save();
        save.load();
        nameSelected = false;
        changedState = false;
    }

    public MusicPlayer getMp()
    {
        return mp;
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

            changedState = true;
        }

        if (state == PLAY) {
            gameState = new NameSelect(this);
            changedState = true;
            if(nameSelected) {
                gameState = new Handler(this,save);

                //switch to play state

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

    public KeyListener getKeyinputListener() {
        return gameState.getKeyListener();
    }

    public MouseListener getMouseinputListener() {
        return gameState.getMouseListener();
    }

}
