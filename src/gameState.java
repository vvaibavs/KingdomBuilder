import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class gameState {
    public static String state = "Start Screen";
    public static int mouseX;
    public static int mouseY;
    public static ScoringCard card1, card2, card3;
    private ArrayList<String> locTile;
    private MainPanel Panel;
    private ArrayList<Integer> randScoring;
    public static Board board;
    public static ArrayList<Integer> terrains;
    public static String substate = "placeSettlement";
    public static boolean nextToSettlementRequired = false;
    public static int settlementsLeft = 3;


    public static Player p1, p2, p3, p4, current;
    public static void inputBoard(Board theBoard) {
        board = theBoard;
    }
    public gameState(MainPanel Panely) {
        randScoring = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            randScoring.add(i);
        }
        p1 = new Player("red");
        p2 = new Player("blue");
        p3 = new Player("orange");
        p4 = new Player("black");
        current = p1;
        Collections.shuffle(randScoring);

        card1 = new ScoringCard(randScoring.get(0));
        card2 = new ScoringCard(randScoring.get(1));
        card3 = new ScoringCard(randScoring.get(2));
        mouseX = 0;
        mouseY = 0;
        Panel = Panely;

        Panel.startPaint();
        locTile = new ArrayList<String>();
        locTile.add("Farm");
        locTile.add("Oracle");
        locTile.add("Tavern");
        locTile.add("Tower");
        locTile.add("Harbor");
        locTile.add("Oasis");
        locTile.add("Paddock");
        locTile.add("Barn");

        terrains = new ArrayList<>();
        for(int i = 1; i <= 30; i++) {
            terrains.add(i);
        }

    }
    public static void runClick() {
        if (mouseX > 278 && mouseX < 705 && mouseY < 631 && mouseY > 544 && state.equals("Start Screen")) {
            state = "Game Screen";
            p1.next(); // Player 1's turn
            p1.card.randomize();
            System.out.println(current.card.type);
            mouseX = 0;
            mouseY = 0;
        } else if(mouseX > 476 && mouseY > 27 && mouseX < 734 && mouseY < 76 && !state.equals("Scoring Card") && !state.equals("not Scoring Card")) {
            state = "Scoring Card";
        } else if(mouseX > 476 && mouseY > 27 && mouseX < 734 && mouseY < 76 && state.equals("not Scoring Card")) {
            state = "Game Screen";
        } else if (mouseX < 1218 && mouseX > 398 && mouseY < 757 && mouseY > 147 && state.equals("Game Screen")) {
            if (substate.equals("placeSettlement") && settlementsLeft > 0) {
                int tempXPlace;
                int tempYPlace;
                ArrayList<Node> contenders = new ArrayList<>();
                Node selected = null;
                for (int i = 0; i < board.getLength(); i ++) {
                    for (int j = 0; j < board.getLength(); j ++) {
                        if (board.returnBoard()[i][j].containsClick(mouseX, mouseY)) {
                            contenders.add(board.returnBoard()[i][j]);
                        }
                    }
                }
                boolean picked = true;
                if (contenders.size() == 0) {
                    picked = false;
                }
                else if (contenders.size() > 1 && Math.hypot(mouseX - contenders.get(0).getX(), mouseY - contenders.get(0).getY()) < Math.hypot(mouseX - contenders.get(1).getX(), mouseY - contenders.get(1).getY())) {
                    selected = contenders.get(0);
                }
                else if (contenders.size() == 1) {
                    selected = contenders.get(0);
                }
                else {
                    selected = contenders.get(1);
                }


                if (picked && selected.isValid(current.getColor(), current.card.type, nextToSettlementRequired)) {
                    selected.putSettlement(current.getColor());
                    settlementsLeft -= 1;
                }
                nextToSettlementRequired = false;
            }

        } else if(mouseX > 1342 && mouseY > 878 && mouseX < 1524 && mouseY < 926 && settlementsLeft == 0) {
            settlementsLeft = 3;
            if(p1.turn) { // Player 2's turn
                p1.next();
                p2.next();
                p2.card.randomize();
                current = p2;
                System.out.println(p2.card.type);
            } else if(p2.turn) { // Player 3's turn
                p2.next();
                p3.next();
                p3.card.randomize();
                current = p3;
                System.out.println(p3.card.type);
            } else if(p3.turn) { // Player 4's turn
                p3.next();
                p4.next();
                current = p4;
                p4.card.randomize();
                System.out.println(p4.card.type);
            } else if(p4.turn) { // Player 1's turn
                p4.next();
                p1.next();
                p1.card.randomize();
                current = p1;
                System.out.println(p1.card.type);
            }
        }
    }

    public void scoringCards(){

    }

    public int worker(String color, Node n){ //simplify code
        if(n.getSettlementColor().equals(color)){
            if(locTile.contains(n.getNeighbor("East"))){
                return 1;
            }else if(locTile.contains(n.getNeighbor("West"))){
                return 1;
            }else if(locTile.contains(n.getNeighbor("SouthWest"))){
                return 1;
            }else if(locTile.contains(n.getNeighbor("NorthWest"))){
                return 1;
            }else if(locTile.contains(n.getNeighbor("SouthEast"))){
                return 1;
            }else if(locTile.contains(n.getNeighbor("NorthEast"))){
                return 1;
            }
        }
        return 0;
    }

    public int miner(String color, Node n){
        if(n.getSettlementColor().equals(color)){
            if(n.getNeighbor("East").getTerrain() == "Mountain"){
                return 1;
            }else if(n.getNeighbor("West").getTerrain() == "Mountain"){
                return 1;
            }else if(n.getNeighbor("NorthEast").getTerrain() == "Mountain"){
                return 1;
            }else if(n.getNeighbor("SouthEast").getTerrain() == "Mountain"){
                return 1;
            }else if(n.getNeighbor("NorthWest").getTerrain() == "Mountain"){
                return 1;
            }else if(n.getNeighbor("SouthWest").getTerrain() == "Mountain"){
                return 1;
            }
        }
        return 0;
    }

    public int fishermen(String color, Node n){
        if(n.getSettlementColor().equals(color)){
            if(n.getNeighbor("East").getTerrain() == "Water"){
                return 1;
            }else if(n.getNeighbor("West").getTerrain() == "Water"){
                return 1;
            }else if(n.getNeighbor("NorthEast").getTerrain() == "Water"){
                return 1;
            }else if(n.getNeighbor("SouthEast").getTerrain() == "Water"){
                return 1;
            }else if(n.getNeighbor("NorthWest").getTerrain() == "Water"){
                return 1;
            }else if(n.getNeighbor("SouthWest").getTerrain() == "Water"){
                return 1;
            }
        }
        return 0;
    }



    public static String getState() {
        return state;
    }

}