package p4tex.modelo;

import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class PalavraIndex{

    private ListaSimplesCircularBaseFim referenciasDaPalavra = new ListaSimplesCircularBaseFim();

    public void inserirReferencia(NoListaDuplaCircularBaseFim referencia) {
        referenciasDaPalavra.inserir(referencia);
    }

    public Iterador getIteradorReferencias() {
        return referenciasDaPalavra.iteradorLista();
    }

}
