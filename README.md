# game-connectfour

## Description

The assignment uses Object Oriented Programming to create a Connect Four game where two players plays against each sharing the same computer. 
The program consists of total 3 classes:

Board.java - Board class is mainly concerned with the maintainance of the board and its setup. It has various methods that allows the good functioning of the game as it has a method that validates the user input, a method that checks for the winner and a method that put the pieces in place onto the board. 

TextUI.java - TextUI class is responsible for all the interaction that takes places between the users and the computer. It's main role is to display correct and meaningful messages and to take the inputs from the users.  

ConnectFour.java - ConnectFour class is used to change the turns of the player, and has a method that helps to save the contents of the board to a file. This class contains the main which is responsible for using methods from all the classes that helps in the running of the program.


Test Cases for methods in Board class have also been created that are implemented as Junit tests.
Please see the testCases.pdf file for the Test Cases.

## Executing the program

To build the program, the user must enter:
```
gradle run
```
To run the program:
```
java -cp build/classes/java/main connectfour.ConnectFour
```
To test the test cases:
```
gradle clean test
```
To create Javadoc:
```
gradle javadoc
```

## Sample Output

$ gradle run <br>
$ java -cp build/classes/java/main connectfour.ConnectFour<br>

+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>

Player 1<br>
Please enter your column choice (1-9): 9 to save and exit<br>
1<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
1++++++<br>

Player 2<br>
Please enter your column choice (1-9): 9 to save and exit<br>
2<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
12+++++<br>

Player 1<br>
Please enter your column choice (1-9): 9 to save and exit<br>
1<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
1++++++<br>
12+++++<br>

Player 2<br>
Please enter your column choice (1-9): 9 to save and exit<br>
2<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
12+++++<br>
12+++++<br>

Player 1<br>
Please enter your column choice (1-9): 9 to save and exit<br>
4<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
12+++++<br>
12+1+++<br>

Player 2<br>
Please enter your column choice (1-9): 9 to save and exit<br>
2<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+2+++++<br>
12+++++<br>
12+1+++<br>

Player 1<br>
Please enter your column choice (1-9): 9 to save and exit<br>
1<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
12+++++<br>
12+++++<br>
12+1+++<br>

Player 2<br>
Please enter your column choice (1-9): 9 to save and exit<br>
2<br>
 
+++++++<br>
+++++++<br>
+2+++++<br>
12+++++<br>
12+++++<br>
12+1+++<br>

The winner of the game is player 2.<br>
Do you wish to play again? Press 8: <br>
8<br>
 
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>
+++++++<br>

Player 2<br>
Please enter your column choice (1-9): 9 to save and exit<br>


## Limitations

The program doesn't support the loading of a gaming from another file. <br>
