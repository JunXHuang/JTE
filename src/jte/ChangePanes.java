/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jte;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Jun
 */

public class ChangePanes {
  public synchronized void changeMap(ImageView mapImg, int q){
      Image splashScreenImage;
      switch(q){
          case 1:
      splashScreenImage = new Image("file:src/jte/img/gameplay_AC14.jpg");
            mapImg.setImage(splashScreenImage);
              break;
          case 2:
            splashScreenImage = new Image("file:src/jte/img/gameplay_DF14.jpg");
            mapImg.setImage(splashScreenImage);
              break;
          case 3:
            splashScreenImage = new Image("file:src/jte/img/gameplay_AC58.jpg");
            mapImg.setImage(splashScreenImage);
              break;
          case 4:
              splashScreenImage = new Image("file:src/jte/img/gameplay_DF58.jpg");
            mapImg.setImage(splashScreenImage);
              break;
      }
            for (int i = 0; i < AllData.players; i++) {
                if (AllData.playerQ[i] != q) {
                    AllData.playerLabel[i].setVisible(false);
                }
                   
                 else {
                    AllData.playerLabel[i].setVisible(true);
                        }
                 if(AllData.playerFlagQ[i]!=q){
                    AllData.playerFlag[i].setVisible(false);
                    }
                 else{
                    AllData.playerFlag[i].setVisible(true);

                }
            }
  }
}
