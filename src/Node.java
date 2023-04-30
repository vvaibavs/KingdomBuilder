import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Node {
    private String terrain;
    private Boolean hasSettlement = false;
    private String settlementColor = null;
    private int board;
    private int x;
    private int y;
    private HashMap<String, Node> neighbors = new HashMap<String, Node>();
    private final int radius = 20;
    BufferedImage hexHighLight;
    public Node(String terrain, int board, int xloc, int yloc) {
        this.terrain = terrain;
        this.board = board;
        x = xloc;
        y = yloc;
        try {
            hexHighLight = ImageIO.read(Node.class.getResource("/images/HexHighlight.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public boolean isValid(String color, String terrain, boolean nextToSettlementMatters) {
        if (hasSettlement) {
            return false;
        }
        if (! this.terrain.equals(terrain)) {
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
}
