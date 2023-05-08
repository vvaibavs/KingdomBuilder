
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

    public int c1Score, c2Score, c3Score, castleScore;
    private ArrayList<SpecialTile> specialTokens;
    public TerrainCard card;
    public Player(String c){
        color = c;
        numSettlements = 40;
        score = 0;
        tile = new ArrayList<LocTile>();
        turn = false;
        card = new TerrainCard();
        specialTokens = new ArrayList<>();
        c1Score = 0;
        c2Score = 0;
        c3Score = 0;
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

    public void setScore(int x) {
        score = x;
    }

    public void addScore(int x) {
        score += x;
    }
    public void addSpecialToken(String tokenToAdd) {
        specialTokens.add(new SpecialTile(tokenToAdd));
    }
    public void removeSpecialToken(String type) {
        for (int i = 0; i < specialTokens.size(); i ++) {
            if (specialTokens.get(i).getType().equals(type)) {
                specialTokens.remove(i);
                break;
            }
        }
    }
    public void refreshTiles() {
        for (SpecialTile i: specialTokens) {
            i.refresh();
        }
    }

    public ArrayList<SpecialTile> getSpecialTokens() {
        return specialTokens;
    }

    public void scoringVariable(int i, int score) {
        if(i == 0) {
            c1Score += score;
        } else if(i == 1) {
            c2Score += score;
        } else if(i == 2) {
            c3Score += score;
        } else if(i == 3) {

        }
    }
}