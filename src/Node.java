import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Node{
    private String terrain;
    private Boolean hasSettlement = false;
    private String settlementColor = null;
    private int board;
    private int x;
    private int y;
    private int specialTokensLeft = 0;
    private boolean special = false;
    private HashMap<String, Node> neighbors = new HashMap<String, Node>();
    private final int radius = 20;
    BufferedImage hexHighLight, red, blue, black, orange;
    public Node(String terrain, int board, int xloc, int yloc) {
        this.terrain = terrain;
        if (terrain.equals("tower") || terrain.equals("oracle") || terrain.equals("paddock") || terrain.equals("farm") || terrain.equals("tavern") || terrain.equals("barn") || terrain.equals("boat") || terrain.equals("oasis")) {
            special = true;
            specialTokensLeft = 2;
        }
        this.board = board;
        x = xloc;
        y = yloc;
        try {
            hexHighLight = ImageIO.read(Node.class.getResource("/images/HexHighlight.png"));
            blue = ImageIO.read(Node.class.getResource("/images/Blue.png"));
            black = ImageIO.read(Node.class.getResource("/images/Black.png"));
            orange = ImageIO.read(Node.class.getResource("/images/Orange.png"));
            red = ImageIO.read(Node.class.getResource("/images/Red.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isSpecial() {
        return special && specialTokensLeft > 0;
    }
    public void addNeighbor(String direction, Node neighbor) {
        neighbors.put(direction, neighbor);
        if (direction.equals("West")) {
            neighbor.addNeighbor("East", this, false);
        }
        else if (direction.equals("NorthWest")) {
            neighbor.addNeighbor("SouthEast", this, false);
        }
        else if (direction.equals("NorthEast")) {
            neighbor.addNeighbor("SouthWest", this, false);
        }
        else if (direction.equals("East")) {
            neighbor.addNeighbor("West", this, false);
        }
        else if (direction.equals("SouthWest")) {
            neighbor.addNeighbor("NorthEast", this, false);
        }
        else if (direction.equals("SouthEast")) {
            neighbor.addNeighbor("NorthWest", this, false);
        }
    }
    public void addNeighbor(String direction, Node neighbor, boolean cont){
        neighbors.put(direction, neighbor);
        if (cont) {
            if (direction.equals("West")) {
                neighbor.addNeighbor("East", this, false);
            }
            else if (direction.equals("NorthWest")) {
                neighbor.addNeighbor("SouthEast", this, false);
            }
            else if (direction.equals("NorthEast")) {
                neighbor.addNeighbor("SouthWest", this, false);
            }
            else if (direction.equals("East")) {
                neighbor.addNeighbor("West", this, false);
            }
            else if (direction.equals("SouthWest")) {
                neighbor.addNeighbor("NorthEast", this, false);
            }
            else if (direction.equals("SouthEast")) {
                neighbor.addNeighbor("NorthWest", this, false);
            }
        }
    }
    public String getTerrain() {
        return terrain;
    }
    public Node getNeighbor(String direction) {
        return neighbors.get(direction);
    }
    public boolean hasSettlement() {
        return hasSettlement;
    }
    public void putSettlement(String color) {
        hasSettlement = true;
        settlementColor = color;
    }
    public String getSettlementColor() {
        return settlementColor;
    }
    public int getSettlementsInBoard(String color, int boardNum) {
        int temp = 0;
        if (color.equals(settlementColor) && board == boardNum) {
            temp += 1;
        }
        if (neighbors.get("South") != null) {
            temp += neighbors.get("South").getSettlementsInBoard(color, boardNum);
        }
        return temp + this.getSettlementsInLine(color, boardNum);

    }
    public int getSettlementsInLine(String color, String direction) {
        int temp = 0;
        if (settlementColor.equals(color)) {
            temp += 1;
        }
        if (neighbors.get(direction) != null) {
            return temp + neighbors.get(direction).getSettlementsInLine(color, direction);
        }
        return temp;
    }
    public int getSettlementsInLine(String color, int boardNum) {
        int temp = 0;
        if (settlementColor.equals(color) && board == boardNum) {
            temp += 1;
        }
        if (neighbors.get("East") != null) {
            return temp + neighbors.get("East").getSettlementsInLine(color, boardNum);
        }
        return temp;
    }
    public boolean containsClick(int xloc, int yloc) {
        if (Math.pow(xloc - x - 20, 2) + Math.pow(yloc - y + 10, 2) < Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }
    public void drawHighlight(Graphics g) {
        g.drawImage(hexHighLight, x - 1, y - 31, 41, 41, null );
    }
    public String getLoc() {
        return board + "";
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isValid(String color, String terrain, boolean nextToSettlementMatters, String specialToken) {

        if ( ( this.terrain.equals("Mountain") || this.terrain.equals("Water")) && ! specialToken.equals("Boat")) {
            return false;
        }
        if (specialToken.equals("tower") && neighbors.size() == 6) {
            return false;
        }
        if (specialToken.equals("farm") && ! this.terrain.equals("Grass")) {
            return false;
        }
        if (specialToken.equals("oasis") && ! this.terrain.equals("Desert")) {
            return false;
        }
        
        if (hasSettlement) {
            return false;
        }
        if (! this.terrain.equals(terrain) && ! specialToken.equals("tower") && !specialToken.equals("farm") && ! specialToken.equals("oasis")) {
            return false;
        }
        if (nextToSettlementMatters) {
            if (! hasColorNeighbor(color)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasColorNeighbor(String inputColor) {
        if (getNeighbor("West") != null && getNeighbor("West").hasSettlement() && getNeighbor("West").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("East") != null && getNeighbor("East").hasSettlement() && getNeighbor("East").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("NorthWest") != null && getNeighbor("NorthWest").hasSettlement() && getNeighbor("NorthWest").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("NorthEast") != null && getNeighbor("NorthEast").hasSettlement() && getNeighbor("NorthEast").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("SouthWest") != null && getNeighbor("SouthWest").hasSettlement() && getNeighbor("SouthWest").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("SouthEast") != null && getNeighbor("SouthEast").hasSettlement() && getNeighbor("SouthEast").getSettlementColor().equals(inputColor)) {
            return true;
        }
        return false;
    }
    public void removeToken() {
        specialTokensLeft -= 1;
    }
    public String hasSpecialNeighbor() {
        if (getNeighbor("West") != null && getNeighbor("West").isSpecial() ) {

            return getNeighbor("West").getTerrain();
        }
        if (getNeighbor("East") != null && getNeighbor("East").isSpecial()) {

            return getNeighbor("East").getTerrain();
        }
        if (getNeighbor("NorthWest") != null && getNeighbor("NorthWest").isSpecial()) {

            return getNeighbor("NorthWest").getTerrain();
        }
        if (getNeighbor("NorthEast") != null && getNeighbor("NorthEast").isSpecial()) {

            return getNeighbor("NorthEast").getTerrain();
        }
        if (getNeighbor("SouthWest") != null && getNeighbor("SouthWest").isSpecial()) {

            return getNeighbor("SouthWest").getTerrain();
        }
        if (getNeighbor("SouthEast") != null && getNeighbor("SouthEast").isSpecial()) {

            return getNeighbor("SouthEast").getTerrain();
        }
        return "None";
    }
    public String removeTokenFromSpecialNeighbor() {
        if (getNeighbor("West") != null && getNeighbor("West").isSpecial() ) {
            getNeighbor("West").removeToken();
            return getNeighbor("West").getTerrain();
        }
        if (getNeighbor("East") != null && getNeighbor("East").isSpecial()) {
            getNeighbor("East").removeToken();
            return getNeighbor("East").getTerrain();
        }
        if (getNeighbor("NorthWest") != null && getNeighbor("NorthWest").isSpecial()) {
            getNeighbor("NorthWest").removeToken();
            return getNeighbor("NorthWest").getTerrain();
        }
        if (getNeighbor("NorthEast") != null && getNeighbor("NorthEast").isSpecial()) {
            getNeighbor("NorthEast").removeToken();
            return getNeighbor("NorthEast").getTerrain();
        }
        if (getNeighbor("SouthWest") != null && getNeighbor("SouthWest").isSpecial()) {
            getNeighbor("SouthWest").removeToken();
            return getNeighbor("SouthWest").getTerrain();
        }
        if (getNeighbor("SouthEast") != null && getNeighbor("SouthEast").isSpecial()) {
            getNeighbor("SouthEast").removeToken();
            return getNeighbor("SouthEast").getTerrain();
        }
        return "None";
    }


    /*public ArrayList<String> ColorNeighbor(String inputColor) {
        if (getNeighbor("West") != null && getNeighbor("West").hasSettlement() && getNeighbor("West").getSettlementColor().equals(inputColor)) {
            return "" ;
        }
        if (getNeighbor("East") != null && getNeighbor("East").hasSettlement() && getNeighbor("East").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("NorthWest") != null && getNeighbor("NorthWest").hasSettlement() && getNeighbor("NorthWest").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("NorthEast") != null && getNeighbor("NorthEast").hasSettlement() && getNeighbor("NorthEast").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("SouthWest") != null && getNeighbor("SouthWest").hasSettlement() && getNeighbor("SouthWest").getSettlementColor().equals(inputColor)) {
            return true;
        }
        if (getNeighbor("SouthEast") != null && getNeighbor("SouthEast").hasSettlement() && getNeighbor("SouthEast").getSettlementColor().equals(inputColor)) {
            return true;
        }
        return false;
    }*/
    public void drawSettlement(Graphics g) {
        if (settlementColor.equals("blue")) {
            g.drawImage(blue, x, y - 30, 40, 40, null);
        }
        if (settlementColor.equals("black")) {
            g.drawImage(black, x, y - 30, 40, 40, null);
        }
        if (settlementColor.equals("orange")) {
            g.drawImage(orange, x, y - 30, 40, 40, null);
        }
        if (settlementColor.equals("red")) {
            g.drawImage(red, x, y - 30, 40, 40, null);
        }
    }
}
