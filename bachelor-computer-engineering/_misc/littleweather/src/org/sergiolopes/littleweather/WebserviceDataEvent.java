/*
 * WebserviceDataEvent.java
 *
 * Created on 26 de Maio de 2007, 17:09
 *
 * Knitter
 */

package org.sergiolopes.littleweather;

/**
 *
 * @author Knitter
 */
public class WebserviceDataEvent {
    
    private Data values;
    
    /** Creates a new instance of WebserviceDataEvent */
    public WebserviceDataEvent(Data values) {
        this.values = values;
    }
    
    public Data getValues() {
        return values;
    }
    
}
