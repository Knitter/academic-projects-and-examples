package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Inimigo Carraça.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public class Carraca extends Armado {

	private int lado;
	

/////////////////// Constructors ///////////////////////////////////////////////
	
	/** Construtor
	 * 
   * @param nome Nome do Inimigo Carraça
   * @param imagens TileSets do Inimigo Carraça
   * @param movimento Tipo de movimento a associar ao Inimigo Carraça
   * @param hitPoints Capacidade de destruição do Inimigo Carraça
	 * @param energia Quantidade de energia que o Inimigo Carraça contém
   * @param tempoActual Instante em que se inicia a animação e se coloca o Inimigo Carraça no jogo
   * @param pontuacao Quantidade de pontos que o Inimigo Carraça oferece quando morre
	 * @param lado Lado em que o Inimigo Carraça anda
   * @param nivel Nivel ao qual o Inimigo Carraça pertence
   */
  public Carraca(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, int lado, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "cola", new int[][] {{},(lado == 0 ? new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14} : new int[] {15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28}),{}}, new int[] {0, 100, 0}, false);
    setTiro((Metal)nivel.cfgTiros.get("tiroMetal"));
		this.lado = lado;
  }
  

/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Dispara um tiro
   * 
   * @param tempoActual Instante que se dispara o tiro
   */
	public void dispara(long tempoActual) {
		int tempoRandom = getAleatorio().nextInt(3) * 300 + 200;
		if (getDiferencaDeTempo(tempoActual) > tempoRandom && sprite.getUltimaTile().equals(sprite.getAnimacaoActual().getTiles().getTile(12 + 14 * lado)))
			super.dispara(tempoActual, new Ponto(sprite.getPosicao(tempoActual)), sprite.getAnimacaoActual().getTiles().getWidth() * lado - getTiro().getAnimacaoTiro().getTiles().getWidth() / 2, sprite.getAnimacaoActual().getTiles().getHeight() / 2 - getTiro().getAnimacaoTiro().getTiles().getHeight() / 2, lado == 0 ? -getTiro().getVelocidade() : getTiro().getVelocidade(), 0);
	}
	

/////////////////// Método Morrer //////////////////////////////////////////////

  /** Remove o Inimigo Carraça do jogo e cria uma explosão adequada ao seu tamanho
   * 
   * @param tempoActual Instante em que o objecto morre
   */
  public void morrer(long tempoActual) {
    super.morrer(tempoActual, Explosao.GRANDE);
  }

}
