package j2gether.model;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import j2gether.view.listeners.ScoreListener;

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
public class Score implements Serializable {

  /**
   * Conjunto de nomes dos jogadores.
   */
  private String[] names;

  /**
   * Pontuação obtida pelos jogadores.
   */
  private double[] scores;

  /**
   * Atributo interno que indica em que posiçao será introduzido o novo par nome de jogador e pontuação.
   */
  private transient int position = -1;

  /**
   * Nome do ficheiro de pontuações a gravar.
   */
  private transient String baseName;

  /**
   * Listeners de eventos para o Score.
   */
  private transient LinkedList listeners;

  /**
   * Constante com o número de erro para uma posição inválida
   */
  public static final int POS_ERR = -1;

  /**
   * Nome da directoria base onde serão guardados os ficheiros de pontuações
   */
  private static String BASEDIR = ".J2Gether";

  /**
   * Nome da sub-directoria base onde serão guardados os ficheiros de pontuações
   */
  private static String BASESUBDIR = "Score";

  /**
   * Constrói uma tabela de pontuações com base no número máximo de pontuações e no modo
   *
   * @param numScores número máximo de pontuações a guardar
   * @param mode modo no qual se baseia esta tabela de pontuações
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
   * Devolve a pontuação indicada por index.
   *
   * @param index índice para o qual se pretende a pontuação
   * @return pontuação no índice indicado
   */
  public double getScoreValueAt(int index) {
    return scores[index];
  }

  /**
   * Devolve o nome do jogador indicado por index.
   *
   * @param index índice para o qual se pretende o nome do jogador
   * @return nome do jogador no índice indicado
   */
  public String getScoreNameAt(int index) {
    return names[index];
  }

  /**
   * Obtém o índice no qual serão introduzidos o nome do jogador e a sua pontuação
   *
   * @param index índice para o qual se pretende a pontuação
   * @return posisão para a nova pontuação ou POS_ERR no caso de não ser possível introduzir a nova pontuação
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
   * Insere um nome e uma pontuação no índice indicado
   *
   * @param index índice no qual se vão introduzir o nome e a pontuação
   * @param name nome a introduzir
   * @param score pontuação a introduzir
   */
  private void insertScore(int index, String name, double score) {
    if (index >= 0 && index < names.length) {
      names[index] = name;
      scores[index] = score;
    }
  }

  /**
   * Verifica se a pontuação indicada tem lugar na tabela de pontuações.
   *
   * @param index índice no qual se vão introduzir o nome e a pontuação
   * @return boolean indicando se é ou não possível introduzir a nova pontuação
   */
  public boolean isInsertableScore(double score) {
    return (position = findScorePosition(score)) != -1;
  }

  /**
   * Permite introduzir um nome e uma pontuação nova. A posição onde os novos valores são introduzidos é indicada internamente.
   * É obrigatório uma chamada ao método isInsertableScore antes da utilização deste método.
   *
   * @param index índice no qual se vão introduzir o nome e a pontuação
   * @return boolean indicando se é ou não possível introduzir a nova pontuação
   * @see j2gether.model.Score#isInsertableScore(double)*/
  public void updateScores(String name, double score) {
    if (names[position] != null) {
      allocateSpace(position);
    }
    insertScore(position, name, score);
  }

  /**
   * Caso seja necessário introduzir uma nova pontuação onde já se encontrem valores este método tem por objectivo
   * alocar espaço deslocando os dados para baixo
   *
   * @param stopAt índice no qual o método termina de deslocar dados
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
   * Devolve o número de espaços para pontuações
   *
   * @return número total de pontuações possíveis de serem introduzidas
   */
  public int getSize() {
    return names.length;
  }

  /**
   * Redefinição do método toString da classe Object
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
   * Grava a tabela pontuações corrente. Cria a directoria score, se esta não existir, onde grava o ficheiro
   *
   * @return boolean indicando se foi possível gravar a tabela de pontuações
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
   * Permite eliminar todos os nomes e pontuações antes guardadas
   */
  public void reset() {
    names = new String[names.length];
    scores = new double[scores.length];
  }

  /**
   * Adiciona um ScoreListener á lista de listeners
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
   * Método que indica a todos os listeners registados que houve alterações na tabela de pontuações
   */
  public void fireScoreChanged() {
    Iterator it = listeners.iterator();
    while (it.hasNext()) {
      ((ScoreListener) it.next()).scoreChanged();
    }
  }
}
