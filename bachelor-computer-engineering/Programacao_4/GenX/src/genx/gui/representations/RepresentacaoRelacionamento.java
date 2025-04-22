package genx.gui.representations;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import componenteGeneologia.*;
import genx.gui.eventos.*;
import genx.gui.save.*;
import genx.modelo.*;
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
 * @author not attributable
 * @version 1.0
 */
public class RepresentacaoRelacionamento extends Representacao {

    private Association[] associacaoAscendente = new Association[2];

    private JPopupMenu popupMenu = new JPopupMenu();

    public RepresentacaoRelacionamento(Relacionamento r, ArvoreGeneologica arvore) {
        super(r, arvore);
        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));
        add(new JLabel(ImageLoader.getLoader().getIcon("/genx/imagens/ralationship.png")));

        JMenuItem aMenuItem = new JMenuItem("Remover", ImageLoader.getLoader().getScaledIcon("/genx/imagens/delete.png", 12, 12));
        aMenuItem.addActionListener(new RepresentacaoRelacionamento_menuItemRemover_actionAdapter(this));
        popupMenu.add(aMenuItem);
        addMouseListener(new RepresentacaoRelacionamento_popupMenu_mouseAdapter(this));
    }

    public void select() {
        super.select();
        setBorder(BorderFactory.createLineBorder(Color.black, 2));

        fireDataChanged(new RepresentacaoEvent(this));
        fireRelacionamentoSelected(new RepresentacaoEvent(this));
    }

    public void unselect() {
        super.unselect();
        setBorder(BorderFactory.createLineBorder(Color.gray, 2));
    }

    public void remover() {
        getArvore().removerRelacionamento((Relacionamento)getOwner());
    }

    public SaveRepresentacaoRelacionamento saveRepresentacaoRelacionamento() {
        return new SaveRepresentacaoRelacionamento(this, getBounds().getLocation());
    }

    public SaveRepresentacaoPessoa saveRepresentacaoPessoa() {
        return null;
    }

    public void adicionarAssociacaoAscendente(int sexo, Association associacaoAscendente) {
        getContainer().removeAssociation(this.associacaoAscendente[sexo]);
        this.associacaoAscendente[sexo] = associacaoAscendente;
        getContainer().addAssociation(associacaoAscendente);
    }

    public void removerAssociacaoAscendente(int sexo) {
        getContainer().removeAssociation(this.associacaoAscendente[sexo]);
        this.associacaoAscendente[sexo] = null;
    }

    public Association getAssociacao(int sexo) {
        return associacaoAscendente[sexo];
    }

    public void popupMenu_mouseAdapter(MouseEvent e) {
        if (e.isPopupTrigger())
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    public void menuItemRemover_actionAdapter(ActionEvent e) {
        getArvore().removerRelacionamento((Relacionamento)getOwner());
    }

}

class RepresentacaoRelacionamento_popupMenu_mouseAdapter
    extends MouseAdapter {
    private RepresentacaoRelacionamento adaptee;
    RepresentacaoRelacionamento_popupMenu_mouseAdapter(RepresentacaoRelacionamento adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.popupMenu_mouseAdapter(e);
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.popupMenu_mouseAdapter(e);
    }

}

class RepresentacaoRelacionamento_menuItemRemover_actionAdapter
    implements ActionListener {
    private RepresentacaoRelacionamento adaptee;
    RepresentacaoRelacionamento_menuItemRemover_actionAdapter(RepresentacaoRelacionamento adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuItemRemover_actionAdapter(e);
    }
}
