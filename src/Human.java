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
                x = hsc.nextInt();
            } else {
                System.out.println("That didn't work. Please try again.");
                if (hsc.hasNextInt()) {
                    x = hsc.nextInt();
                } else {
                    System.out.println("That didn't work either. You will now restart word placement.");
                    scatterWord(humGrid, compGrid, hidGrid);
                }
            }
            System.out.println("Now, type in a y-coordinate, again from 1 to 10.");
            if (hsc.hasNextInt()) {
                y = hsc.nextInt();
            } else {
                System.out.println("That didn't work. Please try again.");
                if (hsc.hasNextInt()) {
                    y = hsc.nextInt();
                } else {
                    System.out.println("That didn't work either. You will now restart word placement.");
                    y++;
                    scatterWord(humGrid, compGrid, hidGrid);
                }
            }
//            if (hidGrid[x][y].getLetter().equals("z")) {
//                System.out.println("There is already a ship in that position. Please set the word again.");
//                scatterWord(humGrid, compGrid, hidGrid);
//            } else {
                Position pos = new Position(x, y);
                pos.setHumView(getWord().substring(i));
                humGrid[x][y] = pos;
                compGrid[x][y] = pos;
                hidGrid[x][y] = pos;
            //}
        }
        Position[][][] group = {humGrid, compGrid, hidGrid};
        return group;
    }
}
