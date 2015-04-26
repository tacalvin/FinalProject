package KeyInputs;

import States.NameSelect;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by 1817172 on 4/15/2015.
 */
public class NameInput extends KeyAdapter {
    private ArrayList<Character> name = new ArrayList<Character>();
    private NameSelect ns;

    public NameInput(NameSelect ns) {
        this.ns = ns;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {


    }



    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            ns.createName();
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            name.remove(name.size()-1);
        else if ( e.getKeyCode() != KeyEvent.VK_SHIFT)
        name.add(e.getKeyChar());

        ns.renderName(name);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }
}
