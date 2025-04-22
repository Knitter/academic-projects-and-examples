package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Pr�mio que oferece um tiro Duplo a uma Nave ou a um Componente.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class PowerDuplo extends PowerUp {


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
   * @param nome Nome do pr�mio Duplo
   * @param imagens TileSets do pr�mio Duplo
   * @param posicao Posi��o na qual o pr�mio Duplo vai ser colocado
   * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio Duplo no jogo
   * @param nivel Nivel ao qual o pr�mio Duplo pertence
   */
  public PowerDuplo(String nome, TileSet imagens, Ponto posicao, long tempoActual,Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "DoubleDamage", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
    setTiro((Duplo)nivel.cfgTiros.get("tiroDuplo"));
  }

}
