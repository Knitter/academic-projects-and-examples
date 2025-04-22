package p4tex.p4utils;

import p4tex.modelo.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class ComparacaoPalavra implements Comparacao {

    public int comparar(Object o1, Object o2) {
        if (o1 == o2)
            return 0;
        if (o1 instanceof Palavra && o2 instanceof Palavra)
            return ((Palavra) o1).getPalavra().compareTo(((Palavra)o2).getPalavra());
        throw ERRO_COMPARACAO;
    }
}
