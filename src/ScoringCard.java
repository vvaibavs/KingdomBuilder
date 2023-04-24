import java.awt.image.BufferedImage;

public class ScoringCard {
    private String cardType;
    private BufferedImage pic;

    public ScoringCard(){
        int random = (int)(Math.random() * 9) + 1;
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

    }
    public String getCardType() {
        return cardType;
    }
}
