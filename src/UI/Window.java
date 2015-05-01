package UI;

import Main.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 1817172 on 3/27/2015.
 */
public class Window extends Canvas {


    private static final long serialVersionUID = 3907742937199667657L;

    public Window(int width, int height, String title, Game game) {

        JFrame frame = new JFrame(title);
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        //tells it to actually stop thread on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //sets frame in the middle of screen
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
