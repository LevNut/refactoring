package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

/**
 * Class that change UI when user presses open card button then calculate
 * value of the card that which one highest and check for error.
 */
class OpenCardHandler implements EventHandler<ActionEvent> {

    private final GameUI gameUI;

    public OpenCardHandler(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameUI.getTextBets = gameUI.inputBets.getText();
        Alert alert = new Alert(Alert.AlertType.NONE);

        if (gameUI.passChoose && gameUI.passConfirm) {
            gameUI.userBets = Integer.parseInt(gameUI.getTextBets);

            int DRAGON = (int) (Math.random() * 13) + 1;
            int TIGER = (int) (Math.random() * 13) + 1;
            int opDragon = (int) (Math.random() * 4) + 1;
            int opTiger = (int) (Math.random() * 4) + 1;

            Image dragonImg = new Image(getClass().getResource("img/cards/" + (DRAGON) + "_" + (opDragon) + ".PNG").toExternalForm());
            Image tigerImg = new Image(getClass().getResource("img/cards/" + (TIGER) + "_" + (opTiger) + ".PNG").toExternalForm());
            gameUI.backCardImg1.setImage(dragonImg);
            gameUI.backCardImg2.setImage(tigerImg);

            int win = 99;
            if (DRAGON < TIGER) {
                win = 1;
            }
            if (DRAGON > TIGER) {
                win = 0;
            }
            if (DRAGON == TIGER) {
                win = 2;
            }

            if (gameUI.chooseSides == win) {
                if (win == 2) {
                    gameUI.userBets = gameUI.userBets * 7;
                }
                gameUI.userChips = gameUI.userChips + gameUI.userBets;
                gameUI.inputBets.setStyle("-fx-text-box-border: #3bac22");
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("You Win");
                alert.setHeaderText(null);
                alert.setContentText("+" + gameUI.userBets + " Chips");
                alert.showAndWait();
            } else {
                if (win != 2) {
                    gameUI.inputBets.setStyle("-fx-text-box-border: #f55656");
                    gameUI.userChips = gameUI.userChips - gameUI.userBets;
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Lose");
                    alert.setHeaderText(null);
                    alert.setContentText("- " + gameUI.userBets + " Chips");
                    alert.showAndWait();
                } else {
                    gameUI.userChips = gameUI.userChips - (gameUI.userBets / 2);
                    gameUI.inputBets.setStyle("-fx-text-box-border: #f55656");
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Lose");
                    alert.setHeaderText(null);
                    alert.setContentText("- " + (gameUI.userBets / 2) + " Chips");
                    alert.showAndWait();
                }
            }
            gameUI.chips.setText("YOUR CHIPS : " + gameUI.userChips);
            gameUI.passConfirm = false;
            gameUI.passChoose = false;
            gameUI.chooseSides = 99;
            gameUI.display();
        } else if (!gameUI.passChoose || !gameUI.passConfirm) {
            gameUI.inputBets.setStyle("-fx-text-box-border: red");
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Betting Unsuccessful.");
            alert.showAndWait();
        }
    }
}
