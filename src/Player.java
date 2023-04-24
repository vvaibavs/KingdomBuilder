
import java.util.ArrayList;
public class Player {
    private String color;
    private int numSettlements;
    private ArrayList<LocTile> tile;
    private int score;
    boolean turn;
    public Player(String c){
        color = c;
        numSettlements = 40;
        score = 0;
        tile = new ArrayList<LocTile>();
        turn = false;
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
}