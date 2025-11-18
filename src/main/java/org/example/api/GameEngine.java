package org.example.api;

import org.example.boards.TicTacToeBoard;
import org.example.game.*;


public class GameEngine {
    public Board start(String gameType) {
        if (gameType.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void makeMove(Board board, Move move, Player player) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            ticTacToeBoard.setCells(move.getCell(), player.getSymbol());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public GameResult isComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            boolean isRowWin = true;
            boolean isColWin = true;
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            String firstChar = "";
            for (int i = 0; i < 3; i++) {
                firstChar = ticTacToeBoard.getCells(i, 0);
                isRowWin = firstChar != null;
                if (firstChar != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstChar.equals(ticTacToeBoard.getCells(i, j))){
                            isRowWin = false;
                            break;
                        }
                    }
                    if (isRowWin) {
                        break;
                    }
                }
            }

            if (isRowWin) {
                return new GameResult(true, firstChar);
            }

            for (int i = 0; i < 3; i++) {
                firstChar = ticTacToeBoard.getCells(0, i);
                isColWin = firstChar!=null;
                if(firstChar!=null){
                for (int j = 1; j < 3; j++) {
                    if (!firstChar.equals(ticTacToeBoard.getCells(j, i))){
                        isColWin = false;
                        break;
                    }
                }
                if (isColWin) {
                    break;
                }
            }}

            if (isColWin) {
                return new GameResult(true, firstChar);
            }

            firstChar = ticTacToeBoard.getCells(0, 0);
            boolean isDiagonalWin = firstChar!=null;
            for (int i = 1; i < 3; i++) {
                if(firstChar!=null){
                    if (!firstChar.equals(ticTacToeBoard.getCells(i, i))) {
                        isDiagonalWin = false;
                        break;
                    }
                }
            }

            if (isDiagonalWin) {
                return new GameResult(true, firstChar);
            }

            firstChar = ticTacToeBoard.getCells(0, 2);
            boolean isRevDiagonalWin = firstChar!=null;
            for (int i = 1; i < 3; i++) {
                if(firstChar!=null){
                    if (!firstChar.equals(ticTacToeBoard.getCells(i, 2 - i))){
                        isRevDiagonalWin = false;
                        break;
                    }
                }
            }

            if (isRevDiagonalWin) {
                return new GameResult(true, firstChar);
            }

            int cellFilledCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (ticTacToeBoard.getCells(i, j) != null) {
                        cellFilledCount++;
                    }
                }
            }

            if (cellFilledCount == 9) {
                return new GameResult(true, "It is a Draw");
            } else {
                return new GameResult(false, "");
            }
        } else {
            return new GameResult(false, "");
        }
    }


    public Move suggestComputerMove(Board board, Move playerMove) {
        if (board instanceof TicTacToeBoard) {
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (((TicTacToeBoard) board).getCells(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
            throw new IllegalStateException();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

