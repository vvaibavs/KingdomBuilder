import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;
public class drawTerrainCards {
    public BufferedImage canyon, desert, flower, forest, meadow;

    public drawTerrainCards() {
        try {
            canyon = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Canyon.png"));
            desert = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Desert.png"));
            flower = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Flower.png"));
            forest = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Forest.png"));
            meadow = ImageIO.read(MainPanel.class.getResource("/images/KB-Card-Meadow.png"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void drawCards(Graphics g, int x, int y, String card) {
        if(card.equals("canyon")) {
            g.drawImage(canyon, x, y, null);
        } else if(card.equals("desert")) {
            g.drawImage(desert, x, y, null);
        } else if(card.equals("flower")) {
            g.drawImage(flower, x, y, null);
        } else if(card.equals("forest")) {
            g.drawImage(forest, x, y, null);
        } else if(card.equals("meadow")) {
            g.drawImage(meadow, x, y, null);
        }
    }

}
