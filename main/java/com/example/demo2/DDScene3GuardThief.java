/**
 * @author James Burriss, Daniel Valencia, Thomas Miller, Taylor Anna
 * @date 03/07/2023
 * @section CSC 331-001
 * @purpose A Scene for Thief Fights the Guard.
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

public class DDScene3GuardThief {

    // Creating Objects for the Classes

    Thief thief1 = new Thief(0, 3, 1, 0, 3, 2);
    Guard guard = new Guard(1,0,5,-2,1,-1);
    int yourHealth = thief1.Health();
    double originalHealth = thief1.getHealth();
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

        guard.setHealth(guard.getHealth() - thief1.Attack());

        double enemyPercent = guard.getHealth()/enemyOriginalHealth;

        enemyHealth = guard.getHealth();
        enemyBar.setProgress(enemyPercent);

        if (guard.getHealth() > 0) {
            thief1.setHealth(thief1.getHealth() - guard.Attack());

            double yourPercent = thief1.getHealth()/originalHealth;

            yourHealth = thief1.getHealth();
            yourBar.setProgress(yourPercent);

            if (thief1.getHealth() <= 0) {
                switchScene("Scenes/D&D_Scene_2_Death.fxml", ((Node) event.getSource()).getScene().getWindow());
            }

        } else {
            switchScene("Scenes/D&D_Scene_2_ThiefEmpty.fxml", ((Node) event.getSource()).getScene().getWindow());
        }
        System.out.println("your health: " + thief1.getHealth());
        System.out.println("Enemy health: " + guard.getHealth());
    }

    @FXML
    private void sneakButtonPressed(ActionEvent event) throws IOException {
        int success = thief1.Sneak();
        if (success >= guard.getWis() + 10) {
            switchScene("Scenes/D&D_Scene_2_ThiefEmpty.fxml", ((Node) event.getSource()).getScene().getWindow());
        }
        else {
            double yourPercent = thief1.getHealth();

            thief1.setHealth(thief1.getHealth() - guard.Attack());

            yourPercent = (double) thief1.getHealth()/yourPercent;

            yourHealth = thief1.getHealth();
            yourBar.setProgress(yourPercent);

            if (thief1.getHealth() <= 0) {
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

