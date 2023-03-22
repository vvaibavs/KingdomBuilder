import java.util.HashMap;
public class Node {
    private String terrain;
    private Boolean hasSettlement = false;
    private String settlementColor = null;
    private HashMap<String, Node> neighbors = new HashMap<String, Node>();
    public Node(String terrain) {
        this.terrain = terrain;
    }
    public void addNeighbor(String direction, Node neighbor) {
        neighbors.put(direction, neighbor);
        if (direction.equals("West")) {
            neighbor.addNeighbor("East", this, false);
        }
        else if (direction.equals("North")) {
            neighbor.addNeighbor("South", this, false);
        }
        else if (direction.equals("East")) {
            neighbor.addNeighbor("West", this, false);
        }
        else if (direction.equals("South")) {
            neighbor.addNeighbor("North", this, false);
        }
    }
    public void addNeighbor(String direction, Node neighbor, boolean cont){
        neighbors.put(direction, neighbor);
        if (cont) {
            if (direction.equals("West")) {
                neighbor.addNeighbor("East", this, false);
            }
            else if (direction.equals("North")) {
                neighbor.addNeighbor("South", this, false);
            }
            else if (direction.equals("East")) {
                neighbor.addNeighbor("West", this, false);
            }
            else if (direction.equals("South")) {
                neighbor.addNeighbor("North", this, false);
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
}
