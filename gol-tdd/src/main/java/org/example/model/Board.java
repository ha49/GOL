package org.example.model;

public interface Board {
    int getHeight();

    int getWidth();

    RealBoard createBoard();

    State getState(int x, int y);

    void setState(int x, int y, State state);
}

