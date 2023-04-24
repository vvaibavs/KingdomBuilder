import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ScoringCard {
    private String cardType;
    public BufferedImage pic;

    public ScoringCard(int random){
        switch(random) {
            case 1:
                cardType = "citizens";
                break;
            case 2:
                cardType = "discoverers";
                break;
            case 3:
                cardType = "farmers";
                break;
            case 4:
                cardType = "fishermen";
                break;
            case 5:
                cardType = "hermits";
                break;
            case 6:
                cardType = "knights";
                break;
            case 7:
                cardType = "lords";
                break;
            case 8:
                cardType = "merchants";
                break;
            case 9:
                cardType = "miners";
                break;
            case 10:
                cardType = "workers";
                break;
        }
        try {
            pic = ImageIO.read(MainPanel.class.getResource("/images/" + this.getCardType() + ".png"));
        } catch(Exception e) {
            System.out.println(e);
        }


    }
    public String getCardType() {
        return cardType;
    }
}
