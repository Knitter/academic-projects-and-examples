package xenon2k4;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os tiros do jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Tiro extends Destruidor implements Cloneable {

  private float velocidade;
  private Ponto offsetTiro;
  private AnimacaoSprite animacaoTiro;
  

/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param velocidade Velocidade que um tiro é disparado
	 * @param capacidadeDestruicao Capacidade de destruição do tiro
	 * @param imagens TileSets do tiro
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param nivel Nivel ao qual o tiro pertence
	 */
  public Tiro(int velocidade, int capacidadeDestruicao, TileSet imagens, int[][] animacoes, int[] tempos, Nivel nivel) {
		setHitPoints(capacidadeDestruicao);
		this.velocidade = velocidade;
		animacaoTiro = new AnimacaoSprite(imagens, animacoes[0], animacoes[1], animacoes[2], tempos[0], tempos[1], tempos[2]);
		this.nivel = nivel;
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve a velocidade do tiro
   */
	public float getVelocidade() {
	   return velocidade;
	 }

	 /**
	 * @return Devolve o offset do tiro
	 */
	public Ponto getOffsetTiro() {
	   return offsetTiro;
	 }

	 /**
	 * @param offsetX Offset do tiro em X
	 * @param offsetY Offset do tiro em Y
	 */
	public void setOffsetTiro(double offsetX, double offsetY) {
	   offsetTiro  = new Ponto(offsetX, offsetY);
	 }

	/**
	 * @return Devolve a animação actual do tiro
	 */
	public AnimacaoSprite getAnimacaoTiro() {
		return animacaoTiro;
	}
  
	/**
	 * @param animacao Animação a atribuir ao tiro 
	 */
	public void setAnimacaoTiro(AnimacaoSprite animacao) {
		animacaoTiro = animacao;
	}
	

/////////////////// Métodos Gerais /////////////////////////////////////////////
	
  /** Gera um novo tiro
   * 
   * @param ponto Posição onde o tiro é gerado
   * @param tempoActual Instante em que o tiro é gerado
   */
	public void fire(Ponto ponto, long tempoActual) {
		sprite = new Sprite("tiro" + nivel.tiros.size(), this);
		sprite.adicionarAnimacao("fire", animacaoTiro);
		sprite.setAnimacao("fire", false, tempoActual);
		sprite.addSpriteColisionListener(this, "trataColisao");
		sprite.addSpriteMovementListener(this, "movimentoAcabou");
		sprite.addScenarioColisionListener(this, "trataColisaoCenario");
		nivel.mapa.addSprite(sprite);
		getMovimento().iniciaMovimento(tempoActual, sprite);
		nivel.tiros.add(this);
	}
	
	/** Clona um tiro para se gerar um novo tiro */
	public Object clone() {
  	Tiro obj = null;
  	try {
			obj = (Tiro) super.clone();
  	}
  	catch (CloneNotSupportedException e) {
			System.out.println("Clonagem abortada!");
 		}
  	return obj;
	}


/////////////////// Método Morrer //////////////////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Colidem#morrer(long)
   */
  public void morrer(long tempoActual) {
    super.morrer(tempoActual, Explosao.PEQUENA);
    nivel.tiros.remove(this);
  }

}
