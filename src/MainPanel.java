import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;
public class MainPanel extends JPanel {
    private BufferedImage startImage;
    static Graphics graphic;
    public MainPanel() {
        super();
        try {
            startImage = ImageIO.read(MainPanel.class.getResource("/images/Start Screen.png"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        setSize(getWidth(), getHeight());
    }
    public void paint(Graphics g){
        graphic = g;

    }
    public void drawStartScreen() {

    }
}
