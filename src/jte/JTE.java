/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Jun
 */
public class JTE extends Application {
    @Override
   public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("splashScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Journey Through Europe");
        stage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CSV test1=new CSV();
        test1.setupCSV();
        XMLParser parse=new XMLParser();
        parse.XMLParser();
        Dijkstra c=new Dijkstra();
        c.initPath();
        launch(args);
    }
    
}
