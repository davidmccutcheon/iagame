public class Computer extends Player {


    public Computer() {
        super ("Computer");
    }

    public Position[][][] scatterWord(Position[][] humGrid, Position[][] compGrid, Position[][] hidGrid) {
        Position[][][] group = {humGrid, compGrid, hidGrid};
        int x = 1;
        int y = 1;
        for (int i = 0; i < this.getWord().length(); i++) {
            Position pos = new Position(x, y);
            pos.setCompView(getWord().substring(i, i + 1));
            pos.setHidView(getWord().substring(i, i + 1));
            pos.setStatus("hidCompShip");
            humGrid[x][y] = pos;
            compGrid[x][y] = pos;
            hidGrid[x][y] = pos;
            x++;
            y++;
        }
        return group;
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
}
