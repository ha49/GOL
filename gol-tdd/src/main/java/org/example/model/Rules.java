package org.example.model;

public class Rules {

    public int countAliveNeighbours(int x, int y, Board board) {
        int count = 0;
        count = count +
                stateOfCellAbove(x, y, board) +
                stateOfCellBelow(x, y, board) +
                stateOfCellRight(x, y, board) +
                stateOfCellLeft(x, y, board) +
                stateOfCellUpRight(x, y, board) +
                stateOfCellUpLeft(x, y, board) +
                stateOfCellDownRight(x, y, board) +
                stateOfCellDownLeft(x, y, board);


        return count;
    }

    public int stateOfCellAbove(int x, int y, Board board) {
        if (board.getState(x, y + 1) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public int stateOfCellBelow(int x, int y, Board board) {
        if (board.getState(x, y - 1) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public int stateOfCellRight(int x, int y, Board board) {
        if (board.getState(x + 1, y) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public int stateOfCellLeft(int x, int y, Board board) {
        if (board.getState(x - 1, y) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }


    public int stateOfCellUpRight(int x, int y, Board board) {
        if (board.getState(x + 1, y + 1) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public int stateOfCellDownRight(int x, int y, Board board) {
        if (board.getState(x + 1, y - 1) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public int stateOfCellUpLeft(int x, int y, Board board) {
        if (board.getState(x - 1, y + 1) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }

    public int stateOfCellDownLeft(int x, int y, Board board) {
        if (board.getState(x - 1, y - 1) == State.ALIVE) {
            return 1;
        } else {
            return 0;

        }
    }


    public State nextGenerationCellState(int x, int y, Board board) {

        int aliveNeighbours = countAliveNeighbours(x, y, board);

        if (board.getState(x, y) == State.ALIVE) {

            if (aliveNeighbours < 2) {
                return State.DEAD;
            } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                return State.ALIVE;

            } else {
                return State.DEAD;
            }

        } else if (aliveNeighbours == 3) {
            return State.ALIVE;
        } else {
            return State.DEAD;
        }

    }
}