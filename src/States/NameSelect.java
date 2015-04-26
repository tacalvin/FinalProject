package States;

import KeyInputs.NameInput;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by 1817172 on 4/15/2015.
 */
public class NameSelect extends GameState
{
    private char[] name;

    public NameSelect(GameStateManager gsm)
    {
        super(gsm);
        name = new char[1];

    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.WHITE);

        Font font = new Font("arial", 1, 50);
        g.setFont(font);


        g.drawString("Please Enter Name", (Game.WIDTH / 2)-100, Game.HEIGHT / 2);
        String ren = "";
        for(int i =0; i < name.length;i++)
        {
            ren += name[i];
            g.drawString(ren,Game.WIDTH / 2, (Game.HEIGHT / 2)+100);
        }




    }

    public void renderName(ArrayList<Character> nameChar)
    {
        name = new char[nameChar.size()];
        for(int i =0; i < name.length; i++)
        {
            name[i] = nameChar.get(i);
        }
    }

    public void createName()
    {

        gsm.setName(new String(name));
        gsm.setNameSelected(true);
        gsm.setState(gsm.PLAY);


    }


    @Override
    public KeyListener getKeyListener() {
        return new NameInput(this);
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
