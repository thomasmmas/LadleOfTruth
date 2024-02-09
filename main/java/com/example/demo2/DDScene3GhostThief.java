/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose A Scene for Thief Fights the Ghost.
 */

package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.util.Objects;

public class DDScene3GhostThief {

    // Creating Objects for the Classes

    Thief thief1 = new Thief(0, 3, 1, 0, 3, 2);
    Ghost ghost = new Ghost(0,1,0,2,3,-2);
    int yourHealth = thief1.Health();
    double originalHealth = thief1.getHealth();
    int enemyHealth = ghost.getHealth();
    double enemyOriginalHealth = ghost.getHealth();

    @FXML
    private TextArea chatTextField;

    @FXML
    private ProgressBar enemyBar;

    @FXML
    private ProgressBar yourBar;

    @FXML
    private void fightButtonPressed(ActionEvent event) throws IOException {

        ghost.setHealth(ghost.getHealth() - thief1.Attack());

        double enemyPercent = ghost.getHealth()/enemyOriginalHealth;

        enemyHealth = ghost.getHealth();
        enemyBar.setProgress(enemyPercent);

        if (ghost.getHealth() > 0) {
            thief1.setHealth(thief1.getHealth() - ghost.Attack());

            double yourPercent = thief1.getHealth()/originalHealth;

            yourHealth = thief1.getHealth();
            yourBar.setProgress(yourPercent);

            if (thief1.getHealth() <= 0) {
                switchScene("Scenes/D&D_Scene_2_Death.fxml", ((Node) event.getSource()).getScene().getWindow());
            }

        } else {
            switchScene("Scenes/D&D_Scene_4_1_Ending.fxml", ((Node) event.getSource()).getScene().getWindow());
        }
        System.out.println("your health: " + thief1.getHealth());
        System.out.println("Enemy health: " + ghost.getHealth());
    }

    public void initialize() {
        chatTextField.setText("A ghost seems to have been haunting the ladle!\nMaybe we can scare it?!");
    }

    public void switchScene(String scene, Window window) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scene)));
        Scene nextScene = new Scene(root);
        Stage stage = (Stage) window;
        stage.setScene(nextScene);
        stage.show();
    }
}

