/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose A Scene for Fighter Fights the Guard.
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

public class DDScene3GuardFighter {

    Fighter fighter1 = new Fighter(3, 0, 2, -2, 0, -1);
    Guard guard = new Guard(1,0,5,-2,1,-1);
    int yourHealth = fighter1.Health();
    double originalHealth = fighter1.getHealth();
    int enemyHealth = guard.getHealth();
    double enemyOriginalHealth = guard.getHealth();

    @FXML
    private TextArea chatTextField;

    @FXML
    private ProgressBar enemyBar;

    @FXML
    private ProgressBar yourBar;

    @FXML
    private void fightButtonPressed(ActionEvent event) throws IOException {

        guard.setHealth(guard.getHealth() - fighter1.Attack());

        double enemyPercent = guard.getHealth()/enemyOriginalHealth;

        enemyHealth = guard.getHealth();
        enemyBar.setProgress(enemyPercent);

        if (guard.getHealth() > 0) {

            fighter1.setHealth(fighter1.getHealth() - guard.Attack());

            double yourPercent = fighter1.getHealth()/originalHealth;

            yourHealth = fighter1.getHealth();
            yourBar.setProgress(yourPercent);

            if (fighter1.getHealth() <= 0) {
                switchScene("Scenes/D&D_Scene_2_Death.fxml", ((Node) event.getSource()).getScene().getWindow());
            }

        } else {
            switchScene("Scenes/D&D_Scene_2_FighterEmpty.fxml", ((Node) event.getSource()).getScene().getWindow());
        }
        System.out.println("your health: " + fighter1.getHealth());
        System.out.println("Enemy health: " + guard.getHealth());
    }

    @FXML
    private void sneakButtonPressed(ActionEvent event) throws IOException {
        int success = fighter1.Sneak();
        if (success >= guard.getWis() + 10) {
            switchScene("Scenes/D&D_Scene_2_FighterEmpty.fxml", ((Node) event.getSource()).getScene().getWindow());
        }
        else {
            double yourPercent = fighter1.getHealth();

            fighter1.setHealth(fighter1.getHealth() - guard.Attack());

            yourPercent = (double) fighter1.getHealth()/yourPercent;

            yourHealth = fighter1.getHealth();
            yourBar.setProgress(yourPercent);

            if (fighter1.getHealth() <= 0) {
                switchScene("Scenes/D&D_Scene_2_Death.fxml", ((Node) event.getSource()).getScene().getWindow());
            }
        }
    }

    public void initialize() {
        chatTextField.setText("You have encountered the guard!\nWhat should you do?!");
    }

    public void switchScene(String scene, Window window) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scene)));
        Scene nextScene = new Scene(root);
        Stage stage = (Stage) window;
        stage.setScene(nextScene);
        stage.show();
    }
}

