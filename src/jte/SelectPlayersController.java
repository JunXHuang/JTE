/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jun
 */
public class SelectPlayersController implements Initializable {

    @FXML
    private ToggleGroup myToggleGroup4;
    @FXML
    private ToggleGroup myToggleGroup5;
    @FXML
    private ToggleGroup myToggleGroup2;
    @FXML
    private ToggleGroup myToggleGroup3;
    @FXML
    private ToggleGroup myToggleGroup1;
    @FXML
    private ToggleGroup myToggleGroup6;
    @FXML
    private MenuButton MenuButton;
    @FXML
    private GridPane gridpane;
    @FXML
    private AnchorPane player4;
    @FXML
    private AnchorPane player5;
    @FXML
    private AnchorPane player3;
    @FXML
    private AnchorPane player6;
    @FXML
    private AnchorPane player2;
    @FXML
    private AnchorPane player1;
    @FXML
    private TextField player4Text;
    @FXML
    private TextField player5Text;
    @FXML
    private TextField player2Text;
    @FXML
    private TextField player3Text;
    @FXML
    private TextField player1Text;
    @FXML
    private TextField player6Text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(int i=0;i<6;i++)
         AllData.realPlayers[i]=true;
        // TODO
    }

    @FXML
    private void numOfPlayers2(ActionEvent event) {
        AllData.players = 2;
        MenuButton.setText("2");
        gridpane.getChildren().removeAll(player1, player2, player3, player4, player5, player6);
        gridpane.getChildren().addAll(player1, player2);
    }

    @FXML
    private void numOfPlayers3(ActionEvent event) {
        AllData.players = 3;
        MenuButton.setText("3");
        gridpane.getChildren().removeAll(player1, player2, player3, player4, player5, player6);
        gridpane.getChildren().addAll(player1, player2, player3);

    }

    @FXML
    private void numOfPlayers4(ActionEvent event) {
        AllData.players = 4;
        MenuButton.setText("4");
        gridpane.getChildren().removeAll(player1, player2, player3, player4, player5, player6);
        gridpane.getChildren().addAll(player1, player2, player3, player4);
    }

    @FXML
    private void numOfPlayers5(ActionEvent event) {
        AllData.players = 5;
        MenuButton.setText("5");
        gridpane.getChildren().removeAll(player1, player2, player3, player4, player5, player6);
        gridpane.getChildren().addAll(player1, player2, player3, player4, player5);
    }

    @FXML
    private void numOfPlayers6(ActionEvent event) {
        AllData.players = 6;
        MenuButton.setText("6");
        gridpane.getChildren().removeAll(player1, player2, player3, player4, player5, player6);
        gridpane.getChildren().addAll(player1, player2, player3, player4, player5, player6);
    }

    @FXML
    private void selectPlayerButton(ActionEvent event) {
        try {
            int players = Integer.parseInt(MenuButton.getText());
            switch (players) {

                case 6:
                    AllData.playerNames[5] = player6Text.getText();
                case 5:
                    AllData.playerNames[4] = player5Text.getText();
                case 4:
                    AllData.playerNames[3] = player4Text.getText();
                case 3:
                    AllData.playerNames[2] = player3Text.getText();
                case 2:
                    AllData.playerNames[1] = player2Text.getText();
                    AllData.playerNames[0] = player1Text.getText();
                    break;
            }
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Scene scene = stage.getScene();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gamePane.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            scene.setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void radioPlayer4(ActionEvent event) {
        AllData.realPlayers[3]=true;
    }

    @FXML
    private void radioComputer4(ActionEvent event) {
         AllData.realPlayers[3]=false;
    }

    @FXML
    private void radioPlayer5(ActionEvent event) {
         AllData.realPlayers[4]=true;
    }

    @FXML
    private void radioComputer5(ActionEvent event) {
         AllData.realPlayers[4]=false;
    }

    @FXML
    private void radioPlayer2(ActionEvent event) {
         AllData.realPlayers[1]=true;
    }

    @FXML
    private void radioComputer2(ActionEvent event) {
         AllData.realPlayers[1]=false;
    }

    @FXML
    private void radioPlayer3(ActionEvent event) {
         AllData.realPlayers[2]=true;
    }

    @FXML
    private void radioComputer3(ActionEvent event) {
         AllData.realPlayers[2]=false;
    }

    @FXML
    private void radioPlayer1(ActionEvent event) {
         AllData.realPlayers[0]=true;
    }

    @FXML
    private void radioComputer1(ActionEvent event) {
         AllData.realPlayers[0]=false;
    }

    @FXML
    private void radioPlayer6(ActionEvent event) {
         AllData.realPlayers[5]=true;
    }

    @FXML
    private void radioComputer6(ActionEvent event) {
         AllData.realPlayers[5]=false;
    }

}
