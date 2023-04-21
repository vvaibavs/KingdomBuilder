

public class gameState {
    private static String state = "Start Screen";
    public static int mouseX;
    public static int mouseY;
    private MainPanel Panel;
    public ScoringCard card1, card2, card3;

    public gameState(MainPanel Panely) {
        Panel = Panely;
        mouseX = 0;
        mouseY = 0;
        Panel.setMode(state);
        Panel.startPaint();
        card1 = new ScoringCard();
        card2 = new ScoringCard();
        card3 = new ScoringCard();
    }
    public static void runClick() {
        if (mouseX > 278 && mouseX < 705 && mouseY < 631 && mouseY > 544 && state.equals("Start Screen")) {
            state = "Game Screen";
            mouseX = 0;
            mouseY = 0;
        } else if(mouseX > 476 && mouseY > 27 && mouseX < 734 && mouseY < 76 && !state.equals("Scoring Card")) {
            state = "Scoring Card";
        } else if(mouseX > 476 && mouseY > 27 && mouseX < 734 && mouseY < 76 && state.equals("Scoring Card")) {
            state = "Game Screen";
        }

    }
    public static String getState() {
        return state;
    }

}
