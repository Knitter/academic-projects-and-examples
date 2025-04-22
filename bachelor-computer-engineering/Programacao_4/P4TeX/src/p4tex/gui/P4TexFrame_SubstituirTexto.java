package p4tex.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.borland.jbcl.layout.*;
import p4tex.modelo.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class P4TexFrame_SubstituirTexto extends JDialog {

    private String textoInicial;
    private JTextField inputSubstituir;
    private JTextField inputPor;

    public P4TexFrame_SubstituirTexto(Frame owner, String textoInicial) {
        super(owner);
        this.textoInicial = textoInicial;
        try {
            jbInit();
            if (textoInicial != null)
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        inputPor.requestFocus();
                    }
                });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JPanel aPanel1;
        JPanel aPanel2;
        JButton aButton;

        setTitle("Substituir Palavras");
        getContentPane().setLayout(new BorderLayout());

        aPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        aButton = new JButton("Substituir");
        aButton.addActionListener(new P4TexFrame_SubstituirTexto_btnSubstituir_actionAdapter(this));
        aPanel1.add(aButton);

        aButton = new JButton("Fechar");
        aButton.addActionListener(new P4TexFrame_SubstituirTexto_btnFechar_actionAdapter(this));
        aPanel1.add(aButton);

        getContentPane().add(aPanel1, BorderLayout.SOUTH);

        aPanel1 = new JPanel(new FlowLayout());
        aPanel2 = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.RIGHT));
        aPanel2.add(new Label("Substituir:"));
        aPanel2.add(new Label("Por:"));
        aPanel1.add(aPanel2);

        aPanel2 = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.LEFT));

        inputSubstituir = new JTextField(textoInicial);
        inputSubstituir.setPreferredSize(new Dimension(150, 20));
        inputSubstituir.addKeyListener(new P4TexFrame_SubstituirTexto_inputSubstituir_KeyAdapter(this));

        inputPor = new JTextField();
        inputPor.setPreferredSize(new Dimension(150, 20));
        inputPor.addKeyListener(new P4TexFrame_SubstituirTexto_inputPor_KeyAdapter(this));

        aPanel2.add(inputSubstituir);
        aPanel2.add(inputPor);
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
            ((P4TexFrame) getOwner()).getP4TeX().substituirTodasPalavras(inputSubstituir.getText().trim(), inputPor.getText().trim());
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            inputPor.requestFocus();
    }

    public void inputPor_KeyAdapter(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            btnSubstituir_actionPerformed(null);
    }

}

class P4TexFrame_SubstituirTexto_inputSubstituir_KeyAdapter extends KeyAdapter {

    private P4TexFrame_SubstituirTexto adaptee;

    public P4TexFrame_SubstituirTexto_inputSubstituir_KeyAdapter(P4TexFrame_SubstituirTexto adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
           adaptee.inputSubstituir_KeyAdapter(e);
    }
}

class P4TexFrame_SubstituirTexto_inputPor_KeyAdapter extends KeyAdapter {

    private P4TexFrame_SubstituirTexto adaptee;

    public P4TexFrame_SubstituirTexto_inputPor_KeyAdapter(P4TexFrame_SubstituirTexto adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
           adaptee.inputPor_KeyAdapter(e);
    }
}

class P4TexFrame_SubstituirTexto_btnFechar_actionAdapter   implements ActionListener {
    private P4TexFrame_SubstituirTexto adaptee;
    P4TexFrame_SubstituirTexto_btnFechar_actionAdapter(P4TexFrame_SubstituirTexto adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnFechar_actionPerformed(e);
    }
}

class P4TexFrame_SubstituirTexto_btnSubstituir_actionAdapter  implements ActionListener {
    private P4TexFrame_SubstituirTexto adaptee;
    P4TexFrame_SubstituirTexto_btnSubstituir_actionAdapter(P4TexFrame_SubstituirTexto adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btnSubstituir_actionPerformed(e);
    }
}
