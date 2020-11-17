package org.example.model;

public class ActualBoard implements Board {

    private int width;
    private int height;
    private CellState[][] initialState;

    public ActualBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.initialState = new CellState[width][height];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                setCellState(x, y, CellState.DEAD);

            }

        }


    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public ActualBoard createBoard() {
        ActualBoard copy = new ActualBoard(this.width, this.height);

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                copy.setCellState(x, y, this.getCellState(x, y));
            }
        }

        return copy;
    }

    @Override
    public CellState getCellState(int x, int y) {
        if (x < 0 || x >= this.width) {
            return CellState.DEAD;
        }

        if (y < 0 || y >= this.height) {
            return CellState.DEAD;
        }

        return this.initialState[x][y];
    }


    //When cell's position is out board it will be regarded as DEAD
    @Override
    public void setCellState(int x, int y, CellState cellState) {
        if (x < 0 || x >= this.width) {
            return;
        }


        if (y < 0 || y >= this.height) {
            return;
        }
        this.initialState[x][y] = cellState;


    }




}
