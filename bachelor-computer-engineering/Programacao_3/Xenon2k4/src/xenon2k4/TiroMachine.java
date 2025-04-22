package xenon2k4;

import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os tiros de uma Machine.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class TiroMachine extends Tiro {

  private int tempoDisparo;


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
   * @param velocidade Velocidade que um tiro é disparado
	 * @param tempoDisparo Intervalo de tempo entre cada tiro disparado
   * @param hitPoints Capacidade de destruição do tiro
   * @param imagens TileSets do tiro
   * @param animacoes Sequência de animações a serem apresentadas
   * @param tempos Duração de cada sequência de animação (por Tile)
   * @param nivel Nivel ao qual o tiro pertence
   */
  public TiroMachine(int velocidade, int tempoDisparo, int hitPoints, TileSet imagens, int[][] animacoes, int[] tempos, Nivel nivel) {
		super(velocidade, hitPoints, imagens, animacoes, tempos, nivel);
    this.tempoDisparo = tempoDisparo;
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve o intervalo de tempo de disparo característico do tiro 
   */
  public int getTempoDisparo() {
    return tempoDisparo;
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão de um Inimiogo com um Tiro da Nave ou de um Componente
   * 
   * @param inimigo Inimigo com o qual o tiro da machine colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Inimigo inimigo, long tempoActual) {
    inimigo.trataColisao(this, tempoActual);
  }

  /** Trata a colisão de um Tiro de Inimigo com um Tiro da Machine
   * 
	 * @param tiro Tiro da Machine com o qual o tiro de inimigo colidiu
	 * @param tempoActual Instante em que colidiu
	 */
	public void trataColisao(TiroInimigo tiro, long tempoActual){
		morrer(tempoActual);
		tiro.morrer(tempoActual);
  }

  /** Trata a colisão dos tiros da machine com o cenário
   * 
	 * @param tempoActual Instante em que colidiu
	 */
	public void trataColisaoCenario(long tempoActual) {
    morrer(tempoActual);
  }

}
