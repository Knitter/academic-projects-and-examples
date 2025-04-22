package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Pr�mio que oferece um tiro Missil a uma Nave ou a um Componente.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class PowerMissil extends PowerUp {

/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
	 * @param nome Nome do pr�mio Missil
	 * @param imagens TileSets do pr�mio Missil
	 * @param posicao Posi��o na qual o pr�mio Missil vai ser colocado
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio Missil no jogo
	 * @param nivel Nivel ao qual o pr�mio Missil pertence
	 */
  public PowerMissil(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "SKUD Missile", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
    setTiro((Missil)nivel.cfgTiros.get("tiroMissil"));
  }

}
