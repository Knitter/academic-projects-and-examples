package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.MovimentoLinear;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os tiros de um inimigo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class TiroInimigo extends Tiro {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
   * @param velocidade Velocidade que um tiro é disparado
   * @param hitPoints Capacidade de destruição do tiro
   * @param imagens TileSets do tiro
   * @param animacoes Sequência de animações a serem apresentadas
   * @param tempos Duração de cada sequência de animação (por Tile)
   * @param nivel Nivel ao qual o tiro pertence
   */
	public TiroInimigo(int velocidade, int hitPoints, TileSet imagens, int[][] animacoes, int[] tempos, Nivel nivel) {
		super(velocidade, hitPoints, imagens, animacoes, tempos, nivel);
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////
  
  /** Gera um novo tiro de inimigo
   * 
   * @param ponto Posição onde o tiro é gerado
   * @param tempoActual Instante em que o tiro é gerado
   * @param velX Velocidade do tiro no eixo dos XX
   * @param velY Velocidade do tiro no eixo dos YY
   */
  public void fire(Ponto ponto, long tempoActual, float velX, float velY) {
  	ponto.translate(getOffsetTiro().getX(), getOffsetTiro().getY());
	  setMovimento(new MovimentoLinear(velX, velY, ponto));
	  super.fire(ponto, tempoActual);
  }
	

/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão de uma Machine com um Tiro de Inimigo 
   * 
   * @param machine Nave ou Componente com o qual o tiro de inimigo colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Machine machine, long tempoActual) {
		machine.trataColisao(this, tempoActual);
  }

  /** Trata a colisão de um Tiro da Machine com um Tiro de Inimigo
   * 
	 * @param tiro Tiro da Machine com o qual o tiro de inimigo colidiu
	 * @param tempoActual Instante em que colidiu
	 */
	public void trataColisao(TiroMachine tiro, long tempoActual) {
		morrer(tempoActual);
		tiro.morrer(tempoActual);
  }

}
