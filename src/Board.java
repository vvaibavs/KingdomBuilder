public class Board {
    public void Board() {
        int randInt1 = (int)(Math.random() * 7 + 1);
        int randInt2 = (int)(Math.random() * 7 + 1);
        while (randInt2 == randInt1) {
            randInt2 = (int)(Math.random() * 7 + 1);
        }
        int randInt3 = (int)(Math.random() * 7 + 1);
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
        int m[][] = new int[20][20];
        System.arraycopy(sec1, 0, m, 0, sec1.get.length);
        System.arraycopy(sec2, 0, m, 10, sec2.length);
        System.out.println(m.toString());
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