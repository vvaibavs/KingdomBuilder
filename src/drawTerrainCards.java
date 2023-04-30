import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
public class drawTerrainCards {
    public BufferedImage canyon, desert, flower, forest, meadow;

    public drawTerrainCards() {
        try {
            canyon = ImageIO.read(MainPanel.class.getResource("/images/Canyon.png"));
            desert = ImageIO.read(MainPanel.class.getResource("/images/Desert.png"));
            flower = ImageIO.read(MainPanel.class.getResource("/images/Flower.png"));
            forest = ImageIO.read(MainPanel.class.getResource("/images/Forest.png"));
            meadow = ImageIO.read(MainPanel.class.getResource("/images/Grass.png"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void drawCards(Graphics g, int x, int y, String card) {
        if(card.equals("Canyon")) {
            g.drawImage(canyon, x, y, null);
        } else if(card.equals("Desert")) {
            g.drawImage(desert, x, y, null);
        } else if(card.equals("Flower")) {
            g.drawImage(flower, x, y, null);
        } else if(card.equals("Forest")) {
            g.drawImage(forest, x, y, null);
        } else if(card.equals("Grass")) {
            g.drawImage(meadow, x, y, null);
        }
    }

}
