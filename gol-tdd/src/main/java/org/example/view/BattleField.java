package org.example.view;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;
import org.example.model.*;

import static org.example.model.Stage.SIMULATING;

public class BattleField extends VBox {

    private Board defaultBoard;
    private Canvas canvas;
    private Affine affine;
    private final int width = 20;
    private final int height = 20;
    private State state = State.ALIVE;
    private Stage stage = Stage.EDITING;

    private Simulation simulation;


    public BattleField() {

        this.canvas = new Canvas(650, 650);
        this.canvas.setOnMousePressed(this::handleDrawEvent);
        this.canvas.setOnMouseDragged(this::handleDrawEvent);
        Toolbar toolbar = new Toolbar(this);
        this.getChildren().addAll(toolbar, this.canvas);
        this.affine = new Affine();
        this.affine.appendScale(600 / 20d, 600 / 20d);
        this.defaultBoard = new RealBoard(width, height);

    }

    private void handleDrawEvent(MouseEvent mouseEvent) {
        if (this.stage == SIMULATING) {
            return;
        }
        double pointX = mouseEvent.getX();
        double pointY = mouseEvent.getY();


        try {
            Point2D coordinate = this.affine.inverseTransform(pointX, pointY);

            int paintedX = (int) (coordinate.getX());
            int paintedY = (int) (coordinate.getY());

            this.defaultBoard.setState(paintedX, paintedY, state);
            draw();

        } catch (NonInvertibleTransformException e) {
        }
    }


    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.setTransform(this.affine);

        g.setFill(Color.DARKGRAY);
        g.fillRect(0, 0, 600, 600);

        if (this.stage == Stage.EDITING) {
            drawSimulation(this.defaultBoard);
        } else {
            drawSimulation(this.simulation.getSimulationBoard());
        }


        g.setStroke(Color.WHITE);
        g.setLineWidth(0.05);

        for (int x = 0; x <= this.defaultBoard.getWidth(); x++) {
            g.strokeLine(x, 0, x, width);

        }
        for (int y = 0; y <= this.defaultBoard.getHeight(); y++) {
            g.strokeLine(0, y, height, y);

        }
    }



    public Simulation getSimulation() {
        return this.simulation;
    }

    private void drawSimulation(Board simulationBoard) {
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        g.setFill(Color.DARKRED);

        for (int x = 0; x < simulationBoard.getWidth(); x++) {
            for (int y = 0; y < simulationBoard.getHeight(); y++) {

                if (simulationBoard.getState(x, y) == State.ALIVE) {

                    g.fillRect(x, y, 1, 1);

                }
            }
        }
    }

    public void setStage(Stage stage) {
        if (stage == this.stage) {

            return;
        }

        if (stage == SIMULATING) {

            this.simulation = new Simulation(this.defaultBoard, new Rules());

        }
        this.stage = stage;


    }

    public Stage getStage() {
        return stage;
    }

    public void makeCellAlive(State state) {
        this.state = state;
    }


    public void makeCellDead(State state) {
        this.state = state;
    }

}
