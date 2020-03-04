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

    public void scatterWord(Position[][] humGrid, Position[][] compGrid, Position[][] hidGrid) {
        for (int i = 0; i < this.getWord().length(); i++) {
            int x = 1;
            int y = 1;
            System.out.println("You are now going to place the letter " + getWord().substring(i) + ". Type in an " +
                    "x-coordinate first, from 1 to 10.");
            x = coordinateHandling("word placement along the x-axis", x, humGrid, compGrid, hidGrid);
            System.out.println("Now, type in a y-coordinate, again from 1 to 10.");
            y = coordinateHandling("word placement along the y-axis", y, humGrid, compGrid, hidGrid);
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
    }

    public int coordinateHandling(String process, int x, Position[][] humGrid, Position[][] compGrid, Position[][] hidGrid) {
        if (hsc.hasNextInt()) {
            x = hsc.nextInt() - 1;
        } else {
            System.out.println("That didn't work. Please try again.");
            if (hsc.hasNextInt()) {
                x = hsc.nextInt() - 1;
            } else {
                System.out.println("That didn't work either. You will now restart " + process + ".");
                coordinateHandling(process, x, humGrid, compGrid, hidGrid);
            }
        }
        return x;
    }

    public void firstSpot(Position[][] humGrid, Position[][] compGrid, Position[][] hidGrid) {
        int x = 1;
        int y = 1;
        System.out.println("");
        System.out.println("Pick a coordinate to land first. You will have to move spot by spot from here for the rest of the game.");
        System.out.println("x-coordinate: ");
        x = coordinateHandling("position selection along the x-axis", x, humGrid, compGrid, hidGrid);
        System.out.println("y-coordinate");
        y = coordinateHandling("position selection along the y-axis", y, humGrid, compGrid, hidGrid);

        humGrid[x][y].setStatus("hum");
        compGrid[x][y].setStatus("hum");
        hidGrid[x][y].setStatus("hum");

        humGrid[x][y].setHumView("⛵");
        compGrid[x][y].setCompView("⛵");
        hidGrid[x][y].setHidView("⛵");
        hidGrid[x][y].setHumView("⛵");
        hidGrid[x][y].setCompView("⛵");

        System.out.println("Here is the board:");
        this.printCurrentGrid(this.makeHumView(humGrid));
        this.turn(1);
    }

    public void turn (int numMoves) {
        while (numMoves > 0) {
            numMoves--;
        }
        System.out.println("Computer's turn.");
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
