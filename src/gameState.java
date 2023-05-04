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
    public static int currentPlayer = 1;
    private ArrayList<Integer> randScoring;
    public static Board board;
    public static ArrayList<Integer> terrains;
    public static String substate = "placeSettlement";
    public static boolean nextToSettlementRequired = false;
    public static int settlementsLeft = 3;
    public static SpecialTile selectedTile = null;
    //Hi Vaibav, I left this special token variable in here for you to use tomorrow, in the Node class there is an isValid method that will have this as an input.
    //When using the method, simply add if statements with the name of the special token and add those parameters!
    public static String specialToken = "None";


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
        locTile.add("Castle");

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

                if ( ((current.getSettlements() != 0 && settlementsLeft > 0) || ! specialToken.equals("None") ) && picked && selected.isValid(current.getColor(), current.card.type, nextToSettlementRequired, specialToken)) {

                    String specialTokenToAdd = selected.hasSpecialNeighbor();
                    if (! specialTokenToAdd.equals("None")) {

                        boolean contains = false;
                        for (int i = 0; i < current.getSpecialTokens().size(); i ++) {
                            if (current.getSpecialTokens().get(i).getType().equals(specialTokenToAdd)) {
                                contains = true;                            }
                        }
                        if (! contains) {
                            current.addSpecialToken(specialTokenToAdd);
                            selected.removeTokenFromSpecialNeighbor();
                        }

                    }
                    if (specialToken.equals("None") || specialToken.equals("oracle") || specialToken.equals("tower") || specialToken.equals("farm") || specialToken.equals("oasis")) {
                        selected.putSettlement(current.getColor());
                        current.byeSettlements(1);
                        if (selectedTile != null) {
                            selectedTile.use();
                        }

                    }
                    if (specialToken.equals("None")) {
                        settlementsLeft -= 1;

                    }
                    specialToken = "None";
                    selectedTile = null;


                }
                nextToSettlementRequired = false;

        } else if(mouseX > 1342 && mouseY > 878 && mouseX < 1524 && mouseY < 926 && (settlementsLeft == 0 || current.getSettlements() == 0)) {
            settlementsLeft = 3;
            if(p1.turn) { // Player 2's turn
                currentPlayer = 2;
                p2.refreshTiles();
                p1.next();
                p2.next();
                p2.card.randomize();
                current = p2;
                System.out.println(p2.card.type);
                if (terrains.size() == 0) {
                    terrains = new ArrayList<>();
                    for(int i = 1; i <= 30; i++) {
                        terrains.add(i);
                    }
                }
            } else if(p2.turn) { // Player 3's turn
                currentPlayer = 3;
                p3.refreshTiles();
                p2.next();
                p3.next();
                p3.card.randomize();
                current = p3;
                System.out.println(p3.card.type);
                if (terrains.size() == 0) {
                    terrains = new ArrayList<>();
                    for(int i = 1; i <= 30; i++) {
                        terrains.add(i);
                    }
                }
            } else if(p3.turn) { // Player 4's turn
                currentPlayer = 4;
                p4.refreshTiles();
                p3.next();
                p4.next();
                current = p4;
                p4.card.randomize();
                System.out.println(p4.card.type);
                if (terrains.size() == 0) {
                    terrains = new ArrayList<>();
                    for(int i = 1; i <= 30; i++) {
                        terrains.add(i);
                    }
                }
            } else if(p4.turn) { // Player 1's turn
                currentPlayer = 1;
                p1.refreshTiles();
                p4.next();
                p1.next();
                p1.card.randomize();
                current = p1;
                if (p1.getSettlements() == 0 || p2.getSettlements() == 0 || p3.getSettlements() == 0 || p4.getSettlements() == 0) {
                    state = "End Screen";
                }
                System.out.println(p1.card.type);
                if (terrains.size() == 0) {
                    terrains = new ArrayList<>();
                    for(int i = 1; i <= 30; i++) {
                        terrains.add(i);
                    }
                }
            }
        }
        else if (mouseX > 56 && mouseY > 127 && mouseX < 1529 && mouseY < 831 && (settlementsLeft == 0 || settlementsLeft == 3 || current.getSettlements() == 0)) {
            System.out.println("OK");

            SpecialTile pickedTile = null;
            int XVal;
            int YVal;
            if (currentPlayer == 1) {
                XVal = 154 + 20;
                YVal = 254 + 20;
            }
            else if (currentPlayer == 2) {
                XVal = 1362 + 20;
                YVal = 254 + 20;
            }
            else if (currentPlayer == 3) {
                XVal = 154 + 20;
                YVal = 649 + 20;
            }
            else {
                XVal = 1362 + 20;
                YVal = 649 + 20;

            }
            for (int i = 0; i < current.getSpecialTokens().size(); i ++) {
                if (  Math.pow(mouseX - XVal, 2) + Math.pow(mouseY - YVal - i * 40, 2) < 400) {
                    pickedTile = current.getSpecialTokens().get(i);

                }

            }
            if (pickedTile != null && pickedTile.isReady()) {
                if (pickedTile.getType().equals(specialToken)) {
                    specialToken = "None";
                    selectedTile = null;

                }
                else {
                    specialToken = pickedTile.getType();
                    selectedTile = pickedTile;
                }
            }
            System.out.println(specialToken);
        }

    }

    public void scoringCards(){
        // need to link players number to their color here before starting

        //lords
        //in the actual scoring cards method
        //first value == player that had the most in the first sector && second value == player that had the second most in the first sector
        //first value + 12 points to total && second value + 6 points
        //maybe loop through odds and +12, then evens and add +6

    }

    public int worker(String color){ //simplify code
        Node[][] allNodes = board.returnBoard();
        int[][] counted = new int[allNodes.length][allNodes[0].length];
        int score = 0;
        for(int i = 0; i < allNodes.length; i++){
            for(int j = 0; j < allNodes[i].length; j++){
                Node n = allNodes[i][j];
                if(n.hasSettlement() == true && n.getSettlementColor().equals(color)){
                    if (n.getNeighbor("East") != null && locTile.contains(n.getNeighbor("East").getTerrain()) && counted[n.getNeighbor("East").getX()][n.getNeighbor("East").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("East").getX()][n.getNeighbor("East").getY()] = 1;
                    }
                    if (n.getNeighbor("West") != null && locTile.contains(n.getNeighbor("West").getTerrain())&& counted[n.getNeighbor("West").getX()][n.getNeighbor("West").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("West").getX()][n.getNeighbor("West").getY()] = 1;
                    }
                    if (n.getNeighbor("SouthWest") != null && locTile.contains(n.getNeighbor("SouthWest").getTerrain())&& counted[n.getNeighbor("SouthWest").getX()][n.getNeighbor("SouthWest").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("SouthWest").getX()][n.getNeighbor("SouthWest").getY()] = 1;
                    }
                    if (n.getNeighbor("NorthWest") != null && locTile.contains(n.getNeighbor("NorthWest").getTerrain())&& counted[n.getNeighbor("NorthWest").getX()][n.getNeighbor("NorthWest").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("NorthWest").getX()][n.getNeighbor("NorthWest").getY()] = 1;
                    }
                    if (n.getNeighbor("SouthEast") != null && locTile.contains(n.getNeighbor("SouthEast").getTerrain())&& counted[n.getNeighbor("SouthEast").getX()][n.getNeighbor("SouthEast").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("SouthEast").getX()][n.getNeighbor("SouthEast").getY()] = 1;
                    }
                    if (n.getNeighbor("NorthEast") != null&& locTile.contains(n.getNeighbor("NorthEast").getTerrain())&& counted[n.getNeighbor("NorthEast").getX()][n.getNeighbor("NorthEast").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("NorthEast").getX()][n.getNeighbor("NorthEast").getY()] = 1;
                    }
                }
            }
        }

        return score;
    }

    public int miner(String color){
        Node[][] allNodes = board.returnBoard();
        int[][] counted = new int[allNodes.length][allNodes[0].length];
        int score = 0;
        for(int i = 0; i < allNodes.length; i++){
            for(int j = 0; j < allNodes[i].length; j++){
                Node n = allNodes[i][j];
                if(n.hasSettlement() == true && n.getSettlementColor().equals(color)){
                    if(n.getNeighbor("East") != null && n.getNeighbor("East").getTerrain().equals("Mountain") && counted[n.getNeighbor("East").getX()][n.getNeighbor("East").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("East").getX()][n.getNeighbor("East").getY()] = 1;
                    }
                    if(n.getNeighbor("West") != null && n.getNeighbor("West").getTerrain().equals("Mountain") && counted[n.getNeighbor("West").getX()][n.getNeighbor("West").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("West").getX()][n.getNeighbor("West").getY()] = 1;
                    }
                    if(n.getNeighbor("NorthEast") != null && n.getNeighbor("NorthEast").getTerrain().equals("Mountain") && counted[n.getNeighbor("NorthEast").getX()][n.getNeighbor("NorthEast").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("NorthEast").getX()][n.getNeighbor("NorthEast").getY()] = 1;
                    }
                    if(n.getNeighbor("SouthEast") != null && n.getNeighbor("SouthEast").getTerrain().equals("Mountain") && counted[n.getNeighbor("SouthEast").getX()][n.getNeighbor("SouthEast").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("SouthEast").getX()][n.getNeighbor("SouthEast").getY()] = 1;
                    }
                    if(n.getNeighbor("NorthWest") != null && n.getNeighbor("NorthWest").getTerrain().equals("Mountain") && counted[n.getNeighbor("NorthWest").getX()][n.getNeighbor("NorthWest").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("NorthWest").getX()][n.getNeighbor("NorthWest").getY()] = 1;

                    }
                    if(n.getNeighbor("SouthWest") != null && n.getNeighbor("SouthWest").getTerrain().equals("Mountain") && counted[n.getNeighbor("SouthWest").getX()][n.getNeighbor("SouthWest").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("SouthWest").getX()][n.getNeighbor("SouthWest").getY()] = 1;
                    }

                }
            }

        }
        return score;
    }

    public int fishermen(String color){
        Node[][] allNodes = board.returnBoard();
        int[][] counted = new int[allNodes.length][allNodes[0].length];
        int score = 0;
        for(int i = 0; i < allNodes.length; i++){
            for(int j = 0; j < allNodes[i].length; j++){
                Node n = allNodes[i][j];
                if(n.hasSettlement() == true && n.getSettlementColor().equals(color)){
                    if(n.getNeighbor("East") != null && n.getNeighbor("East").getTerrain().equals("Water") && counted[n.getNeighbor("East").getX()][n.getNeighbor("East").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("East").getX()][n.getNeighbor("East").getY()] = 1;
                    }
                    if(n.getNeighbor("West") != null && n.getNeighbor("West").getTerrain().equals("Water") && counted[n.getNeighbor("West").getX()][n.getNeighbor("West").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("West").getX()][n.getNeighbor("West").getY()] = 1;
                    }
                    if(n.getNeighbor("NorthEast") != null && n.getNeighbor("NorthEast").getTerrain().equals("Water") && counted[n.getNeighbor("NorthEast").getX()][n.getNeighbor("NorthEast").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("NorthEast").getX()][n.getNeighbor("NorthEast").getY()] = 1;
                    }
                    if(n.getNeighbor("SouthEast") != null && n.getNeighbor("SouthEast").getTerrain().equals("Water") && counted[n.getNeighbor("SouthEast").getX()][n.getNeighbor("SouthEast").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("SouthEast").getX()][n.getNeighbor("SouthEast").getY()] = 1;
                    }
                    if(n.getNeighbor("NorthWest") != null && n.getNeighbor("NorthWest").getTerrain().equals("Water") && counted[n.getNeighbor("NorthWest").getX()][n.getNeighbor("NorthWest").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("NorthWest").getX()][n.getNeighbor("NorthWest").getY()] = 1;

                    }
                    if(n.getNeighbor("SouthWest") != null && n.getNeighbor("SouthWest").getTerrain().equals("Water") && counted[n.getNeighbor("SouthWest").getX()][n.getNeighbor("SouthWest").getY()] != 1) {
                        score++;
                        counted[n.getNeighbor("SouthWest").getX()][n.getNeighbor("SouthWest").getY()] = 1;
                    }

                }
            }

        }
        return score;
    }

    public int farmers (String color){
        Node[][] allNodes = board.returnBoard();
        int[][] counted = new int[allNodes.length][allNodes[0].length];

        int score = 0;
        //top left
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < allNodes.length/2; i++){
            for(int j = 0; j < allNodes[i].length/2; j++){

                Node n = allNodes[i][j];
                int setSize = setArea(n, counted, color);
                if(setSize > 0 && setSize < minNum){
                    minNum = setSize;
                }

            }
        }
        if(minNum > 0 && minNum < Integer.MAX_VALUE){
            score += minNum * 3;
        }
        //top right
        minNum = Integer.MAX_VALUE;
        for(int i = 10; i < allNodes.length; i++){
            for(int j = 0; j < allNodes[i].length/2; j++){

                Node n = allNodes[i][j];
                int setSize = setArea(n, counted, color);
                if(setSize > 0 && setSize < minNum){
                    minNum = setSize;
                }

            }
        }
        if(minNum > 0 && minNum < Integer.MAX_VALUE){
            score += minNum * 3;
        }
        //bottom left
        minNum = Integer.MAX_VALUE;
        for(int i = 0; i < allNodes.length/2; i++){
            for(int j = 10; j < allNodes[i].length; j++){

                Node n = allNodes[i][j];
                int setSize = setArea(n, counted, color);
                if(setSize > 0 && setSize < minNum){
                    minNum = setSize;
                }

            }
        }
        if(minNum > 0 && minNum < Integer.MAX_VALUE){
            score += minNum * 3;
        }
        //bottom right
        minNum = Integer.MAX_VALUE;
        for(int i = 10; i < allNodes.length; i++){
            for(int j = 10; j < allNodes[i].length; j++){

                Node n = allNodes[i][j];
                int setSize = setArea(n, counted, color);
                if(setSize > 0 && setSize < minNum){
                    minNum = setSize;
                }

            }
        }
        if(minNum > 0 && minNum < Integer.MAX_VALUE){
            score += minNum * 3;
        }

        return score;

    }

    public int citizens (String color){
        Node[][] allNodes = board.returnBoard();
        int[][] counted = new int[allNodes.length][allNodes[0].length];
        int maxNum = Integer.MIN_VALUE;
        int score = 0;

        for(int i = 0; i < allNodes.length; i++){
            for(int j = 0; j < allNodes[i].length; j++){

                Node n = allNodes[i][j];
                int setSize = setArea(n, counted, color);
                if(setSize > maxNum){
                    maxNum = setSize;
                }

            }
        }

        score = maxNum/2;
        return score;

    }

    public ArrayList<Integer> lords (String color){

        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<String> pColor = new ArrayList<String>();
        pColor.add(p1.getColor());
        pColor.add(p2.getColor());
        pColor.add(p3.getColor());
        pColor.add(p4.getColor());

        for(int i = 1; i <= 4; i++){
            int max = -1;
            int max2 = -1;
            for(int j= 0; j < 4; j++){ //0 == p1; 1 == p2; 2 == p3; 3 == p4;
                int x = numSet(pColor.get(j), i);
                if(x > max && x > max2){
                    max = x;
                }else if(x < max && x > max2){
                    max2 = x;
                }
            }
            nums.add(max);
            nums.add(max2);
        }

        return nums;

    }

    public int numSet(String color, int sectorNum){ //1 = top left, 2 = top right, 3 = bottom left, 4 = bottom right
        //returns the number of settlements in a sector
        Node[][] allNodes = board.returnBoard();
        int numSettlements = 0;
        int imax = -1;
        int jmax = -1;
        int imin = -1;
        int jmin = -1;
        switch(sectorNum){
            case 1: //top left
                imin = 0;
                imax = allNodes.length/2;
                jmin = 0;
                jmax = allNodes[0].length/2;
                break;
            case 2: //top right
                imin = allNodes.length/2;
                imax = allNodes.length;
                jmin = 0;
                jmax = allNodes[0].length/2;
                break;
            case 3: //bottom left
                imin = 0;
                imax = allNodes.length/2;
                jmin = allNodes[0].length/2;
                jmax = allNodes[0].length;
                break;
            case 4: //bottom right
                imin = allNodes.length/2;
                imax = allNodes.length;
                jmin = allNodes[0].length/2;
                jmax = allNodes[0].length;
                break;
        }

        for(int i = imin; i < imax; i++){
            for(int j = jmin; j < jmax; j++){
                Node l = allNodes[i][j];
                if(l.hasSettlement() == true && l.getSettlementColor().equals(color)){
                    numSettlements++;
                }
            }
        }
        return numSettlements;

    }

    public int setArea(Node n, int[][] counted, String color){
        //returns the number of settlements in a settlement area
        if(n.hasSettlement() == true && n.getSettlementColor().equals(color) && counted[n.getX()][n.getY()] != 1){
            counted[n.getX()][n.getY()] = 1;
            return 1 + setArea(n.getNeighbor("East"), counted, color) + setArea(n.getNeighbor("West"), counted, color) +
                    setArea(n.getNeighbor("NorthEast"), counted, color) + setArea(n.getNeighbor("SouthEast"), counted, color) +
                    setArea(n.getNeighbor("NorthWest"), counted, color) + setArea(n.getNeighbor("SouthWest"), counted, color);
        }else{
            return 0;
        }
    }


    public static String getState() {
        return state;
    }

}