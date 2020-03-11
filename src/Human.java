import java.util.*;

public class Human extends Player {
    Scanner hsc = new Scanner(System.in);

    public Human () {
        super("Human");
    }

    public void setName() {
        System.out.println("Enter a username:");
        String userName = hsc.next();
        System.out.println("Your name is " + userName + ". Your spot on the board will be occupied by the sign ⛵; the computer's spot will be occupied by the sign \uD83D\uDEA2.");
        setName(userName);
    }

    public void scatterWord(Position[][] hidGrid) {
        for (int i = 0; i < this.getWord().length(); i++) {
            int x = 1;
            int y = 1;
            System.out.println("You are now going to place the letter " + getWord().substring(i, i + 1) + ". Type in an " +
                    "x-coordinate first, from 1 to 10.");
            x = coordinateHandling("word placement along the x-axis", x, hidGrid);
            System.out.println("Now, type in a y-coordinate, again from 1 to 10.");
            y = coordinateHandling("word placement along the y-axis", y, hidGrid);
                Position pos = new Position(x, y);
                pos.setLetter(getWord().substring(i, i + 1));
                pos.setStatus("hidHumanShip");
                hidGrid[x][y] = pos;
        }
        for (int i = 0; i < hidGrid.length; i++) {
            for (int j = 0; j < hidGrid[i].length; j++) {
                if (hidGrid[i][j] == null) {
                    hidGrid[i][j] = new Position(i + 1, j + 1);
                    hidGrid[i][j].setStatus("empty");
                }
            }
        }
    }

    public int coordinateHandling(String process, int x, Position[][] hidGrid) {
        if (hsc.hasNextInt()) {
            x = hsc.nextInt() - 1;
        } else {
            System.out.println("That didn't work. Please try again.");
            if (hsc.hasNextInt()) {
                x = hsc.nextInt() - 1;
            } else {
                System.out.println("That didn't work either. You will now restart " + process + ".");
                coordinateHandling(process, x, hidGrid);
            }
        }
        return x;
    }

    public void firstSpot(Position[][] hidGrid) {
        int x = 1;
        int y = 1;
        System.out.println("");
        System.out.println("Pick a coordinate to land first. You will have to move spot by spot from here for the rest of the game.");
        System.out.println("x-coordinate: ");
        x = coordinateHandling("position selection along the x-axis", x, hidGrid);
        this.setxPos(x);
        System.out.println("y-coordinate");
        y = coordinateHandling("position selection along the y-axis", y, hidGrid);
        this.setyPos(y);

        hidGrid[x][y].setStatus("hum");

        System.out.println("Here is the board:");
        this.printCurrentGrid(this.makeHumView(hidGrid));
    }

    public void turn (int numMoves, Position[][] hidGrid) {
        while (numMoves > 0) {
            System.out.println("");
            System.out.println("For this action, your three choices are to move, board a spot next to you, or save a move. Please choose by typing 'move', 'board' or 'save'");
            switch (hsc.next()) {
                case "move":
                    System.out.println("You have chosen to move. Please indicate compass direction by typing 'N', 'E', 'S', 'W', 'NE', 'NW', 'SE' or 'SW'.");
                    int[] mIQ = chooseDirection(hsc.next());
                    hidGrid[mIQ[0]][mIQ[1]].setStatus("hum");
                    //this just sets to empty for now; use letter to figure out how to really set it
                    hidGrid[this.getxPos()][this.getyPos()].setStatus("empty");
                    this.printCurrentGrid(this.makeHumView(hidGrid));
                    break;
                case "board":
                    System.out.println("You have chosen to board. Please indicate compass direction by typing 'N', 'E', 'S', 'W', 'NE', 'NW', 'SE' or 'SW'.");
                    int[] hIQ = chooseDirection(hsc.next());
                    if (hidGrid[hIQ[0]][hIQ[0]].getStatus().equals("empty")) {
                        System.out.println("There is nothing to board at the selected spot. Your action is over.");
                    } else {
                        System.out.println("There is something here to board. Would you like to proceed with boarding? Please type 'yes' to proceed or anything else to stop here.");
                        if(hsc.next().equals("yes")) {
                            String posStat = hidGrid[hIQ[0]][hIQ[1]].getStatus();
                            switch (posStat) {
                                case "comp":
                                    System.out.println("You are trying to board the other player. Action terminated without result.");
                                    break;
                                case "hidHumanShip":
                                    System.out.println("You are trying to board your own ship. Action terminated without result.");
                                    break;
                                case "hidCompShip":
                                    System.out.println("Congratulations, you have boarded a ship! The letter here is " + hidGrid[hIQ[0]][hIQ[1]].getLetter() + ".");
                                    break;
                                case "foundHumanShip":
                                    System.out.println("You are trying to board your own ship. Action terminated without result.");
                                    break;
                                case "foundCompShip":
                                    System.out.println("You have already boarded this ship. The letter here is " + hidGrid[hIQ[0]][hIQ[1]].getLetter() + ".");
                                    break;
                                case "hidLandmine":
                                    System.out.println("Unfortunately, you have just boarded a landmine. Your choice is between two penalties: type 'A' to reveal the position of one of your own ships or press 'B' to lose a chance to guess your opponent's word.");
                                    switch (hsc.next()) {
                                        case "A":
                                            //not sure how to do this yet
                                            break;
                                        case "B":
                                            this.setChances(getChances() - 1);
                                            break;
                                        default:
                                            System.out.println("You have not selected a valid option. Option B was automatically selected for you.");
                                            this.setChances(getChances() - 1);
                                            break;
                                    }
                                    break;
                                case "foundLandmine":
                                    System.out.println("You have already found this landmine. Type 'A' to end the game or type anything else to terminate this action without result.");
                                    switch (hsc.next()) {
                                        case "A":
                                            //not sure how to do this yet
                                            break;
                                        default:
                                            System.out.println("Action terminated without result.");
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            System.out.println("Action terminated.");
                        }
                    }
                    break;
                case "save":
                    System.out.println("Move saved.");
                    saveAnAction();
                    break;
                default:
                    System.out.println("Error encountered. Please try again.");
                    turn(numMoves, hidGrid);
                    break;
            }
            numMoves--;
            System.out.println(numMoves + " action(s) left.");
        }
        System.out.println("Computer's turn.");
    }

    public int[] chooseDirection(String indicator) {
        int curX = this.getxPos();
        int curY = this.getyPos();
        int xIQ;
        int yIQ;
        //currently doesn't work: W is E, E is W, etc.
        switch(indicator) {
            case "N":
                xIQ = curX;
                yIQ = curY + 1;
                break;
            case "E":
                xIQ = curX + 1;
                yIQ = curY;
                break;
            case "S":
                xIQ = curX;
                yIQ = curY - 1;
                break;
            case "W":
                xIQ = curX - 1;
                yIQ = curY;
                break;
            case "NE":
                xIQ = curX + 1;
                yIQ = curY + 1;
                break;
            case "NW":
                xIQ = curX - 1;
                yIQ = curY + 1;
                break;
            case "SE":
                xIQ = curX + 1;
                yIQ = curY - 1;
                break;
            case "SW":
                xIQ = curX - 1;
                yIQ = curY - 1;
                break;
            default:
                xIQ = curX;
                yIQ = curY;
                break;
        }
        int[] result = {xIQ, yIQ};
        return result;
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
