package org.example.model;

public class RealBoard implements Board {

    private final int width;
    private final int height;
    private final State[][] initialState;

    public RealBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.initialState = new State[width][height];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                setState(x, y, State.DEAD);

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
    public RealBoard createBoard() {
        RealBoard copy = new RealBoard(this.width, this.height);

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                copy.setState(x, y, this.getState(x, y));
            }
        }

        return copy;
    }

    @Override
    public State getState(int x, int y) {
        if (x < 0 || x >= this.width) {
            return State.DEAD;
        }

        if (y < 0 || y >= this.height) {
            return State.DEAD;
        }

        return this.initialState[x][y];
    }

    //When cell's position is out board it will be regarded as DEAD
    @Override
    public void setState(int x, int y, State state) {
        if (x < 0 || x >= this.width) {
            return;
        }

        if (y < 0 || y >= this.height) {
            return;
        }
        this.initialState[x][y] = state;
    }
}
