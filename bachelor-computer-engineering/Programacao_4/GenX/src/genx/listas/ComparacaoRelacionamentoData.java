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
public class ComparacaoRelacionamentoData implements Comparacao, Serializable {

    public int comparar(Object o1, Object o2) {
        if (o1 == o2)
            return 0;

        if (o1 instanceof Relacionamento && o2 instanceof Relacionamento)
            return ((Relacionamento) o1).getDataInicio().getTime().compareTo(((Relacionamento) o2).getDataInicio().getTime());

        throw ERRO_COMPARACAO;
    }

}
