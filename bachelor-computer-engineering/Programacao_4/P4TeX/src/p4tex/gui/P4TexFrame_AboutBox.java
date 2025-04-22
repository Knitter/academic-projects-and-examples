package p4tex.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.borland.jbcl.layout.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class P4TexFrame_AboutBox extends JDialog implements ActionListener {

    private JButton buttonOK = new JButton("OK");

    public P4TexFrame_AboutBox(Frame parent) {
        super(parent);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public P4TexFrame_AboutBox() {
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
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panel = new JPanel(new VerticalFlowLayout());
        panel.add(new JLabel("P4TeX"));
        panel.add(new JLabel("1.0"));
        panel.add(new JLabel("Copyright (c) 4thFloor 2005"));
        panel.add(new JLabel("3º Trabalho Prático de P4"));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 0));
        getContentPane().add(new JLabel(new ImageIcon(p4tex.gui.P4TexFrame.class.getResource("logotype.png"))), BorderLayout.WEST);

        setTitle("Sobre P4TeX");
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
