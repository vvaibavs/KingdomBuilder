import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ScoringCard {
    private String cardType;
    public BufferedImage pic, ESpic;

    public ScoringCard(int random){
        switch(random) {
            case 1:
                cardType = "citizens"; //
                break;
            case 2:
                cardType = "farmers"; //
                break;
            case 3:
                cardType = "fishermen"; //
                break;
            case 4:
                cardType = "lords"; //
                break;
            case 5:
                cardType = "miners"; //
                break;
            case 6:
                cardType = "workers"; //
                break;
            case 7:
                cardType = "knights";
                break;
        }
        try {
            pic = ImageIO.read(MainPanel.class.getResource("/images/" + this.getCardType() + ".png"));
            ESpic = ImageIO.read(MainPanel.class.getResource("/images/" + "ES" + this.getCardType() + ".png"));
        } catch(Exception e) {
            System.out.println(e);
        }


    }
    public String getCardType() {
        return cardType;
    }
}
