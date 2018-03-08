/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssatgbmvcstopwatchfxml;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


/**
 *
 * @author Sharoze
 */
public class AnalogStopwatch {
    
    private double tickTimeInSeconds = 0.01; 
    private double secondsElapsed = 0; 
    private double angleDeltaPerSeconds = 6.0; 
    private Timeline timeline; 
    private KeyFrame keyframe; 
    private double rotate; 
    
 
    
    public void setRotate(){
        secondsElapsed += tickTimeInSeconds; 
        rotate = secondsElapsed * angleDeltaPerSeconds;  
    }
    
    public double getRotate(){
        return rotate;
    }
    
    public double gettickTimeInSeconds(){
        return tickTimeInSeconds;
    }
    
    public double reset(){
        secondsElapsed = 0; 
        return 0.0;
    }
    
    public void setTimeLine(Timeline timeline){ 
        this.timeline = timeline; 
    }
    
    public Timeline getTimeline(){
        return timeline;
    }
    
    public void setKeyFrame(KeyFrame keyframe){
        this.keyframe = keyframe;
    }
    
    public KeyFrame getKeyFrame(){
        return keyframe;
    }
    
}
