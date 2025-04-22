package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os pr�mios do jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class Premio extends Colidem {


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do Pr�mio
	 * @param imagens TileSets do pr�mio
 	 * @param posicao Posi��o na qual o pr�mio vai ser colocado
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio no jogo
	 * @param nivel Nivel ao qual o pr�mio pertence
	 * @param nomeAnimacao Nome da anima��o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
	 */
  public Premio(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////

  /** Trata a colis�o de um componente com um pr�mio
   * 
   * @param componete Componente com o qual o pr�mio colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Componente componete, long tempoActual) {
  }

	/** Trata a colis�o de uma nave com um pr�mio
	 * 
   * @param nave Nave com a qual o pr�mio colidiu
 	 * @param tempoActual Instante em que colidiu
 	 */
	public void trataColisao(Nave nave, long tempoActual) {
  }


/////////////////// M�todo Morrer //////////////////////////////////////////////
	
	/* (non-Javadoc)
	 * @see xenon2k4.Colidem#morrer(long)
	 */
  public void morrer(long tempoActual) {
    super.morrer(tempoActual);
		nivel.mapa.removeSprite(sprite);
  }

}
