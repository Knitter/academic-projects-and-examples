package genx.listas;

import java.io.*;
import java.util.*;

import genx.modelo.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplica��o que permite gerir �rvores geneal�gicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author S�rgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class ComparacaoInfimoRelacionamentoData extends ComparacaoRelacionamentoData implements ComparacaoInfimo, Serializable {

    private static final Relacionamento INFIMO = new Relacionamento(new GregorianCalendar(9999999, 1, 1)/*new GregorianCalendar(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE*/);

    public Object infimo() {
        return INFIMO;
    }

}
