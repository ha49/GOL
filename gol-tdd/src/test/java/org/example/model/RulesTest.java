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

        board.setState(5, 5, State.ALIVE);
        board.setState(5, 6, State.ALIVE);

        assertEquals(1, rules.stateOfCellAbove(5, 5, board));
        assertEquals(0, rules.stateOfCellAbove(4, 4, board));


    }

    @Test
    void checkIfCellIsAliveBelow() {

        board.setState(5, 5, State.ALIVE);
        board.setState(5, 4, State.ALIVE);

        assertEquals(1, rules.stateOfCellBelow(5, 5, board));
        assertEquals(0, rules.stateOfCellAbove(3, 4, board));


    }

    @Test
    void checkIfCellIsAliveRight() {

        board.setState(5, 5, State.ALIVE);
        board.setState(6, 5, State.ALIVE);
        assertEquals(1, rules.stateOfCellRight(5, 5, board));
        assertEquals(0, rules.stateOfCellAbove(4, 4, board));


    }


    @Test
    void checkIfCellIsAliveLeft() {

        board.setState(5, 5, State.ALIVE);
        board.setState(4, 5, State.ALIVE);
        assertEquals(1, rules.stateOfCellLeft(5, 5, board));

    }


    @Test
    void checkIfCellIsAliveUpRight() {

        board.setState(5, 5, State.ALIVE);
        board.setState(6, 6, State.ALIVE);
        assertEquals(1, rules.stateOfCellUpRight(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveDownRight() {

        board.setState(5, 5, State.ALIVE);
        board.setState(6, 4, State.ALIVE);
        assertEquals(1, rules.stateOfCellDownRight(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveUpLeft() {

        board.setState(5, 5, State.ALIVE);
        board.setState(4, 6, State.ALIVE);
        assertEquals(1, rules.stateOfCellUpLeft(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveDownLeft() {

        board.setState(5, 5, State.ALIVE);
        board.setState(4, 4, State.ALIVE);
        assertEquals(1, rules.stateOfCellDownLeft(5, 5, board));

    }

    @Test
    void checkIfCellIsAliveAroundUpLeftCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(0, 0, board));
        assertEquals(0, rules.stateOfCellLeft(0, 0, board));
        assertEquals(0, rules.stateOfCellUpLeft(0, 0, board));


        board.setState(-1, -1, State.ALIVE);
        board.setState(-1, 0, State.ALIVE);
        board.setState(0, -1, State.ALIVE);


        assertEquals(0, rules.stateOfCellAbove(0, 0, board));
        assertEquals(0, rules.stateOfCellLeft(0, 0, board));
        assertEquals(0, rules.stateOfCellUpLeft(0, 0, board));
    }

    @Test
    void checkIfCellIsAliveAroundUpRightCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(21, 0, board));
        assertEquals(0, rules.stateOfCellLeft(21, -1, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, +1, board));


        board.setState(21, 0, State.ALIVE);
        board.setState(21, -1, State.ALIVE);
        board.setState(21, 1, State.ALIVE);

        assertEquals(0, rules.stateOfCellAbove(21, 0, board));
        assertEquals(0, rules.stateOfCellLeft(21, -1, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, +1, board));

    }


    @Test
    void checkIfCellIsAliveAroundDownLeftCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(0, 31, board));
        assertEquals(0, rules.stateOfCellLeft(-1, 31, board));
        assertEquals(0, rules.stateOfCellUpLeft(-1, 31, board));


        board.setState(0, 31, State.ALIVE);
        board.setState(-1, 31, State.ALIVE);
        board.setState(-1, 31, State.ALIVE);

        assertEquals(0, rules.stateOfCellAbove(0, 31, board));
        assertEquals(0, rules.stateOfCellLeft(-1, 31, board));
        assertEquals(0, rules.stateOfCellUpLeft(-1, 31, board));

    }

    @Test
    void checkIfCellIsAliveAroundDownRightCornerOfBoard() {
        assertEquals(0, rules.stateOfCellAbove(20, 31, board));
        assertEquals(0, rules.stateOfCellLeft(21, 30, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, 31, board));


        board.setState(20, 30, State.ALIVE);
        board.setState(20, 31, State.ALIVE);
        board.setState(21, 30, State.ALIVE);
        board.setState(21, 31, State.ALIVE);

        assertEquals(0, rules.stateOfCellAbove(20, 31, board));
        assertEquals(0, rules.stateOfCellLeft(21, 30, board));
        assertEquals(0, rules.stateOfCellUpLeft(21, 31, board));

    }

    @Test
    void CountAliveNeighbours (){
        board.setState(0,0, State.ALIVE);
        assertEquals(1, rules.countAliveNeighbours(1,1, board));

        board.setState(0,1, State.ALIVE);
        assertEquals(2, rules.countAliveNeighbours(1,1, board));

        board.setState(1,0, State.ALIVE);
        assertEquals(3, rules.countAliveNeighbours(1,1, board));


        board.setState(2,0, State.ALIVE);
        assertEquals(4, rules.countAliveNeighbours(1,1, board));

        board.setState(0,2, State.ALIVE);
        assertEquals(5, rules.countAliveNeighbours(1,1, board));

        board.setState(1,2, State.ALIVE);
        assertEquals(6, rules.countAliveNeighbours(1,1, board));

        board.setState(2,1, State.ALIVE);
        assertEquals(7, rules.countAliveNeighbours(1,1, board));

        board.setState(2,2, State.ALIVE);
        assertEquals(8, rules.countAliveNeighbours(1,1, board));


        //     Test for corner point 0.0

        assertEquals(2, rules.countAliveNeighbours(0,0, board));
        board.setState(1,1, State.ALIVE);
        assertEquals(3, rules.countAliveNeighbours(0,0, board));

    }


    @Test
    void aliveCellWithLessThanTwoAliveNeighbourDies(){

        //The alive cell
        board.setState(1,1, State.ALIVE);

        //  No alive neighbour
        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

        // One alive neighbour
        board.setState(0,0, State.ALIVE);
        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

    }


    @Test
    void aliveCellWithTwoOrThreeAliveNeighboursLives(){
        //The alive cell
        board.setState(1,1, State.ALIVE);

        // Two alive neighbours
        board.setState(0,0, State.ALIVE);
        board.setState(0,1, State.ALIVE);

        assertEquals(State.ALIVE, rules.nextGenerationCellState(1,1,board));


        // Three alive neighbours
        board.setState(1,0, State.ALIVE);

        assertEquals(State.ALIVE, rules.nextGenerationCellState(1,1,board));

    }





    @Test
    void aliveCellWithMoreThanThreeAliveNeighboursDies(){

        //The alive cell
        board.setState(1,1, State.ALIVE);

        // Four alive neighbours
        board.setState(0,0, State.ALIVE);
        board.setState(1,0, State.ALIVE);
        board.setState(2,0, State.ALIVE);
        board.setState(0,1, State.ALIVE);

        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

        // Five alive neighbours
        board.setState(0,2, State.ALIVE);
        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

        // Six alive neighbours
        board.setState(1,2, State.ALIVE);
        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

        // Seven alive neighbours
        board.setState(2,2, State.ALIVE);
        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

        // Eight alive neighbours
        board.setState(2,1, State.ALIVE);
        assertEquals(State.DEAD, rules.nextGenerationCellState(1,1,board));

    }

    @Test
    void deadCellWithMThreeAliveNeighboursLives(){

        // Three alive neighbours
        board.setState(0,0, State.ALIVE);
        board.setState(1,0, State.ALIVE);
        board.setState(2,0, State.ALIVE);

        //The dead cell Lives
        assertEquals(State.ALIVE, rules.nextGenerationCellState(1,1,board));

    }






}