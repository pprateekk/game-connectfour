package connectfour;

import java.util.Objects;

/**
 *  The Board class maintains the board by putting the user pieces onto the board.
 *  It creates the connect-four board that is printed by the TextUI class,
 *  validates the user input, and
 *  checks for the winner: player 1 or player 2
 *  @author Prateek
 */
public class Board{
    private String[][] board;       //declaring a field/variable

    /**
     * This is a contructor used to initialize the string/board.
     */
    public Board(){                 //constructor to initialize the board
        board = new String[6][7];
    }

    /**
     * This method is responsible for setting up the game board.
     * @return board this is the connect-four board that is returned
     */
    public String[][] connectBoard(){
        int i = 0;
        int j = 0;
        for (i = 0; i < 6; i++){
            for (j = 0; j < 7; j++){
                board[i][j] = "+";
            }
        }
        return board;
    }

    /**
     * The method is used to validate the user input.
     * The input should be within the range 1-8, since there are 7 columns, and
     * the user input should not be out-of-bounds, that is the user cannot place a piece
     * after all the pieces are filled within the same column.
     * @param column    the user input/column where the piece is to be placed
     * @param boardCheck the game board
     * @return true it returns true if the user input is entered correctly
     */
    public boolean checkChoice(int column, String[][]boardCheck){
        if (column <= 0 || column > 9){
            return false;
        } else if (column == 8){
            return false;
        }
        if (board[0][column-1] != "+"){
                return false;
        }
        return true;
    }

    /**
     * This method helps to put the player piece onto the board.
     * @param columnChoice this is the user choice/column where the piece has to be out
     * @param boardPlace   this represents the game board
     * @param player       this is the turn of the player whose piece is to be placed
     * @return returnValue if it is equal to 1, it means that the piece has been successfully placed
     */
    public int stateOfPiece(int columnChoice, String[][] boardPlace, String player){
        int returnValue = 0; //0 if not successful
        int i = 5;
        for (i = 5; i >= 0; i--){ //last row available piece
            if (boardPlace[i][columnChoice] == "+"){
                boardPlace[i][columnChoice] = player;
                returnValue = 1;
                break;
            }
        }
        return returnValue;
    }

    /**
     * The following method is used to check who is the winner of the game.
     * It checks for the winner vertically, horizontally, and diagonally (from bottom-left to top-right
     * and from top-left to bottom-right)
     * @param boardWinner this is the game board
     * @return playerWin this is the player who wins the game
     */
    public int winner(String[][] boardWinner){
        int playerWin = 0;
        for (int i = 0; i < 3; i++){ //i < 6-3 for vertical //check for vertical winner
            for (int j = 0; j < 7; j++) {
                if ((Objects.equals(boardWinner[i][j], boardWinner[i+1][j]))
                        && (Objects.equals(boardWinner[i][j], boardWinner[i+2][j]))
                        && (Objects.equals(boardWinner[i][j], boardWinner[i+3][j]))){
                    if ((Objects.equals(boardWinner[i][j], "1")) || (Objects.equals(boardWinner[i][j], "2"))){
                        playerWin = Integer.parseInt(boardWinner[i][j]); break;
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++){ //check for horizontal winner
            for (int j = 0; j < 4; j++) { //i < 7-3 for horizontal
                if((boardWinner[i][j] == boardWinner[i][j+1]) && (boardWinner[i][j] == boardWinner[i][j+2])
                        && (boardWinner[i][j] == boardWinner[i][j+3])){
                    if (boardWinner[i][j] == "1" || boardWinner[i][j] == "2"){
                        playerWin = Integer.parseInt(boardWinner[i][j]); break;
                    }
                }
            }
        }
        for (int i = 3; i < 6; i++){ //check for upward diagonal
            for (int j = 0; j < 4; j++) { //i < 7-3 for udiag
                if((boardWinner[i][j] == boardWinner[i-1][j+1]) && (boardWinner[i][j] == boardWinner[i-2][j+2])
                        && (boardWinner[i][j] == boardWinner[i-3][j+3])){
                    if (boardWinner[i][j] == "1" || boardWinner[i][j] == "2"){
                        playerWin = Integer.parseInt(boardWinner[i][j]); break;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++){ //check for downward diagonal
            for (int j = 0; j < 4; j++) {
                if((boardWinner[i][j] == boardWinner[i+1][j+1]) && (boardWinner[i][j] == boardWinner[i+2][j+2])
                        && (boardWinner[i][j] == boardWinner[i+3][j+3])){
                    if (boardWinner[i][j] == "1" || boardWinner[i][j] == "2"){
                        playerWin = Integer.parseInt(boardWinner[i][j]); break;
                    }
                }
            }
        }
        return playerWin;
    }

    public String toString(){
        return "This is Board class.";
    }

}