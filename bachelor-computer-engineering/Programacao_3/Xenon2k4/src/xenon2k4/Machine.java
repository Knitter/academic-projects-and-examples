package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa Naves e Componentes.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Machine extends Energetico {

  private Arma arma;
  private long tempoLastFire;


/////////////////// Constructors ///////////////////////////////////////////////

  public Machine() {
  }

  /** Construtor
   * 
	 * @param nome Nome da Machine
	 * @param imagens TileSets da Machine
	 * @param posicao Posição na qual a Machine vai ser colocada
	 * @param movimento Tipo de movimento a associar à Machine
   * @param energia Quantidade de energia que a Machine contém
	 * @param hitPoints Capacidade de destruição da Machine
	 * @param tempoActual Instante em que se inicia a animação e se coloca a Machine no jogo
	 * @param nivel Nivel ao qual a Machine pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
	public Machine(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int energia, int hitPoints, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, movimento, energia, hitPoints, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
    arma = new Arma(this);
		sprite.addScenarioColisionListener(this, "trataColisaoCenario");
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /** Atribui um novo tiro à arma da Machine
   * 
   * @param novoTiro Novo tiro para a arma
   */
	 public void setArma(TiroMachine novoTiro) {
	   arma.setTiro(novoTiro);
	 }

	
/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Dispara um tiro da arma da machine, garantindo um intervalo mínimo de tempo 
   * 
   * @param tempoActual Instante em que se dispara a arma
   */
  public void dispara(long tempoActual) {
    if (tempoActual - tempoLastFire > arma.getTiro().getTempoDisparo()) {
      arma.dispara(tempoActual);
      tempoLastFire = tempoActual;
    }
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão de um Inimigo com a uma Nave ou de um Componente
   * 
   * @param inimigo Inimigo com o qual a Machine colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Inimigo inimigo, long tempoActual) {
  	if(temEnergia()) {
      retirarEnergia(inimigo.getHitPoints());
      if (inimigo.temEnergia())
      	inimigo.retirarEnergia(getHitPoints());
      else
      	inimigo.morrer(tempoActual);
  	}	
    else
      morrer(tempoActual);
  }

  /** Trata a colisão de um Tiro de Inimigo com uma Machine
   * 
	 * @param tiro Tiro do inimigo com o qual a machine colidiu
	 * @param tempoActual Instante em que colidiu
	 */
  public void trataColisao(TiroInimigo tiro, long tempoActual) {
		if (temEnergia()) 
			retirarEnergia(tiro.getHitPoints());
		else
		  morrer(tempoActual);
		tiro.morrer(tempoActual);
  }


  /** Trata a colisão de um PowerUp com a Machine 
   * 
   * @param premio PowerUp com que a Nave ou Componente colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(PowerUp premio, long tempoActual) {
    premio.trataColisao(this, tempoActual);
  }

  /** Trata a colisão de uma Nave ou um Componente com o cenário
	 * 
   * @param tempoActual Instante em que colidiu
   */
	public void trataColisaoCenario(long tempoActual) {
    if(temEnergia())
			retirarEnergia(nivel.getHitPointsCenario());
    else
      morrer(tempoActual);
  }


/////////////////// Método Morrer //////////////////////////////////////////////
  
  /* (non-Javadoc)
   * @see xenon2k4.Movel#morrer(long, java.lang.String)
   */
  public void morrer(long tempoActual, String nomeAnimacao) {
    sprite.removeScenarioColisionListener(this, "trataColisaoCenario");
    super.morrer(tempoActual, nomeAnimacao);
  }
}
