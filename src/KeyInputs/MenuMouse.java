package KeyInputs;

import Main.Game;
import States.MENU;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Calvin Ta on 3/28/2015.
 */
public class MenuMouse extends MouseAdapter {
    private MENU menu;

    public MenuMouse(MENU menu) {
        this.menu = menu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx, my, (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) - 25, 200, 50)) {
            menu.setCurrentSelection(1);
            menu.selectState();
        }

        if (mouseOver(mx, my, (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2)+30 , 200, 50)) {
            menu.setCurrentSelection(2);
            menu.selectState();
        }


    }


    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height)
                return true;
            else return false;
        } else return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
}
