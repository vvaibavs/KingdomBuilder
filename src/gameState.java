

public class gameState {
    public static String state = "Start Screen";
    public static int mouseX;
    public static int mouseY;
    public static ScoringCard card1 = new ScoringCard(), card2 = new ScoringCard(), card3 = new ScoringCard();
    private MainPanel Panel;


    public gameState(MainPanel Panely) {
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
        } else if(mouseX > 1342 && mouseY > 878 && mouseX < 1524 && mouseY < 926 && !state.equals("End Screen")) {
            state = "End Screen";
        } else if(mouseX > 1342 && mouseY > 926 && mouseX < 1524 && mouseY < 926 && state.equals("End Screen")) {
            state = "Game Screen";
        } else if(mouseX > 318 && mouseY > 761 && mouseX < 776 && mouseY < 828 && state.equals("End Screen")) {
            state = "Game Screen";
    }

}
    public static String getState() {
        return state;
    }

}