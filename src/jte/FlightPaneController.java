/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jun
 */
public class FlightPaneController implements Initializable {

    @FXML
    private ImageView flightMap;
    @FXML
    private AnchorPane flightPane;

    /**
     * Initializes the controller class.
     */
    int mov = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        AllData.kk = 1000;
        mov = AllData.moves;
        Circle line = new Circle(5);
        line.setStroke(Color.GREEN);
        for (int i = 0; i < CSV.inc3; i++) {
            if (CSV.flightCityName[i].equals(AllData.playerCurrentCity[AllData.currentplayingPlayer])) {
                line.setLayoutX((double) CSV.flightCityX[i]);
                line.setLayoutY((double) CSV.flightCityY[i]);
                flightPane.getChildren().add(line);
                break;
            }
        }
        flightPane.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();

            // System.out.println("x = " + x + "  y= " + y);
            if (AllData.moves >= 2) {
                for (int i = 0; i < CSV.inc3; i++) {
                    if ((((x - CSV.flightCityX[i]) <= 10) && ((x - CSV.flightCityX[i]) >= -10)) && (((y - CSV.flightCityY[i]) <= 10) && ((y - CSV.flightCityY[i]) >= -10))) {
                        for (int j = 0; j < CSV.inc3; j++) {
                            if (AllData.playerCurrentCity[AllData.currentplayingPlayer].equals(CSV.flightCityName[j])) {
                                for (int k = 0; k < CSV.inc2; k++) {
                                    if (CSV.flightCityName[i].equals(CSV.mapName[k])) {
                                        AllData.kk = k;
                                    }
                                }
                                if (CSV.flightCityQ[j] == CSV.flightCityQ[i]) {
                                    AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                    AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                    AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                    AllData.moves -= 2;
                                } else if (AllData.moves >= 4) {
                                    switch (CSV.flightCityQ[j]) {
                                        case 1:
                                            if (CSV.flightCityQ[i] == 2) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 4) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            }
                                            break;
                                        case 2:
                                            if (CSV.flightCityQ[i] == 1) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 3) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            }
                                            break;
                                        case 3:
                                            if (CSV.flightCityQ[i] == 2) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 6) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 4) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            }
                                            break;
                                        case 4:
                                            if (CSV.flightCityQ[i] == 1) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 3) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 5) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            }
                                            break;
                                        case 5:
                                            if (CSV.flightCityQ[i] == 4) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 6) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            }
                                            break;
                                        case 6:
                                            if (CSV.flightCityQ[i] == 3) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            } else if (CSV.flightCityQ[i] == 5) {
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutX(CSV.mapX[AllData.playerL[AllData.currentplayingPlayer]] - 100);
                                                AllData.playerLabel[AllData.currentplayingPlayer].setLayoutY(CSV.mapY[AllData.playerL[AllData.currentplayingPlayer]] - 110);
                                                AllData.playerQ[AllData.currentplayingPlayer] = CSV.flightCityQ[i];
                                                AllData.moves -= 4;
                                            }
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        });
    }

    @FXML
    private void exitButton(ActionEvent event) {
        if (AllData.kk != 1000 && AllData.moves != mov) {
            AllData.FMAP = true;
            System.out.println("Fly to " + CSV.mapName[AllData.kk]);
        }
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
