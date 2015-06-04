package GameObjects;


import Frameworks.Animate;
import GameLogic.ID;
import Main.Game;
import ShootPattern.BasicShot;
import ShootPattern.Spread;
import ShootPattern.TriShot;
import Specials.Burst;
import States.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;


public class Player extends GameObject {
    private BufferedImage[] im;
    private BufferedImage sheet;

    private int HEALTH = 100;
    private int currentFrame =0;
    private int Score = 0;

    private int currentSpecial;
    private int currentPower;
    public  float shotTimer;
    public  float specialTimer;
    private Animate[] an;
    private int speed;
    private int moving;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id,handler);
        currentPower =1;
        currentSpecial =1;
        shotTimer =0;
        specialTimer =0;
        im = new BufferedImage[3];
        an = new Animate[3];

        try {
            // only way files ever seem to load so use url which starts in src than specify res and specific files if needed
            URL url = this.getClass().getClassLoader().getResource("res/PlayerPowers.png");
            sheet = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println(e);
        }
        int xCount = 0;
        int yCount = 0;
        speed = 10;
        moving = 0;
        for (int i = 0; i < 3; i++)
        {
            xCount = 0;
            for(int z = 0; z < 3; z++)
            {
                im[z] = sheet.getSubimage(xCount, yCount, 80, 80);
                xCount += 80;//resize image
            }
            an[i] = new Animate(im);
            yCount += 80;
        }

    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    public void move(int e)
    {
        if(e == KeyEvent.VK_W)
            y -= speed;

        if(e == KeyEvent.VK_S)
            y += speed;

        if(e == KeyEvent.VK_A)
            x -= speed;

        if(e == KeyEvent.VK_D)
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
            if (temp.getId() == ID.BasicEnemy || temp.getId() == ID.EnemyBullet) {
                //checks for collisions of player and enemies
                if (getBounds().intersects(temp.getBounds()) && temp.getId() == ID.BasicEnemy) {

                   HEALTH -= 2;

                }

                else if (getBounds().intersects(temp.getBounds()) && temp.getId() == ID.EnemyBullet) {

                    HEALTH -= 1;
                    handler.removeObject(temp);

                }
            }
        }
    }



    public void shoot()
    {
        handler.getMp().playSound("shot");
        this.loadShootPattern(currentPower);

    }
    public void useSpecial()
    {
        this.loadSpecial(currentSpecial);
    }
    private void loadSpecial(int cSpecial)
    {
        switch (cSpecial)
        {
            case 1:
                if(this.specialTimer <0) {
                    Burst.shoot(handler,this);
                    specialTimer = 10f;
                }

        }
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
            case 3:
                if(this.shotTimer <0) {
                    TriShot.shoot(handler, this);
                    shotTimer = .1f;
                }
                break;

        }
    }

    @Override
    public void tick() {
        shotTimer -=.01f;
        specialTimer -= .01f;





        x = Game.clamp((int) x, 0, Game.WIDTH - 37);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 60);

        collision();
    }




    @Override
    public void render(Graphics g) {


        if(moving == KeyEvent.VK_A)
            g.drawImage(an[currentPower - 1].moveLeft(), (int) x, (int) y, null);
        else if(moving == KeyEvent.VK_D)
            g.drawImage(an[currentPower - 1].moveRight(), (int) x, (int) y, null);
        else
            g.drawImage(an[currentPower - 1].straight(), (int) x, (int) y, null);




    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int) x, (int) y, im[0].getWidth(), im[0].getHeight());
    }






}
