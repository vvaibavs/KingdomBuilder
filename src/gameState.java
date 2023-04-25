import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class gameState {
    public static String state = "Start Screen";
    public static int mouseX;
    public static int mouseY;
    public static ScoringCard card1, card2, card3;
    private MainPanel Panel;
    private ArrayList<Integer> randScoring;
    public Board board;

    public static Player p1, p2, p3, p4;

    public gameState(MainPanel Panely) {
        randScoring = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            randScoring.add(i);
        }
        p1 = new Player("red");
        p2 = new Player("blue");
        p3 = new Player("green");
        p4 = new Player("black");
        Collections.shuffle(randScoring);
        board = new Board();
        System.out.print(board.check());
        card1 = new ScoringCard(randScoring.get(0));
        card2 = new ScoringCard(randScoring.get(1));
        card3 = new ScoringCard(randScoring.get(2));
        mouseX = 0;
        mouseY = 0;
        Panel = Panely;
        Panel.startPaint();

    }
    public static void runClick() {
        if (mouseX > 278 && mouseX < 705 && mouseY < 631 && mouseY > 544 && state.equals("Start Screen")) {
            state = "Game Screen";
            mouseX = 0;
            mouseY = 0;
        } else if(mouseX > 476 && mouseY > 27 && mouseX < 734 && mouseY < 76 && !state.equals("Scoring Card") && !state.equals("not Scoring Card")) {
            state = "Scoring Card";
        } else if(mouseX > 476 && mouseY > 27 && mouseX < 734 && mouseY < 76 && state.equals("not Scoring Card")) {
            state = "Game Screen";
        } else if(mouseX > 1342 && mouseY > 878 && mouseX < 1524 && mouseY < 926 && state.equals("Game Screen")) { //next button
            state = "End Screen";
        } else if(mouseX > 1342 && mouseY > 878 && mouseX < 1524 && mouseY < 926) {
            if(p1.turn) {
                p1.next();
                p2.next();
            } else if(p2.turn) {
                p2.next();
                p3.next();
            } else if(p3.turn) {
                p3.next();
                p4.next();
            } else if(p4.turn) {
                p4.next();
                p1.next();
            }
        } else if(mouseX > 1342 && mouseY > 926 && mouseX < 1524 && mouseY < 926 && state.equals("End Screen")) {
            state = "Game Screen";
        } else if(mouseX > 318 && mouseY > 761 && mouseX < 776 && mouseY < 828 && state.equals("End Screen")) { //go to game board
            state = "Game Screen";
        }
    }

    public void scoringCards(){

    }
    public static String getState() {
        return state;
    }

}