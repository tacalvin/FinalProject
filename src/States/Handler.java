package States;

import GameLogic.ID;
import GameLogic.Spawn;
import GameObjects.GameObject;
import GameObjects.Player;

import KeyInputs.Keyboard;
import Main.Game;
import UI.HUD;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private int level;
    private Player player;
    private float time;


    public Handler(GameStateManager game,Save save) {
        super(game);
        this.save = save;
        ofSatan = new Spawn(this);
        level = 1;
        time =0;
        player = new Player(Game.WIDTH / 2, Game.HEIGHT / 2, ID.Player, this);

        hud = new HUD(player,this);
        object.add(player);



    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public Player getPlayer() {
        return player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void input()
    {


        if(Keyboard.isKeyDown(KeyEvent.VK_SPACE))
            getPlayer().shoot();

        //takes a keyevent and moves based on keycode
        if(Keyboard.isKeyDown(KeyEvent.VK_W))
        getPlayer().move(KeyEvent.VK_W);
        if(Keyboard.isKeyDown(KeyEvent.VK_A))
            getPlayer().move(KeyEvent.VK_A);
        if(Keyboard.isKeyDown(KeyEvent.VK_S))
            getPlayer().move(KeyEvent.VK_S);
        if(Keyboard.isKeyDown(KeyEvent.VK_D))
            getPlayer().move(KeyEvent.VK_D);








    }

    public void tick() {
        time+= .1f;
        input();
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

    public int getLevel()
    {
     return level;
    }


    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    @Override
    public KeyAdapter getKeyListener() {
        return new GameKeyInput();
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }

    private class GameKeyInput extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent e) {
            Keyboard.setState(e.getKeyCode(),true);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            Keyboard.setState(e.getKeyCode(), true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            Keyboard.setState(e.getKeyCode(),false);
        }
    }
}
