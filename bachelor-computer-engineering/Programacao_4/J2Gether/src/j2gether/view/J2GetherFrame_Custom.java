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
public class J2GetherFrame_Custom extends JDialog {
    private JTextField textHeight = new JTextField();
    private JTextField textWidth = new JTextField();

    public J2GetherFrame_Custom(Frame owner) {
        super(owner, Propriedades.CUSTOM_WINDOW_TITLE, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            textHeight.setText(Integer.toString(((J2GetherFrame)owner).getJogo().getHeight()));
            textWidth.setText(Integer.toString(((J2GetherFrame)owner).getJogo().getWidth()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JButton btn;
        JPanel panel = new JPanel(new FlowLayout());

        btn = new JButton(Propriedades.BUTTON_OK);
        btn.addActionListener(new J2GetherFrame_Custom_buttonOK_actionAdapter(this));
        panel.add(btn);
        btn = new JButton(Propriedades.BUTTON_CANCEL);
        btn.addActionListener(new J2GetherFrame_Custom_buttonCancel_actionAdapter(this));
        panel.add(btn);
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(panel, BorderLayout.SOUTH);

        panel = new JPanel(new VerticalFlowLayout());
        panel.add(new JLabel(Propriedades.CUSTOM_HEIGHT + ":"));
        panel.add(textHeight);
        panel.add(new JLabel(Propriedades.CUSTOM_WIDTH + ":"));
        panel.add(textWidth);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void jButtonCancel_actionPerformed(ActionEvent e) {
        dispose();
    }

    public void jButtonOK_actionPerformed(ActionEvent e) {
        try {
            J2GetherFrame jogo = (J2GetherFrame) getOwner();
            int altura = Integer.parseInt(textHeight.getText());
            int largura = Integer.parseInt(textWidth.getText());

            if (altura > 20)
                altura = 20;
            else if (altura < 5)
                altura = 5;

            if (largura > 20)
                largura = 20;
            else if (largura < 5)
                largura = 5;

            jogo.restart(altura, largura, jogo.getJogo().getNumCores(), jogo.getJogo().getModoActual());
            dispose();
        } catch (NumberFormatException ex) {
        }
    }
}


class J2GetherFrame_Custom_buttonOK_actionAdapter implements ActionListener {
    private J2GetherFrame_Custom adaptee;
    J2GetherFrame_Custom_buttonOK_actionAdapter(J2GetherFrame_Custom adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonOK_actionPerformed(e);
    }
}


class J2GetherFrame_Custom_buttonCancel_actionAdapter implements ActionListener {
    private J2GetherFrame_Custom adaptee;
    J2GetherFrame_Custom_buttonCancel_actionAdapter(J2GetherFrame_Custom adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonCancel_actionPerformed(e);
    }
}
