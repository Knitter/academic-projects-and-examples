package bdestudantil.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupConnection extends JDialog {
    JPanel passUserOwner = new JPanel();
    JPanel painelPass = new JPanel();
    JPanel painelUser = new JPanel();
    JButton buttonOK = new JButton();
    JTextField textUser = new JTextField();
    JLabel labelUser = new JLabel();
    FlowLayout flowLayout = new FlowLayout();
    JLabel labelPass = new JLabel();
    JLabel labelPort = new JLabel();
    JTextField textPort = new JTextField();
    JTextField textPass = new JTextField();
    JPanel painelOK = new JPanel();
    JPanel painelIP = new JPanel();
    JTextField textIP = new JTextField();
    JLabel labelIP = new JLabel();
    JPanel painelBD = new JPanel();
    JTextField textBD = new JTextField();
    JLabel labelBD = new JLabel();

    public SetupConnection(Frame owner) {
        super(owner);
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(flowLayout);
        setSize(new Dimension(420, 190));
        ConfiguracaoLigacao c= ConfiguracaoLigacao.getConf();
        buttonOK.setText("OK");
        buttonOK.addActionListener(new SetupConnection_buttonOK_actionAdapter(this));
        textUser.setPreferredSize(new Dimension(100, 20));
        textUser.setText(c.getUser());
        labelUser.setText("User:");
        labelPass.setText("Password:");
        textPort.setText(c.getPort());
        labelPort.setText("Port:");

        textPort.setPreferredSize(new Dimension(35, 20));
        textPass.setPreferredSize(new Dimension(100, 20));
        textPass.setText(c.getPass());
        textIP.setPreferredSize(new Dimension(150, 20));
        textIP.setText(c.getIp());
        labelIP.setText("IP:");
        textBD.setPreferredSize(new Dimension(100, 20));
        textBD.setText(c.getBd());
        labelBD.setText("BD:");

        painelUser.add(labelUser);
        painelUser.add(textUser);
        passUserOwner.add(painelUser);

        painelPass.add(labelPass);
        painelPass.add(textPass);
        passUserOwner.add(painelPass);

        painelBD.add(labelBD);
        painelBD.add(textBD);

        painelIP.add(labelIP);
        painelIP.add(textIP);
        painelIP.add(labelPort);
        painelIP.add(textPort);

        painelOK.add(buttonOK);

        getContentPane().add(painelBD);
        getContentPane().add(painelIP);
        getContentPane().add(passUserOwner);
        getContentPane().add(painelOK);

        // Center the window
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

        setModal(true);
        setVisible(true);
    }

    public void buttonOK_actionPerformed(ActionEvent e) {
        ConfiguracaoLigacao.getConf().reconfigure(textIP.getText(), textBD.getText(), textUser.getText(), textPass.getText(), textPort.getText());
        dispose();
    }

}


class SetupConnection_buttonOK_actionAdapter implements ActionListener {
    private SetupConnection adaptee;
    SetupConnection_buttonOK_actionAdapter(SetupConnection adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonOK_actionPerformed(e);
    }
}
