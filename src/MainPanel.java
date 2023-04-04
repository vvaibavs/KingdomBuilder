import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainPanel extends JPanel {
    static Graphics graphic;
    BufferedImage startScreen, endScreen, gameScreen;
    public MainPanel() {
        super();
        setSize(getWidth(),getHeight());
        try {
            startScreen = ImageIO.read(getClass().getResourceAsStream("/images/Start Screen.png"));
            gameScreen = ImageIO.read(getClass().getResourceAsStream("/images/"));
            endScreen = ImageIO.read(getClass().getResourceAsStream("/images/"));

        }
        catch(Exception e){

            System.out.println(e.getMessage());
            return;
        }
    }
    public void paint(Graphics g){
        graphic = g;

    }
    public void drawStartScreen() {

    }
}
