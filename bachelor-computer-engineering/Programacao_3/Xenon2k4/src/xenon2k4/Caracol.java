package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Inimigo Caracol.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public class Caracol extends Armado {


/////////////////// Constructors ///////////////////////////////////////////////
	
  /** Construtor
   * 
	 * @param nome Nome do Inimigo Caracol
	 * @param imagens TileSets do Inimigo Caracol
	 * @param movimento Tipo de movimento a associar ao Inimigo Caracol
   * @param energia Quantidade de energia que o Inimigo Caracol contém
	 * @param hitPoints Capacidade de destruição do Inimigo Caracol
	 * @param tempoActual Instante em que se inicia a animação e se coloca o Inimigo Caracol no jogo
	 * @param pontuacao Quantidade de pontos que o Inimigo Caracol oferece quando morre
	 * @param nivel Nivel ao qual o Inimigo Caracol pertence
	 */
  public Caracol(String nome, TileSet imagens, Movimento movimento, int energia, int hitPoints, long tempoActual, int pontuacao, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "rasteja", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},{}}, new int[] {0, 100, 0}, false);
    setTiro((Metal)nivel.cfgTiros.get("tiroMetal"));
  }

  /** Dispara um tiro
   * 
   * @param tempoActual Instante que se dispara o tiro
   */
  public void dispara(long tempoActual) {
  	int tempoRandom = getAleatorio().nextInt(3) * 1000 + 1000;
		if (getDiferencaDeTempo(tempoActual) > tempoRandom)
			super.dispara(tempoActual, new Ponto(sprite.getPosicao(tempoActual)), sprite.getAnimacaoActual().getTiles().getWidth() / 2 - getTiro().getAnimacaoTiro().getTiles().getWidth() / 2, sprite.getAnimacaoActual().getTiles().getHeight() / 2 - getTiro().getAnimacaoTiro().getTiles().getHeight() / 2, (float)(nivel.getNave().sprite.getPosicao(tempoActual).getX() - sprite.getPosicao(tempoActual).getX()), (float)(nivel.getNave().sprite.getPosicao(tempoActual).getY() - sprite.getPosicao(tempoActual).getY()));
	}


/////////////////// Método Morrer //////////////////////////////////////////////

	/** Remove o Inimigo Caracol do jogo e cria uma explosão adequada ao seu tamanho
	 * 
	 * @param tempoActual Instante em que o objecto morre
	 */
  public void morrer(long tempoActual) {
    super.morrer(tempoActual, Explosao.GRANDE);
  }

}
