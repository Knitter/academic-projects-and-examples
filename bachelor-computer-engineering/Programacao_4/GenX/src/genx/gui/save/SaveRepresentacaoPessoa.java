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
public class SaveRepresentacaoPessoa implements Serializable {

    private Pessoa pessoa;
    private Point posicao;
    private Associacao associacao;

    public SaveRepresentacaoPessoa(RepresentacaoPessoa pessoa, Point posicao) {
        this.pessoa = (Pessoa)pessoa.getOwner();
        this.posicao = posicao;
        if (pessoa.getAssociacao() != null)
            associacao = new Associacao(pessoa.getAssociacao().getBegin().getOwner(), pessoa.getAssociacao().getEnd().getOwner());
    }

    public Point getPosicao() {
        return posicao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Associacao getAssociacao() {
        return associacao;
    }
}
