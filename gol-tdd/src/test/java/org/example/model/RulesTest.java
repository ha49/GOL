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
        board.setCellState(5,6,CellState.ALIVE);

        assertEquals(1, Rules.getStateOfCellAbove(5, 5, board));
        assertEquals(0, Rules.getStateOfCellAbove(4, 4, board));


    }

    @Test
    void checkIfCellIsAliveBelow(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(5,4,CellState.ALIVE);

        assertEquals(1, Rules.getStateOfCellBelow(5, 5, board));
        assertEquals(0, Rules.getStateOfCellAbove(3, 4, board));


 }

    @Test
    void checkIfCellIsAliveRight(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(6,5,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellRight(5, 5, board));
        assertEquals(0, Rules.getStateOfCellAbove(4, 4, board));


 }


    @Test
    void checkIfCellIsAliveLeft(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(4,5,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellLeft(5, 5, board));

    }



    @Test
    void checkIfCellIsAliveUpRight(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(6,6,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellUpRight(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveDownRight(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(6,4,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellDownRight(5, 5, board));

    }
    @Test
    void checkIfCellIsAliveUpLeft(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(4,6,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellUpLeft(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveDownLeft(){

        board.setCellState(5,5, CellState.ALIVE);
        board.setCellState(4,4,CellState.ALIVE);
        assertEquals(1, Rules.getStateOfCellDownLeft(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveAroundUpLeftCornerOfBoard(){
        assertEquals(0, Rules.getStateOfCellAbove(0, 0, board));
        assertEquals(0, Rules.getStateOfCellLeft(0, 0, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(0, 0, board));


        board.setCellState(-1,-1, CellState.ALIVE);
        board.setCellState(-1,0,CellState.ALIVE);
        board.setCellState(0,-1,CellState.ALIVE);


        assertEquals(0, Rules.getStateOfCellAbove(0, 0, board));
        assertEquals(0, Rules.getStateOfCellLeft(0, 0, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(0, 0, board));
    }

    @Test
    void checkIfCellIsAliveAroundUpRightCornerOfBoard(){
        assertEquals(0, Rules.getStateOfCellAbove(21, 0, board));
        assertEquals(0, Rules.getStateOfCellLeft(21, -1, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(21, +1, board));


        board.setCellState(21, 0, CellState.ALIVE);
        board.setCellState(21, -1,CellState.ALIVE);
        board.setCellState(21,1,CellState.ALIVE);

        assertEquals(0, Rules.getStateOfCellAbove(21, 0, board));
        assertEquals(0, Rules.getStateOfCellLeft(21, -1, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(21, +1, board));

    }



    @Test
    void checkIfCellIsAliveAroundDownLeftCornerOfBoard(){
        assertEquals(0, Rules.getStateOfCellAbove(0, 31, board));
        assertEquals(0, Rules.getStateOfCellLeft(-1, 31, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(-1, 31, board));


        board.setCellState(0,31, CellState.ALIVE);
        board.setCellState(-1,31,CellState.ALIVE);
        board.setCellState(-1,31,CellState.ALIVE);

        assertEquals(0, Rules.getStateOfCellAbove(0, 31, board));
        assertEquals(0, Rules.getStateOfCellLeft(-1, 31, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(-1, 31, board));

    }

    @Test
    void checkIfCellIsAliveAroundDownRightCornerOfBoard(){
        assertEquals(0, Rules.getStateOfCellAbove(20, 31, board));
        assertEquals(0, Rules.getStateOfCellLeft(21, 30, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(21, 31, board));


        board.setCellState(20,30, CellState.ALIVE);
        board.setCellState(20,31, CellState.ALIVE);
        board.setCellState(21,30,CellState.ALIVE);
        board.setCellState(21,31,CellState.ALIVE);

        assertEquals(0, Rules.getStateOfCellAbove(20, 31, board));
        assertEquals(0, Rules.getStateOfCellLeft(21, 30, board));
        assertEquals(0, Rules.getStateOfCellUpLeft(21, 31, board));

    }


}