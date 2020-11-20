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



    public BattleField() {


        this.canvas = new Canvas(800, 800);

        this.getChildren().addAll(this.canvas);

        this.affine = new Affine();
        this.affine.appendScale(600 / 20d, 600 / 20d);
        this.defaultBoard = new ActualBoard(20, 20);

    }


    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        g.setTransform(this.affine);

        g.setFill(Color.DARKGRAY);
        g.fillRect(0, 0, 600, 600);


    }





}
