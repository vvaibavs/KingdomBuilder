import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.*;

public class MainPanel extends JPanel implements MouseListener {
    private BufferedImage startScreen, endScreen, transSquare, mainGameFrame;
    private BufferedImage temp1, temp2, temp3, temp4;
    static Graphics graphic;
    private String state;
    public MainPanel() {
        super();
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start-Screen.png"));
            mainGameFrame = ImageIO.read(MainPanel.class.getResource("/images/MainGameFrame.png"));
//            endScreen = ImageIO.read(MainPanel.class.getResource("/images/End Screen.png"));
            temp1 = ImageIO.read(MainPanel.class.getResource("/images/map1.png"));
            temp2 = ImageIO.read(MainPanel.class.getResource("/images/map2.png"));
            temp3 = ImageIO.read(MainPanel.class.getResource("/images/map3.png"));
            temp4 = ImageIO.read(MainPanel.class.getResource("/images/map4.png"));

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
        else if (state.equals("Game Screen")) {
            drawGame(g);
            g.drawImage(temp1, 398, 147, 424, 311, null);
            g.drawImage(temp2, 822, 147, 424, 311, null);


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
        setMode(gameState.getState());
        repaint();
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

    public void drawGame(Graphics g) {
        g.drawImage(mainGameFrame, 0, 0, getWidth(), getHeight(), null);
    }
}
