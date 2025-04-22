package j2gether.model;

import java.io.Serializable;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho pr�tico P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author S�rgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class Peca implements Serializable{

    /**
     * Representa��o inteira da cor da pe�a
     */
    private int cor;

    /**
     * Indica se a pe�a se encontra seleccionada
     */
    private boolean candidata;

    /**
     * Posi��o do tabuleiro em que se encontra a pe�a
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
     * Seleciona a pe�a
     */
    public void select() {
        candidata = true;
    }

    /**
     * Desselecciona a pe�a
     */
    public void deSelect() {
        candidata = false;
    }

    /**
     * Compara uma determinada cor com a cor da pe�a
     *
     * @param cor cor a comparar
     * @return boolean indicando se as cores s�o iguais ou n�o
     */
    public boolean sameColour(int cor) {
        return this.cor == cor;
    }

    /**
     * Atribui a cor INCOLOR � pe�a
     */
    public void ocultar() {
        cor = INCOLOR;
    }

    public String toString() {
        return Integer.toString(cor);
    }


}
