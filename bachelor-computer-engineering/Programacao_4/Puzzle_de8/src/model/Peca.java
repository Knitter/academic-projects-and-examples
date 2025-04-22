package model;

import java.io.Serializable;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

public class Peca implements Serializable{

  private int valor;
  private Posicao posicaoCorrecta, posicaoActual;

  public Peca(int valor, Posicao posicao) {
    this.valor = valor;
    posicaoCorrecta = posicaoActual = posicao;
  }

  public Peca(Peca peca) {
    this(peca.getValor(), new Posicao (peca.getPosicaoCorrecta()));

  }

  public Posicao getPosicaoCorrecta() {
    return posicaoCorrecta;
  }

  public int getValor() {
    return valor;
  }

  public Posicao getPosicaoActual() {
    return posicaoActual;
  }

  public void mover(Posicao novaPosicao) {
    posicaoActual = novaPosicao;
  }

  public boolean isCorrecta() {
    if(posicaoActual.getLinha() == posicaoCorrecta.getLinha() && posicaoActual.getColuna() == posicaoCorrecta.getColuna())
      return true;
    return false;
  }

  /**
   * Método criado na aula!
   * */
  public boolean isCorrecta(Posicao pos) {
    return pos.equals(posicaoCorrecta);
  }

  public String toString() {
    return Integer.toString(valor);
  }
}