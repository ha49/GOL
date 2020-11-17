package org.example.model;

public class Rules {


    public static int getStateOfCellAbove(int x, int y, Board board) {
        if (board.getCellState(x, y + 1) == CellState.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public static int getStateOfCellBelow(int x, int y, Board board) {
        if (board.getCellState(x, y - 1) == CellState.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public static int getStateOfCellRight(int x, int y, Board board) {
        if (board.getCellState(x+1, y ) == CellState.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }
    public static int getStateOfCellLeft(int x, int y, Board board) {
        if (board.getCellState(x-1, y ) == CellState.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }


}