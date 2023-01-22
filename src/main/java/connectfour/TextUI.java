package connectfour;

import java.util.Scanner;

/**
 * The class TextUI is responsible for scanning the inputs from the user, and
 * all the printing that is supposed to be displayed to the user.
 * It throws and exception message whenever the user input is incorrect,
 * displays the board,
 * displays the correct user message to facilitate the understanding of what is happening, and
 * it finally displays the winner of the game.
 * @author Prateek
 */
public class TextUI{

    /**
     * This displayBoard method is used to display the connect-four board to the user.
     */
    public void displayBoard(){
        Board objectBoard = new Board();
        TextUI objectTextUI = new TextUI();
        objectBoard.connectBoard();
        objectTextUI.printBoard(objectBoard.connectBoard());
    }

    /**
     * This method is used to display the appropraite message to the user,
     * to ask them to enter the input.
     * @param finalTurn this is the players whose turn it is
     * @return userChoice this returns what the user inputted
     */
    public int userInput(String finalTurn){
        Scanner input = new Scanner(System.in);
        System.out.println("Player " + finalTurn);
        System.out.println("Please enter your column choice (1-9): 9 to save and exit");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    /**
     * This is method that used to display the error message whenever the user input is wrong
     * @throws Exception error message displayed
     */
    public void displayError() throws Exception {
//        throw new Exception("Error: Please enter a correct choice.");
        System.out.println("Error: Please enter a correct choice.");
    }

    /**
     * The following method is used to print the board onto the screen to the user.
     * @param boardFromMain this is the board that is passed from the main
     */
    public void printBoard(String[][] boardFromMain){
        System.out.println(" ");
        int i = 0;
        int j = 0;
        for (i = 0; i < 6; i++){
            for (j = 0; j < 7; j++){
                System.out.print(boardFromMain[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method displays who won the game
     * @param winnerPlayer the player
     */
    public void displayWinner(int winnerPlayer){
        if (winnerPlayer == 1) {
            System.out.println("The winner of the game is player 1.");
        } else if (winnerPlayer == 2){
            System.out.println("The winner of the game is player 2.");
        }
    }

    /**
     * This method is used to check if the user wishes to play the game again
     * @return userChoice returns if the user wants to play again
     */
    public int toContinuePlaying(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you wish to play again? Press 8: ");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    /**
     * This method is used to display a tie message.
     */
    public void displayTie(){
        System.out.println("The game tied.");
    }

    /**
     * This is the method that allows the used to enter the name of the file where the partially compeleted game
     * could be saved.
     * @return userFileName it returns the name of the file
     */
    public String displaySaveFile(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the file name in which you want to save the game: ");
        String userFileName = input.nextLine();
        return userFileName;

    }

    /**
     * to exit the game.
     */
    public void exitGame(){
        System.exit(0);
    }

    public String toString(){
        return "TextUI";
    }

}