import java.awt.image.BufferedImage;

public class ScoringCard {
    private String cardType;
    private BufferedImage pic;

    public ScoringCard(){
        int random = (int)(Math.random() * 9) + 1;
        switch(random) {
            case 1:
                cardType = "citizen";
                break;
            case 2:
                cardType = "discoverer";
                break;
            case 3:
                cardType = "farmer";
                break;
            case 4:
                cardType = "fishermen";
                break;
            case 5:
                cardType = "hermit";
                break;
            case 6:
                cardType = "knight";
                break;
            case 7:
                cardType = "lord";
                break;
            case 8:
                cardType = "merchant";
                break;
            case 9:
                cardType = "miner";
                break;
            case 10:
                cardType = "worker";
                break;
        }

    }
    public String getCardType() {
        return cardType;
    }
}
