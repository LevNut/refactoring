package dragontiger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A Graphical User Interface (GUI) for Dragon Tiger Game.
 *
 * @author Pitchapa Sae-lim
 */
public class GameUI {
    /**
     * The chips that user use to bet.
     */
    public int userChips = 1000;
    /**
     * Text field that input the amount of chips that user wants to bet.
     */
    public TextField inputBets;
    /**
     * Label that shows the text.
     */
    public Label text;
    /**
     * True when user chooses a side.
     */
    public boolean passChoose = false;
    /**
     * True when user presses confirm button.
     */
    public boolean passConfirm = false;
    /**
     * Value of chooseSides will changed when user chooses a side.
     */
    public int chooseSides = 99;
    /**
     * Get the text from text field.
     */
    public String getTextBets = "";
    /**
     * Label that shows the chips.
     */
    public Label chips;
    /**
     * Get the value of the amount of chips that user bets from text field.
     */
    public int userBets;
    /**
     * Image of back card on left side.
     */
    public ImageView backCardImg1;
    /**
     * Image of back card on right side.
     */
    public ImageView backCardImg2;

    /**
     * Initialize components for the scene graph to display.
     */
    public BorderPane initComponents() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10.0));

        // create and add components
        FlowPane flowPaneChips = new FlowPane();
        chips = new Label("YOUR CHIPS : " + userChips);
        chips.setFont(Font.loadFont(getClass().getResourceAsStream("font/CasinoShadow.ttf"), 90));
        chips.setStyle("-fx-text-fill: #ffffff");
        flowPaneChips.getChildren().addAll(chips);
        flowPaneChips.setAlignment(Pos.CENTER);

        Button confirmButton = new Button("CONFIRM");
        confirmButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/BELL.TTF"), 15));
        confirmButton.setMaxSize(100, 200);
        confirmButton.setStyle("-fx-background-color:#1b8c8c");
        confirmButton.setTextFill(Color.web("#ffffff", 0.8));
        confirmButton.setOnAction(new ConfirmHandler(this));

        Button openCardButton = new Button("OPEN CARD");
        openCardButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/BELL.TTF"), 12));
        openCardButton.setMaxSize(100, 200);
        openCardButton.setStyle("-fx-background-color:#a21a51");
        openCardButton.setTextFill(Color.web("#ffffff", 0.8));
        openCardButton.setOnAction(new OpenCardHandler(this));

        Button dragonButton = new Button("DRAGON");
        dragonButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 18));
        dragonButton.setMaxSize(100, 200);
        dragonButton.setStyle("-fx-background-color:#db0a0a");
        dragonButton.setTextFill(Color.web("#ffffff", 0.8));
        dragonButton.setOnAction(new ChooseDragonHandler(this));

        Button tigerButton = new Button("TIGER");
        tigerButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 20));
        tigerButton.setMaxSize(100, 200);
        tigerButton.setStyle("-fx-background-color:#1f1979");
        tigerButton.setTextFill(Color.web("#ffffff", 0.8));
        tigerButton.setOnAction(new ChooseTigerHandler(this));

        Button drawButton = new Button("DRAW");
        drawButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 20));
        drawButton.setMaxSize(100, 200);
        drawButton.setStyle("-fx-background-color:#000000");
        drawButton.setTextFill(Color.web("#ffffff", 0.8));
        drawButton.setOnAction(new ChooseDrawHandler(this));

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(new ClearHandler(this));

        FlowPane flowPaneBets = new FlowPane();
        Label bets = new Label("BET :");
        bets.setStyle("-fx-text-fill: #ffffff");
        bets.setFont(Font.loadFont(getClass().getResourceAsStream("font/CasinoShadow.ttf"), 40));
        inputBets = new TextField();
        inputBets.setOnAction(new ConfirmHandler(this));
        flowPaneBets.setHgap(20);
        flowPaneBets.getChildren().addAll(clearButton, bets, inputBets, confirmButton, openCardButton);
        flowPaneBets.setAlignment(Pos.CENTER);

        VBox vBoxText = new VBox();
        text = new Label("Which side do you bet on ?");
        text.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 45));
        text.setStyle("-fx-text-fill: #ffffff");
        vBoxText.setAlignment(Pos.CENTER);
        vBoxText.setSpacing(20);
        vBoxText.getChildren().addAll(text, drawButton);

        VBox vBoxImg1 = new VBox();
        backCardImg1 = new ImageView(getClass().getResource("img/back_card1.png").toExternalForm());
        backCardImg1.setFitHeight(300);
        backCardImg1.setFitWidth(210);
        vBoxImg1.setSpacing(20);
        vBoxImg1.setAlignment(Pos.CENTER);
        vBoxImg1.getChildren().addAll(backCardImg1, dragonButton);

        VBox vBoxImg2 = new VBox();
        backCardImg2 = new ImageView(getClass().getResource("img/back_card2.png").toExternalForm());
        backCardImg2.setFitHeight(300);
        backCardImg2.setFitWidth(210);
        vBoxImg2.setSpacing(20);
        vBoxImg2.setAlignment(Pos.CENTER);
        vBoxImg2.getChildren().addAll(backCardImg2, tigerButton);

        borderPane.setTop(flowPaneChips);
        borderPane.setLeft(vBoxImg1);
        borderPane.setCenter(vBoxText);
        borderPane.setRight(vBoxImg2);
        borderPane.setBottom(flowPaneBets);

        return borderPane;
    }

    /**
     * Method that change passChoose when user chooses a side.
     */
    void display() {
        if (chooseSides == 0) {
            passChoose = true;
        } else if (chooseSides == 1) {
            passChoose = true;
        } else if (chooseSides == 2) {
            passChoose = true;
        } else {
            passChoose = false;
            passConfirm = false;
        }
    }

    /**
     * Method that change chooseSides when user chooses dragon side.
     */
    void chooseDragon() {
        chooseSides = 0;
    }

    /**
     * Method that change chooseSides when user chooses tiger side.
     */
    void chooseTiger() {
        chooseSides = 1;
    }

    /**
     * Method that change chooseSides when user chooses draw side.
     */
    void chooseDraw() {
        chooseSides = 2;
    }

    /**
     * Class that provide options for the user.
     *
     * @return menu bar of options in Dragon Tiger Game.
     */
    public MenuBar makeMenuBar() {
        Menu menu = new Menu("Options");

        MenuItem changeChipsItem = new MenuItem("✎ Change user's chips");
        MenuItem newGameItem = new MenuItem("New Game");
        MenuItem howToPlayItem = new MenuItem("How to play");
        MenuItem exitItem = new MenuItem("Exit");
        SeparatorMenuItem separatorItem = new SeparatorMenuItem();

        changeChipsItem.setOnAction(new ChangeChipsHandler(this));
        newGameItem.setOnAction(new NewGameHandler(this));
        howToPlayItem.setOnAction(new HowToPlayHandler());
        exitItem.setOnAction(new ExitHandler());

        menu.getItems().add(changeChipsItem);
        menu.getItems().add(newGameItem);
        menu.getItems().add(howToPlayItem);
        menu.getItems().add(separatorItem);
        menu.getItems().add(exitItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        return menuBar;
    }

}
