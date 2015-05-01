package States;

import KeyInputs.Keyboard;
import KeyInputs.NameInput;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by 1817172 on 4/15/2015.
 */
public class NameSelect extends GameState
{
    private char[] nameA;
    private ArrayList<Character> name = new ArrayList<Character>();

    public NameSelect(GameStateManager gsm)
    {
        super(gsm);


    }


    private void keyInput()
    {


    }

    @Override
    public void tick()
    {
        keyInput();
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
        for(int i =0; i < nameA.length;i++)
        {
            ren += nameA[i];
            g.drawString(ren,Game.WIDTH / 2, (Game.HEIGHT / 2)+100);
        }




    }

    public void renderName(ArrayList<Character> nameChar)
    {
        nameA = new char[nameChar.size()];
        for(int i =0; i < nameA.length; i++)
        {
            nameA[i] = nameChar.get(i);
        }
    }

    public void createName()
    {

        gsm.setName(new String(nameA));
        gsm.setNameSelected(true);
        gsm.setState(gsm.PLAY);


    }




    @Override
    public MouseListener getMouseListener() {
        return null;
    }
}
