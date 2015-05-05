package GameObjects;


import Frameworks.Animate;
import GameLogic.ID;

import Main.Game;
import ShootPattern.BasicShot;
import ShootPattern.Spread;
import States.Handler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * Created by Calvin Ta on 3/28/2015.
 */
public class Player extends GameObject {
    private BufferedImage[] im;
    private BufferedImage sheet;

    private int HEALTH = 100;
    private int currentFrame =0;
    private int Score = 0;
    private int currentPower;
    public  float shotTimer;
    private Animate an;
    private int speed;


    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id,handler);
        currentPower =2;
        shotTimer =0;
        im = new BufferedImage[2];


        try {
            // only way files ever seem to load so use url which starts in src than specify res and specific files if needed
            URL url = this.getClass().getClassLoader().getResource("res/player.png");
            sheet = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println(e);
        }

        speed = 10;

        im[0] = sheet.getSubimage(0,0,32,32);
        im[1] = sheet.getSubimage(32,0,32,32);
        an = new Animate(im);


    }

    public void move(int e)
    {
        if(e == KeyEvent.VK_W)
            y -= speed;

        if(e == KeyEvent.VK_S)
            y += speed;

        if(e == KeyEvent.VK_A)
            x -= speed;

        if(e == KeyEvent.VK_W)
            x += speed;




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



    public BufferedImage[] getIm() {
        return im;
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.getId() == ID.BasicEnemy) {
                //checks for collisions of player and enemies
                if (getBounds().intersects(temp.getBounds())) {

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




        x = Game.clamp((int) x, 0, Game.WIDTH - 37);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 60);

        collision();
    }




    @Override
    public void render(Graphics g) {


        //g.setColor(Color.BLACK);

        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(an.getFrame(currentFrame), (int) x, (int) y, null);
        if(currentFrame ==0)
        currentFrame++;
        else
            currentFrame--;




    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, im[0].getWidth(), im[0].getHeight());
    }






}
