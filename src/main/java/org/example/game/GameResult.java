package org.example.game;

public class GameResult {
    boolean isComplete;
    String winner;

    public GameResult(boolean isComplete, String winner) {
        this.isComplete = isComplete;
        this.winner = winner;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getWinner() {
        return winner;
    }
}
