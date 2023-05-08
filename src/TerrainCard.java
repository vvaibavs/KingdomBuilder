import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class TerrainCard {
    public String type;
    public BufferedImage pic;

    public TerrainCard() {
        type = "";
        pic = null;
    }

    public void randomize() {
        if(gameState.terrains.size() == 0) {
            gameState.terrains = new ArrayList<>();
            for(int i = 1; i <= 25; i++) {
                gameState.terrains.add(i);
            }
        }
        Collections.shuffle(gameState.terrains);
        if(gameState.terrains.get(0) <= 5) {
            type = "Canyon";
        } else if(gameState.terrains.get(0) <= 10) {
            type = "Desert";
        } else if(gameState.terrains.get(0) <= 15) {
            type = "Flower";
        } else if(gameState.terrains.get(0) <= 20) {
            type = "Forest";
        } else if(gameState.terrains.get(0) <= 25) {
            type = "Grass";
        }
        gameState.terrains.remove(0);

        try {
            pic = ImageIO.read(MainPanel.class.getResource("/images/" + type + ".png"));

        } catch(Exception e) {
            System.out.println(e + "HELLO" + type);
        }
    }

}
