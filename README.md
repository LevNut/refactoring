# Refactoring

From Pitchapa Sae-lim: https://github.com/PitchapaSaelim/pa4-PitchapaSaelim

### Move class 

---

In `src/dragontiger/GameUI.java` class, there are many classes that make
 the line become too long in `GameUI.java` file.

For Example:

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

All of these class can be classified in to their own separated file for the easy changes.

In `src/dragontiger` can be classified to:

    dragontiger/
        ChangeChipsHandler
        ChooseDragonHandler
        ChooseDrawHandler
        ChooseTigerHandler
        ClearHandler
        ConfirmHandler
        Controller
        DragonTigerGame
        ExitHandler
        GameText
        GameUI
        HowToPlayHandler
        NewGameHandler
        OpenCardHandler
        
        
     
### Extract Method

---
In `src/dragontiger/ConfirmHandler.java`, there are some duplicated code.

Alert had been called many times in `if`, `else if`,and `else`, so instead of calling them repeatedly.
        
    if (getTextBets.isEmpty()) {
                    inputBets.setStyle("-fx-text-box-border: red");
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill in information.");
                    alert.showAndWait();
     if (!getTextBets.isEmpty()) {
                     if (!scanText.hasNextInt()) {
                         try {
                             userBets = Integer.parseInt(getTextBets);
                         } catch (NumberFormatException nfe) {
                             ...
                         }
     } else if (!(chooseSides == 0 || chooseSides == 1 || chooseSides == 2)) {
         ...
     } else {
         ... 
     }
                    
To remove the duplicate code, make a method that handle the alert situation.

        private void AlertSetup(Alert alert, Alert.AlertType error, String error2, String s) {
            alert.setAlertType(error);
            alert.setTitle(error2);
            alert.setHeaderText(null);
            alert.setContentText(s);
            alert.showAndWait();
        }


### Clean up code

---

In `src/dragontiger/OpenCardHandler.java`, there are some code that didn't do anything.

At `if` statement, it shows that when win is not equal to 2, the `userBets` will equal to
itself multiply by one.

So instead of this:

    if (chooseSides == win) {
                        if (win != 2) {
                            userBets = userBets * 1;
                        } else {
                            userBets = userBets * 7;
                        }
    
    
changed to:

    if (gameUI.chooseSides == win) {
                    if (win == 2) {
                        gameUI.userBets = gameUI.userBets * 7;
                    }
    

