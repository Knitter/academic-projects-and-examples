package genx.listas;

import java.io.*;
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
public class ComparacaoInfimoPessoasNome extends ComparacaoPessoasNome implements ComparacaoInfimo, Serializable {

    private static final Pessoa INFIMO = new Pessoa("zzz", new GregorianCalendar(), 0);

    public Object infimo() {
        return INFIMO;
    }

}
