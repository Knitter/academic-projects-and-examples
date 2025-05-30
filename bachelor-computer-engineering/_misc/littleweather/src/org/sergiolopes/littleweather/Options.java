/*
 * Options.java
 *
 * Created on 26 de Maio de 2007, 14:57
 */

package org.sergiolopes.littleweather;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author  Knitter
 */
public class Options extends javax.swing.JDialog {
    
    private boolean changed = false;
    
    /** Creates new form Options
     * @param parent
     * @param modal
     */
    public Options(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        readPreferences();
        center();
    }
    
    /**
     * Sets the default value for all the components
     */
    private void setDefaults() {
        chkRepeat.setSelected(false);
        spinnerInteval.setValue(new Integer(10));
    }
    
    /**
     * Reads preferences file which is stored at the user home folder
     */
    private void readPreferences() {
        File f = new File(System.getProperty("user.home") + File.separator + LittleWeatherGUI.BASE_DIR + File.separator + LittleWeatherGUI.FILE_NAME);
        ObjectInputStream in = null;
        Preferences temp = null;
        
        try {
            if(f.exists()) {
                in = new ObjectInputStream(new FileInputStream(f));
                temp = (Preferences)in.readObject();
                chkRepeat.setSelected(temp.isRepeat());
                spinnerInteval.setValue(new Integer(temp.getInterval()));
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
    }
    
    /** Sets the dialog position to be the center of it's owner.
     */
    private void center() {
        Dimension ownerSize = getOwner().getSize();
        Dimension mySize = getSize();
        
        if (mySize.height > ownerSize.height) {
            mySize.height = ownerSize.height;
        }
        if (mySize.width > ownerSize.width) {
            mySize.width = ownerSize.width;
        }
        setLocation((((ownerSize.width / 2) + getOwner().getX()) - (mySize.width) / 2),
                (((ownerSize.height / 2) + getOwner().getY()) - (mySize.height) / 2));
    }
    
    /** Writes the preferences file in the user's home directory
     */
    private void writePreferences() {
        Preferences temp = new Preferences(chkRepeat.isSelected(), ((Integer)spinnerInteval.getValue()).intValue());
        ObjectOutputStream out = null;
        try {
            File dir = new File(System.getProperty("user.home") + File.separator + LittleWeatherGUI.BASE_DIR);
            if(!dir.exists()) {
                dir.mkdir();
            }
            
            File f = new File(System.getProperty("user.home") + File.separator + LittleWeatherGUI.BASE_DIR + File.separator + LittleWeatherGUI.FILE_NAME);
            out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(temp);
        } catch (IOException ex) {
            //ignore
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    //ignore
                }
            }
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTop = new javax.swing.JPanel();
        chkRepeat = new javax.swing.JCheckBox();
        spinnerInteval = new javax.swing.JSpinner();
        lblSpinnerInterval = new javax.swing.JLabel();
        lblIntervalUnits = new javax.swing.JLabel();
        jpBottom = new javax.swing.JPanel();
        btnClearData = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/sergiolopes/littleweather/resources/language"); // NOI18N
        setTitle(bundle.getString("OPTIONS_DIALOG_TITLE")); // NOI18N

        jpTop.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("OPTIONS_DIALOG_REPEAT_PANEL_TITLE"))); // NOI18N

        chkRepeat.setText(bundle.getString("OPTIONS_DIALOG_REPEAT")); // NOI18N
        chkRepeat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkRepeat.setMargin(new java.awt.Insets(0, 0, 0, 0));
        chkRepeat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                chkRepeatPropertyChange(evt);
            }
        });

        spinnerInteval.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(10), null, Integer.valueOf(1)));
        spinnerInteval.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spinnerIntevalPropertyChange(evt);
            }
        });

        lblSpinnerInterval.setText(bundle.getString("OPTIONS_DIALOG_INTERVAL")); // NOI18N

        lblIntervalUnits.setText(bundle.getString("OPTIONS_DIALOG_INTERVAL_UNITS")); // NOI18N

        javax.swing.GroupLayout jpTopLayout = new javax.swing.GroupLayout(jpTop);
        jpTop.setLayout(jpTopLayout);
        jpTopLayout.setHorizontalGroup(
            jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTopLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblSpinnerInterval)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerInteval, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIntervalUnits))
                    .addComponent(chkRepeat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTopLayout.setVerticalGroup(
            jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopLayout.createSequentialGroup()
                .addComponent(chkRepeat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpinnerInterval)
                    .addComponent(spinnerInteval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntervalUnits))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("OPTIONS_DIALOG_DATA_PANEL_TITLE"))); // NOI18N

        btnClearData.setText(bundle.getString("OPTIONS_DIALOG_BTN_CLEAR_DATA")); // NOI18N
        btnClearData.setToolTipText(bundle.getString("OPTIONS_DIALOG_BTN_CLEAR_DATA_TOOLTIP")); // NOI18N
        btnClearData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBottomLayout = new javax.swing.GroupLayout(jpBottom);
        jpBottom.setLayout(jpBottomLayout);
        jpBottomLayout.setHorizontalGroup(
            jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClearData)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jpBottomLayout.setVerticalGroup(
            jpBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClearData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancel.setText(bundle.getString("OPTIONS_DIALOG_CANCEL")); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText(bundle.getString("OPTIONS_DIALOG_SAVE")); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void spinnerIntevalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spinnerIntevalPropertyChange
    changed = true;
}//GEN-LAST:event_spinnerIntevalPropertyChange

private void chkRepeatPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_chkRepeatPropertyChange
    changed = true;
}//GEN-LAST:event_chkRepeatPropertyChange

private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    if(changed) {
        writePreferences();
    }
    dispose();
}//GEN-LAST:event_btnCancelActionPerformed

private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    ((LittleWeatherGUI)getOwner()).setPreferences(new Preferences(chkRepeat.isSelected(), ((Integer)spinnerInteval.getValue()).intValue()));
}//GEN-LAST:event_btnSaveActionPerformed

/** Deletes preferences file and directory form the user's home directory
 */
private void btnClearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearDataActionPerformed
    File f = new File(System.getProperty("user.home") + File.separator + LittleWeatherGUI.BASE_DIR + File.separator + LittleWeatherGUI.FILE_NAME);
    if(f.exists()) {
        changed = false;
        f.delete();
        File dir = new File(System.getProperty("user.home") + File.separator + LittleWeatherGUI.BASE_DIR);
        dir.delete();
        setDefaults();
    }
}//GEN-LAST:event_btnClearDataActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClearData;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkRepeat;
    private javax.swing.JPanel jpBottom;
    private javax.swing.JPanel jpTop;
    private javax.swing.JLabel lblIntervalUnits;
    private javax.swing.JLabel lblSpinnerInterval;
    private javax.swing.JSpinner spinnerInteval;
    // End of variables declaration//GEN-END:variables
    
}
