package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Representa a explos�o de um objecto quando este morre. </p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class Explosao extends Figura {
	
	protected static final String GRANDE = "explosaoGrande";
	protected static final String MEDIA = "explosaoMedia";
	protected static final String PEQUENA = "explosaoPequena";


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
	 * @param nome Nome da explos�o
	 * @param imagens TileSets da explos�o
	 * @param posicao Posi��o na qual a explos�o vai ser colocada
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca a explos�o no jogo
	 * @param nivel Nivel ao qual a explos�o pertence
	 * @param nomeAnimacao Nome da anima��o da explos�o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
	 */
  public Explosao(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }

}
