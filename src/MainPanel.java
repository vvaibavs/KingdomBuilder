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
    public boolean coolhighlight = false;
    public MainPanel() {
        super();
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start-Screen.png"));
            mainGameFrame = ImageIO.read(MainPanel.class.getResource("/images/MainGameFrame.png"));
            endScreen = ImageIO.read(MainPanel.class.getResource("/images/EndScreen.png"));
            int randInt1 = (int)Math.round(Math.random() * 6 + 1);

            temp1 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt1 + ".png"));
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
    public void paint(Graphics g){
        g.drawRect(10, 10, 10, 10);
        if (gameState.state.equals("Start Screen")) {
            g.drawImage(startScreen, 0, 0, getWidth(), getHeight(), null);
        }
        else if (gameState.state.equals("Game Screen")) {
            drawGameFrame(g);
            g.drawImage(temp1, 398, 147, 420, 310, null);
            g.drawImage(temp2, 798, 147, 420, 310, null);

            g.drawImage(temp3, 398, 447, 420, 310, null);
            g.drawImage(temp4, 798, 447, 420, 310, null);


        } else if(gameState.state.equals("Scoring Card")) {
            Color c = new Color(107, 104, 103, 127);
            g.setColor(c);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawImage(gameState.card1.pic, getWidth()/4, getHeight()/3, 225, 275, null);
            g.drawImage(gameState.card2.pic, getWidth()/4 + 300, getHeight()/3, 225, 275, null);
            g.drawImage(gameState.card3.pic, getWidth()/4 + 600, getHeight()/3, 225, 275, null);

            gameState.state = "not Scoring Card";
        } else if(gameState.state.equals("End Screen")) {
            g.drawImage(endScreen, 0, 0, getWidth(), getHeight(), null);

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

    public void drawGameFrame(Graphics g) {
        g.drawImage(mainGameFrame, 0, 0, getWidth(), getHeight(), null);
    }
}