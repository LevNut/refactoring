package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Class that change UI and run method display() when user presses draw button.
 */
class ChooseDrawHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public ChooseDrawHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameUI.chooseDraw();
        gameUI.text.setStyle("-fx-text-fill: #92e75c");
        gameUI.text.setText("DRAW");
        gameUI.display();
    }
}
