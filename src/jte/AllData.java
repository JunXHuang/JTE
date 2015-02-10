/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Jun
 */
public class AllData {
    public static int holdmoves=0;
   public static int totalcards=8;
public static boolean rolling=false;
    public static boolean fromLoad = false;
    public static int currentplayingPlayer = 0;
    public static int moves = 0;
    public static int players = 6;
    public static int kk = 1000;
    public static String[] playerNames = new String[6];
    public static boolean[] realPlayers = new boolean[6];
    public static int[] playerL = new int[6];
    public static Label[] playerLabel = new Label[6];
    public static int[] playerQ = new int[6];
    public static String[] playerCurrentCity = new String[6];
    public static boolean trolled = false;
    public static Label[][] playerCards = new Label[6][totalcards];
    public static String[][] playerCardsNames = new String[6][totalcards];
    public static Label[] playerFlag = new Label[6];
    public static String[] playerMoved = new String[20];
    public static int[] playerFlagQ = new int[6];
    public static int[][] playerCardIndex = new int[6][totalcards];
    public static int[] playerPieceIndex = new int[6];
    public static int cpp = 0;
    public static int cppp = 0;
    public static List playerAI1;
    public static List playerAI2;
    public static List playerAI3;
    public static List playerAI4;
    public static List playerAI5;
    public static List playerAI6;
   public static String HistoryText="";
   public static boolean FMAP=false;

    public synchronized int setPosition(AnchorPane midPane, ImageView mapImg, AnchorPane leftPane, int setp) {
        Random rand = new Random();
        int i = 0;
        Image playerImage;
        ImageView imageView;
        ImageView imageView1;
        int q = 1;
        Path path = new Path();
        PathTransition pathTransition = new PathTransition();
        Path pathF = new Path();
        PathTransition pathTransitionF = new PathTransition();
        i = rand.nextInt(CSV.inc2);
        switch (setp) {
            case 6:
                i = initCardsAndShit(leftPane, 5, 0);
                if (fromLoad == true) {
                    i = playerL[5];
                }
                q = changeQ(i, mapImg);
                playerL[5] = i;
                playerQ[5] = q;
                playerFlagQ[5] = q;
                playerCurrentCity[5] = CSV.mapName[i];
                playerImage = new Image("file:src/jte/img/piece_yellow.png");
                imageView = new ImageView(playerImage);
                playerLabel[5] = new Label();
                playerLabel[5].setGraphic(imageView);
                playerLabel[5].setScaleX(.15);
                playerLabel[5].setScaleY(.15);
                path.getElements().add(new MoveTo(0, 0));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransition.setDuration(Duration.millis(1800));
                pathTransition.setPath(path);
                pathTransition.setNode(playerLabel[5]);
                pathTransition.setCycleCount(1);
                pathTransition.play();
                
                midPane.getChildren().add(playerLabel[5]);
                if (fromLoad == true) {
                    i = playerPieceIndex[5];
                }
                playerPieceIndex[5] = i;
                q = changeQ(i, mapImg);
                playerImage = new Image("file:src/jte/img/flag_yellow.png");
                imageView1 = new ImageView(playerImage);
                playerFlag[5] = new Label();
                playerFlag[5].setGraphic(imageView1);
                playerFlag[5].setScaleX(.2);
                playerFlag[5].setScaleY(.2);
                pathF.getElements().add(new MoveTo(500, 500));
                pathF.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransitionF.setDuration(Duration.millis(1800));
                pathTransitionF.setPath(path);
                pathTransitionF.setNode(playerFlag[5]);
                pathTransitionF.setCycleCount(1);
                pathTransitionF.play();
                midPane.getChildren().add(playerFlag[5]);
                break;
            case 5:
                
                i = initCardsAndShit(leftPane, 4, 2);
                if (fromLoad == true) {
                    i = playerL[4];
                }
                playerL[4] = i;
                q = changeQ(i, mapImg);

                playerQ[4] = q;
                playerFlagQ[4] = q;
                playerCurrentCity[4] = CSV.mapName[i];
                playerImage = new Image("file:src/jte/img/piece_white.png");
                imageView = new ImageView(playerImage);
                playerLabel[4] = new Label();
                playerLabel[4].setGraphic(imageView);
                playerLabel[4].setScaleX(.15);
                playerLabel[4].setScaleY(.15);
                path.getElements().add(new MoveTo(0, 0));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransition.setDuration(Duration.millis(1800));
                pathTransition.setPath(path);
                pathTransition.setNode(playerLabel[4]);
                pathTransition.setCycleCount(1);
                pathTransition.play();
                midPane.getChildren().add(playerLabel[4]);
                if (fromLoad == true) {
                    i = playerPieceIndex[4];
                }
                playerPieceIndex[4] = i;
                q = changeQ(i, mapImg);
                playerImage = new Image("file:src/jte/img/flag_white.png");
                imageView1 = new ImageView(playerImage);
                playerFlag[4] = new Label();
                playerFlag[4].setGraphic(imageView1);
                playerFlag[4].setScaleX(.2);
                playerFlag[4].setScaleY(.2);
                pathF.getElements().add(new MoveTo(500, 500));
                pathF.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransitionF.setDuration(Duration.millis(1800));
                pathTransitionF.setPath(path);
                pathTransitionF.setNode(playerFlag[4]);
                pathTransitionF.setCycleCount(1);
                pathTransitionF.play();
                midPane.getChildren().add(playerFlag[4]);

                break;

            case 4:
                
                initCardsAndShit(leftPane, 3, 1);
                if (fromLoad == true) {
                    i = playerL[3];
                }
                playerL[3] = i;
                q = changeQ(i, mapImg);

                playerCurrentCity[3] = CSV.mapName[i];
                playerQ[3] = q;
                playerFlagQ[3] = q;
                playerImage = new Image("file:src/jte/img/piece_red.png");
                imageView = new ImageView(playerImage);
                playerLabel[3] = new Label();
                playerLabel[3].setGraphic(imageView);
                playerLabel[3].setScaleX(.15);
                playerLabel[3].setScaleY(.15);
                path.getElements().add(new MoveTo(0, 0));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransition.setDuration(Duration.millis(1800));
                pathTransition.setPath(path);
                pathTransition.setNode(playerLabel[3]);
                pathTransition.setCycleCount(1);
                pathTransition.play();
                midPane.getChildren().add(playerLabel[3]);
                if (fromLoad == true) {
                    i = playerPieceIndex[3];
                }
                playerPieceIndex[3] = i;
                q = changeQ(i, mapImg);
                playerImage = new Image("file:src/jte/img/flag_red.png");
                imageView1 = new ImageView(playerImage);
                playerFlag[3] = new Label();
                playerFlag[3].setGraphic(imageView1);
                playerFlag[3].setScaleX(.2);
                playerFlag[3].setScaleY(.2);
                pathF.getElements().add(new MoveTo(500, 500));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransitionF.setDuration(Duration.millis(1800));
                pathTransitionF.setPath(path);
                pathTransitionF.setNode(playerFlag[3]);
                pathTransitionF.setCycleCount(1);
                pathTransitionF.play();
                midPane.getChildren().add(playerFlag[3]);

                break;
            case 3:
                
                i = initCardsAndShit(leftPane, 2, 0);
                if (fromLoad == true) {
                    i = playerL[2];
                }
                playerL[2] = i;
                q = changeQ(i, mapImg);

                playerCurrentCity[2] = CSV.mapName[i];

                playerQ[2] = q;
                playerFlagQ[2] = q;
                playerImage = new Image("file:src/jte/img/piece_green.png");
                imageView = new ImageView(playerImage);
                playerLabel[2] = new Label();
                playerLabel[2].setGraphic(imageView);
                playerLabel[2].setScaleX(.15);
                playerLabel[2].setScaleY(.15);
                path.getElements().add(new MoveTo(0, 0));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransition.setDuration(Duration.millis(1800));
                pathTransition.setPath(path);
                pathTransition.setNode(playerLabel[2]);
                pathTransition.setCycleCount(1);
                pathTransition.play();
                midPane.getChildren().add(playerLabel[2]);
                if (fromLoad == true) {
                    i = playerPieceIndex[2];
                }
                playerPieceIndex[2] = i;
                q = changeQ(i, mapImg);
                playerImage = new Image("file:src/jte/img/flag_green.png");
                imageView1 = new ImageView(playerImage);
                playerFlag[2] = new Label();
                playerFlag[2].setGraphic(imageView1);
                playerFlag[2].setScaleX(.2);
                playerFlag[2].setScaleY(.2);
                pathF.getElements().add(new MoveTo(500, 500));
                pathF.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransitionF.setDuration(Duration.millis(1800));
                pathTransitionF.setPath(path);
                pathTransitionF.setNode(playerFlag[2]);
                pathTransitionF.setCycleCount(1);
                pathTransitionF.play();
                midPane.getChildren().add(playerFlag[2]);
                break;
            case 2:
                i = initCardsAndShit(leftPane, 1, 2);
                if (fromLoad == true) {
                    i = playerL[1];
                }
                playerL[1] = i;
                q = changeQ(i, mapImg);
                playerCurrentCity[1] = CSV.mapName[i];
                playerQ[1] = q;
                playerFlagQ[1] = q;
                playerImage = new Image("file:src/jte/img/piece_blue.png");
                imageView = new ImageView(playerImage);
                playerLabel[1] = new Label();
                playerLabel[1].setGraphic(imageView);
                playerLabel[1].setScaleX(.15);
                playerLabel[1].setScaleY(.15);
                path.getElements().add(new MoveTo(0, 0));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransition.setDuration(Duration.millis(1800));
                pathTransition.setPath(path);
                pathTransition.setNode(playerLabel[1]);
                pathTransition.setCycleCount(1);
                pathTransition.play();
                midPane.getChildren().add(playerLabel[1]);
                if (fromLoad == true) {
                    i = playerPieceIndex[1];
                }
                playerPieceIndex[1] = i;
                q = changeQ(i, mapImg);
                playerImage = new Image("file:src/jte/img/flag_blue.png");
                imageView1 = new ImageView(playerImage);
                playerFlag[1] = new Label();
                playerFlag[1].setGraphic(imageView1);
                playerFlag[1].setScaleX(.2);
                playerFlag[1].setScaleY(.2);
                pathF.getElements().add(new MoveTo(500, 500));
                pathF.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransitionF.setDuration(Duration.millis(1800));
                pathTransitionF.setPath(path);
                pathTransitionF.setNode(playerFlag[1]);
                pathTransitionF.setCycleCount(1);
                pathTransitionF.play();
                midPane.getChildren().add(playerFlag[1]);
                break;
            case 1:
                i = initCardsAndShit(leftPane, 0, 1);
                if (fromLoad == true) {
                    i = playerL[0];
                }
                playerL[0] = i;
                q = changeQ(i, mapImg);
                playerCurrentCity[0] = CSV.mapName[i];
                playerQ[0] = q;
                playerFlagQ[0] = q;
                playerImage = new Image("file:src/jte/img/piece_black.png");
                imageView = new ImageView(playerImage);
                playerLabel[0] = new Label();
                playerLabel[0].setGraphic(imageView);
                playerLabel[0].setScaleX(.15);
                playerLabel[0].setScaleY(.15);
                path.getElements().add(new MoveTo(0, 0));
                path.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransition.setDuration(Duration.millis(1800));
                pathTransition.setPath(path);
                pathTransition.setNode(playerLabel[0]);
                pathTransition.setCycleCount(1);
                pathTransition.play();
                midPane.getChildren().add(playerLabel[0]);
                if (fromLoad == true) {
                    i = playerPieceIndex[0];
                }
                playerPieceIndex[0] = i;
                q = changeQ(i, mapImg);
                playerImage = new Image("file:src/jte/img/flag_black.png");
                imageView1 = new ImageView(playerImage);
                playerFlag[0] = new Label();
                playerFlag[0].setGraphic(imageView1);
                playerFlag[0].setScaleX(.2);
                playerFlag[0].setScaleY(.2);
                pathF.getElements().add(new MoveTo(500, 500));
                pathF.getElements().add(new LineTo(CSV.mapX[i], CSV.mapY[i]));
                pathTransitionF.setDuration(Duration.millis(1800));
                pathTransitionF.setPath(path);
                pathTransitionF.setNode(playerFlag[0]);
                pathTransitionF.setCycleCount(1);
                pathTransitionF.play();
                midPane.getChildren().add(playerFlag[0]);
                break;
        }
        return q;

    }

    public synchronized void drawLinesinPane(AnchorPane secondmidPane, int a, int qu) {
        int m = 0;
        secondmidPane.getChildren().clear();
        // System.out.println(playerCurrentCity[a]);
        if (AllData.playerQ[a] == qu) {
            for (int v = 0; v < CSV.inc2; v++) {
                if (CSV.mapName[v].equals(playerCurrentCity[a])) {
                    m = AllData.playerL[a];
                    for (int j = 0; j < CSV.inc2; j++) {
                        if (CSV.mapName[m].equals(XMLParser.ctNames[j])) {

                            for (int k = 0; k < XMLParser.nLand[j]; k++) {
                                if ((k + 1) % 2 == 0) {
                                    for (int jj = 0; jj < CSV.inc2; jj++) {
                                        if ((int) CSV.mapQuarter[jj] == AllData.playerQ[a]) {

                                            if (CSV.mapName[jj].equals(XMLParser.ctLand[j][k])) {
                                                Line line = new Line(CSV.mapX[m], CSV.mapY[m], CSV.mapX[jj], CSV.mapY[jj]);
                                                line.setStroke(Color.PURPLE);
                                                line.setStrokeWidth(5);
                                                secondmidPane.getChildren().add(line);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            for (int k = 0; k < XMLParser.nSea[j]; k++) {
                                if ((k + 1) % 2 == 0) {
                                    for (int jj = 0; jj < CSV.inc2; jj++) {
                                        if ((int) CSV.mapQuarter[jj] == AllData.playerQ[a]) {

                                            if (CSV.mapName[jj].equals(XMLParser.ctSea[j][k])) {
                                                Line line;

                                                line = new Line(CSV.mapX[m], CSV.mapY[m], CSV.mapX[jj], CSV.mapY[jj]);
                                                line.setStroke(Color.HOTPINK);
                                                line.setStrokeWidth(5);
                                                secondmidPane.getChildren().add(line);
                                                break;
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

    private synchronized int changeQ(int i, ImageView mapImg) {
        int q = 1;

        Image splashScreenImage;
        switch ((int) CSV.mapQuarter[i]) {
            case 1:
                splashScreenImage = new Image("file:src/jte/img/gameplay_AC14.jpg");
                mapImg.setImage(splashScreenImage);
                q = 1;
                break;
            case 2:
                splashScreenImage = new Image("file:src/jte/img/gameplay_DF14.jpg");
                mapImg.setImage(splashScreenImage);
                q = 2;
                break;
            case 3:
                splashScreenImage = new Image("file:src/jte/img/gameplay_AC58.jpg");
                mapImg.setImage(splashScreenImage);
                q = 3;
                break;
            case 4:
                splashScreenImage = new Image("file:src/jte/img/gameplay_DF58.jpg");
                mapImg.setImage(splashScreenImage);
                q = 4;
                break;
        }
        return q;
    }

    public synchronized int endT(Label playerName, Text playerTurnText, AnchorPane secondmidPane, int q, ImageView mapImg, ChangePanes chmap, Image plImg, ImageView rightPlayerImg) {
         if(!(holdmoves==6))
        currentplayingPlayer++;
        currentplayingPlayer = currentplayingPlayer % players;
        playerName.setText(playerNames[currentplayingPlayer]);
        playerTurnText.setText(AllData.playerNames[currentplayingPlayer]);
        for (int i = 0; i < CSV.inc2; i++) {
            if (CSV.mapName[i].equals(playerCurrentCity[currentplayingPlayer])) {
                q = (int) CSV.mapQuarter[i];
                chmap.changeMap(mapImg, q);
                break;
            }
        }
        switch (currentplayingPlayer) {
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
        return q;
    }

    public synchronized int initCardsAndShit(AnchorPane leftPane, int play, int inccc) {
        int ccc = 185;
        Random rand = new Random();
        Label Ilabel;
        ImageView imageView;
        int c = 0;
        int timing = 500;
        Image car;
        boolean aa;
        for (int x = 0; x < totalcards; x++) {
            aa = true;
            int mm = (x + inccc) % 3;
            switch (mm) {
                case 0:
                    while (aa) {
                        c = rand.nextInt(CSV.inc2);
                        if (fromLoad == true) {
                            c = playerCardIndex[play][x];
                            if (c == 1000) {
                                ccc += 60;
                                timing += 500;
                            playerCardsNames[play][x] = "done";
                                break;
                            }
                        }
                        car = new Image("file:data/green/" + CSV.mapName[c] + ".jpg");
                        if (!car.isError()) {
                            Ilabel = new Label();
                            imageView = new ImageView(car);
                            Ilabel.setGraphic(imageView);
                            Ilabel.setScaleX(.45);
                            Ilabel.setScaleY(.45);
                            Path path = new Path();
                            path.getElements().add(new MoveTo(100, -1000));
                            path.getElements().add(new LineTo(100, ccc));
                            PathTransition pathTransition = new PathTransition();
                            pathTransition.setDuration(Duration.millis(timing));
                            pathTransition.setPath(path);
                            pathTransition.setNode(Ilabel);
                            pathTransition.setCycleCount(1);
                            pathTransition.play();
                            ccc += 60;
                            playerCards[play][x] = Ilabel;
                            playerCardsNames[play][x] = CSV.mapName[c];
                            leftPane.getChildren().add(Ilabel);
                            aa = false;
                            timing += 500;
                            playerCardIndex[play][x] = c;
                        }
                    }
                    break;

                case 1:
                    while (aa) {
                        c = rand.nextInt(CSV.inc2);
                        if (fromLoad == true) {
                            c = playerCardIndex[play][x];
                            if (c == 1000) {
                                ccc += 60;
                                timing += 500;
                                
                            playerCardsNames[play][x] = "done";
                                break;
                            }
                        }
                        car = new Image("file:data/red/" + CSV.mapName[c] + ".jpg");
                        if (!car.isError()) {
                            Ilabel = new Label();
                            imageView = new ImageView(car);
                            Ilabel.setGraphic(imageView);
                            Ilabel.setScaleX(.45);
                            Ilabel.setScaleY(.45);
                            Path path = new Path();
                            path.getElements().add(new MoveTo(100, -1000));
                            path.getElements().add(new LineTo(100, ccc));
                            PathTransition pathTransition = new PathTransition();
                            pathTransition.setDuration(Duration.millis(timing));
                            pathTransition.setPath(path);
                            pathTransition.setNode(Ilabel);
                            pathTransition.setCycleCount(1);
                            pathTransition.play();
                            ccc += 60;
                            playerCards[play][x] = Ilabel;
                            playerCardsNames[play][x] = CSV.mapName[c];
                            playerCardIndex[play][x] = c;
                            leftPane.getChildren().add(Ilabel);
                            aa = false;
                            timing += 500;
                        }
                    }
                    break;
                case 2:
                    while (aa) {
                        c = rand.nextInt(CSV.inc2);
                        if (fromLoad == true) {
                            c = playerCardIndex[play][x];
                            if (c == 1000) {
                                ccc += 60;
                                timing += 500;
                                
                            playerCardsNames[play][x] = "done";
                                break;
                            }
                        }
                        car = new Image("file:data/yellow/" + CSV.mapName[c] + ".jpg");
                        if (!car.isError()) {
                            Ilabel = new Label();
                            imageView = new ImageView(car);
                            Ilabel.setGraphic(imageView);
                            Ilabel.setScaleX(.45);
                            Ilabel.setScaleY(.45);
                            Path path = new Path();
                            path.getElements().add(new MoveTo(100, -1000));
                            path.getElements().add(new LineTo(100, ccc));
                            PathTransition pathTransition = new PathTransition();
                            pathTransition.setDuration(Duration.millis(timing));
                            pathTransition.setPath(path);
                            pathTransition.setNode(Ilabel);
                            pathTransition.setCycleCount(1);
                            pathTransition.play();
                            ccc += 60;
                            playerCards[play][x] = Ilabel;
                            playerCardsNames[play][x] = CSV.mapName[c];
                            leftPane.getChildren().add(Ilabel);
                            aa = false;
                            timing += 500;
                            playerCardIndex[play][x] = c;
                        }
                    }
                    break;
            }
        }
        return playerCardIndex[play][0];
    }
public synchronized void flightLoad() {
        for (int jj = 0; jj < CSV.inc3; jj++) {
            if (CSV.mapName[AllData.playerPieceIndex[AllData.currentplayingPlayer]].equals(CSV.flightCityName[jj])) {
                for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                    if (jjj != jj) {
                        if (CSV.flightCityQ[jjj] == CSV.flightCityQ[jj]) {
                            AllData.moves -= 2;
                            return;
                        }
                    }
                }
            switch (CSV.flightCityQ[jj]) {
                case 1:
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (CSV.flightCityQ[jjj] == 2) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 4) {
                            AllData.moves -= 4;
                            return;
                        }
                    }
                    break;
                case 2:
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (CSV.flightCityQ[jjj] == 1) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 3) {
                            AllData.moves -= 4;
                            return;
                        }
                    }
                    break;
                case 3:
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (CSV.flightCityQ[jjj] == 2) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 4) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 6) {
                            AllData.moves -= 4;
                            return;
                        }
                    }
                    break;
                case 4:
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (CSV.flightCityQ[jjj] == 1) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 3) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 5) {
                            AllData.moves -= 4;
                            return;
                        }
                    }
                    break;
                case 5:
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (CSV.flightCityQ[jjj] == 6) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 4) {
                            AllData.moves -= 4;
                            return;
                        }
                    }
                    break;
                case 6:
                    for (int jjj = 0; jjj < CSV.inc3; jjj++) {
                        if (CSV.flightCityQ[jjj] == 3) {
                            AllData.moves -= 4;
                            return;
                        } else if (CSV.flightCityQ[jjj] == 5) {
                            AllData.moves -= 4;
                            return;
                        }
                    }
                    break;
            }
        }
    } 
}
}
