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
            startImage = ImageIO.read(MainPanel.class.getResource("/images/Start Screen.png"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        setSize(getWidth(), getHeight());

    }
    public void setMode(String type) {
        state = type;
    }
    public void paint(Graphics g){
        g.drawRect(10, 10, 10, 10);
        if (state.equals("Start Screen")) {
            g.drawImage(startImage, 0, 0, getWidth(), getHeight(), null);
        }

    }
    public void startPaint() {
        repaint();
    }

}
