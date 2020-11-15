package org.example.model;

public class Board implements BoardTemplate{

    private int x;
    private int y;
    private CellState [][] cellState;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public Board create() {
        return null;
    }

    @Override
    public CellState getCellState() {
        return null;
    }


}
