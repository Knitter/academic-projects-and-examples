package p4tex.gui;

import java.io.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

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
public class P4TexFrame extends JFrame implements DicionarioListener {
    private JPanel contentPane;
    private BorderLayout borderLayout1 = new BorderLayout();
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFicheiroSair = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuAjudaSobre = new JMenuItem();
    private JScrollPane scrollPane = new JScrollPane();
    private JMenuItem menuFicheiroAbrirFDE = new JMenuItem();
    private JMenuItem menuFicheiroAbrirDoc = new JMenuItem();
    private JMenuItem menuFicheiroAbrirDic = new JMenuItem();
    private JMenuItem menuFicheiroGravar = new JMenuItem();
    private JMenuItem menuFicheiroGravarComo = new JMenuItem();
    private JCheckBoxMenuItem optionSmartSelect = new JCheckBoxMenuItem("SmartSelect", true);
    private JPopupMenu popupMenu = new JPopupMenu();
    private JMenu popupMenuSinonimos = new JMenu();
    private JMenu popupMenuAnagramas = new JMenu();
    private JMenuItem popupMenuSubstituir = new JMenuItem();
    private JPanel statusBar = new JPanel();
    private JLabel statusText = new JLabel();
    private JProgressBar progressBar = new JProgressBar();
    private BorderLayout borderLayout2 = new BorderLayout();
    private JMenu menuSubstituir = new JMenu();
    private JMenuItem menuSubstituirSinonimos = new JMenuItem();
    private JMenuItem menuSubstituirPalavras = new JMenuItem();
    private JMenu menuFerramentas = new JMenu();

    private P4TeX p4tex = new P4TeX();
    private DefaultStyledDocumentAdapter adaptador = new DefaultStyledDocumentAdapter(p4tex.getDocumento());
    private JTextPane textPane = new JTextPane(adaptador);
    private JMenuItem menuFicheiroImprimir = new JMenuItem();

    public P4TexFrame() {
        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public P4TexFrame(String[] args) {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            if (args.length > 0) {
                p4tex.abrirFDE(new File(args[0]));
                menuFicheiroAbrirDoc.setEnabled(true);
            }
            if (args.length > 1) {
                p4tex.abrirDocumento(new File(args[1]));
                menuFicheiroGravar.setEnabled(true);
                menuFicheiroGravarComo.setEnabled(true);
                menuFicheiroImprimir.setEnabled(true);
            }
            if (args.length > 2) {
                p4tex.abrirDicionario(new File(args[2]));
                p4tex.getDicionario().addDicionarioListener(this);
            }
        }
        catch (FormatacaoException ex) {
            new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (DocumentoException ex) {
            new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ex) {
            new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(800, 600));
        setTitle("P4TeX");
        menuFile.setText("Ficheiro");
        menuFicheiroSair.setText("Sair");
        menuFicheiroSair.addActionListener(new P4TexFrame_jMenuFileExit_ActionAdapter(this));
        menuHelp.setText("Ajuda");
        menuAjudaSobre.setText("Sobre...");
        menuAjudaSobre.addActionListener(new P4TexFrame_jMenuHelpAbout_ActionAdapter(this));
        textPane.setToolTipText("");
        textPane.setEditable(false);
        textPane.addMouseListener(new P4TexFrame_textPane_mouseAdapter(this));
        menuFicheiroAbrirFDE.setText("Abrir FDE...");
        menuFicheiroAbrirFDE.addActionListener(new P4TexFrame_menuFicheiroAbrirFDE_actionAdapter(this));
        menuFicheiroAbrirDoc.setText("Abrir Documento...");
        menuFicheiroAbrirDoc.setEnabled(false);
        menuFicheiroAbrirDoc.addActionListener(new P4TexFrame_menuFicheiroAbrirDoc_actionAdapter(this));
        menuFicheiroAbrirDic.setText("Abrir Dicionario...");
        menuFicheiroAbrirDic.addActionListener(new P4TexFrame_menuFicheiroAbrirDic_actionAdapter(this));
        menuFicheiroGravar.setText("Gravar Documento");
        menuFicheiroGravar.addActionListener(new P4TexFrame_menuFicheiroGavar_actionAdapter(this));
        menuFicheiroGravar.setEnabled(false);
        menuFicheiroGravarComo.setText("Gravar Documento Como...");
        menuFicheiroGravarComo.addActionListener(new P4TexFrame_menuFicheiroGravarComo_actionAdapter(this));
        menuFicheiroGravarComo.setEnabled(false);
        menuFicheiroImprimir.setText("Imprimir...");
        menuFicheiroImprimir.addActionListener(new P4TexFrame_menuFicheiroImprimir_actionAdapter(this));
        menuFicheiroImprimir.setEnabled(false);
        popupMenuSinonimos.setText("Sinónimos");
        popupMenuAnagramas.setText("Correcçao");
        popupMenuSubstituir.setText("Substituir...");
        popupMenuSubstituir.addActionListener(new P4TexFrame_popupMenuSubstituirActionAdapter(this));
        progressBar.setVisible(false);
        statusText.setText(" ");
        statusBar.setLayout(borderLayout2);
        menuSubstituir.setText("Substituir");
        menuSubstituirSinonimos.setText("Sinónimos...");
        menuSubstituirSinonimos.addActionListener(new P4TexFrame_jMenuItem1_actionAdapter(this));
        menuSubstituirPalavras.addActionListener(new P4TexFrame_jMenuItem2_actionAdapter(this));
        menuSubstituirPalavras.setText("Palavras...");
        menuFerramentas.setText("Ferramentas");
        jMenuBar1.add(menuFile);
        jMenuBar1.add(menuSubstituir);
        jMenuBar1.add(menuFerramentas);
        menuFile.add(menuFicheiroAbrirFDE);
        menuFile.add(menuFicheiroAbrirDoc);
        menuFile.add(menuFicheiroAbrirDic);
        menuFile.addSeparator();
        menuFile.add(menuFicheiroGravar);
        menuFile.add(menuFicheiroGravarComo);
        menuFile.addSeparator();
        menuFile.add(menuFicheiroImprimir);
        menuFile.addSeparator();
        menuFile.add(menuFicheiroSair);
        jMenuBar1.add(menuHelp);
        menuHelp.add(menuAjudaSobre);
        setJMenuBar(jMenuBar1);
        contentPane.add(scrollPane, java.awt.BorderLayout.CENTER);
        scrollPane.getViewport().add(textPane);
        popupMenu.add(popupMenuSinonimos);
        popupMenu.add(popupMenuAnagramas);
        popupMenu.add(popupMenuSubstituir);
        contentPane.add(statusBar, java.awt.BorderLayout.SOUTH);
        statusBar.add(progressBar, java.awt.BorderLayout.CENTER);
        statusBar.add(statusText, java.awt.BorderLayout.WEST);
        menuSubstituir.add(menuSubstituirPalavras);
        menuSubstituir.add(menuSubstituirSinonimos);
        menuFerramentas.add(optionSmartSelect);
    }

    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        P4TexFrame_AboutBox dlg = new P4TexFrame_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.show();
    }

    public P4TeX getP4TeX() {
        return p4tex;
    }

    public void menuFicheiroAbrirFDE_actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Abrir FDE");
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            try {
                p4tex.abrirFDE(jfc.getSelectedFile());
                menuFicheiroAbrirDoc.setEnabled(true);
                statusText.setText("FDE carregado com sucesso");
            }
            catch (FormatacaoException ex) {
                new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro ao abrir FDE", JOptionPane.ERROR_MESSAGE);
            }
            catch (DocumentoException ex) {
                new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro ao abrir FDE", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ex) {
                new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro ao abrir FDE", JOptionPane.ERROR_MESSAGE);
            }
    }

    public void menuFicheiroAbrirDoc_actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Abrir Documento");
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            try {
                p4tex.abrirDocumento(jfc.getSelectedFile());
                setTitle("P4TeX - " + jfc.getSelectedFile());
                menuFicheiroGravar.setEnabled(true);
                menuFicheiroGravarComo.setEnabled(true);
                menuFicheiroImprimir.setEnabled(true);
                statusText.setText("Documento carregado com sucesso");
            }
            catch (FormatacaoException ex) {
                new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro ao abrir documento", JOptionPane.ERROR_MESSAGE);
            }
            catch (DocumentoException ex) {
                new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro ao abrir documento", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ex) {
                new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro ao abrir documento", JOptionPane.ERROR_MESSAGE);
            }
    }

    public void menuFicheiroAbrirDic_actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Abrir Dicionário");
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            p4tex.abrirDicionario(jfc.getSelectedFile());
            p4tex.getDicionario().addDicionarioListener(this);
        }
    }

    public void menuFicheiroGavar_actionPerformed(ActionEvent e) {
        p4tex.gravar();
    }

    public void menuFicheiroGravarComo_actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
           p4tex.gravarComo(jfc.getSelectedFile());
    }

    public void menuFicheiroImprimir_actionPerformed(ActionEvent e) {
        DocumentRenderer dr = new DocumentRenderer();
        dr.print(textPane);
    }

    private String getSmartSelectedText() {
        int i = textPane.getSelectionStart(), j = textPane.getSelectionEnd();
        try {
            if (!textPane.getText(i, 1).matches("\\b.+?\\b"))
                while (!textPane.getText(++i, 1).matches("\\b.+?\\b"));
            else {
                while (i != 0 && textPane.getText(--i, 1).matches("\\b.+?\\b"));
                if (i != 0)
                    i++;
            }
            if (!textPane.getText(--j, 1).matches("\\b.+?\\b")) {
                while (!textPane.getText(--j, 1).matches("\\b.+?\\b"));
                j++;
            }
            else
                while (textPane.getText(++j, 1).matches("\\b.+?\\b"));

            textPane.select(i, j);
            return textPane.getSelectedText();
        }
        catch (BadLocationException ex) {}

        return null;
    }

    public void textPane_popUp(MouseEvent e) {
        if (e.isPopupTrigger()) {
            String selectedText = null;

            if (optionSmartSelect.isSelected())
                selectedText = getSmartSelectedText();
            else
                selectedText = textPane.getSelectedText();

            if (selectedText != null) {
                criarPopupMenu(selectedText);
                popupMenu.show(this, e.getX(), e.getY());
            }
        }
    }

    private void criarPopupMenu(String selectedText) {
        popupMenuSinonimos.removeAll();
        popupMenuAnagramas.removeAll();
        Iterador sinonimos = p4tex.procurarSinonimos(selectedText);

        popupMenuSinonimos.setEnabled(false);
        if (sinonimos.podeAvancar()) {
            popupMenuSinonimos.setEnabled(true);
            while (sinonimos.podeAvancar()) {
                JMenuItem menuItem = new JMenuItem(((Palavra) sinonimos.avancar()).getPalavra());
                menuItem.setActionCommand(((Palavra) sinonimos.corrente()).getPalavra());
                menuItem.addActionListener(new P4TexFrame_subPopupMenuActionAdapter(this));
                popupMenuSinonimos.add(menuItem);
            }
        }

        popupMenuAnagramas.setEnabled(false);
        if (p4tex.isSelectedWordWrong(selectedText)) {
            Iterador anagramas = p4tex.procurarAnagramas(selectedText);
            if (anagramas.podeAvancar()) {
                popupMenuAnagramas.setEnabled(true);
                while (anagramas.podeAvancar()) {
                    JMenuItem menuItem = new JMenuItem(((Palavra) anagramas.avancar()).getPalavra());
                    menuItem.setActionCommand(((Palavra) anagramas.corrente()).getPalavra());
                    menuItem.addActionListener(new P4TexFrame_subPopupMenuActionAdapter(this));
                    popupMenuAnagramas.add(menuItem);
                }
            }
        }

    }

    public void subPopupMenuAction(ActionEvent e) {
        try {
            p4tex.substituirTodasPalavras(textPane.getSelectedText(), e.getActionCommand());
        }
        catch (FormatacaoException ex) {
            new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro de Substituição", JOptionPane.ERROR_MESSAGE);
        }
        catch (SubstituicaoException ex) {
            new JOptionPane().showMessageDialog(this, ex.getMessage(), "Erro de Substituição", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void popupMenuSubstituirAction(ActionEvent e) {
        jMenuItem2_actionPerformed(e);
    }

    public void dicionarioLoadFinished(DicionarioEvent event) {
        progressBar.setVisible(false);
        statusText.setText("Dicionário carregado com sucesso");
    }

    public void dicionarioLoading(DicionarioEvent event) {
        progressBar.setValue(event.getLinhaCorrente());
    }

    public void dicionarioStartLoading(DicionarioEvent event) {
        statusText.setText("A carregar dicionário ");
        progressBar.setVisible(true);
        progressBar.setMaximum(event.getNumLinhas());
    }

    public void jMenuItem1_actionPerformed(ActionEvent e) {
        P4TexFrame_SubstituirSinonimos dlg = new P4TexFrame_SubstituirSinonimos(this, textPane.getSelectedText());
        dlg.pack();
        dlg.centrar();
        dlg.setVisible(true);
    }

    public void jMenuItem2_actionPerformed(ActionEvent e) {
        P4TexFrame_SubstituirTexto dlg = new P4TexFrame_SubstituirTexto(this, textPane.getSelectedText());
        dlg.pack();
        dlg.centrar();
        dlg.setVisible(true);
    }

}

class P4TexFrame_jMenuItem2_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_jMenuItem2_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem2_actionPerformed(e);
    }
}

class P4TexFrame_jMenuItem1_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_jMenuItem1_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}

class P4TexFrame_popupMenuSubstituirActionAdapter implements ActionListener {
    P4TexFrame adaptee;

    public P4TexFrame_popupMenuSubstituirActionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.popupMenuSubstituirAction(e);
    }

}

class P4TexFrame_subPopupMenuActionAdapter implements ActionListener {
    P4TexFrame adaptee;

    public P4TexFrame_subPopupMenuActionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.subPopupMenuAction(e);
    }

}

class P4TexFrame_textPane_mouseAdapter extends MouseAdapter {
    private P4TexFrame adaptee;
    P4TexFrame_textPane_mouseAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.textPane_popUp(e);
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.textPane_popUp(e);
    }
}

class P4TexFrame_menuFicheiroImprimir_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_menuFicheiroImprimir_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFicheiroImprimir_actionPerformed(e);
    }
}

class P4TexFrame_menuFicheiroGravarComo_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_menuFicheiroGravarComo_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFicheiroGravarComo_actionPerformed(e);
    }
}

class P4TexFrame_menuFicheiroGavar_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_menuFicheiroGavar_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFicheiroGavar_actionPerformed(e);
    }
}

class P4TexFrame_menuFicheiroAbrirDic_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_menuFicheiroAbrirDic_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFicheiroAbrirDic_actionPerformed(e);
    }
}

class P4TexFrame_menuFicheiroAbrirFDE_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_menuFicheiroAbrirFDE_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFicheiroAbrirFDE_actionPerformed(e);
    }
}

class P4TexFrame_menuFicheiroAbrirDoc_actionAdapter
    implements ActionListener {
    private P4TexFrame adaptee;
    P4TexFrame_menuFicheiroAbrirDoc_actionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFicheiroAbrirDoc_actionPerformed(e);
    }
}

class P4TexFrame_jMenuFileExit_ActionAdapter
    implements ActionListener {
    P4TexFrame adaptee;

    P4TexFrame_jMenuFileExit_ActionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}

class P4TexFrame_jMenuHelpAbout_ActionAdapter
    implements ActionListener {
    P4TexFrame adaptee;

    P4TexFrame_jMenuHelpAbout_ActionAdapter(P4TexFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}
