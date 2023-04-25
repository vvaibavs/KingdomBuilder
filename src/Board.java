public class Board {
    Node[][] board;
    int randInt1;
    int randInt2;
    int randInt3;
    int randInt4;
    public Board() {
        randInt1 = (int)(Math.random() * 7 + 1);
        randInt2 = (int)(Math.random() * 7 + 1);
        System.out.println("HELLO");
        while (randInt2 == randInt1) {
            randInt2 = (int)(Math.random() * 7 + 1);
        }
        randInt3 = (int)(Math.random() * 7 + 1);
        while (randInt3 == randInt1 || randInt3 == randInt2) {
            randInt3 = (int)(Math.random() * 7 + 1);
        }
        int randInt4 = (int)(Math.random() * 7 + 1);
        while (randInt4 == randInt1 || randInt4 == randInt2 || randInt4 == randInt3) {
            randInt4 = (int)(Math.random() * 7 + 1);
        }
        Sector sec1 = new Sector(randInt1, 1, 398, 147);
        Sector sec2 = new Sector(randInt2, 2, 798, 147);
        Sector sec3 = new Sector(randInt3, 3, 398, 447);
        Sector sec4 = new Sector(randInt4, 4, 798, 447);
        board = new Node[20][20];
        for (int i = 0; i < 10; i ++) {
            System.arraycopy(sec1.getSector()[i], 0, board[i], 0, sec1.getSector()[i].length);
            System.arraycopy(sec2.getSector()[i], 0, board[i], 10, sec2.getSector()[i].length);
            System.arraycopy(sec3.getSector()[i], 0, board[i + 10], 0, sec3.getSector()[i].length);
            System.arraycopy(sec4.getSector()[i], 0, board[i + 10], 10, sec4.getSector()[i].length);
        }
        System.out.println("HELLO");
    }
    public String check() {
        return "Help" + board[0][0].getTerrain();
    }
    public int getRand1() {
        return randInt1;
    }
    public int getRand2() {
        return randInt2;
    }
    public int getRand3() {
        return randInt3;
    }
    public int getRand4() {
        return randInt4;
    }
}
//for (int i = 0; i < sector.length;  i ++) {
//        for (int j = 0; j < sector[i].length; j ++) {
//        if (i != sector.length - 1) {
//        if (i % 2 == 0) {
//        sector[i][j].addNeighbor("SouthEast", sector[i - 1][j]);
//        }
//        }
//        }
//        }
