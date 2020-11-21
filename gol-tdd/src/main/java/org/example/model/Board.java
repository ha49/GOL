package org.example.model;

public interface Board {
    int getHeight();

    int getWidth();

    ActualBoard createBoard();

    State getState(int x, int y);

    void setState(int x, int y, State state);
}

