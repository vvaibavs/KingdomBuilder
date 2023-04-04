import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class gameState implements MouseListener {
    private String state = "Start Screen";
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
