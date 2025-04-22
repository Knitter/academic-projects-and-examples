package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os objectos que têm capacidade de destruição.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Destruidor extends Movel {

	private int hitPoints;


/////////////////// Constructors ///////////////////////////////////////////////

	public Destruidor() {
	}

	/** Construtor
	 * 
   * @param nome Nome do objecto destruidor
   * @param imagens TileSets do objecto destruidor
   * @param posicao Posição na qual o objecto destruidor vai ser colocado
   * @param movimento Tipo de movimento a associar ao objecto destruidor
   * @param hitPoints Capacidade de destruição do objecto destruidor
   * @param tempoActual Instante em que se inicia a animação e se coloca o objecto destruidor no jogo
   * @param nivel Nivel ao qual o objecto destruidor pertence
   * @param nomeAnimacao Nome da animação
   * @param animacoes Sequência de animações a serem apresentadas
   * @param tempos Duração de cada sequência de animação (por Tile)
   * @param opcaoAni Indica se deve terminar a animação actual ou não
   */
	public Destruidor(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int hitPoints, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes,	int[] tempos,	boolean opcaoAni) {
		super(nome,	imagens, posicao,	movimento, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
		this.hitPoints = hitPoints;
	}


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve a capacidade de destruição do objecto destruidor
   */
	public int getHitPoints() {
	  return hitPoints;
	}

	/**
	 * @param hitPoints Quantidade de hitpoints a atribuir ao objecto destruidor
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

}
