/*
 * WebserviceDataListener.java
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
public interface WebserviceDataListener {
    
    public void fireDataReceived(Object source, WebserviceDataEvent event);
    
}
