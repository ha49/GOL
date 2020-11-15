package org.example.model;

public interface BoardTemplate {
    int getHeight();
    int getWidth();
    Board create();
    CellState getCellState();
}

