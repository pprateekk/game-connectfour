package connectfour;

import org.junit.Assert;
import org.junit.Test;


public class BoardTest{

    //testcases for UserInput Validation: checkChoice()
    @Test
    public void userInputGreater(){
        Board newObject = new Board();
//        String[][] board = newObject.connectBoard();
        Assert.assertFalse(newObject.checkChoice(8, newObject.connectBoard()));
    }

    @Test
    public void userInputSmaller(){
        Board newObject = new Board();
        String[][] board = newObject.connectBoard();
        Assert.assertFalse(newObject.checkChoice(0, board));
    }

    @Test
    public void userInputGreat(){
        Board newObject = new Board();
        String[][] board = newObject.connectBoard();
        Assert.assertFalse(newObject.checkChoice(100, board));
    }

    //testcases for successfully placing the piece onto the board
    @Test
    public void testStateOfPiece1(){
        Board newObject = new Board();
        String[][] board = newObject.connectBoard();

        int actualResult1 = newObject.stateOfPiece(1, board, "1");
        Assert.assertEquals(1, actualResult1);
    }

    @Test
    public void testStateOfPiece2() { //for player 2
        Board newObject = new Board();
        String[][] board = newObject.connectBoard();

        int actualResult2 = newObject.stateOfPiece(1, board, "2");
        Assert.assertEquals(1, actualResult2);
    }

    //testCases to check the winner method
    @Test
    public void testWinner(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[1][2] = "1";
        boardInTest[2][2] = "1";
        boardInTest[3][2] = "1";
        boardInTest[4][2] = "1";
        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }

    @Test
    public void testWinner2(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[2][4] = "2";
        boardInTest[3][4] = "2";
        boardInTest[4][4] = "2";
        boardInTest[5][4] = "2";
        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(2, winnerReturn);
    }

    @Test
    public void testWinner3(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[0][6] = "1";
        boardInTest[1][6] = "1";
        boardInTest[2][6] = "1";
        boardInTest[3][6] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }

    @Test
    public void testWinner4(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[0][3] = "1";
        boardInTest[0][4] = "1";
        boardInTest[0][5] = "1";
        boardInTest[0][6] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }

    @Test
    public void testWinner5(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[3][2] = "1";
        boardInTest[3][3] = "1";
        boardInTest[3][4] = "1";
        boardInTest[3][5] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }

    @Test
    public void testWinner6(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[5][0] = "1";
        boardInTest[5][1] = "1";
        boardInTest[5][2] = "1";
        boardInTest[5][3] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }

    //checking for diagonals
    @Test
    public void testWinner7(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[2][3] = "2";
        boardInTest[3][4] = "2";
        boardInTest[4][5] = "2";
        boardInTest[5][6] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(0, winnerReturn);
    }

    @Test
    public void testWinner8(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[0][6] = "1";
        boardInTest[1][5] = "1";
        boardInTest[2][4] = "1";
        boardInTest[3][3] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }

    @Test
    public void testWinner9(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[5][0] = "2";
        boardInTest[4][1] = "2";
        boardInTest[3][2] = "2";
        boardInTest[2][3] = "2";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(2, winnerReturn);
    }

    @Test
    public void testWinner10(){
        Board objectBoard = new Board();
        String[][] boardInTest = objectBoard.connectBoard();  //connect-four board
        boardInTest[3][0] = "1";
        boardInTest[2][1] = "1";
        boardInTest[1][2] = "1";
        boardInTest[0][3] = "1";

        int winnerReturn = 0;
        winnerReturn = objectBoard.winner(boardInTest);
        Assert.assertEquals(1, winnerReturn);
    }


}
