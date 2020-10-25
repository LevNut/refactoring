package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Class that change UI and run method display() when user presses dragon button.
 */
class ChooseDragonHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public ChooseDragonHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameUI.chooseDragon();
        gameUI.text.setText("DRAGON");
        gameUI.text.setStyle("-fx-text-fill: #ff0000");
        gameUI.display();
    }
}
