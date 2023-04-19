public class Sector {
    public int type;
    public int loc;
    public Node sector[][];

    String[][] map1 = {{"Desert", "Desert", "Canyon", "Water", "Water", "Forest", "Forest", "Forest", "Grass", "Grass"},{"Desert", "Castle", "Canyon", "Water", "Forest", "Forest", "Forest", "Farm", "Grass", "Grass"},{"Canyon", "Canyon", "Canyon", "Flower", "Flower", "Flower", "Forest", "Canyon", "Flower", "Flower"},{"Canyon", "Canyon", "Flower", "Flower", "Water", "Desert", "Desert", "Canyon", "Canyon", "Flower"},{"Canyon", "Grass", "Grass", "Water", "Flower", "Flower", "Desert", "Desert", "Canyon", "Canyon"},{"Grass", "Grass", "Farm", "Flower", "Water", "Flower", "Water", "Desert", "Desert"},{"Grass", "Grass", "Grass", "Forest", "Flower", "Flower", "Water", "Water", "Desert", "Desert"},{"Grass", "Grass", "Forest", "Forest", "Mountain", "Water", "Water", "Water", "Desert", "Water"},{"Grass", "Mountain", "Forest", "Forest", "Water", "Water", "Water", "Water", "Water", "Water"},{"Forest", "Forest", "Forest", "Water", "Water", "Water", "Water", "Water", "Water", "Water"}};
    String[][] map2 = {{"Grass", "Grass", "Forest", "Forest", "Forest", "Water", "Grass", "Forest", "Forest", "Flower"},{"Grass", "Flower", "Forest", "Forest", "Water", "Grass", "Forest", "Forest", "Flower", "Flower"},{"Grass", "Flower", " Flower", "Forest", "Water", "Grass", "Grass", "Flower", "Flower", "Flower"},{"Flower", "Flower", "Forest", "Forest", "Water", "Grass", "Mountain", "Flower", "Desert", "Desert"},{"Canyon", "Flower", "Castle", "Forest", "Water", "Grass", "Desert", "Desert","Desert","Desert"},{"Canyon", "Canyon", "Forest", "Water", "Grass", "Grass", "Mountain", "Mountain", "Desert", "Desert"},{"Canyon", "Canyon", "Water", "Water", "Water", "Grass", "Desert", "Desert", "Desert", "Canyon"},{"Water","Water", "Grass", "Grass", "Water", "Water", "Boat", "Canyon", "Mountain", "Canyon"},{"Water", "Desert", "Castle", "Grass", " Water", "Mountain", "Water", "Canyon", "Canyon", "Canyon"},{"Water", "Desert", "Desert", "Water", "Water", "Water", "Water", "Canyon", "Canyon", "Canyon"}};
    String[][] map3 = {{"Desert", "Desert", "Canyon", "Water", "Water", "Forest", "Forest", "Grass", "Grass", "Grass"},{"Desert", "Canyon", "Water", "Flower", "Flower", "Forest", "Forest", "Forest", "Grass", "Grass"},{"Desert", "Desert", "Water", "Flower", "Flower", "Forest", "Forest", "Oasis", "Flower", "Grass"},{"Water", "Water", "Water", "Flower", "Grass", "Forest", "Flower", "Flower", "Flower", "Flower"},{"Water", "Water", "Water", "Water", "Grass", "Grass", "Grass", "Grass", "Flower", "Flower"},{"Water", "Forest", "Forest", "Water", "Grass", "Grass", "Canyon", "Canyon", "Desert", "Canyon"},{"Water", "Forest", "Canyon", "Forest", "Water", "Grass", "Canyon", "Canyon", "Desert", "Canyon"},{"Water", "Castle", "Canyon", "Flower", "Water", "Oasis", "Desert", "Desert", "Canyon", "Water"},{"Water", "Water", "Canyon", "Flower", "Water", "Water", "Water", "Desert", "Desert", "Water"},{"Water", "Water", "Water", "Water", "Water", "Water", "Water", "Water", "Water", "Water",}};
    String[][] map4 = {{"Grass", "Grass", "Grass", "Forest", "Forest", "Water", "Grass", "Forest", "Forest", "Forest"},{"Grass", "Grass", "Grass", "Castle", "Forest", "Water", "Grass", "Forest", "Forest", "Forest"},{"Grass", "Flower", "Flower", "Grass", "Forest", "Forest", "Water", "Grass", "Grass", "Forest"},{"Flower", "Flower", "Canyon", "Grass", "Forest", "Water", "Flower", "Oracle", "Forest", "Forest"},{"Flower", "Flower", "Flower", "Canyon", "Canyon", "Water", "Flower", "Flower", "Water", "Water"},{"Mountain", "Mountain", "Canyon", "Grass", "Grass", "Water", "Water", "Water", "Desert", "Desert"},{"Canyon", "Canyon", "Canyon", "Mountain", "Grass", "Flower", "Flower", "Flower", "Desert", "Desert"},{"Canyon", "Canyon", "City", "Desert", "Mountain", "Desert","Flower","Flower","Canyon","Canyon"},{"Water","Water","Water","Desert","Desert","Desert","Desert","Mountain","Canyon","Canyon"},{"Water","Water","Water","Water","Desert","Desert","Desert","Desert","Desert","Canyon"}};
    String[][] map5 = {{"Canyon", "Canyon", "Canyon", "Desert", "Desert", "Water", "Desert",  "Desert",  "Desert",  "Desert"},{"Mountain", "Mountain", "Canyon", "Desert", "Desert", "Water", "Desert", "Desert", "Desert", "Desert"},{"Mountain", "Mountain", "Canyon", "Mountain", "Mountain", "Water", "Desert", "Desert", "Paddock", "Flower"},{"Mountain", "Canyon", "Mountain", "Mountain", "Water", "Mountain", "Desert", "Flower", "Flower", "Flower"},{"Canyon", "Canyon", "Forest", "Forest", "Water", "Mountain", "Mountain", "Canyon", "Flower", "Flower"},{"Canyon", "Forest", "Forest", "Water", "Canyon", "Canyon", "Canyon", "Mountain", "Flower", "Flower"},{"Canyon", "Paddock", "Forest", "Forest", "Water", "Flower", "Flower", "Flower", "Flower", "Flower"},{"Grass", "Grass", "Forest", "Water", "Grass", "Castle", "Grass", "Flower", "Grass", "Forest"},{"Grass", "Grass", "Forest", "Forest", "Water", "Grass", "Grass", "Grass", "Grass", "Forest"},{"Grass", "Grass", "Forest", "Forest", "Water", "Grass", "Grass", "Grass", "Forest", "Forest"}};
    String[][] map6 = {{"Flower", "Desert", "Desert", "Mountain", "Mountain", "Desert", "Desert", "Canyon", "Canyon", "Canyon" },{"Flower", "Flower", "Desert", },{},{},{},{},{},{},{},{}};
    String[][] map7 = {{"Forest", "Forest", "Forest", "Forest", "Mountain", "Mountain", "Grass", "Mountain", "Canyon", "Canyon"},{"Forest", "Mountain", "Forest", "Forest", "Flower", "Grass", "Mountain", "Mountain", "Mountain", "Canyon"},{"Flower", "Flower", "Forest", "Flower", "Flower", "Flower", "Grass", "Grass", "Water", "Mountain"},{"Desert", "Flower", "Flower", "Flower", "Water", "Tower", "Grass", "Water", "Mountain", "Mountain"},{"Desert", "Desert", "Desert", "Desert", "Flower", "Water", "Grass", "Water", "Canyon", "Canyon"},{"Desert", "Canyon", "Desert", "Desert", "Desert", "Water", "Water", "Canyon", "Grass", "Canyon"},{"Desert", "Desert", "Canyon", "Desert", "Desert", "Water", "Flower", "Castle", "Grass", "Canyon"},{"Canyon", "Canyon", "Tower", "Desert", "Water", "Flower", "Flower", "Flower", "Grass", "Grass"},{"Desert", "Canyon", "Water", "Water", "Water", "Forest", "Forest", "Flower", "Grass", "Grass"},{"Desert", "Canyon", "Canyon", "Water", "Forest", "Forest", "Forest", "Grass", "Grass", "Grass"}};
    public Sector(int type, int loc) {
        this.type = type;
        switch (type) {
            case 1:
                for (String[] i: map1) {
                    for (String j: i) {

                    }
                }

        }
        this.loc = loc;
        createBoard();
    }
    public void createBoard() {


    }

    public void addSettlements(int x, int y) {

    }
}
