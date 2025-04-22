/*
 * ObtainDataThead.java
 *
 * Created on 26 de Maio de 2007, 16:50
 *
 * Knitter
 */

package org.sergiolopes.littleweather;

import java.lang.IllegalArgumentException;

/** Thread that fetchs the data from the webservice.
 *
 * @author Knitter
 */
public class ObtainDataThead implements Runnable {
    
    private Service1 webservice;
    private WebserviceDataListener listener;
    
    /**
     * Creates a new instance of ObtainDataThead
     * @param webservice 
     * @param listener 
     */
    public ObtainDataThead(Service1 webservice, WebserviceDataListener listener) {
        if(listener == null)
            throw new IllegalArgumentException("Invalid listener. Null not allowed.");
        
        this.listener = listener;
        this.webservice = webservice;
    }
    
    /** Get the data, create the data object and send it to the listeners.
     */
    public void run() {
        listener.fireDataReceived(this, new WebserviceDataEvent(
                new Data(webservice.getService1Soap().valoresActuaisGetDataUltimaActualizacao(),
                    webservice.getService1Soap().valoresActuaisGetDireccaoVento(),
                    webservice.getService1Soap().valoresActuaisGetHumidade(),
                    webservice.getService1Soap().valoresActuaisGetPrecipitacao(),
                    webservice.getService1Soap().valoresActuaisGetPressaoAtmosferica(),
                    webservice.getService1Soap().valoresActuaisGetRadiacaoSolar(),
                    webservice.getService1Soap().valoresActuaisGetTemperatura(),
                    webservice.getService1Soap().valoresActuaisGetVelocidadeVento())));
    }
    
}
