import java.util.HashMap;
public class Node {
    private String terrain;
    private Boolean hasSettlement = false;
    private String settlementColor = null;
    private int board;
    private int x;
    private int y;
    private HashMap<String, Node> neighbors = new HashMap<String, Node>();
    public Node(String terrain, int board, int xloc, int yloc) {
        this.terrain = terrain;
        this.board = board;
        x = xloc;
        y = yloc;
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
    public boolean containsClick(int xloc, int yloc, int radius) {
        if (Math.pow(xloc - x, 2) + Math.pow(yloc - y, 2) == radius) {
            return true;
        }
        return false;
    }

}
