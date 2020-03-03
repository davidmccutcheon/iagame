import java.util.*;

public class Human extends Player {
    Scanner hsc = new Scanner(System.in);

    public Human () {
        super("Human");
    }

    public void setName() {
        System.out.println("Enter a username:");
        String userName = hsc.next();
        System.out.println("Your name is " + userName);
        setName(userName);
    }

    public Position[][][] scatterWord(Position[][] humGrid, Position[][] compGrid, Position[][] hidGrid) {
        for (int i = 0; i < this.getWord().length(); i++) {
            int x = 1;
            int y = 1;
            System.out.println("You are now going to place the letter " + getWord().substring(i) + ". Type in an " +
                    "x-coordinate first, from 1 to 10.");
            if (hsc.hasNextInt()) {
                x = hsc.nextInt() - 1;
            } else {
                System.out.println("That didn't work. Please try again.");
                if (hsc.hasNextInt()) {
                    x = hsc.nextInt() - 1;
                } else {
                    System.out.println("That didn't work either. You will now restart word placement.");
                    scatterWord(humGrid, compGrid, hidGrid);
                }
            }
            //make handling function for getting coordinates and processing them, to avoid repeating yourself
            System.out.println("Now, type in a y-coordinate, again from 1 to 10.");
            if (hsc.hasNextInt()) {
                y = hsc.nextInt() - 1;
            } else {
                System.out.println("That didn't work. Please try again.");
                if (hsc.hasNextInt()) {
                    y = hsc.nextInt() - 1;
                } else {
                    System.out.println("That didn't work either. You will now restart word placement.");
                    y++;
                    scatterWord(humGrid, compGrid, hidGrid);
                }
            }
                Position pos = new Position(x, y);
                pos.setHumView(getWord().substring(i, i + 1));
                pos.setHidView(getWord().substring(i, i + 1));
                pos.setStatus("hidHumanShip");
                humGrid[x][y] = pos;
                compGrid[x][y] = pos;
                hidGrid[x][y] = pos;
        }
        for (int i = 0; i < humGrid.length; i++) {
            for (int j = 0; j < humGrid[i].length; j++) {
                if (humGrid[i][j] == null) {
                    humGrid[i][j] = new Position(i + 1, j + 1);
                    compGrid[i][j] = new Position(i + 1, j + 1);
                    hidGrid[i][j] = new Position(i + 1, j + 1);

                    humGrid[i][j].setStatus("empty");
                    compGrid[i][j].setStatus("empty");
                    hidGrid[i][j].setStatus("empty");
                }
            }
        }
        Position[][][] group = {humGrid, compGrid, hidGrid};
        return group;
    }

    public void firstSpot() {
        int x;
        int y;
        System.out.println("");
        System.out.println("Pick a coordinate to land first. You will have to move spot by spot from here for the rest of the game.");
        System.out.println("First pick an x-coordinate: ");

    }

    public String[][] makeHumView (Position[][] grid) {
        String[][] done = new String[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                done[i][j] = grid[i][j].getHumView();
            }
        }
        return done;
    }
}
