package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os objectos que colidem no jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Colidem extends Figura {


/////////////////// Constructors ///////////////////////////////////////////////

	public Colidem() {
	}

	/** Construtor
	 * 
   * @param nome Nome da sprite
   * @param imagens TileSets do objecto
   * @param posicao Posição na qual o objecto vai ser colocado
   * @param tempoActual Instante em que se inicia a animação e se coloca o objecto no jogo
   * @param nivel Nivel ao qual o objecto pertence
   * @param nomeAnimacao Nome da animação
   * @param animacoes Sequência de animações a serem apresentadas
   * @param tempos Duração de cada sequência de animação (por Tile)
   * @param opcaoAni Indica se deve terminar a animação actual ou não
   */
	public Colidem(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
		super(nome,	imagens, posicao,	tempoActual, nivel,	nomeAnimacao, animacoes, tempos, opcaoAni);
		sprite.addSpriteColisionListener(this, "trataColisao");
	}


/////////////////// Método Morrer //////////////////////////////////////////////
	
	/** Morrer do objecto
	 * 
	 * @param tempoActual Instante em que o objecto morre
	 */
  public void morrer(long tempoActual) {
		sprite.removeSpriteColisionListener(this, "trataColisao");
  }

}
