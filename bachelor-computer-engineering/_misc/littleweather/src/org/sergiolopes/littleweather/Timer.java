/*
 * Timer.java
 *
 * Created on 16/Jun/2007, 17:11:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.sergiolopes.littleweather;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Knitter
 */
public class Timer implements Runnable {
    
    private LinkedList<TimeListener> listeners = new LinkedList<TimeListener>();   
    private boolean running = true;
    private int interval;
    
    public Timer() {
        this(10);
    }
    
    public Timer(int tickInterval) {
        this.interval = tickInterval;
    }
    
    public void addListeners(TimeListener l) {
        listeners.add(l);
    }
    
    public void removeListeners(TimeListener l) {
        listeners.remove(l);
    }
    
    public void stop() {
        running = false;
    }
    
    public void run() {
        tick();
    }
    
    private void tick() {
        while(running) {
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException ex) {
                //ignore;
            }
            fireTick();
        }
    }
    
    /** Notify all registered listeners that a tick as passed
    */
    private void fireTick() {
        Iterator<TimeListener> it = listeners.listIterator();
        
        while(it.hasNext()) {
            it.next().tick();
        }
    }
    
}
