package xenon2k4;

import java.util.Random;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os inimigos que disparam algo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class InimigoOnFire extends Inimigo {

	private long tempoLastFire;
	private Random seed = new Random();


/////////////////// Constructors ///////////////////////////////////////////////
	
	/** Construtor
	 * 
   * @param nome Nome do Inimigo'On'Fire
   * @param imagens TileSets do Inimigo'On'Fire
   * @param posicao Posição na qual o Inimigo'On'Fire vai ser colocado
   * @param movimento Tipo de movimento a associar ao Inimigo'On'Fire
   * @param hitPoints Capacidade de destruição do Inimigo'On'Fire
	 * @param energia Quantidade de energia que o Inimigo'On'Fire contém
   * @param pontuacao Quantidade de pontos que o Inimigo'On'Fire oferece quando morre
   * @param tempoActual Instante em que se inicia a animação e se coloca o Inimigo'On'Fire no jogo
   * @param nivel Nivel ao qual o Inimigo'On'Fire pertence
   * @param nomeAnimacao Nome da animação
   * @param animacoes Sequência de animações a serem apresentadas
   * @param tempos Duração de cada sequência de animação (por Tile)
   * @param opcaoAni Indica se deve terminar a animação actual ou não
   */
  public InimigoOnFire(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int hitPoints, int energia, int pontuacao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, movimento, hitPoints, energia, pontuacao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @param tempoActual Instante a comparar a diferença de tempo
   * @return Devolve a diferença do tempo actual com o último disparo efectuado
   */
  public long getDiferencaDeTempo(long tempoActual) {
  	return tempoActual - tempoLastFire;
  }

  /**
	 * @param tempo Actualiza o tempo do último disparo efectuado
	 */
	public void setTempoLastFire(long tempo) {
  	tempoLastFire = tempo;
  }
  		
  /**
	 * @return Devolve o gerador de números aleatórios
	 */
	public Random getAleatorio() {
  	return seed;
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////

  public abstract void dispara(long tempoActual);

}
