package genx.listas;

import java.io.*;

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
public class ComparacaoPessoasData implements Comparacao, Serializable {

    public int comparar(Object o1, Object o2) {
        if (o1 == o2)
            return 0;

        if (o1 instanceof Pessoa && o2 instanceof Pessoa)
            return ((Pessoa) o1).getDataNasc().getTime().compareTo(((Pessoa) o2).getDataNasc().getTime());

        throw ERRO_COMPARACAO;
    }

}
