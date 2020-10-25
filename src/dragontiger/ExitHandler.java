package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Class that exits the game.
 */
class ExitHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
