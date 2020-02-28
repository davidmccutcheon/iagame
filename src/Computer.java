public class Computer extends Player {


    public Computer() {
        super ("Computer");
    }

    public void scatterWord() {
        for(int i = 0; i < this.getWord().length(); i++) {
            int randomX = 4;
            int randomY = 6;
            Position pos = new Position(randomX, randomY);
            pos.setStatus("compShip");
        }
    }
}
