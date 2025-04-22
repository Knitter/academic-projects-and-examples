package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Representa a explosão de um objecto quando este morre. </p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Explosao extends Figura {
	
	protected static final String GRANDE = "explosaoGrande";
	protected static final String MEDIA = "explosaoMedia";
	protected static final String PEQUENA = "explosaoPequena";


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
	 * @param nome Nome da explosão
	 * @param imagens TileSets da explosão
	 * @param posicao Posição na qual a explosão vai ser colocada
	 * @param tempoActual Instante em que se inicia a animação e se coloca a explosão no jogo
	 * @param nivel Nivel ao qual a explosão pertence
	 * @param nomeAnimacao Nome da animação da explosão
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
  public Explosao(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }

}
