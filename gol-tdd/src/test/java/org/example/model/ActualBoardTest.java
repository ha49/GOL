package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActualBoardTest {

    //    #Create Board

    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new ActualBoard(20, 30);

    }

    @Test
    void checkIfBoardSizeIsCorrect() {

        assertEquals(20, board.getWidth());
        //        System.out.println(newBoard.getWidth());
        assertEquals(30, board.getHeight());
        //        System.out.println(newBoard.getHeight());

    }

    @Test
    void checkIfAllCellsAreDeadAtTheBeginning() {

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertEquals(CellState.DEAD, board.getCellState(x, y));

            }

        }

    }


    @Test
    void checkIfNextGenerationBoardHasSameSize() {
        Board newBoard = board.createBoard();
        assertEquals(20, newBoard.getWidth());
        assertEquals(30, newBoard.getHeight());

    }


    @Test
    void UserInitiatedCellStatesShouldBeReflectedOnBoard() {


        board.setCellState(0, 0, CellState.ALIVE);
        board.setCellState(1, 1, CellState.ALIVE);
        board.setCellState(2, 2, CellState.ALIVE);
        board.setCellState(3, 3, CellState.ALIVE);


        assertEquals(CellState.ALIVE, board.getCellState(0, 0));
        assertEquals(CellState.ALIVE, board.getCellState(1, 1));
        assertEquals(CellState.ALIVE, board.getCellState(2, 2));
        assertEquals(CellState.ALIVE, board.getCellState(3, 3));


    }

    @Test
    void UserInitiatedCellStatesShouldNotAffectCellStatesOfPreviousBoard() {

        Board newBoard = board.createBoard();

        newBoard.setCellState(0, 0, CellState.ALIVE);
        newBoard.setCellState(1, 1, CellState.ALIVE);
        newBoard.setCellState(2, 2, CellState.ALIVE);
        newBoard.setCellState(3, 3, CellState.ALIVE);
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertEquals(CellState.DEAD, board.getCellState(x, y));
                System.out.println("x:" + x + ",y:" + y + " -> " + board.getCellState(x, y));
            }
        }
    }

    @Test
    void WhenPointsOutOfBoundsConstructedNoExceptionThrown() {
        assertDoesNotThrow(() -> board.setCellState(21, 31, CellState.ALIVE));
        assertDoesNotThrow(() -> board.setCellState(21, 31, CellState.DEAD));
        assertDoesNotThrow(() -> board.setCellState(-1, -1, CellState.ALIVE));
        assertDoesNotThrow(() -> board.setCellState(-1, -1, CellState.DEAD));
        assertDoesNotThrow(() -> board.getCellState(21, 31));
        assertDoesNotThrow(() -> board.getCellState(-1, -1));
    }

    @Test
    void AllCellsOutOfBoundsShouldConvertToDeadState() {
        Board newBoard = board.createBoard();
        for (int x = -1; newBoard.getWidth() < x && x < newBoard.getWidth() + 2; x++) {
            for (int y = -1; newBoard.getHeight() < y && y < newBoard.getHeight() + 2; y++) {
                newBoard.setCellState(x, y, CellState.ALIVE);
            }
        }

        for (int x = -1; newBoard.getWidth() < x && x < newBoard.getWidth() + 2; x++) {
            for (int y = -1; newBoard.getHeight() < y && y < newBoard.getHeight() + 2; y++) {

                assertEquals(CellState.DEAD, newBoard.getCellState(x, y));
            }
        }
    }

}



