package org.example.view;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import org.example.model.*;

public class BattleField extends VBox {

    private Board defaultBoard;
    private Canvas canvas;
    private Affine affine;
    private final int width=20;
    private final int height=20;


    public BattleField() {


        this.canvas = new Canvas(800, 800);

        this.getChildren().addAll(this.canvas);

        this.affine = new Affine();
        this.affine.appendScale(600 / 20d, 600 / 20d);
        this.defaultBoard = new ActualBoard(width, height);

    }


    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.setTransform(this.affine);

        g.setFill(Color.DARKGRAY);
        g.fillRect(0, 0, 600, 600);


        g.setStroke(Color.WHITE);
        g.setLineWidth(0.05);

        for (int x = 0; x <= this.defaultBoard.getWidth(); x++) {
            g.strokeLine(x, 0, x, width);


        }
        for (int y = 0; y <= this.defaultBoard.getHeight(); y++) {
            g.strokeLine(0, y, height, y);

        }
    }





}
