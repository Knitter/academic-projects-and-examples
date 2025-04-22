/*
 * Preferences.java
 *
 * Created on 16/Jun/2007, 18:08:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.sergiolopes.littleweather;

import java.io.Serializable;

/**
 *
 * @author Knitter
 */
public class Preferences implements Serializable {
    
    private boolean repeat;
    private int interval;
    
    public Preferences(boolean repeat, int interval) {
        this.repeat = repeat;
        this.interval = interval;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public int getInterval() {
        return interval;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }    
}
