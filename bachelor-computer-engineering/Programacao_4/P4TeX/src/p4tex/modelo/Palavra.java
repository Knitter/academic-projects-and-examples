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
public class Palavra {

    private String palavra;
    private ListaSimplesCircularBaseLimiteSemRepeticao lista;

    public Palavra(String palavra, ComparacaoInfimoPalavra criterio) {
        this.palavra = palavra;
        lista = new ListaSimplesCircularBaseLimiteSemRepeticao(criterio);
    }

    public Palavra(String palavra) {
        this(palavra, new ComparacaoInfimoPalavra());
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Iterador getIteradorListaPalavras() {
        return lista.iteradorLista();
    }

    public void inserir(Palavra palavra) {
        lista.inserir(palavra);
    }

}
