package xenon2k4;

import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Tiro Espinho de um inimigo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Espinho extends TiroInimigo {
  
  protected static final int NINE_OCLOCK = 1; 
  protected static final int TEN_OCLOCK = 2; 
  protected static final int TWELVE_OCLOCK = 3; 
  protected static final int TWO_OCLOCK = 4; 
  protected static final int THREE_OCLOCK = 5; 
  protected static final int FIVE_OCLOCK = 6; 
  protected static final int SIX_OCLOCK = 7; 
  protected static final int EIGHT_OCLOCK = 8; 
	

/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param velocidade Velocidade que o tiro Espinho é disparado
	 * @param capacidadeDestruicao Capacidade de destruição do tiro Espinho
	 * @param imagens TileSets do tiro Espinho
	 * @param imagensHost TileSets do objecto que dispara o tiro Espinho. Serve para calcular o offset
	 * @param nivel Nivel ao qual o tiro Espinho pertence
	 */
	public Espinho(int velocidade, int capacidadeDestruicao, TileSet imagens, TileSet imagensHost, Nivel nivel) {
    super(velocidade, capacidadeDestruicao, imagens, new int[][] {{},{TWELVE_OCLOCK},{}}, new int[] {0, 50, 0}, nivel);
    setOffsetTiro(imagensHost.getWidth() / 2 - imagens.getWidth() / 2, imagensHost.getHeight() / 2 - imagens.getHeight());
  }

}
