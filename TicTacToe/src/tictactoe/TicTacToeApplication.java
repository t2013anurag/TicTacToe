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
        while(doYouWantToPlay) {
            System.out.println("Welcome to Tic Tac Toe! \n Please pick your character and mine too");
            System.out.println("Enter a character you like");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a charact that represents me");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            
        }
    }
    
}
