package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os objectos que se movem no jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Movel extends Colidem {

  private Movimento movimento;


/////////////////// Constructors ///////////////////////////////////////////////

  public Movel() {
  }

  /** Construtor
   * 
	 * @param nome Nome do objecto móvel
	 * @param imagens TileSets do objecto móvel
	 * @param posicao Posição na qual o objecto móvel vai ser colocado
	 * @param movimento Tipo de movimento a associar ao objecto móvel
	 * @param tempoActual Instante em que se inicia a animação e se coloca o objecto móvel no jogo
	 * @param nivel Nivel ao qual o objecto móvel pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
	public Movel(String nome, TileSet imagens, Ponto posicao, Movimento movimento, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
    sprite.addSpriteMovementListener(this, "movimentoAcabou");
    this.movimento = movimento;
  }
  

/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve o Movimento que um objecto possui
   */
  public Movimento getMovimento() {
		return movimento;
  }

  /**
	 * @param movimento Movimento a atribuir ao objecto móvel
	 */
	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////
	
  /** Procedimento a efectuar quando um movimento termina
   * 
   * @param tempoActual Instante em que o movimento terminou
   */
  public void movimentoAcabou(long tempoActual) {
    movimento.movimentarSprite(tempoActual, sprite);
  }


/////////////////// Método Morrer //////////////////////////////////////////////
	
  /** Morrer do objecto móvel. Remove o objecto do jogo e cria uma explosão adequada ao seu tamanho
   * 
   * @param tempoActual Instante em que o objecto morre
   * @param nomeAnimacao Nome do TileSet que contém as explosões a apresentar
   */
  public void morrer(long tempoActual, String nomeAnimacao) {
    Explosao explode = new Explosao("BOOM!" + nivel.explosoes.size(), (TileSet)nivel.imagens.get(nomeAnimacao), sprite.getPosicao(tempoActual), tempoActual, nivel, "morrer", new int[][] {{},{},{1,2,3,4,5,6,7,8,9,10}}, new int[] {0, 0, 50}, false);
    nivel.explosoes.add(explode);
		super.morrer(tempoActual);
    nivel.mapa.removeSprite(sprite);
    nivel.mapa.addSprite(explode.sprite);
  }

}
