package j2gether.model;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import j2gether.view.listeners.ScoreListener;

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
public class Score implements Serializable {

  /**
   * Conjunto de nomes dos jogadores.
   */
  private String[] names;

  /**
   * Pontua��o obtida pelos jogadores.
   */
  private double[] scores;

  /**
   * Atributo interno que indica em que posi�ao ser� introduzido o novo par nome de jogador e pontua��o.
   */
  private transient int position = -1;

  /**
   * Nome do ficheiro de pontua��es a gravar.
   */
  private transient String baseName;

  /**
   * Listeners de eventos para o Score.
   */
  private transient LinkedList listeners;

  /**
   * Constante com o n�mero de erro para uma posi��o inv�lida
   */
  public static final int POS_ERR = -1;

  /**
   * Nome da directoria base onde ser�o guardados os ficheiros de pontua��es
   */
  private static String BASEDIR = ".J2Gether";

  /**
   * Nome da sub-directoria base onde ser�o guardados os ficheiros de pontua��es
   */
  private static String BASESUBDIR = "Score";

  /**
   * Constr�i uma tabela de pontua��es com base no n�mero m�ximo de pontua��es e no modo
   *
   * @param numScores n�mero m�ximo de pontua��es a guardar
   * @param mode modo no qual se baseia esta tabela de pontua��es
   * @see j2gether.model.ScoreMode
   */
  public Score(int numScores, ScoreMode mode) {
      names = new String[numScores];
      scores = new double[numScores];
      baseName = Integer.toString(mode.getNumLinhasTabuleiro() *
                                  mode.getNumColunasTabuleiro() *
                                  mode.getNumCores());
      ObjectInputStream inStream = null;

      try {
          File scoreFile = new File(System.getProperty("user.home") +
                                    File.separator + BASEDIR +
                                    File.separator + BASESUBDIR +
                                    File.separator +
                                    baseName + ".dat");
          if (scoreFile.exists()) {
              inStream = new ObjectInputStream(new FileInputStream(scoreFile));
              Score sc = (Score) inStream.readObject();
              if (sc != null) {
                  names = sc.names;
                  scores = sc.scores;
              }
          }
      } catch (ClassNotFoundException ex3) {
          System.out.println(ex3);
      } catch (IOException ex1) {
          System.out.println(ex1);
      } finally {
          if (inStream != null) {
              try {
                  inStream.close();
              } catch (IOException ex2) {
                  System.out.println(ex2);
              }
          }
      }
  }

  /**
   * Devolve a pontua��o indicada por index.
   *
   * @param index �ndice para o qual se pretende a pontua��o
   * @return pontua��o no �ndice indicado
   */
  public double getScoreValueAt(int index) {
    return scores[index];
  }

  /**
   * Devolve o nome do jogador indicado por index.
   *
   * @param index �ndice para o qual se pretende o nome do jogador
   * @return nome do jogador no �ndice indicado
   */
  public String getScoreNameAt(int index) {
    return names[index];
  }

  /**
   * Obt�m o �ndice no qual ser�o introduzidos o nome do jogador e a sua pontua��o
   *
   * @param index �ndice para o qual se pretende a pontua��o
   * @return posis�o para a nova pontua��o ou POS_ERR no caso de n�o ser poss�vel introduzir a nova pontua��o
   */
  private int findScorePosition(double score) {
    for (int z = 0; z < names.length; z++) {
      if (scores[z] <= score) {
        return z;
      }
    }
    return POS_ERR;
  }

  /**
   * Insere um nome e uma pontua��o no �ndice indicado
   *
   * @param index �ndice no qual se v�o introduzir o nome e a pontua��o
   * @param name nome a introduzir
   * @param score pontua��o a introduzir
   */
  private void insertScore(int index, String name, double score) {
    if (index >= 0 && index < names.length) {
      names[index] = name;
      scores[index] = score;
    }
  }

  /**
   * Verifica se a pontua��o indicada tem lugar na tabela de pontua��es.
   *
   * @param index �ndice no qual se v�o introduzir o nome e a pontua��o
   * @return boolean indicando se � ou n�o poss�vel introduzir a nova pontua��o
   */
  public boolean isInsertableScore(double score) {
    return (position = findScorePosition(score)) != -1;
  }

  /**
   * Permite introduzir um nome e uma pontua��o nova. A posi��o onde os novos valores s�o introduzidos � indicada internamente.
   * � obrigat�rio uma chamada ao m�todo isInsertableScore antes da utiliza��o deste m�todo.
   *
   * @param index �ndice no qual se v�o introduzir o nome e a pontua��o
   * @return boolean indicando se � ou n�o poss�vel introduzir a nova pontua��o
   * @see j2gether.model.Score#isInsertableScore(double)*/
  public void updateScores(String name, double score) {
    if (names[position] != null) {
      allocateSpace(position);
    }
    insertScore(position, name, score);
  }

  /**
   * Caso seja necess�rio introduzir uma nova pontua��o onde j� se encontrem valores este m�todo tem por objectivo
   * alocar espa�o deslocando os dados para baixo
   *
   * @param stopAt �ndice no qual o m�todo termina de deslocar dados
   */
  private void allocateSpace(int stopAt) {
    for (int z = names.length - 1; z >= stopAt; z--) {
      if (z != 0) {
        names[z] = names[z - 1];
        scores[z] = scores[z - 1];
      }
    }
  }

  /**
   * Devolve o n�mero de espa�os para pontua��es
   *
   * @return n�mero total de pontua��es poss�veis de serem introduzidas
   */
  public int getSize() {
    return names.length;
  }

  /**
   * Redefini��o do m�todo toString da classe Object
   */
  public String toString() {
    StringBuffer strbuff = new StringBuffer();
    for (int z = 0; z < names.length; z++) {
      strbuff.append(names[z] + " ");
      strbuff.append(scores[z]);
      strbuff.append("\n");
    }
    return strbuff.toString();
  }

  /**
   * Grava a tabela pontua��es corrente. Cria a directoria score, se esta n�o existir, onde grava o ficheiro
   *
   * @return boolean indicando se foi poss�vel gravar a tabela de pontua��es
   */
  public boolean saveScore() {
      ObjectOutputStream outStream = null;
      try {
          File scoreDir = new File(System.getProperty("user.home") + File.separator + BASEDIR + File.separator);
          if(!scoreDir.exists())
              scoreDir.mkdir();
          scoreDir = new File(System.getProperty("user.home") + File.separator + BASEDIR + File.separator + BASESUBDIR + File.separator);
          if (!scoreDir.exists())
              scoreDir.mkdir();
          File scoreFile = new File(System.getProperty("user.home") +
                                    File.separator + BASEDIR + File.separator + BASESUBDIR + File.separator +
                                    baseName + ".dat");
          if (!scoreFile.exists())
              scoreFile.createNewFile();
          outStream = new ObjectOutputStream(new FileOutputStream(scoreFile));
          outStream.writeObject(this);
          return true;
      } catch (IOException ex1) {
          System.out.println(ex1);
      } finally {
          if (outStream != null) {
              try {
                  outStream.close();
              } catch (IOException ex2) {
                  System.out.println(ex2);
              }
          }
      }
      return false;
  }

  /**
   * Permite eliminar todos os nomes e pontua��es antes guardadas
   */
  public void reset() {
    names = new String[names.length];
    scores = new double[scores.length];
  }

  /**
   * Adiciona um ScoreListener � lista de listeners
   *
   * @param l listener a ser adicionado
   * @see j2gether.view.listeners.ScoreListener
   */
  public void addScoreListener(ScoreListener l) {
    if (listeners == null) {
      listeners = new LinkedList();
    }
    listeners.add(l);
  }

  /**
   * Elimina um listener da lista
   *
   * @param l listener a ser removido
   * @see j2gether.view.listeners.ScoreListener
   */
  public void removeScoreListener(ScoreListener l) {
    if (listeners != null) {
      listeners.remove(l);
    }
  }

  /**
   * M�todo que indica a todos os listeners registados que houve altera��es na tabela de pontua��es
   */
  public void fireScoreChanged() {
    Iterator it = listeners.iterator();
    while (it.hasNext()) {
      ((ScoreListener) it.next()).scoreChanged();
    }
  }
}
