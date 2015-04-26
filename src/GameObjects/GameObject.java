package GameObjects;

import GameLogic.ID;
import States.Handler;

import java.awt.*;

/**
 * Created by 1817172 on 3/27/2015.
 */
public abstract class GameObject {
    //protected only access by objects inheriting GameObject
    protected float x, y;//top corner of drawn object
    protected ID id;
    protected float velX, velY;
    public Handler handler;

    public GameObject(float x, float y, ID id, Handler handler) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();
}
