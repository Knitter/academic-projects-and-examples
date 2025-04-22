package model;

import java.util.LinkedList;
import controller.PuzzleListener;
import java.util.Iterator;
import java.io.Serializable;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

public class Puzzle implements Serializable{


  private final int DIMENSAO = 3;

  private Peca[][] pecas;

  /**
   * Atributo da aula! Guarda a posição da peça vazia. Não está a ser utilizada.
   * */
  private Posicao vazia;
  /**
   * Lista de todos os listeners registados que receberão as indicações
   * das alterações efectuadas pelo puzzle.
   * 'transient' - indica que este objecto não será guardado permanentemente pelo
   * que será ignorado pelo 'writeObject()'. Tem, por isso, de ser reconstruído "manulmente"
   * aquando da leitura do ficheiro.
   * */
  private transient LinkedList listeners = new LinkedList();
  private int numMovimentos;

  public Puzzle() {
    pecas = new Peca[][]{{new Peca(1, new Posicao(0,0)), new Peca(2, new Posicao(0,1)), new Peca(3, new Posicao(0,2))},
      {new Peca(4, new Posicao(1,0)), new Peca(5, new Posicao(1,1)), new Peca(6, new Posicao(1,2))},
      {new Peca(7, new Posicao(2,0)), new Peca(8, new Posicao(2,1)), null}};
  }

  /**
   * Construtor feito na aula! Este construtor, embora atribua uma posição nula
   * á peça vazia, atribui-lhe também um valor válido.
   * */
  public Puzzle(boolean fromClass) {
    int linha = 0, coluna = 0, valor = 1;
    Posicao posicao = null;
    pecas = new Peca[3][3];
    for (linha = 0; linha < 3; linha++)
      for (coluna = 0; coluna < 3; coluna++) {
        if (linha != 2 && coluna != 2)
          posicao = new Posicao(linha, coluna);
        pecas[linha][coluna] = new Peca(valor++, posicao);
      }
    vazia = new Posicao(2, 2);
  }

  /**
   * Adaptado as imagens! para mudar!
   * */
  public Puzzle(int valorBase) {
    int linha = 0, coluna = 0;
    Posicao posicao = null;
    pecas = new Peca[3][3];
    for (linha = 0; linha < 3; linha++)
      for (coluna = 0; coluna < 3; coluna++) {
        posicao = new Posicao(linha, coluna);
        pecas[linha][coluna] = new Peca(valorBase++, posicao);
      }
    pecas[2][2] = null;
    vazia = new Posicao(2, 2);
  }


  public int getColunas() {
    return DIMENSAO;
  }

  public int getLinhas() {
    return DIMENSAO;
  }

  public Peca getPecaEm(int linha, int coluna) {
    return pecas[linha][coluna];
  }


  /**
   * Indica se o puzzle se encontra concluido verificando se alguma das peças está
   * fora da sua posição correcta.
   *
   * */
  public boolean isConcluido() {
    int z, y;
    for (z = 0; z < pecas.length; z++)
      for (y = 0; y < pecas[z].length; y++)
        if (pecas[z][y] != null && !pecas[z][y].isCorrecta())
          return false;
    return true;
  }

  /**
   * Verifica se a posição dada pela linha e coluna é uma posição vazia.
   * */
  public boolean isEmptySlot(int linha, int coluna) {
    return pecas[linha][coluna] == null;
  }

  public boolean mover(int linha, int coluna) {
    Posicao destino;
    if ( (destino = podeMover(linha, coluna)) != null) {
      Peca peca = pecas[linha][coluna];
      peca.mover(destino);
      pecas[destino.getLinha()][destino.getColuna()] = peca;
      pecas[linha][coluna] = null;
      firePuzzleChanged();
      return true;
    }
    return false;
  }

  /**
   * Método da aula!B3N
   * */
  public boolean mover(Posicao posicao) {
    if (pecas[posicao.getLinha()][posicao.getColuna()] != null)
      if (vazia.isAdjacente(posicao)) {
        pecas[vazia.getLinha()][vazia.getColuna()] =
            pecas[posicao.getLinha()][posicao.getColuna()];
        vazia = posicao;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        firePuzzleChanged();
        return true;
      }
    return false;
  }

  public Posicao podeMover(int linha, int coluna) {
    Posicao destino = null;
    if (linha + 1 < pecas.length)
      if (isEmptySlot(linha + 1, coluna))
        destino = new Posicao(linha + 1, coluna);

    if (linha - 1 >= 0)
      if (isEmptySlot(linha - 1, coluna))
        destino = new Posicao(linha - 1, coluna);

    if (coluna + 1 < pecas[0].length)
      if (isEmptySlot(linha, coluna + 1))
        destino = new Posicao(linha, coluna + 1);

    if (coluna - 1 >= 0)
      if (isEmptySlot(linha, coluna - 1))
        destino = new Posicao(linha, coluna - 1);
    return destino;
  }

  public void addPuzzleListener(PuzzleListener listener) {
    if(listeners == null)
      (listeners = new LinkedList()).add(listener);
      else
        listeners.add(listener);
  }

  public void removePuzzleListener(PuzzleListener listener) {
    if(listeners != null)
      listeners.remove(listener);
  }

  public void firePuzzleChanged() {
    Iterator it = listeners.iterator();
    while (it.hasNext())
      ( (PuzzleListener) it.next()).puzzleChanged();
  }

  /**
   * (c)B3N
   * */
  public void scranble() {
    double maxMovimentos = Math.random() * 150 + 50, movimentosValidos = 0;
    while (movimentosValidos < maxMovimentos)
      if (mover((int) Math.round(Math.random() * 2), (int) Math.round(Math.random() * 2)) == true)
        movimentosValidos++;
  }

  public void incNumMovimentos() {
    numMovimentos++;
  }

  public int getNumMovimentos() {
    return numMovimentos;
  }

  public void resetNumMovimentos() {
    numMovimentos = 0;
  }

  /**
   * Imprime os valores das peças do puzzle numa matriz 3x3.
   * */
  public String toString() {
    int linha, coluna;
    StringBuffer bfr = new StringBuffer();
    for (linha = 0; linha < pecas.length; linha++) {
      for (coluna = 0; coluna < pecas[linha].length; coluna++) {
        if (!isEmptySlot(linha, coluna)) {
          bfr.append(pecas[linha][coluna].toString());
          bfr.append(" ");
        }
        else
          bfr.append("  ");
      }
      bfr.append("\n");
    }
    return bfr.toString();
  }

}