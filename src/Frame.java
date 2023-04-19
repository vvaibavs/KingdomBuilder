import javax.swing.*;
import java.util.*;
public class Frame extends JFrame{

    public Frame(int width, int height) {
        super("Kingdom Builder");
        setSize(width, height);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel thePanel = new MainPanel();
        add(thePanel);
        setVisible(true);
        gameState theGame = new gameState(thePanel);

    }
}
