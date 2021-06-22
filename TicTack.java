import java.util.Scanner;

public class TicTack {

	 static Scanner value = new Scanner(System.in);

	    public static void main(String args[]) {

	        //Create a 3x3 array that represents the tic tac toe board
	        char[][] board = new char[3][3];

	        //Initialize the board with dashes (empty positions)
	        System.out.println("Game initiated!");
	        for(int i = 0; i < 3; i++) {
	            for(int j = 0; j < 3; j++) {
	                board[i][j] = '-';
	            }
	        }

	        //Check who plays first
	        System.out.println("Let's start the Tic Tac Toe game!");
	        String player = checkPlayFirst();
	        System.out.println(player + " plays first.");

	        //Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
	        boolean player1 = true;

	        //Create a gameEnded boolean and use it as the condition in the while loop
	        boolean gameEnded = false;
	        while(!gameEnded) {
	            //Draw the board
	            showBoard(board);

	            //Select X or O
	            char inputCharUser = playerInput(player);

	            //Enter position of the input
	            userPosition(inputCharUser, board);

	            //Check to see if either player has won
	            if(playerHasWon(board) == 'X') {
	                System.out.println(player + " wins!");
	                gameEnded = true;
	            }
	            else if(playerHasWon(board) == 'O') {
	                System.out.println(player + " wins!");
	                gameEnded = true;
	            }
	            else {
	                //If neither player has won, check to see if there has been a tie (if the board is full)
	                if(boardIsFull(board)) {
	                    System.out.println("It's a tie!");
	                    gameEnded = true;
	                } else {
	                    //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
	                    player1 = !player1;
	                }
	            }
	            while(gameEnded == true) {
	                System.out.println("Play another game? Y | N");
	                char option = value.next().charAt(0);

	                if(option == 'Y') {
	                    //Initilise the board with '-' to again start playing
	                    gameEnded = false;
	                    for (int i = 0; i < 3; i++) {
	                        for (int j = 0; j < 3; j++) {
	                            board[i][j] = '-';
	                        }
	                    }
	                }
	                else
	                    break;
	            }
	        }

	        //Final game board
	        showBoard(board);
	    }

	    //Initiate the game by asking the player to choose the input
	    public static char playerInput(String player) {
	        System.out.println("Enter the input to begin the game: X | O: ");
	        char inputChar = value.next().charAt(0);

	        return inputChar;
	    }

	    //Display the board
	    public static void showBoard(char[][] board) {
	        System.out.println("Board");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("\n");
	    }

	    //Ask the user for what position they want to place their x or o
	    public static void userPosition(char inputCharUser, char[][] board) {
	        int row = 0;
	        int col = 0;

	        //Only break out of the while loop once the user enters a valid position
	        while(true) {
	            System.out.print("Enter a row number (0, 1, or 2): ");
	            row = value.nextInt();
	            System.out.print("Enter a column number (0, 1, or 2): ");
	            col = value.nextInt();

	            //Check if the row and col are 0, 1, or 2
	            if (row < 0 || col < 0 || row > 2 || col > 2)
	                System.out.println("This position is out of the bounds of the board! Try again!" + "\n");

	                //Check if the position on the board the user entered is empty or not
	            else if (board[row][col] != '-')
	                System.out.println("Someone has already made a move at this position! Try again!" + "\n");

	                //If none of the above condition fulfils then input the value
	            else
	                break;
	        }
	        board[row][col] = inputCharUser;
	    }

	    //Check who plays first
	    public static String checkPlayFirst() {
	        int randomNumber = (int) Math.floor(Math.random() * 10) % 2;
	        String player = "";
	        if ( randomNumber == 0)
	            player = "Computer";
	        else
	            player = "User";

	        return player;
	    }

	    //Check if someone has won
	    public static char playerHasWon(char[][] board) {

	        //Check each row
	        for(int i = 0; i < 3; i++) {
	            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
	                return board[i][0];
	            }
	        }

	        //Check each column
	        for(int j = 0; j < 3; j++) {
	            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
	                return board[0][j];
	            }
	        }

	        //Check the diagonals
	        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
	            return board[0][0];
	        }
	        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
	            return board[2][0];
	        }

	        //Otherwise nobody has not won yet
	        return ' ';
	    }

	    //Check if all of the positions on the board have been filled
	    public static boolean boardIsFull(char[][] board) {
	        for(int i = 0; i < 3; i++) {
	            for(int j = 0; j < 3; j++) {
	                if(board[i][j] == '-') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}