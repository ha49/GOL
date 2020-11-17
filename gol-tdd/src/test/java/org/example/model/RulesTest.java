package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RulesTest {

    private Board board;
    private Rules rules;

    @BeforeEach
    void setUp() {
        this.board = new ActualBoard(20, 30);
        this.rules=rules;

    }

    @Test
    void checkIfCellIsAliveAbove(){

        board.setCellState(5,5, CellState.ALIVE);
        System.out.println(board.getCellState(5,5));
        board.setCellState(5,6,CellState.ALIVE);
        System.out.println(board.getCellState(5,6));

        assertEquals(1, Rules.getStateOfCellAbove(5, 5, board));


    }

 @Test
    void checkIfCellIsAliveBelow(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(5,4,CellState.ALIVE);

        assertEquals(1, Rules.getStateOfCellBelow(5, 5, board));

    }

 @Test
    void checkIfCellIsAliveRight(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(6,5,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellRight(5, 5, board));

    }


 @Test
    void checkIfCellIsAliveLeft(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(4,5,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellLeft(5, 5, board));

    }



}