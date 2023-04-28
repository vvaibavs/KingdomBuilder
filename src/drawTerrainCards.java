import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
public class drawTerrainCards {
    public BufferedImage canyon, desert, flower, forest, meadow;

    public drawTerrainCards() {
        try {
            canyon = ImageIO.read(MainPanel.class.getResource("/images/canyon.png"));
            desert = ImageIO.read(MainPanel.class.getResource("/images/desert.png"));
            flower = ImageIO.read(MainPanel.class.getResource("/images/flower.png"));
            forest = ImageIO.read(MainPanel.class.getResource("/images/forest.png"));
            meadow = ImageIO.read(MainPanel.class.getResource("/images/meadow.png"));
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
