package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os prémios do jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Premio extends Colidem {


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do Prémio
	 * @param imagens TileSets do prémio
 	 * @param posicao Posição na qual o prémio vai ser colocado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o prémio no jogo
	 * @param nivel Nivel ao qual o prémio pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
  public Premio(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão de um componente com um prémio
   * 
   * @param componete Componente com o qual o prémio colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Componente componete, long tempoActual) {
  }

	/** Trata a colisão de uma nave com um prémio
	 * 
   * @param nave Nave com a qual o prémio colidiu
 	 * @param tempoActual Instante em que colidiu
 	 */
	public void trataColisao(Nave nave, long tempoActual) {
  }


/////////////////// Método Morrer //////////////////////////////////////////////
	
	/* (non-Javadoc)
	 * @see xenon2k4.Colidem#morrer(long)
	 */
  public void morrer(long tempoActual) {
    super.morrer(tempoActual);
		nivel.mapa.removeSprite(sprite);
  }

}
