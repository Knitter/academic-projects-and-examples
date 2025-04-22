package genx.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.borland.jbcl.layout.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class GenXFrame_AboutBox extends JDialog implements ActionListener {

    private JButton buttonOK = new JButton("OK");

    public GenXFrame_AboutBox(Frame parent) {
        super(parent);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public GenXFrame_AboutBox() {
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
        panel.add(new JLabel("GenX"));
        panel.add(new JLabel("1.0"));
        panel.add(new JLabel("Copyright (c) 2005"));
        panel.add(new JLabel("Aplicação que permite gerir árvores genealógicas"));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 0));
        getContentPane().add(new JLabel(new ImageIcon(getClass().getResource("/genx/imagens/logotype.png"))), BorderLayout.WEST);

        setTitle("Sobre GenX");
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
