package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os inimigos que disparam tiros.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Armado extends InimigoOnFire {

	private TiroInimigo tiro;


/////////////////// Constructors ///////////////////////////////////////////////
	
  /** Construtor
   * 
	 * @param nome Nome do Inimigo Armado
	 * @param imagens TileSets do Inimigo Armado
	 * @param posicao Posição na qual o Inimigo Armado vai ser colocado
	 * @param movimento Tipo de movimento a associar ao Inimigo Armado
	 * @param hitPoints Capacidade de destruição do Inimigo Armado
   * @param energia Quantidade de energia que o Inimigo Armado contém
	 * @param pontuacao Quantidade de pontos que o Inimigo Armado oferece quando morre
	 * @param tempoActual Instante em que se inicia a animação e se coloca o Inimigo Armado no jogo
	 * @param nivel Nivel ao qual o Inimigo Armado pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
  public Armado(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int hitPoints, int energia, int pontuacao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, movimento, hitPoints, energia, pontuacao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @param tiro Tiro a atribuir ao inimigo armado
   */
  public void setTiro(TiroInimigo tiro) {
  	this.tiro = tiro;
  }
  
  /**
	 * @return Devolve o tiro que o inimigo armado possui
	 */
	public TiroInimigo getTiro() {
  	return tiro;
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Dispara um tiro
   * 
   * @param tempoActual Instante que se dispara o tiro
   */
  public void dispara(long tempoActual) {
  }

  /** Dispara um tiro
   * 
	 * @param tempoActual Instante que se dispara o tiro
	 * @param ponto Posição onde o tiro é disparado
	 * @param offsetX Offset do tiro em X
	 * @param offsetY Offset do tiro em Y
	 * @param velX Velocidade do tiro em X
	 * @param velY Velocidade do tiro em Y
	 */
	public void dispara(long tempoActual, Ponto ponto, double offsetX, double offsetY, float velX, float velY) {
		tiro.setOffsetTiro(offsetX, offsetY);
		((TiroInimigo)tiro.clone()).fire(ponto, tempoActual, velX, velY);
		setTempoLastFire(tempoActual);
	}


/////////////////// Método Morrer //////////////////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Movel#morrer(long, java.lang.String)
   */
	public void morrer(long tempoActual, String nomeAnimacao) {
		super.morrer(tempoActual, nomeAnimacao);
		nivel.inimigosOnFire.remove(this);
	}

}
