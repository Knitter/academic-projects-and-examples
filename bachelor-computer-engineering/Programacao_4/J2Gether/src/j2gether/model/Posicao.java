package j2gether.model;

import java.io.Serializable;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class Posicao implements Serializable {

    private int linha;
    private int coluna;

    public Posicao() {
        this(0, 0);
    }

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Posicao(Posicao posicao) {
        this(posicao.getLinha(), posicao.getColuna());
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Posicao))
            return false;
        return ((Posicao) o).getLinha() == linha &&
                ((Posicao) o).getColuna() == coluna;
    }

    public String toString() {
        return new String("(" + linha + ", " + coluna + ")");
    }

}
