package genx.gui.save;

import java.io.*;

import java.awt.*;

import genx.gui.representations.*;
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
public class SaveRepresentacaoRelacionamento implements Serializable {

    private Relacionamento relacionamento;
    private Point posicao;
    private Associacao[] associacao = new Associacao[2];

    public SaveRepresentacaoRelacionamento(RepresentacaoRelacionamento relacionamento, Point posicao) {
        this.relacionamento = (Relacionamento)relacionamento.getOwner();
        this.posicao = posicao;
        if (relacionamento.getAssociacao(Pessoa.SEXO_MASCULINO) != null)
            associacao[Pessoa.SEXO_MASCULINO] = new Associacao(relacionamento.getAssociacao(Pessoa.SEXO_MASCULINO).getBegin().getOwner(), relacionamento.getAssociacao(Pessoa.SEXO_MASCULINO).getEnd().getOwner());
        if (relacionamento.getAssociacao(Pessoa.SEXO_FEMININO) != null)
            associacao[Pessoa.SEXO_FEMININO] = new Associacao(relacionamento.getAssociacao(Pessoa.SEXO_FEMININO).getBegin().getOwner(), relacionamento.getAssociacao(Pessoa.SEXO_FEMININO).getEnd().getOwner());
    }

    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public Point getPosicao() {
        return posicao;
    }

    public Associacao getAssociacao(int sexo) {
        return associacao[sexo];
    }

}
