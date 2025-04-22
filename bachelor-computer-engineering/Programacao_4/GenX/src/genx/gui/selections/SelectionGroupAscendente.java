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
public class SelectionGroupAscendente extends SelectionGroup {

    public SelectionGroupAscendente(ArvoreGeneologica arvore) {
        super(arvore);
    }

    public void pessoaSelected(RepresentacaoEvent event) {
        Pessoa p = (Pessoa) ( (RepresentacaoPessoa) event.getSource()).getOwner();
        seleccionarPessoa(p);
        if (isPessoaSelected( (p.getSexo() + 1) % 2))
            try {
                getArvore().criarRelacionamento(getPessoa(Pessoa.SEXO_MASCULINO), getPessoa(Pessoa.SEXO_FEMININO));
            }
            catch (GenXSexosIguaisException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            catch (GenXRelacionamentoNecrofilosException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        else if (isRelacionamentoSelected())
            try {
                getArvore().alterarProgenitoresRelacionamento(getRelacionamento(), getPessoaSelected());
            }
            catch (GenXDataInvalidaException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                unSelectGroup();
            }
            catch (GenXRelacionamentoNecrofilosException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                unSelectGroup();
            }
    }

    public void relacionamentoSelected(RepresentacaoEvent event) {
        Relacionamento r = (Relacionamento)((RepresentacaoRelacionamento)event.getSource()).getOwner();
        seleccionarRelacionamento(r);
        if (isAnyPessoaSelected())
            try {
                getArvore().alterarProgenitoresRelacionamento(r, getPessoaSelected());
            }
            catch (GenXDataInvalidaException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                unSelectGroup();
            }
            catch (GenXRelacionamentoNecrofilosException ex) {
                new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                unSelectGroup();
            }
    }
}
