import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;
public class ScoringCardsPanel {
    private BufferedImage startScreen;
    public ScoringCardsPanel() {
        super();
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start Screen.png"));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }
    public void paint(Graphics g){


    }
}
