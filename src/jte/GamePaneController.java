/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Jun
 */
public class GamePaneController implements Initializable {

    boolean won = false;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private Label playerName;
    @FXML
    private AnchorPane midPane;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private ImageView mapAC14;
    @FXML
    private ImageView mapDF14;
    @FXML
    private ImageView mapAC58;
    @FXML
    private ImageView mapDF58;
    @FXML
    private ImageView dice;
    @FXML
    private Text playerTurnText;
    @FXML
    private ImageView mapImg;
    double xx = 0;
    double yy = 0;
    ChangePanes chmap = new ChangePanes();
    @FXML
    private Label cityname;
    @FXML
    private AnchorPane basepane;
    boolean a1 = true;
    /**
     * Initializes the controller class.
     */
    int q = 1;
    int CardCount = 0;
    boolean showCityInfo = false;
    Image plImg = new Image("file:src/jte/img/piece_black.png");
    Random rand = new Random();
    AllData lp = new AllData();
    int inc = 1;
    boolean movedherebefore = false;
    @FXML
    private AnchorPane secondmidPane;
    @FXML
    private ImageView rightPlayerImg;
    Timeline animation;
    int pcounter = 0;
    int setp = AllData.players;
    @FXML
    private Button startGameButton;
    @FXML
    private Button cityInfoButton;
    @FXML
    private Label RmovesLeft;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rightPlayerImg.setImage(plImg);
        playerName.setText(AllData.playerNames[AllData.currentplayingPlayer]);
        playerTurnText.setText(AllData.playerNames[AllData.currentplayingPlayer]);

        dice.setOnMouseClicked(e -> {
            if (AllData.trolled == false) {
                chmap.changeMap(mapImg, q);
                switch (AllData.currentplayingPlayer) {
                    case 1:
                        plImg = new Image("file:src/jte/img/piece_blue.png");
                        rightPlayerImg.setImage(plImg);
                        break;
                    case 2:
                        plImg = new Image("file:src/jte/img/piece_green.png");
                        rightPlayerImg.setImage(plImg);
                        break;
                    case 3:
                        plImg = new Image("file:src/jte/img/piece_red.png");
                        rightPlayerImg.setImage(plImg);
                        break;
                    case 4:
                        plImg = new Image("file:src/jte/img/piece_white.png");
                        rightPlayerImg.setImage(plImg);
                        break;
                    case 5:
                        plImg = new Image("file:src/jte/img/piece_yellow.png");
                        rightPlayerImg.setImage(plImg);
                        break;
                    case 0:
                        plImg = new Image("file:src/jte/img/piece_black.png");
                        rightPlayerImg.setImage(plImg);
                        break;
                }
                lp.drawLinesinPane(secondmidPane, 0, q);
                AllData.playerMoved[0] = AllData.playerCurrentCity[AllData.currentplayingPlayer];
                for (int i = 0; i < AllData.players; i++) {
                    if (AllData.playerQ[i] != q) {
                        AllData.playerLabel[i].setVisible(false);
                    } else {
                        AllData.playerLabel[i].setVisible(true);
                    }
                    if (AllData.playerFlagQ[i] != q) {
                        AllData.playerFlag[i].setVisible(false);
                    } else {
                        AllData.playerFlag[i].setVisible(true);
                    }
                }
                for (int i = 0; i < AllData.players; i++) {
                    if (i != AllData.currentplayingPlayer) {
                        for (int j = 0; j < AllData.totalcards; j++) {
                            AllData.playerCards[i][j].setVisible(false);
                        }
                    } else {
                        for (int j = 0; j < AllData.totalcards; j++) {
                            if (!AllData.playerCardsNames[i][j].equals("done")) {
                                AllData.playerCards[i][j].setVisible(true);
                            }
                        }
                    }
                }
                Ai gg = new Ai();
                gg.initAI();
                rollDice(dice, RmovesLeft);
                AllData.trolled = true;
                inc = 1;
                movedherebefore = false;
                if (a1 == true) {
                    int c8 = 0;
                    for (int c7 = 0; c7 < AllData.players; c7++) {
                        c8 = 0;
                        for (int c9 = 0; c9 < AllData.totalcards; c9++) {
                            AllData.playerCards[c7][c9].setLayoutX(0);
                            AllData.playerCards[c7][c9].setLayoutY(c8);
                            c8 += 6;
                        }
                    }
                    a1 = false;
                }
                Timeline tl = new Timeline();
                tl.setCycleCount(Animation.INDEFINITE);
                KeyFrame moveBall = new KeyFrame(Duration.seconds(1.5), (ActionEvent event) -> {
                    if (AllData.FMAP == true) {
                        AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                        AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                        q = (int) CSV.mapQuarter[AllData.kk];
                        AllData.playerQ[AllData.currentplayingPlayer] = q;
                        AllData.playerMoved[inc++] = CSV.mapName[AllData.kk];
                        changePosition(CSV.mapName[AllData.kk], CSV.mapX[AllData.kk], CSV.mapY[AllData.kk], AllData.kk, AllData.currentplayingPlayer, (int) CSV.mapQuarter[AllData.kk]);
                        RmovesLeft.setText("" + AllData.moves);
                        for (int hh = 0; hh < AllData.totalcards; hh++) {
                            if (AllData.playerCardsNames[AllData.currentplayingPlayer][hh].equals(AllData.playerCurrentCity[AllData.currentplayingPlayer])) {
                                if (hh == 0) {
                                    for (int kb = 1; kb < AllData.totalcards; kb++) {
                                        if (AllData.playerCardsNames[AllData.currentplayingPlayer][kb].equals("done")) {
                                            CardCount++;
                                        }
                                    }
                                    if (CardCount == 7) {
                                        AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                        AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                        leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                        AllData.moves = 0;
                                        RmovesLeft.setText("" + AllData.moves);
                                        System.out.println("you won!!!");
                                        won = true;
                                        final Stage dialog = new Stage();
                                        VBox dialogVbox = new VBox(20);
                                        Label info = new Label();
                                        info.setPrefSize(200, 100);
                                        info.setText(AllData.playerNames[AllData.currentplayingPlayer] + " WON!!!");
                                        info.setWrapText(true);
                                        info.setFont(new Font("SansSerif", 20));
                                        info.setAlignment(Pos.CENTER);
                                        dialogVbox.getChildren().add(info);
                                        Scene dialogScene = new Scene(dialogVbox, 200, 100);
                                        dialog.setScene(dialogScene);
                                        dialog.show();
                                    } else {
                                        CardCount = 0;
                                    }
                                } else {
                                    AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                    AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                    leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                    AllData.moves = 0;
                                    RmovesLeft.setText("" + AllData.moves);
                                }
                            }
                        }
                        if (!won) {
                            if (AllData.moves == 0) {
                                int qq = lp.endT(playerName, playerTurnText, secondmidPane, q, mapImg, chmap, plImg, rightPlayerImg);
                                q = qq;
                                chmap.changeMap(mapImg, q);
                                lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);
                                for (int ib = 0; ib < AllData.players; ib++) {
                                    if (ib != AllData.currentplayingPlayer) {
                                        for (int jb = 0; jb < AllData.totalcards; jb++) {
                                            AllData.playerCards[ib][jb].setVisible(false);
                                        }
                                    } else {
                                        for (int jb = 0; jb < AllData.totalcards; jb++) {
                                            if (!AllData.playerCardsNames[ib][jb].equals("done")) {
                                                AllData.playerCards[ib][jb].setVisible(true);
                                            }
                                        }
                                    }
                                }
                                inc = 1;
                                movedherebefore = false;
                                rollDice(dice, RmovesLeft);
                                AllData.playerMoved[0] = AllData.playerCurrentCity[AllData.currentplayingPlayer];

                            }
                        }
                        AllData.FMAP = false;
                    } else {
                        MovePlayer();
                    }
                });
                tl.getKeyFrames().add(moveBall);
                tl.play();

            }
        });

        mapAC14.setOnMouseClicked(e -> {
            q = 1;
            chmap.changeMap(mapImg, q);
            lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);

        });
        mapDF14.setOnMouseClicked(e -> {
            q = 2;
            chmap.changeMap(mapImg, q);
            lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);

        });
        mapAC58.setOnMouseClicked(e -> {
            q = 3;
            chmap.changeMap(mapImg, q);
            lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);

        });
        mapDF58.setOnMouseClicked(e -> {
            q = 4;
            chmap.changeMap(mapImg, q);
            lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);

        });
        midPane.setOnMouseMoved(e -> {
            double x = e.getX();
            double y = e.getY();
            for (int i = 0; i < CSV.inc2; i++) {
                if (CSV.mapQuarter[i] == q) {
                    if ((((x - CSV.mapX[i]) <= 10) && ((x - CSV.mapX[i]) >= -10)) && ((((y - CSV.mapY[i]) <= 10) && ((y - CSV.mapY[i]) >= -10))) && ((yy != CSV.mapY[i]) || (xx != CSV.mapX[i]))) {
                        xx = CSV.mapX[i];
                        yy = CSV.mapY[i];
                        cityname.setText(CSV.mapName[i]);
                        break;
                    }
                }
            }
        });
        midPane.setOnMouseDragged(e -> {
            double x=e.getX();
            double y=e.getY();
            AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(x-CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]]);
            AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(y-CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]]);
            
        });
        midPane.setOnMouseReleased(e
                -> {
                    if (showCityInfo == true) {
                        double x1 = e.getX();
                        double y1 = e.getY();
                        for (int i = 0; i < CSV.inc2; i++) {
                            if (CSV.mapQuarter[i] == q) {
                                if ((((x1 - CSV.mapX[i]) <= 10) && ((x1 - CSV.mapX[i]) >= -10)) && ((((y1 - CSV.mapY[i]) <= 10) && ((y1 - CSV.mapY[i]) >= -10)))) {
                                    for (int j = 0; j < CSV.inc1; j++) {
                                        if (CSV.cityNameInfo[j].equals(CSV.mapName[i])) {
                                            System.out.println(CSV.cityInfoData[j]);
                                            final Stage dialog = new Stage();
                                            VBox dialogVbox = new VBox(20);
                                            Label info = new Label();
                                            info.setPrefSize(400, 300);
                                            info.setText(CSV.cityInfoData[j]);
                                            info.setWrapText(true);
                                            dialogVbox.getChildren().add(info);
                                            Scene dialogScene = new Scene(dialogVbox, 400, 300);
                                            dialog.setScene(dialogScene);
                                            dialog.setTitle(CSV.cityNameInfo[j]);
                                            dialog.show();
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!won) {
                        if (AllData.moves > 0) {
                            movedherebefore = false;
                            double x = e.getX();
                            double y = e.getY();
                            for (int i = 0; i < CSV.inc2; i++) {
                                if (CSV.mapQuarter[i] == q) {
                                    if ((((x - CSV.mapX[i]) <= 10) && ((x - CSV.mapX[i]) >= -10)) && ((((y - CSV.mapY[i]) <= 10) && ((y - CSV.mapY[i]) >= -10)))) {
                                        for (int j = 0; j < CSV.inc2; j++) {
                                            if (CSV.mapName[i].equals(XMLParser.ctNames[j])) {
                                                for (int k = 0; k < XMLParser.nLand[j]; k++) {
                                                    if ((k + 1) % 2 == 0) {
                                                        if (AllData.playerCurrentCity[AllData.currentplayingPlayer].equals(XMLParser.ctLand[j][k])) {
                                                            for (int qq = 0; qq < inc; qq++) {
                                                                if (AllData.playerMoved[qq].equals(CSV.mapName[i])) {
                                                                    movedherebefore = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (movedherebefore == false) {
                                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                                AllData.playerMoved[inc++] = XMLParser.ctLand[j][k];
                                                                q = (int) CSV.mapQuarter[i];
                                                                AllData.playerQ[AllData.currentplayingPlayer] = q;
                                                                changePosition(CSV.mapName[i], CSV.mapX[i], CSV.mapY[i], i, AllData.currentplayingPlayer, q);
                                                                AllData.moves--;
                                                                RmovesLeft.setText("" + AllData.moves);
                                                                //                   System.out.println("holdmoves = "+AllData.holdmoves);

                                                                for (int hh = 0; hh < AllData.totalcards; hh++) {
                                                                    if (AllData.playerCardsNames[AllData.currentplayingPlayer][hh].equals(AllData.playerCurrentCity[AllData.currentplayingPlayer])) {
                                                                        if (hh == 0) {
                                                                            for (int kb = 1; kb < AllData.totalcards; kb++) {
                                                                                if (AllData.playerCardsNames[AllData.currentplayingPlayer][kb].equals("done")) {
                                                                                    CardCount++;
                                                                                }
                                                                            }
                                                                            if (CardCount == 7) {
                                                                                AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                                                                AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                                                                leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                                                                AllData.moves = 0;
                                                                                RmovesLeft.setText("" + AllData.moves);
                                                                                System.out.println("you won!!!");
                                                                                won = true;
                                                                                final Stage dialog = new Stage();
                                                                                VBox dialogVbox = new VBox(20);
                                                                                Label info = new Label();
                                                                                info.setPrefSize(200, 100);
                                                                                info.setAlignment(Pos.CENTER);
                                                                                info.setText("**********\n" + AllData.playerNames[AllData.currentplayingPlayer] + " WON!!!\n" + "**********");
                                                                                info.setWrapText(true);
                                                                                info.setFont(new Font("SansSerif", 20));
                                                                                info.setAlignment(Pos.CENTER);
                                                                                dialogVbox.getChildren().add(info);
                                                                                Scene dialogScene = new Scene(dialogVbox, 200, 100);
                                                                                dialog.setScene(dialogScene);
                                                                                dialog.show();
                                                                            } else {
                                                                                CardCount = 0;
                                                                            }
                                                                        } else {
                                                                            AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                                                            AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                                                            leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                                                            AllData.moves = 0;
                                                                            RmovesLeft.setText("" + AllData.moves);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!won) {
                                                                if (AllData.moves == 0) {
                                                                    int qq = lp.endT(playerName, playerTurnText, secondmidPane, q, mapImg, chmap, plImg, rightPlayerImg);
                                                                    q = qq;
                                                                    chmap.changeMap(mapImg, q);
                                                                    lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);
                                                                    for (int ib = 0; ib < AllData.players; ib++) {
                                                                        if (ib != AllData.currentplayingPlayer) {
                                                                            for (int jb = 0; jb < AllData.totalcards; jb++) {
                                                                                AllData.playerCards[ib][jb].setVisible(false);
                                                                            }
                                                                        } else {
                                                                            for (int jb = 0; jb < AllData.totalcards; jb++) {
                                                                                if (!AllData.playerCardsNames[ib][jb].equals("done")) {
                                                                                    AllData.playerCards[ib][jb].setVisible(true);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    inc = 1;
                                                                    movedherebefore = false;
                                                                    rollDice(dice, RmovesLeft);
                                                                    AllData.playerMoved[0] = AllData.playerCurrentCity[AllData.currentplayingPlayer];

                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                for (int k = 0; k < XMLParser.nSea[j]; k++) {
                                                    if ((k + 1) % 2 == 0) {
                                                        if (AllData.playerCurrentCity[AllData.currentplayingPlayer].equals(XMLParser.ctSea[j][k])) {
                                                            AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                            AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                            q = (int) CSV.mapQuarter[i];
                                                            AllData.playerQ[AllData.currentplayingPlayer] = q;
                                                            AllData.playerMoved[inc++] = XMLParser.ctLand[j][k];
                                                            changePosition(CSV.mapName[i], CSV.mapX[i], CSV.mapY[i], i, AllData.currentplayingPlayer, q);
                                                            AllData.moves = 0;
                                                            RmovesLeft.setText("" + AllData.moves);
                                                            for (int hh = 0; hh < AllData.totalcards; hh++) {
                                                                if (AllData.playerCardsNames[AllData.currentplayingPlayer][hh].equals(AllData.playerCurrentCity[AllData.currentplayingPlayer])) {
                                                                    if (hh == 0) {
                                                                        for (int kb = 1; kb < AllData.totalcards; kb++) {
                                                                            if (AllData.playerCardsNames[AllData.currentplayingPlayer][kb].equals("done")) {
                                                                                CardCount++;
                                                                            }
                                                                        }
                                                                        if (CardCount == 7) {
                                                                            AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                                                            AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                                                            leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                                                            AllData.moves = 0;
                                                                            RmovesLeft.setText("" + AllData.moves);
                                                                            System.out.println("you won!!!");
                                                                            won = true;
                                                                            final Stage dialog = new Stage();
                                                                            VBox dialogVbox = new VBox(20);
                                                                            Label info = new Label();
                                                                            info.setPrefSize(200, 100);
                                                                            info.setAlignment(Pos.CENTER);
                                                                            info.setText("**********\n" + AllData.playerNames[AllData.currentplayingPlayer] + " WON!!!\n" + "**********");
                                                                            info.setWrapText(true);
                                                                            info.setFont(new Font("SansSerif", 20));
                                                                            info.setAlignment(Pos.CENTER);
                                                                            dialogVbox.getChildren().add(info);
                                                                            Scene dialogScene = new Scene(dialogVbox, 200, 100);
                                                                            dialog.setScene(dialogScene);
                                                                            dialog.show();
                                                                        } else {
                                                                            CardCount = 0;
                                                                        }
                                                                    } else {
                                                                        AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                                                        AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                                                        leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                                                        AllData.moves = 0;
                                                                        RmovesLeft.setText("" + AllData.moves);
                                                                    }
                                                                }
                                                            }
                                                            if (!won) {
                                                                if (AllData.moves == 0) {
                                                                    int qq = lp.endT(playerName, playerTurnText, secondmidPane, q, mapImg, chmap, plImg, rightPlayerImg);
                                                                    q = qq;
                                                                    chmap.changeMap(mapImg, q);
                                                                    lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);
                                                                    for (int ib = 0; ib < AllData.players; ib++) {
                                                                        if (ib != AllData.currentplayingPlayer) {
                                                                            for (int jb = 0; jb < AllData.totalcards; jb++) {
                                                                                AllData.playerCards[ib][jb].setVisible(false);
                                                                            }
                                                                        } else {
                                                                            for (int jb = 0; jb < AllData.totalcards; jb++) {
                                                                                if (!AllData.playerCardsNames[ib][jb].equals("done")) {
                                                                                    AllData.playerCards[ib][jb].setVisible(true);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    inc = 1;
                                                                    movedherebefore = false;
                                                                    rollDice(dice, RmovesLeft);
                                                                    AllData.playerMoved[0] = AllData.playerCurrentCity[AllData.currentplayingPlayer];

                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
        );
    }

    public synchronized void MovePlayer() {
        if (!won) {
            if (AllData.realPlayers[AllData.currentplayingPlayer] == false && AllData.moves > 0) {
                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                AllData.playerQ[AllData.currentplayingPlayer] = q;
                boolean t1 = true;
                int i;
                for (i = 0; i < CSV.inc2; i++) {
                    if (t1 == true) {
                        switch (AllData.currentplayingPlayer) {
                            case 0:
                                String ok = AllData.playerAI1.get(0).toString();
                                if (ok.equals(CSV.mapName[i])) {
                                    AllData.playerAI1.remove(0);
                                    t1 = false;
                                }
                                break;
                            case 1:
                                String ok1 = AllData.playerAI2.get(0).toString();
                                if (ok1.equals(CSV.mapName[i])) {
                                    AllData.playerAI2.remove(0);
                                    t1 = false;
                                }
                                break;
                            case 2:
                                String ok2 = AllData.playerAI3.get(0).toString();
                                if (ok2.equals(CSV.mapName[i])) {
                                    AllData.playerAI3.remove(0);
                                    t1 = false;
                                }
                                break;
                            case 3:
                                String ok3 = AllData.playerAI4.get(0).toString();
                                if (ok3.equals(CSV.mapName[i])) {
                                    AllData.playerAI4.remove(0);
                                    t1 = false;
                                }
                                break;
                            case 4:
                                String ok4 = AllData.playerAI5.get(0).toString();
                                if (ok4.equals(CSV.mapName[i])) {
                                    AllData.playerAI5.remove(0);
                                    t1 = false;
                                }
                                break;
                            case 5:
                                String ok5 = AllData.playerAI6.get(0).toString();
                                if (ok5.equals(CSV.mapName[i])) {
                                    AllData.playerAI6.remove(0);
                                    t1 = false;
                                }
                                break;
                        }
                    } else {
                        break;
                    }
                }
                i--;
                System.out.println(CSV.mapName[i] + "   currentplayer = " + AllData.currentplayingPlayer);
                q = (int) CSV.mapQuarter[i];
                changePosition(CSV.mapName[i], CSV.mapX[i], CSV.mapY[i], i, AllData.currentplayingPlayer, q);
                AllData.moves--;
                RmovesLeft.setText("" + AllData.moves);
                for (int hh = 0; hh < AllData.totalcards; hh++) {
                    if (AllData.playerCardsNames[AllData.currentplayingPlayer][hh].equals(AllData.playerCurrentCity[AllData.currentplayingPlayer])) {
                        if (hh == 0) {
                            for (int kb = 1; kb < AllData.totalcards; kb++) {
                                if (AllData.playerCardsNames[AllData.currentplayingPlayer][kb].equals("done")) {
                                    CardCount++;
                                }
                            }
                            if (CardCount == 7) {
                                AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                                AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                                leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                                AllData.moves = 0;
                                RmovesLeft.setText("" + AllData.moves);
                                System.out.println("you won!!!");
                                won = true;
                                final Stage dialog = new Stage();
                                VBox dialogVbox = new VBox(20);
                                Label info = new Label();
                                info.setPrefSize(200, 100);
                                info.setAlignment(Pos.CENTER);
                                info.setText("**********\n" + AllData.playerNames[AllData.currentplayingPlayer] + " WON!!!\n" + "**********");
                                info.setWrapText(true);
                                info.setFont(new Font("SansSerif", 20));
                                info.setAlignment(Pos.CENTER);
                                dialogVbox.getChildren().add(info);
                                Scene dialogScene = new Scene(dialogVbox, 200, 100);
                                dialog.setScene(dialogScene);
                                dialog.show();
                            } else {
                                CardCount = 0;
                            }
                        } else {
                            AllData.playerCardsNames[AllData.currentplayingPlayer][hh] = "done";
                            AllData.playerCardIndex[AllData.currentplayingPlayer][hh] = 1000;
                            leftPane.getChildren().remove(AllData.playerCards[AllData.currentplayingPlayer][hh]);
                            AllData.moves = 0;
                            RmovesLeft.setText("" + AllData.moves);
                        }
                    }

                }
                if (!won) {
                    if (AllData.moves <= 0) {
                        int qq = lp.endT(playerName, playerTurnText, secondmidPane, q, mapImg, chmap, plImg, rightPlayerImg);
                        q = qq;
                        chmap.changeMap(mapImg, q);
                        lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);
                        for (int ib = 0; ib < AllData.players; ib++) {
                            if (ib != AllData.currentplayingPlayer) {
                                for (int jb = 0; jb < AllData.totalcards; jb++) {
                                    AllData.playerCards[ib][jb].setVisible(false);
                                }
                            } else {
                                for (int jb = 0; jb < AllData.totalcards; jb++) {
                                    if (!AllData.playerCardsNames[ib][jb].equals("done")) {
                                        AllData.playerCards[ib][jb].setVisible(true);
                                    }
                                }
                            }
                        }
                        inc = 1;
                        movedherebefore = false;
                        rollDice(dice, RmovesLeft);
                        AllData.playerMoved[0] = AllData.playerCurrentCity[AllData.currentplayingPlayer];

                    }
                }
            }
        }
    }

    @FXML
    private void flightPlan(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("flightPane.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Flight Route");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gameHistory(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("historyPane.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Game History");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void about(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("aboutPane.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("About Page");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void save(ActionEvent event) {
        try {
            FileWriter write = new FileWriter("savedData.txt", false);
            PrintWriter print = new PrintWriter(write);
            print.printf("%d\n", AllData.players);
            for (int pq = 0; pq < AllData.players; pq++) {
                print.printf("%s %d %d %d %d ", AllData.playerNames[pq], AllData.playerPieceIndex[pq], AllData.playerL[pq], AllData.playerQ[pq], AllData.playerFlagQ[pq]);
                if (true == AllData.realPlayers[pq]) {
                    print.printf("1 ");
                } else {
                    print.printf("0 ");
                }
                if (pq == AllData.currentplayingPlayer) {
                    print.printf("1\n");
                } else {
                    print.printf("0\n");
                }
                for (int qp = 0; qp < AllData.totalcards; qp++) {
                    print.printf("%d ", AllData.playerCardIndex[pq][qp]);
                }
                print.printf("\n");
            }
            print.close();

        } catch (IOException ex) {
            Logger.getLogger(GamePaneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter write1 = new FileWriter("savedHistoryText.txt", false);
            PrintWriter print1 = new PrintWriter(write1);
            print1.printf("%s", AllData.HistoryText);
            print1.close();

        } catch (IOException ex) {
            Logger.getLogger(GamePaneController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void endTurn(ActionEvent event) {
        int qq = lp.endT(playerName, playerTurnText, secondmidPane, q, mapImg, chmap, plImg, rightPlayerImg);
        q = qq;
        inc = 1;
        movedherebefore = false;
        lp.drawLinesinPane(secondmidPane, AllData.currentplayingPlayer, q);
        for (int i = 0; i < AllData.players; i++) {
            if (i != AllData.currentplayingPlayer) {
                for (int j = 0; j < AllData.totalcards; j++) {
                    AllData.playerCards[i][j].setVisible(false);
                }
            } else {
                for (int j = 0; j < AllData.totalcards; j++) {
                    if (!AllData.playerCardsNames[i][j].equals("done")) {
                        AllData.playerCards[i][j].setVisible(true);
                    }
                }
            }
        }
        rollDice(dice, RmovesLeft);
        movedherebefore = false;
        AllData.playerMoved[0] = AllData.playerCurrentCity[AllData.currentplayingPlayer];

    }

    @FXML
    private void startGame(ActionEvent event) {
        AllData.cpp = AllData.players - 1;
        AllData.cppp = AllData.players - 1;
        EventHandler<ActionEvent> eH = e -> {

            if (setp > 0) {
                q = lp.setPosition(midPane, mapImg, leftPane, setp--);
                for (int i = AllData.players - 1; i > setp; i--) {
                    if (AllData.playerQ[i] != q) {
                        AllData.playerLabel[i].setVisible(false);
                    } else {
                        AllData.playerLabel[i].setVisible(true);
                    }
                    if (AllData.playerFlagQ[i] != q) {
                        AllData.playerFlag[i].setVisible(false);
                    } else {
                        AllData.playerFlag[i].setVisible(true);
                    }
                }
                for (int i = AllData.players - 1; i > setp; i--) {
                    if (i != AllData.currentplayingPlayer) {
                        for (int j = 0; j < AllData.totalcards; j++) {
                            AllData.playerCards[i][j].setVisible(false);
                        }
                    } else {
                        for (int j = 0; j < AllData.totalcards; j++) {
                            if (!AllData.playerCardsNames[i][j].equals("done")) {
                                AllData.playerCards[i][j].setVisible(true);
                            }
                        }
                    }
                }
            }
            pcounter++;
            if (pcounter >= AllData.players + 2) {
                animation.stop();
            }
        };
        animation = new Timeline(new KeyFrame(Duration.millis(5000), eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        startGameButton.setDisable(true);
    }

    @FXML
    private void cityInfo(ActionEvent event) {
        if (showCityInfo == false) {
            showCityInfo = true;
            cityInfoButton.setText("City Info: ON");
        } else {
            showCityInfo = false;
            cityInfoButton.setText("City Info: OFF");
        }
    }
    int khh = 0;
    int kll = 0;
    Image di = new Image("file:src/jte/img/die_1.jpg");

    public synchronized void rollDice(ImageView dice, Label RmovesLeft) {
        khh = 0;
        AllData.rolling = true;
        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        tl.getKeyFrames().add(new KeyFrame(Duration.seconds(.05), new EventHandler() {
            @Override
            public void handle(Event event) {
                khh++;
                for (int kh = 0; kh < 10; kh++) {
                    int dic = rand.nextInt(6);

                    switch (dic) {
                        case 0:
                            di = new Image("file:src/jte/img/die_1.jpg");
                            AllData.moves = 1;
                            break;
                        case 1:
                            di = new Image("file:src/jte/img/die_2.jpg");
                            AllData.moves = 2;
                            break;
                        case 2:
                            di = new Image("file:src/jte/img/die_3.jpg");
                            AllData.moves = 3;
                            break;
                        case 3:
                            di = new Image("file:src/jte/img/die_4.jpg");
                            AllData.moves = 4;
                            break;
                        case 4:
                            di = new Image("file:src/jte/img/die_5.jpg");
                            AllData.moves = 5;
                            break;
                        case 5:
                            di = new Image("file:src/jte/img/die_6.jpg");
                            AllData.moves = 6;
                            break;
                    }
                    dice.setImage(di);
                }
                if (khh >= 30) {
                    RmovesLeft.setText("" + AllData.moves);
                    AllData.holdmoves = AllData.moves;
                    tl.stop();
                }
            }
        }));

        tl.playFromStart();

    }

    public synchronized void changePosition(String cCity, double x, double y, int a, int player, int qu) {
        String tempstr = AllData.playerNames[AllData.currentplayingPlayer] + " moved to " + cCity + "\n";
        AllData.HistoryText += tempstr;
        chmap.changeMap(mapImg, qu);
        AllData.playerQ[AllData.currentplayingPlayer] = qu;
        AllData.playerCurrentCity[player] = cCity;
        AllData.playerL[player] = a;
        double xx = x - AllData.playerLabel[player].getLayoutX();
        double yy = y - AllData.playerLabel[player].getLayoutY();
        Path path = new Path();
        path.getElements().add(new MoveTo(100, 100));
        path.getElements().add(new LineTo(xx, yy));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(path);
        pathTransition.setNode(AllData.playerLabel[player]);
        pathTransition.setCycleCount(1);
        pathTransition.play();
        lp.drawLinesinPane(secondmidPane, player, qu);

    }

}
