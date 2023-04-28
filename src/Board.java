public class Board {
    Node[][] board;

    public Board() {

        Sector sec1 = new Sector(MainPanel.randInt1, 1, 398, 147);
        Sector sec2 = new Sector(MainPanel.randInt2, 2, 798, 147);
        Sector sec3 = new Sector(MainPanel.randInt3, 3, 398, 447);
        Sector sec4 = new Sector(MainPanel.randInt4, 4, 798, 447);
        board = new Node[20][20];
        for (int i = 0; i < 10; i ++) {
            System.arraycopy(sec1.getSector()[i], 0, board[i], 0, sec1.getSector()[i].length);
            System.arraycopy(sec2.getSector()[i], 0, board[i], 10, sec2.getSector()[i].length);
            System.arraycopy(sec3.getSector()[i], 0, board[i + 10], 0, sec3.getSector()[i].length);
            System.arraycopy(sec4.getSector()[i], 0, board[i + 10], 10, sec4.getSector()[i].length);
        }
        for (int i = 0; i < board.length;  i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (i != board.length - 1) {
                    if (i % 2 == 0) {
                        System.out.println(i + " " + j + " " + board[i][j].getLoc());
                        board[i][j].addNeighbor("SouthEast", board[i + 1][j]);
                        if (j != 0) {
                            board[i][j].addNeighbor("SouthWest", board[i + 1][j - 1]);
                        }
                    }
                    if (i % 2 == 1) {

                        board[i][j].addNeighbor("SouthWest", board[i + 1][j]);
                        if (j != board[i].length - 1) {
                            board[i][j].addNeighbor("SouthEast", board[i + 1][j + 1]);
                        }
                    }
                    if (j != board[i].length - 1) {
                        board[i][j].addNeighbor("East", board[i][j+1]);
                    }

                }
            }
        }
    }
    public String check() {
        return "Help" + board[0][0].getTerrain() + " " + board[0][0].getLoc();
    }

}

