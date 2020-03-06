import java.util.*;

public class Runner {

    //To do next:
            // Make the hid view the master view and just doing an automatic update of the others based off that
            // Use the above to allow moving / setting the xPos and yPos as well as scattering the word to automatically
            // create the right view. This should make everything easier for later so it's important to do now.

            //Then, set up a function so that the turns alternate. Consider making a Move class so you can set number
            //and types of moves.

    public static void main (String args[]) {
        Human human = new Human();
        Computer computer = new Computer();
        Position[][] humanGrid = new Position[10][10];
        Position[][] compGrid = new Position[10][10];
        Position[][] hidGrid = new Position[10][10];

        human.setName();
        human.setWord(human.getName());
        computer.setWordArray(human.getWordArray());
        computer.setWord(computer.getName());

        human.scatterWord(humanGrid, compGrid, hidGrid);
        computer.scatterWord(humanGrid, compGrid, hidGrid);

        System.out.println("STARTING BOARD: " + human.getName() + "'s view");
        human.printCurrentGrid(human.makeHumView(humanGrid));
        human.firstSpot(humanGrid, compGrid, hidGrid);
        computer.firstSpot(humanGrid, compGrid, hidGrid);
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


    //Arrays:
        //Human grid:       Symbols for positions of human ⛵ and computer 🚢, blank spots and undetected computer ships
        //                  🌊, human hit ships 💥, human undetected ships (with capital letter) and found computer ships ☠️.

        //Computer grid:    Symbols for positions of human ⛵ and computer 🚢, blank spots and undetected
        //                  human ships 🌊, computer hit ships 💥 and found human ships ☠️.

        //Hid grid:         Symbols for positions of human ⛵ and computer 🚢, blank spots and undetected human ships 🌊,
        //                  computer hit ships 💥, computer undetected ships (with capital letter) and found human ships ☠️.

}
