package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.Scanner;

/**
 * Class that read the values from the inputBets, check for error,
 * change UI and run method display() when user presses dragon button.
 */
class ConfirmHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public ConfirmHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameUI.inputBets.setStyle(null);
        gameUI.getTextBets = gameUI.inputBets.getText();
        Scanner scanText = new Scanner(gameUI.getTextBets);
        Alert alert = new Alert(Alert.AlertType.NONE);

        if (gameUI.getTextBets.isEmpty()) {
            gameUI.inputBets.setStyle("-fx-text-box-border: red");
            AlertSetup(alert, Alert.AlertType.ERROR, "Error", "Please fill in information.");
        }
        if (!gameUI.getTextBets.isEmpty()) {
            if (!scanText.hasNextInt()) {
                try {
                    gameUI.userBets = Integer.parseInt(gameUI.getTextBets);
                } catch (NumberFormatException nfe) {
                    gameUI.inputBets.setStyle("-fx-text-box-border: red");
                    AlertSetup(alert, Alert.AlertType.ERROR, "Error", "Not an Integer Number!");
                }
            } else if (!(gameUI.chooseSides == 0 || gameUI.chooseSides == 1 || gameUI.chooseSides == 2)) {
                gameUI.inputBets.setStyle("-fx-text-box-border: red");
                AlertSetup(alert, Alert.AlertType.ERROR, "Error", "Please Choose dragon OR tiger OR draw.");
            } else {
                try {
                    gameUI.userBets = Integer.parseInt(gameUI.getTextBets);
                    if ((gameUI.userBets > gameUI.userChips) || (gameUI.userBets <= 0)) {
                        gameUI.inputBets.setStyle("-fx-text-box-border: #ffd811");
                        AlertSetup(alert, Alert.AlertType.WARNING, "Sorry", "You have lost all your chips.");
                        gameUI.passConfirm = false;
                    } else {
                        gameUI.inputBets.setStyle(null);
                        gameUI.inputBets.setStyle("-fx-text-box-border: #2c5df1");
                        AlertSetup(alert, Alert.AlertType.INFORMATION, "Success", "Bet Successful!");
                        gameUI.passConfirm = true;
                    }
                } catch (Exception e) {
                    gameUI.inputBets.setStyle("-fx-text-box-border: red");
                    AlertSetup(alert, Alert.AlertType.ERROR, "Error", "Error message!");
                }
            }
        }
    }

    private void AlertSetup(Alert alert, Alert.AlertType error, String error2, String s) {
        alert.setAlertType(error);
        alert.setTitle(error2);
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
}
