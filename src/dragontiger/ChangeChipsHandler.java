package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

/**
 * Class that change the user's chips when user want to change and check for error.
 */
class ChangeChipsHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public ChangeChipsHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Change user's chips");
        alert.setContentText("Do you want to change your chips?");
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yesButton, cancelButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == yesButton) {
                gameUI.chooseSides = 99;
                TextInputDialog inputUserChips = new TextInputDialog(null);
                inputUserChips.setTitle("✎ Change user's chips");
                inputUserChips.setHeaderText("Please enter an Integer Number");
                inputUserChips.setContentText("Enter your chips:");
                inputUserChips.showAndWait();
                String getUserChips = inputUserChips.getResult();
                if (getUserChips != null) {
                    try {
                        gameUI.userChips = Integer.parseInt(getUserChips);
                    } catch (NumberFormatException nfe) {
                        Alert alert2 = new Alert(Alert.AlertType.NONE);
                        alert2.setAlertType(Alert.AlertType.ERROR);
                        alert2.setTitle("Error");
                        alert2.setHeaderText("Not an Integer Number!");
                        alert2.setContentText("Please try again.");
                        alert2.showAndWait();
                    }
                }
                gameUI.text.setStyle("-fx-text-fill: #ffffff");
                gameUI.text.setText("Which side do you bet on ?");
                gameUI.chips.setText("YOUR CHIPS : " + gameUI.userChips);
            }
        });
    }
}
