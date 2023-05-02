
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
public class Player {
    private String color;
    private int numSettlements;
    private ArrayList<LocTile> tile;
    private int score;
    boolean turn;
    private ArrayList<String> specialTokens;
    public ArrayList<BufferedImage> specialTokenImages;
    public TerrainCard card;
    public Player(String c){
        color = c;
        numSettlements = 40;
        score = 0;
        tile = new ArrayList<LocTile>();
        turn = false;
        card = new TerrainCard();
        specialTokens = new ArrayList<>();
        specialTokenImages = new ArrayList<>();

    }

    public void next() {
      turn = !turn;
    }

    public void byeSettlements(int x) {
        numSettlements = numSettlements - x;
    }

    public int getSettlements(){
        return numSettlements;
    }

    public String getColor(){
        return color;
    }

    public int getScore(){
        return score;
    }
    public void addSpecialToken(String tokenToAdd) {
        specialTokens.add(tokenToAdd);
        try {
            specialTokenImages.add(ImageIO.read(Node.class.getResource("/images/" + tokenToAdd + ".png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeSpecialToken(String tokenToRemove) {
        specialTokenImages.remove(specialTokens.remove(tokenToRemove));
    }

    public ArrayList<String> getSpecialTokens() {
        return specialTokens;
    }
}