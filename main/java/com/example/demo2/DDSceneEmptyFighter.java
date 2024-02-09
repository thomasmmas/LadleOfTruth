/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose A Scene for chat for the Fighter.
 */

package com.example.demo2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class DDSceneEmptyFighter {

    @FXML
    private GridPane sceneMove;

    @FXML
    private TextArea chatTextField;

    public void scene3(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scenes/D&D_Scene_3_2_Fighter.fxml")));
            Scene secondScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(secondScene);
            window.show();
        } catch (IOException error){
            error.printStackTrace();
        }
    }

    public void initialize() {
        chatTextField.setText("You have succeeded!\nWhat will you encounter next?");
        sceneMove.setOnMouseClicked(this::scene3);
    }
}
