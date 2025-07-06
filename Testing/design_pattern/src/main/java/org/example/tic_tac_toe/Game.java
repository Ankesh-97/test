package org.example.tic_tac_toe;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> player;

    public Game() {
    }

    public Game(Board board, List<Player> player) {
        this.board = board;
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public boolean play(int row, int col, String symbol) {
        if (board.addSymbol(symbol, row, col)) {
            return true;
        } else {
            System.out.println("Failed to add symbol");
            return false;
        }
    }
}
