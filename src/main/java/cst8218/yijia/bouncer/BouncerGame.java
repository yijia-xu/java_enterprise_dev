/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.yijia.bouncer;

import cst8218.yijia.bouncer.entity.Bouncer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * A Singleton class to manipulate the  bouncer game, and make the 
 * bouncers' values change continuously.
 * @author Yijia
 */
@Startup
@Singleton
public class BouncerGame {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private BouncerFacade bouncerFacade;
    private List<Bouncer> bouncers;
    public static final int CHANGE_RATE = 1;
    
    /**
     * This method is to keep the bouncers' properties continuously change and
     * update the values each frame.
     * Runs immediately after the constructor.
     */
    @PostConstruct
    public void go() {
        new Thread(new Runnable() {
        public void run() {
            // the game runs indefinitely
            while (true) {
                //update all the bouncers and save changes to the database
                bouncers = bouncerFacade.findAll();
                for (Bouncer bouncer : bouncers) {
                    bouncer.advanceOneFrame();
                    bouncerFacade.edit(bouncer);
                }
                //sleep while waiting to process the next frame of the animation
                try {
                    // wake up roughly CHANGE_RATE times per second
                    Thread.sleep((long)(1.0/CHANGE_RATE*1000));
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
        }).start();
    }
}
