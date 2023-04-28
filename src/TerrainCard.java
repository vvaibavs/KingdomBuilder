import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Collections;

public class TerrainCard {
    public String type;
    public BufferedImage pic;

    public TerrainCard() {
        type = "";
        pic = null;
    }

    public void randomize() {
        Collections.shuffle(gameState.terrains);
        if(gameState.terrains.get(0) <= 6) {
            type = "canyon";
        } else if(gameState.terrains.get(0) <= 12) {
            type = "desert";
        } else if(gameState.terrains.get(0) <= 18) {
            type = "flower";
        } else if(gameState.terrains.get(0) <= 24) {
            type = "forest";
        } else if(gameState.terrains.get(0) <= 30) {
            type = "meadow";
        }
        gameState.terrains.remove(0);

        try {
            pic = ImageIO.read(MainPanel.class.getResource("/images/" + type + ".png"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
