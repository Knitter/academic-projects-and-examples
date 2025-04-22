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
 * @author S�rgio Lopes
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
   * @param posicao Posi��o na qual o Inimigo'On'Fire vai ser colocado
   * @param movimento Tipo de movimento a associar ao Inimigo'On'Fire
   * @param hitPoints Capacidade de destrui��o do Inimigo'On'Fire
	 * @param energia Quantidade de energia que o Inimigo'On'Fire cont�m
   * @param pontuacao Quantidade de pontos que o Inimigo'On'Fire oferece quando morre
   * @param tempoActual Instante em que se inicia a anima��o e se coloca o Inimigo'On'Fire no jogo
   * @param nivel Nivel ao qual o Inimigo'On'Fire pertence
   * @param nomeAnimacao Nome da anima��o
   * @param animacoes Sequ�ncia de anima��es a serem apresentadas
   * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
   * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
   */
  public InimigoOnFire(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int hitPoints, int energia, int pontuacao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, movimento, hitPoints, energia, pontuacao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @param tempoActual Instante a comparar a diferen�a de tempo
   * @return Devolve a diferen�a do tempo actual com o �ltimo disparo efectuado
   */
  public long getDiferencaDeTempo(long tempoActual) {
  	return tempoActual - tempoLastFire;
  }

  /**
	 * @param tempo Actualiza o tempo do �ltimo disparo efectuado
	 */
	public void setTempoLastFire(long tempo) {
  	tempoLastFire = tempo;
  }
  		
  /**
	 * @return Devolve o gerador de n�meros aleat�rios
	 */
	public Random getAleatorio() {
  	return seed;
  }


/////////////////// M�todos Gerais /////////////////////////////////////////////

  public abstract void dispara(long tempoActual);

}
