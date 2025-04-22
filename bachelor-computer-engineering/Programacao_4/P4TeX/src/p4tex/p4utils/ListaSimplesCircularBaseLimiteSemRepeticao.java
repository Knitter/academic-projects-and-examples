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
public class ListaSimplesCircularBaseLimiteSemRepeticao  extends ListaSimplesCircularBaseLimite {

    public ListaSimplesCircularBaseLimiteSemRepeticao(ComparacaoInfimo criterio) {
        super(criterio);
    }

    public void inserir(Object elem)  {
        NoListaSimplesCircularBaseLimite ant = pesquisar(elem);
        if(!((Palavra)ant.seguinte.elemento).getPalavra().equals(((Palavra)elem).getPalavra()))
            ant.seguinte = new NoListaSimplesCircularBaseLimite(elem, ant.seguinte);
    }

}
