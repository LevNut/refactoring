package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

/**
 * Class that restart game and set new user's chips.
 */
class NewGameHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public NewGameHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("New Game");
        alert.setContentText("Do you want to start a new game?");
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yesButton, cancelButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == yesButton) {
                Image newBackCard1 = new Image(getClass().getResource("img/back_card1.png").toExternalForm());
                Image newBackCard2 = new Image(getClass().getResource("img/back_card2.png").toExternalForm());
                gameUI.backCardImg1.setImage(newBackCard1);
                gameUI.backCardImg2.setImage(newBackCard2);
                gameUI.inputBets.setStyle(null);
                gameUI.inputBets.setText("");
                gameUI.chooseSides = 99;
                gameUI.userChips = 1000;
                gameUI.text.setStyle("-fx-text-fill: #ffffff");
                gameUI.text.setText("Which side do you bet on ?");
                gameUI.chips.setText("YOUR CHIPS : " + gameUI.userChips);
            }
        });
    }
}
