package genx.gui.representations;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import componenteGeneologia.*;
import genx.gui.*;
import genx.gui.eventos.*;
import genx.gui.save.*;
import genx.modelo.*;
import genx.modelo.eventos.*;
import genx.utils.*;

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
public class RepresentacaoPessoa extends Representacao implements PessoaListener {

    private JLabel nome = new JLabel();
    private JLabel fotografia = new JLabel();
    private ChildAssociation associacaoDescendente;
    private JPopupMenu popupMenu = new JPopupMenu();

    public RepresentacaoPessoa(Pessoa p, ArvoreGeneologica arvore) {
        super(p, arvore);
        p.addPessoaListener(this);
        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JMenu aMenu;
        JMenuItem aMenuItem;

        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));

        fotografia.setIcon(ImageLoader.getLoader().getScaledIcon( ( (Pessoa) getOwner()).getFotografia(), 32, 32));
        add(fotografia);
        nome.setText( ( (Pessoa) getOwner()).getNome());
        add(nome);

        aMenu = new JMenu("Pesquisar");
        aMenu.setIcon(ImageLoader.getLoader().getScaledIcon("/genx/imagens/lipa.png", 12, 12));
        aMenuItem = new JMenuItem("Ascendentes de grau...");
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemParentesGrauN_actionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Filhos");
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemFilhos_actionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Irmãos");
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemIrmaos_actionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Meios-irmãos");
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemMeiosIrmaos_actionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Primos");
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemPrimos_actionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Tios");
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemTios_actionAdapter(this));
        aMenu.add(aMenuItem);
        popupMenu.add(aMenu);
        popupMenu.addSeparator();
        aMenuItem = new JMenuItem("Remover", ImageLoader.getLoader().getScaledIcon("/genx/imagens/delete.png", 12, 12));
        aMenuItem.addActionListener(new RepresentacaoPessoa_menuItemRemover_actionAdapter(this));
        popupMenu.add(aMenuItem);

        addMouseListener(new RepresentacaoPessoa_popupMenu_mouseAdapter(this));
    }

    public void select() {
        super.select();
        setBorder(BorderFactory.createLineBorder(Color.black, 2));

        fireDataChanged(new RepresentacaoEvent(this));
        firePessoaSelected(new RepresentacaoEvent(this));
    }

    public void unselect() {
        super.unselect();
        setBorder(BorderFactory.createLineBorder(Color.gray, 2));
    }

    public void remover() {
        getArvore().removerPessoa((Pessoa) getOwner());
    }

    public void nomeChanged(PessoaEvent event) {
        nome.setText(event.getNovoNome());
    }

    public void sexoChanged(PessoaEvent event) {
    }

    public void fotoChanged(PessoaEvent event) {
        fotografia.setIcon(ImageLoader.getLoader().getScaledIcon(event.getNovaFotografia(), 32, 32));
    }

    public void dataNascChanged(PessoaEvent event) {
    }

    public void dataObitoChanged(PessoaEvent event) {
    }

    public void relacionamentoAscendenteRemoved(PessoaEvent event) {
        getContainer().removeAssociation(associacaoDescendente);
        associacaoDescendente = null;
    }

    public SaveRepresentacaoPessoa saveRepresentacaoPessoa() {
        return new SaveRepresentacaoPessoa(this, getBounds().getLocation());
    }

    public SaveRepresentacaoRelacionamento saveRepresentacaoRelacionamento() {
        return null;
    }

    public void removerAssociacaoDescendente() {
        getContainer().removeAssociation(associacaoDescendente);
        associacaoDescendente = null;
    }

    public void setAssociacaoDescendente(ChildAssociation associacaoDescendente) {
        getContainer().removeAssociation(this.associacaoDescendente);
        this.associacaoDescendente = associacaoDescendente;
        getContainer().addAssociation(associacaoDescendente);
    }

    public Association getAssociacao() {
        return associacaoDescendente;
    }

    public void popupMenu_mouseAdapter(MouseEvent e) {
        if (e.isPopupTrigger())
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    public void menuItemFilhos_actionAdapter(ActionEvent e) {
        ShowResults dlg = new ShowResults("Filhos de " + ( (Pessoa) getOwner()).getNome(), getArvore().consultarFilhos( (Pessoa) getOwner()));
        dlg.pack();
        dlg.centrar();
        dlg.show();
    }

    public void menuItemIrmaos_actionAdapter(ActionEvent e) {
        ShowResults dlg = new ShowResults("Irmãos de " + ( (Pessoa) getOwner()).getNome(), getArvore().consultarIrmaos( (Pessoa) getOwner()));
        dlg.pack();
        dlg.centrar();
        dlg.show();
    }

    public void menuItemMeiosIrmaos_actionAdapter(ActionEvent e) {
        ShowResults dlg = new ShowResults("Meios-Irmãos de " + ( (Pessoa) getOwner()).getNome(), getArvore().consultarMeiosIrmaos( (Pessoa) getOwner()));
        dlg.pack();
        dlg.centrar();
        dlg.show();
    }

    public void menuItemPrimos_actionAdapter(ActionEvent e) {
        ShowResults dlg = new ShowResults("Primos de " + ( (Pessoa) getOwner()).getNome(), getArvore().consultarPrimos( (Pessoa) getOwner()));
        dlg.pack();
        dlg.centrar();
        dlg.show();
    }

    public void menuItemTios_actionAdapter(ActionEvent e) {
        ShowResults dlg = new ShowResults("Tios de " + ( (Pessoa) getOwner()).getNome(), getArvore().consultarTios( (Pessoa) getOwner()));
        dlg.pack();
        dlg.centrar();
        dlg.show();
    }

    public void menuItemParentesGrauN_actionAdapter(ActionEvent e) {
        int grau = 0;
        String nome = new JOptionPane().showInputDialog(this, "", "Grau a pesquisar", JOptionPane.PLAIN_MESSAGE);

        try {
            if (nome != null && !nome.equals("")) {
                grau = Integer.parseInt(nome);
                ShowResults dlg = new ShowResults("Parentes de Grau " + grau + " de " + ( (Pessoa) getOwner()).getNome(),
                                                  getArvore().consultarAscendentesGrauN( (Pessoa) getOwner(), grau));
                dlg.pack();
                dlg.centrar();
                dlg.show();
            }
        }
        catch (NumberFormatException ex) {
            new JOptionPane().showMessageDialog(this, "Introduza um número", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void menuItemRemover_actionAdapter(ActionEvent e) {
        getArvore().removerPessoa((Pessoa)getOwner());
    }

}



///////// Action Adapters //////////////////////////////////////////////////////

class RepresentacaoPessoa_popupMenu_mouseAdapter
    extends MouseAdapter {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_popupMenu_mouseAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.popupMenu_mouseAdapter(e);
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.popupMenu_mouseAdapter(e);
    }

}

class RepresentacaoPessoa_menuItemFilhos_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemFilhos_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemFilhos_actionAdapter(e);
    }
}

class RepresentacaoPessoa_menuItemIrmaos_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemIrmaos_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemIrmaos_actionAdapter(e);
    }

}

class RepresentacaoPessoa_menuItemMeiosIrmaos_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemMeiosIrmaos_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemMeiosIrmaos_actionAdapter(e);
    }
}

class RepresentacaoPessoa_menuItemPrimos_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemPrimos_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemPrimos_actionAdapter(e);
    }
}

class RepresentacaoPessoa_menuItemTios_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemTios_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemTios_actionAdapter(e);
    }
}

class RepresentacaoPessoa_menuItemParentesGrauN_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemParentesGrauN_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemParentesGrauN_actionAdapter(e);
    }
}

class RepresentacaoPessoa_menuItemRemover_actionAdapter
    implements ActionListener {
    private RepresentacaoPessoa adaptee;
    RepresentacaoPessoa_menuItemRemover_actionAdapter(RepresentacaoPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemRemover_actionAdapter(e);
    }
}
