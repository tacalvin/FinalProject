package Frameworks;

import java.awt.image.BufferedImage;

/**
 * Created by Calvin Ta on 4/30/2015.
 */
public class Animate
{
    private BufferedImage[] ims;

    public Animate(BufferedImage[] images)
    {
        ims = images;
    }

    public BufferedImage getFrame(int frame)
    {
        return ims[frame];
    }

    public BufferedImage moveLeft()
    {
        return ims[0];
    }

    public BufferedImage straight()
    {
        return ims[1];
    }

    public BufferedImage moveRight()
    {
        return ims[2];
    }
}
