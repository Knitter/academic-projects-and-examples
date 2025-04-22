package j2gether.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import j2gether.config.Propriedades;
import j2gether.view.adapters.ScoreAdaptor;
import j2gether.view.renderers.DoubleRenderer;
import j2gether.view.renderers.IntegerRenderer;
import j2gether.view.renderers.StringRenderer;



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
public class J2GetherFrame_Score extends JDialog {

    public J2GetherFrame_Score(Frame owner) {
        super(owner, Propriedades.SCORES_WINDOW_TITLE, true);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JButton btn;
        JPanel panel = new JPanel(new FlowLayout());

        btn = new JButton(Propriedades.BUTTON_OK);
        btn.addActionListener(new J2GetherFrame_Score_buttonOK_actionAdapter(this));
        panel.add(btn);
        btn = new JButton(Propriedades.BUTTON_CLEAR);
        btn.addActionListener(new J2GetherFrame_Score_buttonClear_actionAdapter(this));
        panel.add(btn);
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        getContentPane().add(panel, BorderLayout.SOUTH);

        JTable table = new JTable(new ScoreAdaptor(((J2GetherFrame)getOwner()).getJogo().getScores()));
        table.getColumnModel().getColumn(0).setCellRenderer(new IntegerRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new StringRenderer());
        table.getColumnModel().getColumn(2).setCellRenderer(new DoubleRenderer());
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setRowHeight(22);
        getContentPane().add(table, BorderLayout.CENTER);

        setResizable(false);
    }

    public void buttonClear_actionPerformed(ActionEvent e) {
        ((J2GetherFrame)getOwner()).getJogo().getScores().reset();
        ((J2GetherFrame)getOwner()).getJogo().getScores().fireScoreChanged();
        ((J2GetherFrame)getOwner()).getJogo().getScores().saveScore();
    }

    public void jButtonOK_actionPerformed(ActionEvent e) {
        dispose();
    }
}

class J2GetherFrame_Score_buttonOK_actionAdapter implements ActionListener {
    private J2GetherFrame_Score adaptee;
    J2GetherFrame_Score_buttonOK_actionAdapter(J2GetherFrame_Score adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonOK_actionPerformed(e);
    }
}

class J2GetherFrame_Score_buttonClear_actionAdapter implements ActionListener {
    private J2GetherFrame_Score adaptee;
    J2GetherFrame_Score_buttonClear_actionAdapter(J2GetherFrame_Score adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonClear_actionPerformed(e);
    }
}
