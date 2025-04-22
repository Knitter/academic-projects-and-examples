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
public class Peca implements Serializable{

    /**
     * Representação inteira da cor da peça
     */
    private int cor;

    /**
     * Indica se a peça se encontra seleccionada
     */
    private boolean candidata;

    /**
     * Posição do tabuleiro em que se encontra a peça
     */
    private Posicao posicao;

    /**
     * Constante que representa a cor incolor
     */
    public static final int INCOLOR = -1;

    public Peca(Posicao posicao, int cor) {
        this.cor = cor;
        this.posicao = posicao;
    }

    public int getCor() {
        return cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public boolean isCandidata() {
        return candidata;
    }

    public boolean isIncolor() {
        return cor == INCOLOR;
    }

    public void setPosicao(Posicao novaPosicao) {
        posicao = novaPosicao;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }


    /**
     * Seleciona a peça
     */
    public void select() {
        candidata = true;
    }

    /**
     * Desselecciona a peça
     */
    public void deSelect() {
        candidata = false;
    }

    /**
     * Compara uma determinada cor com a cor da peça
     *
     * @param cor cor a comparar
     * @return boolean indicando se as cores são iguais ou não
     */
    public boolean sameColour(int cor) {
        return this.cor == cor;
    }

    /**
     * Atribui a cor INCOLOR à peça
     */
    public void ocultar() {
        cor = INCOLOR;
    }

    public String toString() {
        return Integer.toString(cor);
    }


}
