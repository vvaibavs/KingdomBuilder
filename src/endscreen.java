import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class endscreen {
    private Player p1, p2, p3, p4;
    private BufferedImage bkg;
    private BufferedImage citizens, discoverers, farmers, fishermen, hermits, knights, lords, merchants, miners, workers;
    public endscreen(){
        super();
        try {
            bkg = ImageIO.read(MainPanel.class.getResource("/images/EndScreen.png"));
            citizens = ImageIO.read(MainPanel.class.getResource("/images/EScitizens"));
            discoverers = ImageIO.read(MainPanel.class.getResource("/images/ESdiscoverers"));
            farmers = ImageIO.read(MainPanel.class.getResource("/images/ESfarmers"));
            fishermen = ImageIO.read(MainPanel.class.getResource("/images/ESfishermen"));
            hermits = ImageIO.read(MainPanel.class.getResource("/images/EShermits"));
            knights = ImageIO.read(MainPanel.class.getResource("/images/ESknights"));
            lords = ImageIO.read(MainPanel.class.getResource("/images/ESlords"));
            merchants = ImageIO.read(MainPanel.class.getResource("/images/ESmerchants"));
            miners = ImageIO.read(MainPanel.class.getResource("/images/ESminers"));
            workers = ImageIO.read(MainPanel.class.getResource("/images/ESworkers"));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }
}
