import javax.swing.*;
import java.util.*;
import java.awt.*;
public class MainPanel extends JPanel {
    static Graphics graphic;
    public MainPanel() {
        super();
        setSize(getWidth(),getHeight());
    }
    public void paint(Graphics g){
        graphic = g;

    }
    public void drawStartScreen() {

    }
}
