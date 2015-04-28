package States;

import GameLogic.ID;
import GameLogic.Spawn;
import GameObjects.BasicEnemy;
import GameObjects.GameObject;
import GameObjects.Player;
import KeyInputs.GameKeyInput;
import Main.Game;
import UI.HUD;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class Handler extends GameState {


    //class is going to loop through game objects to update and render

    public ArrayList<GameObject> object = new ArrayList<GameObject>();
    private Spawn ofSatan;
    private HUD hud;
    private Save save;


    public Handler(GameStateManager game,Save save) {
        super(game);
        this.save = save;
        ofSatan = new Spawn(this);
        Player player = new Player(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Player, this);

        hud = new HUD(player);
        object.add(player);


    }


    public void tick() {

        for (int i = 0; i < object.size(); i++) {
            GameObject tempO = object.get(i);
            tempO.tick();
            if(tempO.getId() == ID.Player)
            {

                if(((Player)tempO).getHEALTH() <= 0)
                {

                    save.gd.setTenativeScore(((Player) tempO).getScore());
                    this.gameOver();
                }
            }

        }
        hud.tick();
        ofSatan.tick();


    }

    public void render(Graphics g) {


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for (int i = 0; i < object.size(); i++) {
            GameObject tempO = object.get(i);
            tempO.render(g);

        }
        hud.render(g);


    }
    public void gameOver()
    {
        gsm.setState(gsm.GMOVER);
    }

    public void addPoint(int point)
    {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject temp = this.object.get(i);
            if (temp.getId() == ID.Player) {
                ((Player)temp).setScore(point);

            }
        }

    }


    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    @Override
    public KeyAdapter getKeyListener() {
        return new GameKeyInput(gsm);
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
