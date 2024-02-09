/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose TheLadleOfTruth class. Will inherit from Application.
 */

package com.example.demo2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class TheLadleOfTruth extends Application {

    /**
     * Sets the stage up
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scenes/D&D_Scene_1_1_Start.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("The Ladle of Truth");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the stage
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}