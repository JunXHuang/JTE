/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jun
 */
public class SplashScreenController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button aboutButton;
    @FXML
    private Button quitButton;
    @FXML
    private AnchorPane mainAnchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Scanner read = new Scanner(new File("savedData.txt"));
        } catch (FileNotFoundException ex) {
            loadButton.setDisable(true);
        }
    }

    @FXML
    private void startButton(ActionEvent event) {
        try {
            //mainAnchorpane.getChildren().removeAll(startButton,loadButton,aboutButton,quitButton);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
           
            Scene scene = stage.getScene();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("selectPlayers.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            scene.setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadButton(ActionEvent event) {
        int cp = 0,op=0;
        Scanner read = null;
        try {
            read = new Scanner(new File("savedData.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (read.hasNext()) {
            Scanner reads = new Scanner(read.nextLine());
            AllData.players = Integer.parseInt(reads.next());
            for (int i = 0; i < AllData.players; i++) {
                reads = new Scanner(read.nextLine());
                AllData.playerNames[i] = reads.next();
                AllData.playerPieceIndex[i] = Integer.parseInt(reads.next());
              //  System.out.println("i = "+ AllData.playerPieceIndex[i]);
                AllData.playerL[i]= Integer.parseInt(reads.next());
               // System.out.println("L = "+AllData.playerL[i]);
                AllData.playerQ[i]= Integer.parseInt(reads.next());
                AllData.playerFlagQ[i]= Integer.parseInt(reads.next());
                op= Integer.parseInt(reads.next());
                if(op==1)
                AllData.realPlayers[i]=true;
                else
                    AllData.realPlayers[i]=false;
                cp = Integer.parseInt(reads.next());
                if (cp == 1) {
                    AllData.currentplayingPlayer = i;
                }
                reads = new Scanner(read.nextLine());
                for (int j = 0; j < AllData.totalcards; j++) {
                    AllData.playerCardIndex[i][j] = Integer.parseInt(reads.next());
                }
            }
            Scanner read1 = null;
        try {
            read1 = new Scanner(new File("savedHistoryText.txt"));
            while(read1.hasNextLine()){
           AllData.HistoryText+=read1.nextLine();
           AllData.HistoryText+="\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (AllData.players > 0) {
                AllData.fromLoad=true;
                try {
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
        }
    }

    @FXML
    private void aboutButton(ActionEvent event) {
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
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void quitButton(ActionEvent event) {
        exit();
    }

}
