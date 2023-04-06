import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class gameState {
    private static String state = "Start Screen";
    public static int mouseX;
    public static int mouseY;
    private MainPanel Panel;

    public gameState(MainPanel Panely) {
        Panel = Panely;
        mouseX = 0;
        mouseY = 0;
        Panel.setMode(state);
        Panel.startPaint();

    }
    public void runClick() {
        if (mouseX > 278 && mouseX < 705 && mouseY < 631 && mouseY > 544 && state.equals("Start Screen")) {
            state = "Game Screen";

        }

    }

}
