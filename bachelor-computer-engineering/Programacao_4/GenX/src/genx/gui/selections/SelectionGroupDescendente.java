package genx.gui.selections;

import javax.swing.*;

import genx.gui.eventos.*;
import genx.gui.representations.*;
import genx.modelo.*;
import genx.modelo.exceptions.*;

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
public class SelectionGroupDescendente extends SelectionGroup {

    public SelectionGroupDescendente(ArvoreGeneologica arvore) {
        super(arvore);
    }

    public void pessoaSelected(RepresentacaoEvent event) {
        Pessoa p = (Pessoa)((RepresentacaoPessoa)event.getSource()).getOwner();
        seleccionarPessoa(p);
        if (isRelacionamentoSelected())
            try {
                getArvore().adicionarFilho(p, getRelacionamento());
            }
            catch (GenXDataInvalidaException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                unSelectGroup();
            }
    }

    public void relacionamentoSelected(RepresentacaoEvent event) {
        Relacionamento r = (Relacionamento)((RepresentacaoRelacionamento)event.getSource()).getOwner();
        seleccionarRelacionamento(r);
        if (isAnyPessoaSelected())
            try {
                getArvore().adicionarFilho(getPessoaSelected(), r);
            }
            catch (GenXDataInvalidaException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                unSelectGroup();
            }
    }

}
