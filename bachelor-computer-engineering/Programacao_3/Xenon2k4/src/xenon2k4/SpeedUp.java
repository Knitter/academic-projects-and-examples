package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Aumenta a velocidade de uma nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class SpeedUp extends Premio {

  private int factorV;


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do pr�mio SpeedUp
	 * @param imagens TileSets do pr�mio SpeedUp
	 * @param posicao Posi��o na qual o pr�mio SpeedUp vai ser colocado
   * @param factor Factor multiplicador da velocidade
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio SpeedUp no jogo
	 * @param nivel Nivel ao qual o pr�mio SpeedUp pertence
	 */
  public SpeedUp(String nome, TileSet imagens, Ponto posicao, int factor, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "speedy", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
    factorV = factor;
  }


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////
	
  /* (non-Javadoc)
   * @see xenon2k4.Premio#trataColisao(xenon2k4.Componente, long)
   */
  public void trataColisao(Componente componete, long tempoActual) {
    componete.getNave().setSpeedUp(factorV);
    morrer(tempoActual);
  }

  /* (non-Javadoc)
 	 * @see xenon2k4.Premio#trataColisao(xenon2k4.Nave, long)
   */
	public void trataColisao(Nave nave, long tempoActual) {
    nave.setSpeedUp(factorV);
    morrer(tempoActual);
  }

}
