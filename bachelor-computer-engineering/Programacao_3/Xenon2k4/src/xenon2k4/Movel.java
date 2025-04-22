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
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class Movel extends Colidem {

  private Movimento movimento;


/////////////////// Constructors ///////////////////////////////////////////////

  public Movel() {
  }

  /** Construtor
   * 
	 * @param nome Nome do objecto m�vel
	 * @param imagens TileSets do objecto m�vel
	 * @param posicao Posi��o na qual o objecto m�vel vai ser colocado
	 * @param movimento Tipo de movimento a associar ao objecto m�vel
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o objecto m�vel no jogo
	 * @param nivel Nivel ao qual o objecto m�vel pertence
	 * @param nomeAnimacao Nome da anima��o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
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
	 * @param movimento Movimento a atribuir ao objecto m�vel
	 */
	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
  }


/////////////////// M�todos Gerais /////////////////////////////////////////////
	
  /** Procedimento a efectuar quando um movimento termina
   * 
   * @param tempoActual Instante em que o movimento terminou
   */
  public void movimentoAcabou(long tempoActual) {
    movimento.movimentarSprite(tempoActual, sprite);
  }


/////////////////// M�todo Morrer //////////////////////////////////////////////
	
  /** Morrer do objecto m�vel. Remove o objecto do jogo e cria uma explos�o adequada ao seu tamanho
   * 
   * @param tempoActual Instante em que o objecto morre
   * @param nomeAnimacao Nome do TileSet que cont�m as explos�es a apresentar
   */
  public void morrer(long tempoActual, String nomeAnimacao) {
    Explosao explode = new Explosao("BOOM!" + nivel.explosoes.size(), (TileSet)nivel.imagens.get(nomeAnimacao), sprite.getPosicao(tempoActual), tempoActual, nivel, "morrer", new int[][] {{},{},{1,2,3,4,5,6,7,8,9,10}}, new int[] {0, 0, 50}, false);
    nivel.explosoes.add(explode);
		super.morrer(tempoActual);
    nivel.mapa.removeSprite(sprite);
    nivel.mapa.addSprite(explode.sprite);
  }

}
