package org.example.model;

public interface Board {
    int getHeight();
    int getWidth();
    ActualBoard createBoard();
    CellState getCellState( int x, int y);
    void setCellState(int x, int y, CellState cellState);
}

