package org.example.game;

public class Move {
    private Cell cell;

    public Move(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell(){
        return cell;
    }
}
