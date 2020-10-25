package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * Class that shows how to play Dragon Tiger Game.
 */
class HowToPlayHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        GameText gameText = new GameText();
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("           Welcome to Dragon-Tiger!");
        alert.setTitle("How to play");
        alert.getDialogPane().setPrefSize(630, 700);
        ImageView howToPlayImg = new ImageView(getClass().getResource("img/cards_icon.png").toExternalForm());
        alert.setGraphic(howToPlayImg);
        alert.setContentText(gameText.msgHowToPlay);
        alert.showAndWait();
    }
}
