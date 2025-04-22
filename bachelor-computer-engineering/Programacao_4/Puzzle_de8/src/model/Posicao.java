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

public class Posicao implements Serializable{

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

  /**
   * Método criado na aula!
   * */
  public boolean isAdjacente(Posicao posicao) {
    return (Math.abs(linha - posicao.getLinha()) + Math.abs(coluna - posicao.getColuna())) == 1;
  }

  /**
   * Método criado na aula!
   * */
  public boolean equals (Object o) {
    if (!(o instanceof Posicao))
        return false;
    return ((Posicao) o).getLinha() == linha && ((Posicao) o).getColuna() == coluna;
  }

  public String toString() {
    return new String("(" + linha + ", " + coluna + ")");
  }
}