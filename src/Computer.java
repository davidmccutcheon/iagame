public class Computer extends Player {


    public Computer() {
        super ("Computer");
    }

    public Position[][] scatterWord(Position[][] hidGrid) {
        int x = 1;
        int y = 1;
        for (int i = 0; i < this.getWord().length(); i++) {
            Position pos = new Position(x, y);
            pos.setCompView(getWord().substring(i, i + 1));
            pos.setStatus("hidCompShip");
            hidGrid[x][y] = pos;
            x++;
            y++;
        }
        return hidGrid;
    }

    public String[][] makeCompView (Position[][] grid) {
        String[][] done = new String[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                done[i][j] = grid[i][j].getCompView();
            }
        }
        return done;
    }

    public void firstSpot(Position[][] hidGrid) {
        int x = 5;
        int y = 5;
        hidGrid[x][y].setStatus("comp");

        hidGrid[x][y].setHumView("🚢");
        hidGrid[x][y].setCompView("🚢");
    }

    public void turn (int numMoves, Position[][] hidGrid) {
        System.out.print("(computer turn)");
        this.setChances(getChances() - 1);
    }
}
