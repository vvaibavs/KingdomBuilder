import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;
public class MainPanel extends JPanel {
    private BufferedImage startScreen, endScreen;
    private BufferedImage canyon, desert, flower, forest, meadow;
    static Graphics graphic;
    public MainPanel() {
        super();
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start Screen.png"));
            endScreen = ImageIO.read(MainPanel.class.getResource("/images/End Screen 2.png"));
            canyon = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Canyon.png"));
            desert = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Desert.png"));
            flower = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Flower.png"));
            forest = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Forest.png"));
            meadow = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Meadow.png"));
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
        graphic.drawImage(startScreen, 0, 0, getWidth(), getHeight(), null);
    }
}
