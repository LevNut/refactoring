package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Class that change UI and run method display() when user presses tiger button.
 */
class ChooseTigerHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public ChooseTigerHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameUI.chooseTiger();
        gameUI.text.setStyle("-fx-text-fill: #5745e5");
        gameUI.text.setText("TIGER");
        gameUI.display();
    }
}
