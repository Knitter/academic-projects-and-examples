package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Prémio que oferece um tiro Missil a uma Nave ou a um Componente.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class PowerMissil extends PowerUp {

/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
	 * @param nome Nome do prémio Missil
	 * @param imagens TileSets do prémio Missil
	 * @param posicao Posição na qual o prémio Missil vai ser colocado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o prémio Missil no jogo
	 * @param nivel Nivel ao qual o prémio Missil pertence
	 */
  public PowerMissil(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "SKUD Missile", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
    setTiro((Missil)nivel.cfgTiros.get("tiroMissil"));
  }

}
