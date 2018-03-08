/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatgbmvcstopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Sharoze
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label digc;
    
    @FXML
    private Button btn1; 
    
    @FXML
    private Button btn2; 
    
    @FXML
    private ImageView hand; 
    
    private AnalogStopwatch analog; 
    
    private DigitalStopwatch digital; 
    
    
    
    private void setupAnalog(){
        analog.setKeyFrame(new KeyFrame(Duration.millis(analog.gettickTimeInSeconds() * 1000), (ActionEvent event) -> {
            analogUpdate(); 
        })); 
        analog.setTimeLine(new Timeline(analog.getKeyFrame()));
        analog.getTimeline().setCycleCount(Animation.INDEFINITE); 
    }
    
    private void analogUpdate(){
        analog.setRotate();
        hand.setRotate(analog.getRotate());
    }
    
    private void setupDigital(){
        digital.setKeyFrame(new KeyFrame(Duration.millis(digital.gettickTimeInSeconds()), (ActionEvent event) -> {
            digitalUpdate(); 
        }));
        
        digital.setTimeline(new Timeline(digital.getKeyFrame()));
        digital.getTimeline().setCycleCount(Animation.INDEFINITE);
        
    }
    
    private void digitalUpdate(){
        digital.update();
        digc.setText(digital.getdigidisplay());  
    }
    
    @FXML
    private void handlebtn1(ActionEvent event){
     if("Start".equals(btn1.getText())){
         analog.getTimeline().play();
         digital.getTimeline().play();
         btn1.setText("Stop");
         btn2.setText("Lap");
     }   
     else if("Stop".equals(btn1.getText())){
         analog.getTimeline().stop();
         digital.getTimeline().stop();
         btn1.setText("Start");
         btn2.setText("Reset"); 
     }
         
    } 
   
    
    @FXML
    private void handlebtn2(ActionEvent event){
        
        if("Lap".equals(btn2.getText()) && !"Start".equals(btn1.getText())){ //this will make sure the lap button prints out the time while making sure that the time is already running
            digital.lap();
        }
        else if("Reset".equals(btn2.getText())) {
            digital.reset();
            hand.setRotate(analog.reset());
            digc.setText(digital.getdigidisplay());
            btn1.setText("Start");
            btn2.setText("Lap");
            
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        analog = new AnalogStopwatch(); 
        digital = new DigitalStopwatch();
        setupAnalog(); 
        setupDigital();
    }    
    
}
