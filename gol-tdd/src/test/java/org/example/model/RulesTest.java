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
        this.rules=new Rules();

    }

    @Test
    void checkIfCellIsAliveAbove() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(5, 6, CellState.ALIVE);

        assertEquals(1, rules.stateOfCellAbove(5, 5, board));
        assertEquals(0, rules.stateOfCellAbove(4, 4, board));


    }

    @Test
    void checkIfCellIsAliveBelow() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(5, 4, CellState.ALIVE);

        assertEquals(1, rules.stateOfCellBelow(5, 5, board));
        assertEquals(0, rules.stateOfCellAbove(3, 4, board));


    }

    @Test
    void checkIfCellIsAliveRight() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(6, 5, CellState.ALIVE);
        assertEquals(1, rules.stateOfCellRight(5, 5, board));
        assertEquals(0, rules.stateOfCellAbove(4, 4, board));


    }


    @Test
    void checkIfCellIsAliveLeft() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(4, 5, CellState.ALIVE);
        assertEquals(1, rules.stateOfCellLeft(5, 5, board));

    }


    @Test
    void checkIfCellIsAliveUpRight() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(6, 6, CellState.ALIVE);
        assertEquals(1, rules.stateOfCellUpRight(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveDownRight() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(6, 4, CellState.ALIVE);
        assertEquals(1, rules.stateOfCellDownRight(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveUpLeft() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(4, 6, CellState.ALIVE);
        assertEquals(1, rules.stateOfCellUpLeft(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveDownLeft() {

        board.setCellState(5, 5, CellState.ALIVE);
        board.setCellState(4, 4, CellState.ALIVE);
        assertEquals(1, rules.stateOfCellDownLeft(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveAroundUpLeftCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(0, 0, board));
        assertEquals(0, rules.stateOfCellLeft(0, 0, board));
        assertEquals(0, rules.stateOfCellUpLeft(0, 0, board));


        board.setCellState(-1, -1, CellState.ALIVE);
        board.setCellState(-1, 0, CellState.ALIVE);
        board.setCellState(0, -1, CellState.ALIVE);


        assertEquals(0, rules.stateOfCellAbove(0, 0, board));
        assertEquals(0, rules.stateOfCellLeft(0, 0, board));
        assertEquals(0, rules.stateOfCellUpLeft(0, 0, board));
    }

    @Test
    void checkIfCellIsAliveAroundUpRightCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(21, 0, board));
        assertEquals(0, rules.stateOfCellLeft(21, -1, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, +1, board));


        board.setCellState(21, 0, CellState.ALIVE);
        board.setCellState(21, -1, CellState.ALIVE);
        board.setCellState(21, 1, CellState.ALIVE);

        assertEquals(0, rules.stateOfCellAbove(21, 0, board));
        assertEquals(0, rules.stateOfCellLeft(21, -1, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, +1, board));

    }


    @Test
    void checkIfCellIsAliveAroundDownLeftCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(0, 31, board));
        assertEquals(0, rules.stateOfCellLeft(-1, 31, board));
        assertEquals(0, rules.stateOfCellUpLeft(-1, 31, board));


        board.setCellState(0, 31, CellState.ALIVE);
        board.setCellState(-1, 31, CellState.ALIVE);
        board.setCellState(-1, 31, CellState.ALIVE);

        assertEquals(0, rules.stateOfCellAbove(0, 31, board));
        assertEquals(0, rules.stateOfCellLeft(-1, 31, board));
        assertEquals(0, rules.stateOfCellUpLeft(-1, 31, board));

    }

    @Test
    void checkIfCellIsAliveAroundDownRightCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(20, 31, board));
        assertEquals(0, rules.stateOfCellLeft(21, 30, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, 31, board));


        board.setCellState(20, 30, CellState.ALIVE);
        board.setCellState(20, 31, CellState.ALIVE);
        board.setCellState(21, 30, CellState.ALIVE);
        board.setCellState(21, 31, CellState.ALIVE);

        assertEquals(0, rules.stateOfCellAbove(20, 31, board));
        assertEquals(0, rules.stateOfCellLeft(21, 30, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, 31, board));

    }

    @Test
    void CountAliveNeighbours (){
        board.setCellState(0,0, CellState.ALIVE);
        assertEquals(1, rules.countAliveNeighbours(1,1, board));

        board.setCellState(0,1, CellState.ALIVE);
        assertEquals(2, rules.countAliveNeighbours(1,1, board));

        board.setCellState(1,0, CellState.ALIVE);
        assertEquals(3, rules.countAliveNeighbours(1,1, board));


        board.setCellState(2,0, CellState.ALIVE);
        assertEquals(4, rules.countAliveNeighbours(1,1, board));

        board.setCellState(0,2, CellState.ALIVE);
        assertEquals(5, rules.countAliveNeighbours(1,1, board));

        board.setCellState(1,2, CellState.ALIVE);
        assertEquals(6, rules.countAliveNeighbours(1,1, board));

        board.setCellState(2,1, CellState.ALIVE);
        assertEquals(7, rules.countAliveNeighbours(1,1, board));

        board.setCellState(2,2, CellState.ALIVE);
        assertEquals(8, rules.countAliveNeighbours(1,1, board));


        //     Test for corner point 0.0

        assertEquals(2, rules.countAliveNeighbours(0,0, board));
        board.setCellState(1,1, CellState.ALIVE);
        assertEquals(3, rules.countAliveNeighbours(0,0, board));


    }

}