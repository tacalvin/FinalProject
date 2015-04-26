package GameObjects;


import GameLogic.ID;

import Main.Game;
import ShootPattern.BasicShot;
import ShootPattern.Spread;
import States.Handler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.net.URL;

/**
 * Created by Calvin Ta on 3/28/2015.
 */
public class Player extends GameObject {
    private BufferedImage im;

    private int HEALTH = 100;

    private int Score = 0;
    private int currentPower;
    public  float shotTimer;


    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id,handler);
        currentPower =2;
        shotTimer =0;

        try {
            // only way files ever seem to load so use url which starts in src than specify res and specific files if needed
            URL url = this.getClass().getClassLoader().getResource("res/player.png");
            im = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public int getHEALTH()
    {
        return HEALTH;
    }

    public int getScore()
    {
        return Score;
    }

    public void setScore(int score)
    {
        Score += score;
    }

    public BufferedImage getIm() {
        return im;
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.BasicEnemy) {
                //checks for collisions of player and enemies
                if (getBounds().intersects(temp.getBounds())) {
                    if(HEALTH ==0)
                    {

                        handler.gameOver(this.getScore());


                    }
                   HEALTH -= 2;

                }
            }
        }
    }



    public void shoot()
    {
        this.loadShootPattern(currentPower);
    }

    private void loadShootPattern(int currentPower)
    {
        switch (currentPower)
        {
            case 1:
                if(this.shotTimer <0) {
                    BasicShot.shoot(handler, this);
                    shotTimer = .01f;
                }
                break;
            case 2:
                if(this.shotTimer <0) {
                    Spread.shoot(handler, this);
                    shotTimer = .1f;
                }
                break;
        }
    }

    @Override
    public void tick() {
        shotTimer -=.01f;

        x += velX;
        y += velY;
        x = Game.clamp((int) x, 0, Game.WIDTH - 37);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 60);

        collision();
    }

    @Override
    public void render(Graphics g) {


        //g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(im, (int) x, (int) y, null);


    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, im.getWidth(), im.getHeight());
    }




}
