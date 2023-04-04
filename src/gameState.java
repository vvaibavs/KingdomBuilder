import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class gameState implements MouseListener {
    public static int mouseX;
    public static int mouseY;

    public gameState() {
        mouseX = 0;
        mouseY = 0;
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
