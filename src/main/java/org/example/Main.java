package org.example;

import org.example.api.GameEngine;
import org.example.game.Board;
import org.example.game.Cell;
import org.example.game.Move;
import org.example.game.Player;

import java.lang.reflect.Array;
import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");

        Scanner input = new Scanner(System.in);
        while(!gameEngine.isComplete(board).isComplete()){
            Player player = new Player("X");
            Player computer = new Player("O");

            System.out.println(board);;
            System.out.println("Make your move!");
            System.out.println("Row : ");
            int row = input.nextInt();

            System.out.println("Col : ");
            int col = input.nextInt();

            Cell cell = new Cell(row, col);
            Move playerMove = new Move(cell);
            gameEngine.makeMove(board, playerMove, player);

            if(!gameEngine.isComplete(board).isComplete()){
                Move computerMove = gameEngine.suggestComputerMove(board,playerMove);
                gameEngine.makeMove(board, computerMove, computer);
            }
        }

        System.out.println(board);
        System.out.println("Game Result : " + gameEngine.isComplete(board).isComplete());
        System.out.println("Game Winner : " + gameEngine.isComplete(board).getWinner());
    }
}
