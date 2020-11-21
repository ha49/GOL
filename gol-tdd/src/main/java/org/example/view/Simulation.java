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


    public Board getSimulationBoard() {
        return this.simulationBoard;
    }





}
