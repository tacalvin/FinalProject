package Main;

import States.GameStateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class Game extends Canvas implements Runnable {


    private static final long serialVersionUID = 1871907509462243103L;
    private Graphics g;
    private boolean running;


    public static int WIDTH;
    public static int HEIGHT;
    private Thread thread;
    private GameStateManager gsm;



    public Game(int WIDTH) {
        this.WIDTH = WIDTH;
        HEIGHT = WIDTH / 12 * 9;
        gsm = new GameStateManager();




        this.addKeyListener(gsm.getKeyinputListener());
        if (gsm.getMouseinputListener() != null) {
            this.addMouseListener(gsm.getMouseinputListener());
        }

//        handler = new Handler();
//        hud = new HUD();

        new UI.Window(WIDTH, HEIGHT, "Game Is Running", this);


    }


    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            //kills thread
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {

        gsm.tick();
        if (gsm.changedState) {
            this.removeKeyListener(this.getKeyListeners()[0]);
            this.addKeyListener(gsm.getKeyinputListener());

            gsm.changedState = false;
        }
//        handler.tick();
//        hud.tick();
        // backGround.tick();
    }

    public void render() {
        //starts off as null
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            //creates three buffers
            this.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        gsm.render(g);




        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        this.requestFocus();
        //no need to click on screen for control to take effect
        //game loop

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    public static float clamp(float var, float min, float max) {
        //used for collision with edges
        //i.e if x is greater than max or min than var is max or min
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        return var;
    }


    public static void main(String[] args) {
        new Game(800);
    }


}
