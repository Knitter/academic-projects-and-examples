package bdestudantil;

import java.awt.Toolkit;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;

/**
 * <p>Title: Base de Dados Estudantil</p>
 *
 * <p>Description: 3ª Fase do Trabalho de Base de Dados II</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: ESTG</p>
 *
 * @author Nelson Rodrigues 10608 e Sérgio Lopes nº10635
 * @version 1.02
 */
public class BDApp {
    boolean packFrame = false;

    /**
     * Construct and show the application.
     */
    public BDApp() {
        MainFrame frame = new MainFrame();
        // Validate frames that have preset sizes
        // Pack frames that have useful preferred size info, e.g. from their layout
        if (packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }

        // Center the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    /**
     * Application entry point.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.
                                             getSystemLookAndFeelClassName());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                new BDApp();
            }
        });
    }
}