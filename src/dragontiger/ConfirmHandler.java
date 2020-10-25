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
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in information.");
            alert.showAndWait();
        }
        if (!gameUI.getTextBets.isEmpty()) {
            if (!scanText.hasNextInt()) {
                try {
                    gameUI.userBets = Integer.parseInt(gameUI.getTextBets);
                } catch (NumberFormatException nfe) {
                    gameUI.inputBets.setStyle("-fx-text-box-border: red");
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Not an Integer Number!");
                    alert.showAndWait();
                }
            } else if (!(gameUI.chooseSides == 0 || gameUI.chooseSides == 1 || gameUI.chooseSides == 2)) {
                gameUI.inputBets.setStyle("-fx-text-box-border: red");
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please Choose dragon OR tiger OR draw.");
                alert.showAndWait();
            } else {
                try {
                    gameUI.userBets = Integer.parseInt(gameUI.getTextBets);
                    if ((gameUI.userBets > gameUI.userChips) || (gameUI.userBets <= 0)) {
                        gameUI.inputBets.setStyle("-fx-text-box-border: #ffd811");
                        alert.setAlertType(Alert.AlertType.WARNING);
                        alert.setTitle("Sorry");
                        alert.setHeaderText(null);
                        alert.setContentText("You have lost all your chips.");
                        alert.showAndWait();
                        gameUI.passConfirm = false;
                    } else {
                        gameUI.inputBets.setStyle(null);
                        gameUI.inputBets.setStyle("-fx-text-box-border: #2c5df1");
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("Bet Successful!");
                        alert.showAndWait();
                        gameUI.passConfirm = true;
                    }
                } catch (Exception e) {
                    gameUI.inputBets.setStyle("-fx-text-box-border: red");
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Error message!");
                    alert.showAndWait();
                }
            }
        }
    }
}
