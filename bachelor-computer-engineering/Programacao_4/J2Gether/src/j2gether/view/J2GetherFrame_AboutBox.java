package j2gether.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.borland.jbcl.layout.VerticalFlowLayout;
import j2gether.config.Propriedades;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class J2GetherFrame_AboutBox extends JDialog implements ActionListener {

    private JButton buttonOK = new JButton(Propriedades.BUTTON_OK);

    public J2GetherFrame_AboutBox(Frame parent) {
        super(parent);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public J2GetherFrame_AboutBox() {
        this(null);
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        buttonOK.addActionListener(this);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(buttonOK);
        getContentPane().add(panel, BorderLayout.SOUTH);
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel = new JPanel(new VerticalFlowLayout());
        panel.add(new JLabel("J2Gether"));
        panel.add(new JLabel("1.0"));
        panel.add(new JLabel("Copyright (c) 2005"));
        panel.add(new JLabel(Propriedades.ABOUT_COMMENT));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 0));
        getContentPane().add(new JLabel(new ImageIcon(j2gether.view.J2GetherFrame.class.getResource("/j2gether/imagens/logotype.png"))), BorderLayout.WEST);

        setTitle(Propriedades.ABOUT + " J2Gether");
        setResizable(false);
    }

    /**
     * Close the dialog on a button event.
     *
     * @param actionEvent ActionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonOK) {
            dispose();
        }
    }
}
