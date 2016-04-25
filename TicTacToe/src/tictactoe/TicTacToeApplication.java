/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author anurag
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        // Getting inputs
        while(doYouWantToPlay) {
            System.out.println("Welcome to Tic Tac Toe! \n Please pick your character and mine too");
            System.out.println("Enter a character you like");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a charact that represents me");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            
            // Setting up the game
            System.out.println("Let's begin: Enter a token from 1 to 9 \n");
            TicTacToe.printIndexBoard();
            System.out.println();
            
            //Let's play the game
            while(game.gameOver().equals("gameNotOver")) {
                if(game.currentMarker == game.userMarker) {
                    // it's user turn
                    System.out.println("Your turn! Enter a spot");
                    int spot = sc.nextInt();
                    while(!game.playTurn(spot)) {
                        System.out.println("Try again! This spot is already taken or is not valid");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");                 
                } else {
                    // it's the AI turn
                    System.out.println("It's my turn!");
                    // Getting the spot for AI
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot);
                }
                
                // Print the new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            
            // Setting up new game as per users request
            System.out.println("Enter y to continue or anything else to exit");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'y');
            System.out.println();
        }
    }   
}
