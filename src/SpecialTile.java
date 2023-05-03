import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpecialTile {
    String type;
    BufferedImage image;
    boolean isReady;
    public SpecialTile(String type) {
        this.type = type;
        try {
            image = ImageIO.read(Node.class.getResource("/images/" + type + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getType() {
        return type;
    }
    public BufferedImage getImage() {
        return image;
    }
    public boolean isReady() {
        return isReady;
    }
    public void use() {
        isReady = false;
    }
    public void refresh() {
        isReady = true;
    }
}
