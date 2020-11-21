package org.example.view;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.util.Duration;
import org.example.model.Stage;
import org.example.model.State;


public class Toolbar extends ToolBar {

    private BattleField battleField;
    private Timeline timeline;


    public Toolbar(BattleField battleField) {
        this.battleField = battleField;
        Button draw = new Button("Draw");
        draw.setOnAction(this::handleDraw);
        Button delete = new Button("Delete");
        delete.setOnAction(this::handleDelete);
        Button play = new Button("Play");
        play.setOnAction(this::handlePlay);

        this.getItems().addAll(draw, delete, play);
        this.timeline = new Timeline(new KeyFrame(Duration.millis(1000), this::handlePlay));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void handlePlay(ActionEvent actionEvent) {
            this.battleField.setStage(Stage.SIMULATING);
            this.battleField.getSimulation().step();
            this.battleField.draw();
            this.timeline.play();
        }


    private void handleDelete(ActionEvent actionEvent) {
        this.battleField.makeCellDead(State.DEAD);

    }

    private void handleDraw(ActionEvent actionEvent) {
        this.battleField.makeCellAlive(State.ALIVE);

    }


}