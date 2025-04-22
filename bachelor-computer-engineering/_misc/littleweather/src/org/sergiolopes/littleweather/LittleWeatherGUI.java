/*
 * LittleWeatherGUI.java
 *
 * Created on 16 de Junho de 2007, 12:27
 */

package org.sergiolopes.littleweather;

import edu.stanford.ejalbert.BrowserLauncher;
import edu.stanford.ejalbert.exception.BrowserLaunchingInitializingException;
import edu.stanford.ejalbert.exception.UnsupportedOperatingSystemException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author  Knitter
 */
public class LittleWeatherGUI extends javax.swing.JFrame implements WebserviceDataListener, TimeListener {
    
    public static final String BASE_DIR = ".littleweather";
    public static final String FILE_NAME = "littleweathersettings.dat";
    
    private Service1 webservice;
    private LittleWeatherGUI me = this;
    private Preferences preferences;
    private Timer tm;
    
    
    /** Creates new form LittleWeatherGUI */
    public LittleWeatherGUI() {
        initComponents();
        center();
        preferences = readPreferences();
        try {
            webservice = new Service1();
            getData();
            if(preferences != null && preferences.isRepeat()) {
                tm = new Timer(preferences.getInterval());
                tm.addListeners(this);
                (new Thread(tm)).start();
            }
        } catch(Exception ex) {
            /* If the webservice is not available set the status label. */
            lblConnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/connect_no.png")));
            lblConnStatus.setToolTipText(java.util.ResourceBundle.getBundle("org/sergiolopes/littleweather/resources/languages").getString("RED_CONN_STATUS_TOOLTIP")); // NOI18N
            webservice = null;
        }
    }
    
    /** Sets the frame to the center of the screen
     */
    private void center() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }
    
    /** Reads the preferences file, if it exists.
     */
    private Preferences readPreferences() {
        File f = new File(System.getProperty("user.home") + File.separator + BASE_DIR + File.separator + FILE_NAME);
        ObjectInputStream in = null;
        Preferences temp = null;
        
        try {
            if(f.exists()) {
                in = new ObjectInputStream(new FileInputStream(f));
                temp = (Preferences)in.readObject();
            }
        } catch (ClassNotFoundException ex) {
            //ignore
        } catch (IOException ex) {
            //ignore
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    //ignore
                }
            }
        }
        return temp;
    }
    
    /** Sets the preferences object of this frame.
     * @param preferences object that represents the user preferences.
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
        if(preferences != null && preferences.isRepeat()) {
            //if the timer exists, stop it.
            if(tm != null) {
                tm.stop();
            }
            tm = new Timer(preferences.getInterval());
            tm.addListeners(this);
            (new Thread(tm)).start();
        }
    }
    
    /** Get data form webservice.
     * Data is fetch in an asynchronous maner.
     */
    private void getData() {
        ObtainDataThead th = new ObtainDataThead(webservice, this);
        (new Thread(th)).start();
    }
    
    public void tick() {
        getData();
    }
    
    public void fireDataReceived(Object source, WebserviceDataEvent event) {
        jtfLastUpdate.setText(event.getValues().getLastUpdateAsString());
        jtfWindDirection.setText(event.getValues().getWindDirectionAsString());
        jtfHumidity.setText(event.getValues().getHumidityAsString());
        jtfRain.setText(event.getValues().getRainAsString());
        jtfPressure.setText(event.getValues().getPressureAsString());
        jtfRadiation.setText(event.getValues().getRadiationAsString());
        jtfAirTemperature.setText(event.getValues().getTemperatureAsString());
        jtfWindSpeed.setText(event.getValues().getWindSpeedAsString());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMainPanel = new javax.swing.JPanel();
        btnWebMeteo = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jpTempWindImages = new javax.swing.JPanel();
        lblThermo = new javax.swing.JLabel();
        lblWindRose = new javax.swing.JLabel();
        jpCurrentData = new javax.swing.JPanel();
        jtfAirTemperature = new javax.swing.JTextField();
        lblAirTemperature = new javax.swing.JLabel();
        jtfRain = new javax.swing.JTextField();
        lblRain = new javax.swing.JLabel();
        jtfWindDirection = new javax.swing.JTextField();
        jtfRadiation = new javax.swing.JTextField();
        lblWindDirection = new javax.swing.JLabel();
        lblRadiation = new javax.swing.JLabel();
        lblAirTemperatureUnits = new javax.swing.JLabel();
        lblRainUnits = new javax.swing.JLabel();
        lblWindDirectionUnits = new javax.swing.JLabel();
        lblRadiationUnits = new javax.swing.JLabel();
        lblHumidity = new javax.swing.JLabel();
        jtfWindSpeed = new javax.swing.JTextField();
        lblPressure = new javax.swing.JLabel();
        lblWindSpeed = new javax.swing.JLabel();
        jtfPressure = new javax.swing.JTextField();
        jtfHumidity = new javax.swing.JTextField();
        lblLastUpdate = new javax.swing.JLabel();
        jtfLastUpdate = new javax.swing.JTextField();
        lblHumidityUnits = new javax.swing.JLabel();
        lblPressureUnits = new javax.swing.JLabel();
        lblWindSpeedUnits = new javax.swing.JLabel();
        btnAbout = new javax.swing.JButton();
        btnConfigure = new javax.swing.JButton();
        lblConnStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/sergiolopes/littleweather/resources/language"); // NOI18N
        setTitle(bundle.getString("MAIN_WINDOW_TITLE")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpMainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("MAIN_WINDOW_MAIN_PANEL_TITLE"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 0))); // NOI18N

        btnWebMeteo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/webpres.png"))); // NOI18N
        btnWebMeteo.setToolTipText(bundle.getString("MAIN_WINDOW_BROWSER_TOOLTIP")); // NOI18N
        btnWebMeteo.setMaximumSize(new java.awt.Dimension(28, 28));
        btnWebMeteo.setMinimumSize(new java.awt.Dimension(28, 28));
        btnWebMeteo.setPreferredSize(new java.awt.Dimension(28, 28));
        btnWebMeteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebMeteoActionPerformed(evt);
            }
        });

        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/reload.png"))); // NOI18N
        btnReload.setToolTipText(bundle.getString("MAIN_WINDOW_RELOAD_TOOLTIP")); // NOI18N
        btnReload.setMaximumSize(new java.awt.Dimension(28, 28));
        btnReload.setMinimumSize(new java.awt.Dimension(28, 28));
        btnReload.setPreferredSize(new java.awt.Dimension(28, 28));
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        jpTempWindImages.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("MAIN_WINDOW_TOP_PANEL_TITLE"))); // NOI18N

        lblThermo.setText("Aqui vai ficar um termo");

        lblWindRose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/rosanorte.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jpTempWindImagesLayout = new org.jdesktop.layout.GroupLayout(jpTempWindImages);
        jpTempWindImages.setLayout(jpTempWindImagesLayout);
        jpTempWindImagesLayout.setHorizontalGroup(
            jpTempWindImagesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpTempWindImagesLayout.createSequentialGroup()
                .addContainerGap()
                .add(lblThermo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 26, Short.MAX_VALUE)
                .add(lblWindRose)
                .addContainerGap())
        );
        jpTempWindImagesLayout.setVerticalGroup(
            jpTempWindImagesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpTempWindImagesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpTempWindImagesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblThermo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblWindRose))
                .addContainerGap())
        );

        jpCurrentData.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores Actuais"));

        jtfAirTemperature.setEditable(false);
        jtfAirTemperature.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfAirTemperature.setForeground(new java.awt.Color(0, 102, 0));

        lblAirTemperature.setText(bundle.getString("MAIN_WINDOW_LBL_TEMPERATURE")); // NOI18N

        jtfRain.setEditable(false);
        jtfRain.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfRain.setForeground(new java.awt.Color(0, 102, 0));

        lblRain.setText(bundle.getString("MAIN_WINDOW_LBL_RAIN")); // NOI18N

        jtfWindDirection.setEditable(false);
        jtfWindDirection.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfWindDirection.setForeground(new java.awt.Color(0, 102, 0));

        jtfRadiation.setEditable(false);
        jtfRadiation.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfRadiation.setForeground(new java.awt.Color(0, 102, 0));

        lblWindDirection.setText(bundle.getString("MAIN_WINDOW_LBL_WIND_DIRECTION")); // NOI18N

        lblRadiation.setText(bundle.getString("MAIN_WINDOW_LBL_RADIATION")); // NOI18N

        lblAirTemperatureUnits.setText("\u00baC");

        lblRainUnits.setText("l/m2");

        lblWindDirectionUnits.setText("\u00baN  ");

        lblRadiationUnits.setText("W/m2");

        lblHumidity.setText(bundle.getString("MAIN_WINDOW_LBL_HUMIDITY")); // NOI18N

        jtfWindSpeed.setEditable(false);
        jtfWindSpeed.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfWindSpeed.setForeground(new java.awt.Color(0, 102, 0));

        lblPressure.setText(bundle.getString("MAIN_WINDOW_LBL_PRESSURE")); // NOI18N

        lblWindSpeed.setText(bundle.getString("MAIN_WINDOW_LBL_WIND_SPEED")); // NOI18N

        jtfPressure.setEditable(false);
        jtfPressure.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfPressure.setForeground(new java.awt.Color(0, 102, 0));

        jtfHumidity.setEditable(false);
        jtfHumidity.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfHumidity.setForeground(new java.awt.Color(0, 102, 0));

        lblLastUpdate.setText(bundle.getString("MAIN_WINDOW_LBL_LAST_UPDATE")); // NOI18N

        jtfLastUpdate.setEditable(false);
        jtfLastUpdate.setFont(new java.awt.Font("Tahoma", 1, 11));
        jtfLastUpdate.setForeground(new java.awt.Color(0, 102, 0));

        lblHumidityUnits.setText("%");

        lblPressureUnits.setText("mBar");

        lblWindSpeedUnits.setText("Km/h");

        org.jdesktop.layout.GroupLayout jpCurrentDataLayout = new org.jdesktop.layout.GroupLayout(jpCurrentData);
        jpCurrentData.setLayout(jpCurrentDataLayout);
        jpCurrentDataLayout.setHorizontalGroup(
            jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpCurrentDataLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblAirTemperature)
                    .add(lblRain)
                    .add(lblWindDirection)
                    .add(lblRadiation))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jtfRadiation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .add(jtfWindDirection, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .add(jtfRain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jtfAirTemperature, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .add(4, 4, 4)
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblRainUnits)
                    .add(lblAirTemperatureUnits)
                    .add(lblWindDirectionUnits)
                    .add(lblRadiationUnits))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jpCurrentDataLayout.createSequentialGroup()
                        .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblWindSpeed)
                            .add(lblPressure)
                            .add(lblHumidity))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jtfWindSpeed)
                            .add(jtfPressure)
                            .add(jtfHumidity, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblWindSpeedUnits)
                            .add(lblPressureUnits)
                            .add(lblHumidityUnits)))
                    .add(jpCurrentDataLayout.createSequentialGroup()
                        .add(lblLastUpdate)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jtfLastUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCurrentDataLayout.setVerticalGroup(
            jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpCurrentDataLayout.createSequentialGroup()
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblAirTemperature)
                    .add(jtfAirTemperature, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblHumidity)
                    .add(lblAirTemperatureUnits)
                    .add(jtfHumidity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblHumidityUnits))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblRain)
                    .add(lblPressure)
                    .add(lblRainUnits)
                    .add(jtfPressure, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblPressureUnits)
                    .add(jtfRain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblWindDirection)
                    .add(lblWindSpeed)
                    .add(lblWindDirectionUnits)
                    .add(jtfWindSpeed, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblWindSpeedUnits)
                    .add(jtfWindDirection, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpCurrentDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblRadiation)
                    .add(lblRadiationUnits)
                    .add(lblLastUpdate)
                    .add(jtfLastUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtfRadiation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/help.png"))); // NOI18N
        btnAbout.setToolTipText(bundle.getString("MAIN_WINDOW_ABOUT_TOOLTIP")); // NOI18N
        btnAbout.setMaximumSize(new java.awt.Dimension(28, 28));
        btnAbout.setMinimumSize(new java.awt.Dimension(28, 28));
        btnAbout.setPreferredSize(new java.awt.Dimension(28, 28));
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnConfigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/configure.png"))); // NOI18N
        btnConfigure.setToolTipText(bundle.getString("MAIN_WINDOW_OPTIONS_TOOLTIP")); // NOI18N
        btnConfigure.setMaximumSize(new java.awt.Dimension(28, 28));
        btnConfigure.setMinimumSize(new java.awt.Dimension(28, 28));
        btnConfigure.setPreferredSize(new java.awt.Dimension(28, 28));
        btnConfigure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigureActionPerformed(evt);
            }
        });

        lblConnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sergiolopes/littleweather/resources/connect_established.png"))); // NOI18N
        lblConnStatus.setMaximumSize(new java.awt.Dimension(28, 28));
        lblConnStatus.setMinimumSize(new java.awt.Dimension(28, 28));
        lblConnStatus.setPreferredSize(new java.awt.Dimension(28, 28));

        org.jdesktop.layout.GroupLayout jpMainPanelLayout = new org.jdesktop.layout.GroupLayout(jpMainPanel);
        jpMainPanel.setLayout(jpMainPanelLayout);
        jpMainPanelLayout.setHorizontalGroup(
            jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpMainPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jpMainPanelLayout.createSequentialGroup()
                            .add(btnReload, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(btnWebMeteo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jpTempWindImages, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jpCurrentData, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jpMainPanelLayout.createSequentialGroup()
                        .add(lblConnStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 407, Short.MAX_VALUE)
                        .add(btnConfigure, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAbout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpMainPanelLayout.setVerticalGroup(
            jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpMainPanelLayout.createSequentialGroup()
                .add(jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnWebMeteo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnReload, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpTempWindImages, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpCurrentData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpMainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(btnAbout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnConfigure, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(lblConnStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jpMainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jpMainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if(tm != null) {
        tm.stop();
    }
}//GEN-LAST:event_formWindowClosing

private void btnConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigureActionPerformed
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Options(me, true).setVisible(true);
        }
    });
}//GEN-LAST:event_btnConfigureActionPerformed

private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new About(me, true).setVisible(true);
        }
    });
}//GEN-LAST:event_btnAboutActionPerformed

private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
    if(webservice != null)
        getData();
}//GEN-LAST:event_btnReloadActionPerformed

private void btnWebMeteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebMeteoActionPerformed
    new Thread(new Runnable(){
        public void run() {
            try {
                BrowserLauncher l = new BrowserLauncher();
                l.openURLinBrowser("http://www.meteo.estg.ipleiria.pt");
            } catch (BrowserLaunchingInitializingException ex) {
                ex.printStackTrace();
            } catch (UnsupportedOperatingSystemException ex) {
                ex.printStackTrace();
            }
        }
    }).start();
}//GEN-LAST:event_btnWebMeteoActionPerformed

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                new org.sergiolopes.littleweather.LittleWeatherGUI().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            }
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnConfigure;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnWebMeteo;
    private javax.swing.JPanel jpCurrentData;
    private javax.swing.JPanel jpMainPanel;
    private javax.swing.JPanel jpTempWindImages;
    private javax.swing.JTextField jtfAirTemperature;
    private javax.swing.JTextField jtfHumidity;
    private javax.swing.JTextField jtfLastUpdate;
    private javax.swing.JTextField jtfPressure;
    private javax.swing.JTextField jtfRadiation;
    private javax.swing.JTextField jtfRain;
    private javax.swing.JTextField jtfWindDirection;
    private javax.swing.JTextField jtfWindSpeed;
    private javax.swing.JLabel lblAirTemperature;
    private javax.swing.JLabel lblAirTemperatureUnits;
    private javax.swing.JLabel lblConnStatus;
    private javax.swing.JLabel lblHumidity;
    private javax.swing.JLabel lblHumidityUnits;
    private javax.swing.JLabel lblLastUpdate;
    private javax.swing.JLabel lblPressure;
    private javax.swing.JLabel lblPressureUnits;
    private javax.swing.JLabel lblRadiation;
    private javax.swing.JLabel lblRadiationUnits;
    private javax.swing.JLabel lblRain;
    private javax.swing.JLabel lblRainUnits;
    private javax.swing.JLabel lblThermo;
    private javax.swing.JLabel lblWindDirection;
    private javax.swing.JLabel lblWindDirectionUnits;
    private javax.swing.JLabel lblWindRose;
    private javax.swing.JLabel lblWindSpeed;
    private javax.swing.JLabel lblWindSpeedUnits;
    // End of variables declaration//GEN-END:variables
    
}
