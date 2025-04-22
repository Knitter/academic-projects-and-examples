package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Pr�mio que oferece um tiro Laser a uma Nave ou a um Componente.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class PowerLaser extends PowerUp {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
	 * @param nome Nome do pr�mio Laser
	 * @param imagens TileSets do pr�mio Laser
	 * @param posicao Posi��o na qual o pr�mio Laser vai ser colocado
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio Laser no jogo
	 * @param nivel Nivel ao qual o pr�mio Laser pertence
	 */
  public PowerLaser(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "Laser", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
    setTiro((Laser)nivel.cfgTiros.get("tiroLaser"));
  }

}
