/*
 * Data.java
 *
 * Created on 26 de Maio de 2007, 16:50
 *
 * Knitter
 */

package org.sergiolopes.littleweather;

import javax.xml.datatype.XMLGregorianCalendar;

/** 
 *
 * @author Knitter
 */
public class Data {
      
    private XMLGregorianCalendar lastUpdate;
    private float windDirection;
    private float humidity;
    private float rain;
    private float pressure;
    private float radiation;
    private float temperature;
    private float windSpeed;
    
    /** Creates a new instance of Data 
     * @param lastUpdate 
     * @param windDirection 
     * @param humidity
     * @param rain 
     * @param pressure 
     * @param radiation 
     * @param temperature 
     * @param windSpeed 
     */
    public Data(XMLGregorianCalendar lastUpdate,  float windDirection,
            float humidity, float rain, float pressure, float radiation,
            float temperature, float windSpeed) {
        
        this.lastUpdate = lastUpdate;
        this.windDirection = windDirection;
        this.humidity = humidity;
        this.rain = rain;
        this.pressure = pressure;
        this.radiation = radiation;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }
       
    public XMLGregorianCalendar getLastUpdate() {
        return lastUpdate;
    }
    
    public float getWindDirection() {
        return windDirection;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getRain() {
        return rain;
    }
    
    public float getPressure() {
        return pressure;
    }
    
    public float getRadiation() {
        return radiation;
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    public float getWindSpeed() {
        return windSpeed;
    }
    
    public String getLastUpdateAsString() {
        return String.valueOf(lastUpdate);
    }
    
    public String getWindDirectionAsString() {
        return String.valueOf(windDirection);
    }
    
    public String getHumidityAsString() {
        return String.valueOf(humidity);
    }
    
    public String getRainAsString() {
        return String.valueOf(rain);
    }
    
    public String getPressureAsString() {
        return String.valueOf(pressure);
    }
    
    public String getRadiationAsString() {
        return String.valueOf(radiation);
    }
    
    public String getTemperatureAsString() {
        return String.valueOf(temperature);
    }
    
    public String getWindSpeedAsString() {
        return String.valueOf(windSpeed);
    }
}
