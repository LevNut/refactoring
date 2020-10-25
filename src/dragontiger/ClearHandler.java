package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Class that clear the text fields.
 */
class ClearHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public ClearHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameUI.inputBets.setText("");
        gameUI.inputBets.setStyle(null);
    }
}
