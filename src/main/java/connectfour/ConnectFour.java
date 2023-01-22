package connectfour;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class has the method setTurn and a main that is responsible for the
 * overall working of the connectFour game.
 * The class updates the pieces onto the board, asks the Board class to check
 * the winner of the game, and tells the TextUI class what to print
 *
 * @author Prateek
 */

public class ConnectFour{

    /**
     * This method sets the turn so that the ext player is able to place their piece.
     * @param turn this is the current player who just played their turn
     * @return "1" it returns the turn of the next player
     */
    public String setTurn(String turn) {
        if (turn == "1") {
            return "2";
        } else {
            return "1";
        }
    }

    /**
     * This method is used to save the board to a file.
     * @param fileName the name of the file to be save in
     * @param boardToSave the board that is to be saved
     */
    public void saveFile(String fileName, String[][] boardToSave){
        FileWriter pointerWrite = null;
        int i = 0;
        int j = 0;
        try{
            pointerWrite = new FileWriter(fileName);
            while (i < 6){
                j = 0;
                while (j < 7){
                    if (boardToSave[i][j] == "+"){  //replacing + with 0
                        boardToSave[i][j] = "0";
                    }
                    pointerWrite.append((boardToSave[i][j]));   //writing to file
                    pointerWrite.append(",");
                    j++;
                }
                pointerWrite.append("\n");
                i++;
            }
            pointerWrite.flush();
            pointerWrite.close();
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return "This is class ConnectFour.";
    }

    /**
     * This is the main that is used to run the game.
     * @param args this is for the command-line argument
     * @throws Exception gives exception when the user input is invalid
     */
    public static void main(String[] args) throws Exception {
        //objects
        TextUI objectText = new TextUI();
        ConnectFour objectConnect = new ConnectFour();
        Board objectBoard = new Board();

        String[][] boardInMain = objectBoard.connectBoard();    //connect-four board
        String finalTurn = "1";                                 //setting turn to player 1
        int userChoice;                                         //where to put the piece
        int numberOfTurns = 0;                                  //total number of turns
        boolean checkUserChoice = true;                         //to validate the user input
        int winnerInMain = 0;                                   //1 = player 1; 2 = player 2
        objectText.displayBoard();                              //displaying the board
        int continuePlaying = 8;                                //to continue the game
        String nameOfTheFile;                                   //to store the name of the file

        while (continuePlaying == 8){
            while(winnerInMain == 0 && numberOfTurns < 42){
                userChoice = objectText.userInput(finalTurn);
                if (userChoice == 9) {                              //user wants to save the file
                    nameOfTheFile = objectText.displaySaveFile();
                    objectConnect.saveFile(nameOfTheFile, boardInMain);
                }
                checkUserChoice = objectBoard.checkChoice(userChoice, boardInMain);
                if (!checkUserChoice) {
                    objectText.displayError();
                } else {
                    numberOfTurns++;
                    objectBoard.stateOfPiece(userChoice - 1, boardInMain, finalTurn); //board updated
                    winnerInMain = objectBoard.winner(boardInMain); //winner player if any
                    finalTurn = objectConnect.setTurn(finalTurn); //setting the next turn
                    objectText.printBoard(boardInMain);    //board displayed
                }
            }
            objectText.displayWinner(winnerInMain);             //display the winner of the game
            if (numberOfTurns == 42){                           //if the game is tie
                objectText.displayTie();
            }
            continuePlaying = objectText.toContinuePlaying();   //user wish to continue?
            if (continuePlaying != 8){                          //no?
                objectText.exitGame();
            } else{                                             //yes, set everything to its initial value:
                winnerInMain = 0;
                numberOfTurns = 0;
                finalTurn = "2";                                //player 2 starts the game now
                objectText.displayBoard();                      //display original board
                boardInMain = objectBoard.connectBoard();       //the new board
            }
        }
    }
}