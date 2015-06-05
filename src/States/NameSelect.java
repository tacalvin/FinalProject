package States;

import KeyInputs.NameInput;
import Main.Game;
import UI.BackGround;

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
    private BackGround nameBack;

    public NameSelect(GameStateManager gsm)
    {
        super(gsm);
        name = new char[1];
        nameBack = new BackGround("res/background.jpg",0,0);

    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {



        nameBack.render(g);
        g.setColor(Color.BLACK);

        Font font = new Font("arial", 1, 50);
        g.setFont(font);


        g.drawString("Please Enter Name", (Game.WIDTH / 2)-200, Game.HEIGHT / 2-100);
        String ren = "";
        for(int i =0; i < name.length;i++)
        {
            ren += name[i];
            g.drawString(ren,(Game.WIDTH / 2)-100, (Game.HEIGHT / 2));
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
