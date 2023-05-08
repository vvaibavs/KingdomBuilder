import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.*;

public class MainPanel extends JPanel implements MouseListener {
    static int randInt1;
    static int randInt2;
    static int randInt3;
    static int randInt4;
    static BufferedImage startToken, pic2;
    static boolean hasEnded = false;
    private BufferedImage startScreen, endScreen, transSquare, mainGameFrame;
    private BufferedImage temp1, temp2, temp3, temp4, hexHighLight;
    static Graphics graphic;
    private String state;
    private Board theBoard;
    public MainPanel() {
        super();

        randInt1 = (int)(Math.random() * 7 + 1);
        randInt2 = (int)(Math.random() * 7 + 1);
        while (randInt2 == randInt1) {
            randInt2 = (int)(Math.random() * 7 + 1);
        }
        randInt3 = (int)(Math.random() * 7 + 1);
        while (randInt3 == randInt1 || randInt3 == randInt2) {
            randInt3 = (int)(Math.random() * 7 + 1);
        }
        randInt4 = (int)(Math.random() * 7 + 1);
        while (randInt4 == randInt1 || randInt4 == randInt2 || randInt4 == randInt3) {
            randInt4 = (int)(Math.random() * 7 + 1);
        }
        theBoard = new Board();
        gameState.inputBoard(theBoard);
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start-Screen.png"));
            mainGameFrame = ImageIO.read(MainPanel.class.getResource("/images/nMainGameFrame.png"));
            endScreen = ImageIO.read(MainPanel.class.getResource("/images/EndScreen.png"));
            startToken = ImageIO.read(MainPanel.class.getResource("/images/StartToken.png"));
            pic2 = ImageIO.read(MainPanel.class.getResource("/images/" + "CardBack" + ".png"));
            temp1 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt1 + ".png"));
            temp2 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt2 + ".png"));
            temp3 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt3 + ".png"));
            temp4 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt4 + ".png"));

            hexHighLight = ImageIO.read(Node.class.getResource("/images/HexHighlight.png"));



        }
        catch (Exception e) {
            System.out.println(randInt1);
            System.out.println(randInt2);
            System.out.println(randInt3);
            System.out.println(randInt4);
            System.out.println(e.getMessage());
            return;
        }

        setSize(getWidth(), getHeight());
        addMouseListener(this);
    }
    public void restart() {
        hasEnded = false;
        randInt1 = (int)(Math.random() * 7 + 1);
        randInt2 = (int)(Math.random() * 7 + 1);
        while (randInt2 == randInt1) {
            randInt2 = (int)(Math.random() * 7 + 1);
        }
        randInt3 = (int)(Math.random() * 7 + 1);
        while (randInt3 == randInt1 || randInt3 == randInt2) {
            randInt3 = (int)(Math.random() * 7 + 1);
        }
        randInt4 = (int)(Math.random() * 7 + 1);
        while (randInt4 == randInt1 || randInt4 == randInt2 || randInt4 == randInt3) {
            randInt4 = (int)(Math.random() * 7 + 1);
        }
        theBoard = new Board();
        gameState.inputBoard(theBoard);
        try {
            startScreen = ImageIO.read(MainPanel.class.getResource("/images/Start-Screen.png"));
            mainGameFrame = ImageIO.read(MainPanel.class.getResource("/images/nMainGameFrame.png"));
            endScreen = ImageIO.read(MainPanel.class.getResource("/images/EndScreen.png"));

            temp1 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt1 + ".png"));
            temp2 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt2 + ".png"));
            temp3 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt3 + ".png"));
            temp4 = ImageIO.read(MainPanel.class.getResource("/images/map" + randInt4 + ".png"));
            hexHighLight = ImageIO.read(Node.class.getResource("/images/HexHighlight.png"));



        }
        catch (Exception e) {
            System.out.println(randInt1);
            System.out.println(randInt2);
            System.out.println(randInt3);
            System.out.println(randInt4);
            System.out.println(e.getMessage());
            return;
        }
    }
    public void inputTheBoard(Board board) {
        theBoard = board;
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
            g.drawImage(gameState.p1.card.pic, 84, 277, 50, 50, null);
            g.drawImage(gameState.p2.card.pic, 1289, 277, 50, 50, null);
            g.drawImage(gameState.p3.card.pic, 84, 673, 50, 50, null);
            g.drawImage(gameState.p4.card.pic, 1289, 683, 50, 50, null);
            if (gameState.currentPlayer == 1) {
                g.drawImage(pic2, 1289, 277, 50, 50, null);
                g.drawImage(pic2, 84, 673, 50, 50, null);
                g.drawImage(pic2, 1289, 683, 50, 50, null);
            }
            if (gameState.currentPlayer == 2) {
                g.drawImage(pic2,  84, 277, 50, 50, null);
                g.drawImage(pic2, 84, 673, 50, 50, null);
                g.drawImage(pic2, 1289, 683, 50, 50, null);
            }
            if (gameState.currentPlayer == 3) {
                g.drawImage(pic2, 1289, 277, 50, 50, null);
                g.drawImage(pic2,  84, 277, 50, 50, null);
                g.drawImage(pic2, 1289, 683, 50, 50, null);
            }
            if (gameState.currentPlayer == 4) {
                g.drawImage(pic2, 1289, 277, 50, 50, null);
                g.drawImage(pic2, 84, 673, 50, 50, null);
                g.drawImage(pic2,  84, 277, 50, 50, null);
            }
            for (int i = 0; i < theBoard.getLength(); i ++) {
                for (int j = 0; j < theBoard.getLength(); j ++) {
                    if (theBoard.returnBoard()[i][j].hasSettlement()) {
                        theBoard.returnBoard()[i][j].drawSettlement(g);
                    }
                }

            }
            if (gameState.startPlayerInt == 1) {
                System.out.println("HELLO");
                g.drawImage(startToken, 10, 147, 50, 50, null);
            }
            if (gameState.startPlayerInt == 2) {
                g.drawImage(startToken, 1507, 147, 50, 50, null);
            }
            if (gameState.startPlayerInt == 3) {
                g.drawImage(startToken, 10, 544, 50, 50, null);
            }
            if (gameState.startPlayerInt == 4) {
                g.drawImage(startToken, 1507, 544, 50, 50, null);
            }
            g.setFont(new Font("Kunstler Script", Font.BOLD, 65));
            g.drawString(gameState.p1.getSettlements() + "", 235, 238);
            g.drawString(gameState.p2.getSettlements() + "", 1440, 238);
            g.drawString(gameState.p3.getSettlements() + "", 238, 631);
            g.drawString(gameState.p4.getSettlements() + "", 1450, 643);
            int y = 0;
            for (int i = 0; i < gameState.p1.getSpecialTokens().size(); i ++) {
                g.drawImage(gameState.p1.getSpecialTokens().get(i).getImage(), 154 + y, 254 + i%4 * 40, 40, 40, null);
                if (i == 3) {
                    y += 40;
                }
            }
            y = 0;
            for (int i = 0; i < gameState.p2.getSpecialTokens().size(); i ++) {
                g.drawImage(gameState.p2.getSpecialTokens().get(i).getImage(), 1362 + y, 254 + i%4 * 40, 40, 40, null);
                if (i == 3) {
                    y += 40;
                }
            }
            y = 0;
            for (int i = 0; i < gameState.p3.getSpecialTokens().size(); i ++) {
                g.drawImage(gameState.p3.getSpecialTokens().get(i).getImage(), 154 + y, 649 + i%4 * 40, 40, 40, null);
                if (i == 3) {
                    y += 40;
                }
            }
            y = 0;
            for (int i = 0; i < gameState.p4.getSpecialTokens().size(); i ++) {
                g.drawImage(gameState.p4.getSpecialTokens().get(i).getImage(), 1362 + y, 649 + i%4 * 40, 40, 40, null);
                if (i == 3) {
                    y += 40;
                }
            }

            if (gameState.settlementsLeft > 0 || ! gameState.specialToken.equals("None")) {
                for (int i = 0; i < gameState.board.getLength(); i++) {
                    for (int j = 0; j < gameState.board.getLength(); j++) {
                        if (gameState.board.returnBoard()[i][j].isValid(gameState.current.getColor(), gameState.current.card.type, true, gameState.specialToken)) {
                            gameState.nextToSettlementRequired = true;
                        }
                    }
                }

                for (int i = 0; i < theBoard.getLength() && gameState.current.getSettlements() > 0; i++) {
                    for (int j = 0; j < theBoard.returnBoard()[i].length; j++) {
                        if (theBoard.returnBoard()[i][j].isValid(gameState.current.getColor(), gameState.current.card.type, gameState.nextToSettlementRequired, gameState.specialToken)) {
                            theBoard.returnBoard()[i][j].drawHighlight(g);
                        }

                    }
                }
            }

            Color c = new Color(107, 104, 103, 127);
            if(gameState.p1.turn) {
                g.setColor(c);
                g.fillRect(58, 130, 250, 296);
            } else if(gameState.p2.turn) {
                g.setColor(c);
                g.fillRect(1256, 130, 250, 296);
            } else if(gameState.p3.turn) {
                g.setColor(c);
                g.fillRect(58, 526, 250, 296);
            } else if(gameState.p4.turn) {
                g.setColor(c);
                g.fillRect(1266, 536, 250, 296);
            }


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
            g.drawImage(gameState.card1.ESpic, 375, 243, 90, 120, null);
            g.drawImage(gameState.card2.ESpic, 491, 243, 90, 120, null);
            g.drawImage(gameState.card3.ESpic, 610, 243, 90, 120, null);
            g.setFont(new Font("Kunstler Script", Font.BOLD, 100));
            if (!hasEnded) {
                gameState.scoringCards();
                gameState.p1.combineScores();
                gameState.p2.combineScores();
                gameState.p3.combineScores();
                gameState.p4.combineScores();
                hasEnded = true;
                System.out.println("end");
            }
            g.drawString("" + gameState.p1.c1Score, 375, 410);
            g.drawString("" + gameState.p2.c1Score, 375, 500);
            g.drawString("" + gameState.p3.c1Score, 375, 590);
            g.drawString("" + gameState.p4.c1Score, 375, 680);

            g.drawString("" + gameState.p1.c2Score, 500, 410);
            g.drawString("" + gameState.p2.c2Score, 500, 500);
            g.drawString("" + gameState.p3.c2Score, 500, 590);
            g.drawString("" + gameState.p4.c2Score, 500, 680);

            g.drawString("" + gameState.p1.c3Score, 625, 410);
            g.drawString("" + gameState.p2.c3Score, 625, 500);
            g.drawString("" + gameState.p3.c3Score, 625, 590);
            g.drawString("" + gameState.p4.c3Score, 625, 680);

            g.drawString("" + gameState.p1.castleScore, 730, 410);
            g.drawString("" + gameState.p2.castleScore, 730, 500);
            g.drawString("" + gameState.p3.castleScore, 730, 590);
            g.drawString("" + gameState.p4.castleScore, 730, 680);

            g.drawString("" + gameState.p1.getScore(), 855, 410);
            g.drawString("" + gameState.p2.getScore(), 855, 500);
            g.drawString("" + gameState.p3.getScore(), 855, 590);
            g.drawString("" + gameState.p4.getScore(), 855, 680);
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
    public void redraw() {
        repaint();
    }
}