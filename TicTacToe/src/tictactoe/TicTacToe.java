/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author anurag
 */
public class TicTacToe {
    protected char[] board;
    protected char userMarker;
    protected char aiMarker;
    protected char winner;
    protected char currentMarker;

    public TicTacToe(char playerToken, char aiToken){
        this.userMarker = playerToken;
        this.aiMarker = aiToken;
        this.winner = '-';
        this.board = setBoard();
        this.currentMarker = userMarker;//letting user play first turn
    }

    // Making the setBoard method static as it just initializes the board to
    // board;
    public static char[] setBoard() {
        char[] board = new char[9];
        for(int i = 0; i < board.length; i++)
            board[i] = '-';
        return board;
    }
    
    public boolean playTurn(int spot) {
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if(isValid) {
            board[spot-1] = currentMarker;
            // Flipping the turns (turn change)
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }
    
    //Checking is the spot is in range from 1 to 10
    public boolean withinRange(int number) {
        return number> 0 && number < board.length + 1;
    }
    
    //Checking if the spot is already taken is it's not equal to '-'
    public boolean isSpotTaken(int number) {
        return board[number-1] != '-';
    }
    
    public void printBoard() {
        System.out.println();
        for(int i = 0 ; i < board.length; i++) {
            if(i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("---------------");
            }
            System.out.print(" | " + board[i]);
        }
        System.out.println();
    }
    
    public static void printIndexBoard() {
        System.out.println();
        for(int i = 0 ; i < 9; i++) {
            if(i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("---------------");
            }
            System.out.print(" | " + (i + 1));
        }
        System.out.println();
    }
    
    public boolean isThereAWinner(){
        // board[4] != '-'; is checked so that conditions doesn't hold when the game begins
        // as at the beginning rightDi() || leftDi() || middleRow() || secondCol() will be
        // true, so we need to avoid it by checking the null or dashed value in the middle
        // as all the 4 methods have center column ( so checking if centre is not dash)
        // obviously states for others also not to be dashed;
        
        //Simple terms : winner can't be dash character
        boolean diagonalsAndMiddles = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
        boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-'; //as 1 is present in both methods
        boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';
        if(diagonalsAndMiddles) {
            this.winner = board[4]; // winner is in position 4
        }
        if(topAndFirst) {
            this.winner = board[0];
        }
        if(bottomAndThird) {
            this.winner = board[8];
        }
        return diagonalsAndMiddles || topAndFirst || bottomAndThird; // returns true if winner
    }
    
    public boolean topRow() {
        return board[0] == board[1] && board[1] == board[2];
    }
    
    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }
    
    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }
    
    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }
     
    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }
    
    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }
    
    public boolean rightDi() {
        return board[0] == board[4] && board[4] == board[8];
    }
     
    public boolean leftDi() {
        return board[2] == board[4] && board[4] == board[6];
    }
    
    public boolean isTheBoardFilled() {
        for(int i = 0; i < board.length; i++) {
            if(board[i] == '-') {
                return false;
            }
        }
        return true;
    }
    
    public String gameOver() {
        boolean didSomeoneWin = isThereAWinner();
        if(didSomeoneWin) {
            return "We had a winner! The winner is " + this.winner;
        } else if(isTheBoardFilled()) {
            return "Draw : Game Over!";
        } else {
            return "gameNotOver";
        }
    }
}