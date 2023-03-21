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
