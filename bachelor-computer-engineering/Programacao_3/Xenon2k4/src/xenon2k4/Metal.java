package xenon2k4;

import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Tiro Metal de um inimigo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Metal extends TiroInimigo {
  
/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param velocidade Velocidade que o tiro Metal é disparado
	 * @param capacidadeDestruicao Capacidade de destruição do tiro Metal
	 * @param imagens TileSets do tiro Metal
	 * @param nivel Nivel ao qual o tiro Metal pertence
	 */
	public Metal(int velocidade, int capacidadeDestruicao, TileSet imagens, Nivel nivel) {
    super(velocidade, capacidadeDestruicao, imagens, new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, nivel);
  }

}
