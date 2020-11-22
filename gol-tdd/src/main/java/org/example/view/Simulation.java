package org.example.view;

import org.example.model.Board;
import org.example.model.State;
import org.example.model.Rules;

public class Simulation {
    private Board simulationBoard;

    private Rules rules;

    public Simulation(Board simulationBoard, Rules rules) {
        this.simulationBoard = simulationBoard;
        this.rules = rules;
    }

    public void step() {
        Board nextState = simulationBoard.createBoard();

        for (int y = 0; y < simulationBoard.getWidth(); y++) {
            for (int x = 0; x < simulationBoard.getHeight(); x++) {
                State newState = rules.nextGenerationCellState(x, y, simulationBoard);
                nextState.setState(x, y, newState);
            }
        }

        this.simulationBoard = nextState;
    }

    public Board getSimulationBoard() {
        return this.simulationBoard;
    }


}
