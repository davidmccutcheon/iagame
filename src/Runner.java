import java.util.*;

public class Runner {

    //To do next:
            // Set up landmines.
            // Make it possible to board.
            // Make sure saving actions works.

            //Consider making a playerIsPresent boolean instead of having it be a status

    public static void main (String args[]) {
        boolean theGameIsOn = true;

        Human human = new Human();
        Computer computer = new Computer();
        Position[][] hidGrid = new Position[10][10];

        human.setName();
        human.setWord(human.getName());
        computer.setWordArray(human.getWordArray());
        computer.setWord(computer.getName());

        human.scatterWord(hidGrid);
        computer.scatterWord(hidGrid);

        human.firstSpot(hidGrid);
        computer.firstSpot(hidGrid);
        System.out.println("STARTING BOARD: " + human.getName() + "'s view");
        human.printCurrentGrid(human.makeHumView(hidGrid));

        while (human.getChances() > 0 && computer.getChances() > 0) {
            human.turn(2 + human.getActionsSaved(), hidGrid);
            computer.turn(2 + computer.getActionsSaved(), hidGrid);
        }
    }

    //CODEBREAKER

    //BATTLESHIP ROUND
    //Computer and human each start by choosing a coordinate on the other player's array. Human starts (could try to
    //make a setting for computer starting) and the players take turns.

    //In a turn, a player has two moves. For each move, they can choose to move north, east, south or west; or they
    //can choose to guess that there is a ship on their spot; they can save their move. It takes five moves to move
    //a ship.

    //WORD GUESSING ROUND
    //Once one of the players has all the other's letters (or make it accessible anytime?) both start trying to guess
    //the other's word. Each has five tries or they lose; they can pass without sacrificing a try. If a player guesses
    //correctly, or their opponent loses, the player wins.

    //Views:
        //Human grid:       Symbols for positions of human ⛵ and computer 🚢, blank spots and undetected computer ships
        //                  🌊, human hit ships 💥, human undetected ships (with capital letter) and found computer ships ☠️.

        //Computer grid:    Symbols for positions of human ⛵ and computer 🚢, blank spots and undetected
        //                  human ships 🌊, computer hit ships 💥 and found human ships ☠️.

}
