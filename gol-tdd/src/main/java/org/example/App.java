package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.view.BattleField;

public class App extends Application {


    @Override
    public void start(Stage stage) {
        BattleField battleField = new BattleField();
        Scene scene = new Scene(battleField, 650, 650);
        stage.setScene(scene);
        stage.show();

        battleField.draw();
    }

    public static void main(String[] args) {
        launch();
    }

}