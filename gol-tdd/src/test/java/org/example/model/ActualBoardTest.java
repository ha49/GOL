package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActualBoardTest {

//    #Create Board

    private Board board;

    @BeforeEach
    void setUp (){
        this.board =new ActualBoard(20,30);

    }

    @Test
    void checkIfBoardSizeIsCorrect() {

        assertEquals(20, board.getWidth());
        //        System.out.println(newBoard.getWidth());
        assertEquals(30, board.getHeight());
        //        System.out.println(newBoard.getHeight());

    }

    @Test
    void checkIfAllCellsAreDeadAtTheBeginning(){

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertEquals(CellState.DEAD, board.getCellState(x,y));

            }

        }

    }


    @Test
    void checkIfNextGenerationBoardHasSameSize() {
        Board newBoard= board.createBoard();
        assertEquals(20, newBoard.getWidth());
        assertEquals(30, newBoard.getHeight());

    }


    @Test
    void checkIfNewInstanceOfTheBoardDoesAffectCellStatesOfThePreviousBoard() {

        Board newBoard= board.createBoard();

        newBoard.setCellState(0,0,CellState.ALIVE);
        newBoard.setCellState(1,1,CellState.ALIVE);
        newBoard.setCellState(2,2,CellState.ALIVE);
        newBoard.setCellState(3,3,CellState.ALIVE);


        assertEquals(CellState.ALIVE, newBoard.getCellState(0,0));
        assertEquals(CellState.ALIVE, newBoard.getCellState(1,1));
        assertEquals(CellState.ALIVE, newBoard.getCellState(2,2));
        assertEquals(CellState.ALIVE, newBoard.getCellState(3,3));
        assertEquals(CellState.DEAD, board.getCellState(0,0));
        assertEquals(CellState.DEAD, board.getCellState(1,1));
        assertEquals(CellState.DEAD, board.getCellState(2,2));
        assertEquals(CellState.DEAD, board.getCellState(3,3));


    }



}