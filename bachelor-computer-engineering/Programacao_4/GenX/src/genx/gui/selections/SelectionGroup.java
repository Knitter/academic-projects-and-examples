package genx.gui.selections;

import genx.gui.eventos.*;
import genx.modelo.*;

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
public abstract class SelectionGroup implements RepresentacaoListener {

    private ArvoreGeneologica arvore;
    private Relacionamento relacionamento;
    private Pessoa[] pessoa = new Pessoa[2];

    public SelectionGroup(ArvoreGeneologica arvore) {
        this.arvore = arvore;
    }

    public boolean isPessoaSelected(int sexo) {
        return pessoa[sexo] != null;
    }

    public boolean isAnyPessoaSelected() {
        return pessoa[Pessoa.SEXO_FEMININO] != null || pessoa[Pessoa.SEXO_MASCULINO] != null;
    }

    public Pessoa getPessoaSelected() {
        return pessoa[Pessoa.SEXO_MASCULINO] != null ? pessoa[Pessoa.SEXO_MASCULINO] : pessoa[Pessoa.SEXO_FEMININO];
    }

    public boolean isRelacionamentoSelected() {
        return relacionamento != null;
    }

    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public void seleccionarPessoa(Pessoa pessoa) {
        this.pessoa[pessoa.getSexo()] = pessoa;
    }

    public void seleccionarRelacionamento(Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }

    public Pessoa getPessoa(int sexo) {
        return pessoa[sexo];
    }

    public ArvoreGeneologica getArvore() {
        return arvore;
    }

    public void unSelectGroup() {
        relacionamento = null;
        pessoa[Pessoa.SEXO_MASCULINO] = pessoa[Pessoa.SEXO_FEMININO] = null;
    }

    public void dataChanged(RepresentacaoEvent event) {
    }

}
