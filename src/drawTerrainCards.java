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
