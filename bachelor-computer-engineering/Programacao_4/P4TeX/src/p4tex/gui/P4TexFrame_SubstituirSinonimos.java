package p4tex.gui;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.borland.jbcl.layout.*;
import p4tex.modelo.*;
import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class P4TexFrame_SubstituirSinonimos extends JDialog {

    private String textoInicial;
    private JTextField inputSubstituir;
    private JComboBox comboBox;

    public P4TexFrame_SubstituirSinonimos(Frame owner, String textoInicial) {
        super(owner);
        this.textoInicial = textoInicial;

        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JPanel aPanel1;
        JPanel aPanel2;
        JButton aButton;

        setTitle("Substituir Sinónimos");
        getContentPane().setLayout(new BorderLayout());

        aPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        aButton = new JButton("Substituir");
        aButton.addActionListener(new P4TexFrame_SubstituirSinonimos_btnSubstituir_actionAdapter(this));
        aPanel1.add(aButton);

        aButton = new JButton("Fechar");
        aButton.addActionListener(new P4TexFrame_SubstituirSinonimos_btnFechar_actionAdapter(this));
        aPanel1.add(aButton);

        getContentPane().add(aPanel1, BorderLayout.SOUTH);

        aPanel1 = new JPanel(new FlowLayout());
        aPanel2 = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.RIGHT));
        aPanel2.add(new Label("Palavra:"));
        aPanel2.add(new Label("Sinónimo:"));
        aPanel1.add(aPanel2);

        aPanel2 = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.LEFT));

        inputSubstituir = new JTextField(textoInicial);
        inputSubstituir.setPreferredSize(new Dimension(150, 20));
        inputSubstituir.addKeyListener(new P4TexFrame_SubstituirSinonimos_inputSubstituir_KeyAdapter(this));

        comboBox = new JComboBox();
        comboBox.setEditable(false);
        comboBox.setPreferredSize(new Dimension(150, 20));
        comboBox.addKeyListener(new P4TexFrame_SubstituirSinonimos_comboBox_KeyAdapter(this));

        aPanel2.add(inputSubstituir);
        aPanel2.add(comboBox);
        aPanel1.add(aPanel2);

        getContentPane().add(aPanel1, BorderLayout.CENTER);
    }

    public void centrar(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public void btnSubstituir_actionPerformed(ActionEvent e) {
        try {
            ((P4TexFrame) getOwner()).getP4TeX().substituirTodasPalavras(inputSubstituir.getText().trim(), (String) comboBox.getSelectedItem());
        }
        catch (FormatacaoException ex) {}
        catch (SubstituicaoException ex) {
            hide();
            new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro de Substituição", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            dispose();
        }
    }

    public void btnFechar_actionPerformed(ActionEvent e) {
        dispose();
    }

    public void inputSubstituir_KeyAdapter(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            comboBox.removeAll();
            Vector v = new Vector();
            Iterador it = ((P4TexFrame) getOwner()).getP4TeX().procurarSinonimos(inputSubstituir.getText().trim());
            while (it.podeAvancar())
                comboBox.addItem(((Palavra) it.avancar()).getPalavra());

            comboBox.requestFocus();
        }
    }

    public void comboBox_KeyAdapter(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            btnSubstituir_actionPerformed(null);
    }

}

class P4TexFrame_SubstituirSinonimos_inputSubstituir_KeyAdapter extends KeyAdapter {

    private P4TexFrame_SubstituirSinonimos adaptee;

    public P4TexFrame_SubstituirSinonimos_inputSubstituir_KeyAdapter(P4TexFrame_SubstituirSinonimos adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
           adaptee.inputSubstituir_KeyAdapter(e);
    }
}

class P4TexFrame_SubstituirSinonimos_comboBox_KeyAdapter extends KeyAdapter {

    private P4TexFrame_SubstituirSinonimos adaptee;

    public P4TexFrame_SubstituirSinonimos_comboBox_KeyAdapter(P4TexFrame_SubstituirSinonimos adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
           adaptee.comboBox_KeyAdapter(e);
    }
}

class P4TexFrame_SubstituirSinonimos_btnFechar_actionAdapter   implements ActionListener {
    private P4TexFrame_SubstituirSinonimos adaptee;
    P4TexFrame_SubstituirSinonimos_btnFechar_actionAdapter(P4TexFrame_SubstituirSinonimos adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnFechar_actionPerformed(e);
    }
}

class P4TexFrame_SubstituirSinonimos_btnSubstituir_actionAdapter  implements ActionListener {
    private P4TexFrame_SubstituirSinonimos adaptee;
    P4TexFrame_SubstituirSinonimos_btnSubstituir_actionAdapter(P4TexFrame_SubstituirSinonimos adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSubstituir_actionPerformed(e);
    }
}
