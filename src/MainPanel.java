import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class MainPanel extends JPanel implements MouseListener {
    private BufferedImage startScreen, endScreen, transSquare;
    static Graphics graphic;
    private String state;
    public MainPanel() {
        super();
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start-Screen.png"));

            //transSquare = ImageIO.read(MainPanel.class.getResource("/images/transPlayerSquare.png"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        setSize(getWidth(), getHeight());
        addMouseListener(this);
    }
    public void setMode(String type) {
        state = type;
    }
    public void paint(Graphics g){
        g.drawRect(10, 10, 10, 10);
        if (state.equals("Start Screen")) {
            g.drawImage(startScreen, 0, 0, getWidth(), getHeight(), null);
        }

    }
    public void startPaint() {
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameState.mouseX = e.getX();
        gameState.mouseY = e.getY();
        System.out.println(gameState.mouseX + " " + gameState.mouseY);
        gameState.runClick();
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

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
