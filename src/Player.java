import java.util.*;

public class Player {
    Scanner psc = new Scanner(System.in);

    private String[] smallOptions = {"ab", "cd", "ef", "gh", "ij"};
    private String[] mediumOptions = {"kl", "mn", "op", "qr", "st"};
    private String[] largeOptions = {"uv", "wx", "yz", "AB", "CD"};
    private String[] wordArray;

    private int xPos;
    private int yPos;

    private String name;
    private String word;
    private int movesSaved;

    public Player(String name) {
        this.name = name;
        this.movesSaved = 0;
    }

    public void setWord(String name) {
        if (!name.equals("Computer")) {
            System.out.println("Type 'easy', 'medium' or 'hard' to select game difficulty");
            String levelRequest = psc.next();
            if (levelRequest.equals("easy")) {
                setWordArray(getSmallOptions());
                System.out.println("Your level is EASY");
            } else if (levelRequest.equals("medium")) {
                setWordArray(getMediumOptions());
                System.out.println("Your level is MEDIUM");
            } else if (levelRequest.equals("hard")) {
                setWordArray(getLargeOptions());
                System.out.println("Your level is HARD");
            } else {
                System.out.println("Please try again");
                setWord(name);
            }
        }

        int randomNum = 3;
        this.word = this.wordArray[randomNum];
    }

    public void printCurrentGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println("");
            for(int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
                if (!grid[i][j].equals("\uD83C\uDF0A")) {
                    if (!grid[i][j].equals("⛵")) {
                        if(!grid[i][j].equals("\uD83D\uDEA2")) {
                            System.out.print(" ");
                        }
                    }
                }
            }
        }
    }

    public String[] getSmallOptions() {
        return smallOptions;
    }

    public String[] getMediumOptions() {
        return mediumOptions;
    }

    public String[] getLargeOptions() {
        return largeOptions;
    }

    public void setWordArray(String[] wordArray) {
        this.wordArray = wordArray;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getWordArray() {
        return wordArray;
    }

    public String getWord() {
        return word;
    }

    public int getMovesSaved() {
        return movesSaved;
    }

    public void saveAMove() {
        this.movesSaved++;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
