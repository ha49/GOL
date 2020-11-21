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
                assertEquals(State.DEAD, board.getState(x, y));

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


        board.setState(0, 0, State.ALIVE);
        board.setState(1, 1, State.ALIVE);
        board.setState(2, 2, State.ALIVE);
        board.setState(3, 3, State.ALIVE);


        assertEquals(State.ALIVE, board.getState(0, 0));
        assertEquals(State.ALIVE, board.getState(1, 1));
        assertEquals(State.ALIVE, board.getState(2, 2));
        assertEquals(State.ALIVE, board.getState(3, 3));


    }

    @Test
    void UserInitiatedCellStatesShouldNotAffectCellStatesOfPreviousBoard() {

        Board newBoard = board.createBoard();

        newBoard.setState(0, 0, State.ALIVE);
        newBoard.setState(1, 1, State.ALIVE);
        newBoard.setState(2, 2, State.ALIVE);
        newBoard.setState(3, 3, State.ALIVE);
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertEquals(State.DEAD, board.getState(x, y));
                System.out.println("x:" + x + ",y:" + y + " -> " + board.getState(x, y));
            }
        }
    }

    @Test
    void WhenPointsOutOfBoundsConstructedNoExceptionThrown() {
        assertDoesNotThrow(() -> board.setState(21, 31, State.ALIVE));
        assertDoesNotThrow(() -> board.setState(21, 31, State.DEAD));
        assertDoesNotThrow(() -> board.setState(-1, -1, State.ALIVE));
        assertDoesNotThrow(() -> board.setState(-1, -1, State.DEAD));
        assertDoesNotThrow(() -> board.getState(21, 31));
        assertDoesNotThrow(() -> board.getState(-1, -1));
    }

    @Test
    void AllCellsOutOfBoundsShouldConvertToDeadState() {
        Board newBoard = board.createBoard();
        for (int x = -1; newBoard.getWidth() < x && x < newBoard.getWidth() + 2; x++) {
            for (int y = -1; newBoard.getHeight() < y && y < newBoard.getHeight() + 2; y++) {
                newBoard.setState(x, y, State.ALIVE);
            }
        }

        for (int x = -1; newBoard.getWidth() < x && x < newBoard.getWidth() + 2; x++) {
            for (int y = -1; newBoard.getHeight() < y && y < newBoard.getHeight() + 2; y++) {

                assertEquals(State.DEAD, newBoard.getState(x, y));
            }
        }
    }

}



