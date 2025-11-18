package org.example.boards;

import org.example.game.Board;
import org.example.game.Cell;

public class TicTacToeBoard extends Board {
    private String cells[][] = new String[3][3];

    public String getCells(int row, int col){
        return cells[row][col];
    }

    public void setCells(Cell cell, String symbol){
        cells[cell.getRow()][cell.getCol()] = symbol;
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(cells[i][j]==null){
                    result += "_ ";
                }else{
                    result += cells[i][j]+" ";
                }
            }
            result += "\n";
        }
        return result;
    }
}

