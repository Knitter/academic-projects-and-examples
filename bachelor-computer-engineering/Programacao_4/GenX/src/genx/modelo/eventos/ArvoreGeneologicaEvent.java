package genx.modelo.eventos;

import java.util.*;

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
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class ArvoreGeneologicaEvent extends EventObject {
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Relacionamento relacionamento;

    public ArvoreGeneologicaEvent(Object source, Pessoa p1, Pessoa p2, Relacionamento r) {
        super(source);
        pessoa1 = p1;
        pessoa2 = p2;
        relacionamento = r;
    }

    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public Pessoa getPessoa2() {
        return pessoa2;
    }

    public Pessoa getPessoa1() {
        return pessoa1;
    }
}
