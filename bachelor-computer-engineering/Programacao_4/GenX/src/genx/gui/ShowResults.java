package genx.gui;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import genx.listas.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class ShowResults  extends JDialog {

    public ShowResults(String title, Iterador it) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Vector v = new Vector();
        while (it.podeAvancar())
            v.add(it.avancar());

        JPanel panel = new JPanel(new BorderLayout());
        JList list = new JList(v);
        JScrollPane scroll = new JScrollPane(list);
        panel.add(scroll, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.CENTER);

        JButton btn = new JButton("OK");
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        btn.addActionListener(al);

        panel = new JPanel(new FlowLayout());
        panel.add(btn);
        getContentPane().add(panel, BorderLayout.SOUTH);
    }

    public void centrar() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation( (screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
    }

}
