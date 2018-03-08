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
public class DigitalStopwatch {
    
    private double tickTimeInSeconds = 1.0; 
    private double angleDeltaPerSeconds = 6.0;
    private double secondsElapsed = 0.0; 
    private int h1 = 0, h2 = 0, m1 = 0, m2 = 0, s1 = 0, s2 = 0; 
    private int lapcount = 1; 
    private Timeline timeline;
    private KeyFrame keyframe; 
    private String digidisplay = "00:00:00";  
    
    
    public void setTimeline(Timeline timeline){
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
    
    public double gettickTimeInSeconds(){
        return tickTimeInSeconds; 
    }
    
    public void start(){
        timeline.play(); 
    }
    
    public void stop(){
        timeline.pause();
    }
    
    public void lap(){
        System.out.println("Lap" + lapcount + " : " + digidisplay); 
        lapcount++; 
    }
    
    public String getdigidisplay(){
        return digidisplay;
    }
    
    public void reset(){
     lapcount = 1; 
     s2 = s1 = m2 = m1 = h2 = h1 = 0; 
     digidisplay = "" + h1 + h2 + " : " + m1 + m2 + " : " + s1 + s2 + "."; 
     
    }
    
    public void update(){
    
        s2++; 
        if(s2 == 10){ //last second reaches 10 and have to bump the first second up
            s1++; 
            s2=0; 
            if(s1 == 6){ //first second variable hits 60 and have to bump the secon minute
                m2++; 
                s1 = 0; 
                if(m2 == 10){ //same concept for mintues as was for the seconds 
                    m1++; 
                    m2 = 0; 
                    if(m1 == 6){
                        h2++; 
                        m1 = 0; 
                        if(h2 == 10){
                            h1++; 
                            h2 = 0; 
                            if(h2 == 9 && h1 == 9){ //if user allows timer to continuously run we have to account for the largest time
                            reset(); 
                        }
                    }
                }
            }
        }
    
     }
        
        //now have to set the values for the stopwatch: 
       
       digidisplay = "" + h1 + h2 + " : " + m1 + m2 + " : " + s1 + s2 + "."; 
        
    }
    
    public DigitalStopwatch(){
        
    }
    
    
}
