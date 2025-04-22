package xenon2k4;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Inimigo Espinhoso.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public class Espinhoso extends Armado {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
   * @param nome Nome do Inimigo Espinhoso
   * @param imagens TileSets do Inimigo Espinhoso
   * @param movimento Tipo de movimento a associar ao Inimigo Espinhoso
   * @param hitPoints Capacidade de destruição do Inimigo Espinhoso
	 * @param energia Quantidade de energia que o Inimigo Espinhoso contém
   * @param tempoActual Instante em que se inicia a animação e se coloca o Inimigo Espinhoso no jogo
   * @param pontuacao Quantidade de pontos que o Inimigo Espinhoso oferece quando morre
   * @param nivel Nivel ao qual o Inimigo Espinhoso pertence
   */
  public Espinhoso(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "espeta", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},{}}, new int[] {0, 50, 0}, false);
    setTiro((Espinho)nivel.cfgTiros.get("tiroEspinho"));
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Calcula a velocidade em X e Y dada uma direcção
   * 
   * @param direction Direção cuja velocidade se pretende calcular 
   * @return Devolve a velocidade em X e Y
   */
	private int[] obterDireccao(int direction) {
		switch (direction) {
			case Espinho.NINE_OCLOCK:
				return new int[] {-1, 0};
			case Espinho.TEN_OCLOCK:
				return new int[] {-1, -1};
			case Espinho.TWELVE_OCLOCK:
				return new int[] {0, -1}; 
			case Espinho.TWO_OCLOCK: 
				return new int[] {1, -1}; 
			case Espinho.THREE_OCLOCK: 
				return new int[] {1, 0}; 
			case Espinho.FIVE_OCLOCK: 
				return new int[] {1, 1}; 
			case Espinho.SIX_OCLOCK: 
				return new int[] {0, 1}; 
			case Espinho.EIGHT_OCLOCK: 
				return new int[] {-1, 1};
			default:
				return new int[] {0, 0};
		}
	}


/////////////////// Método Morrer //////////////////////////////////////////////

  /** Remove o Inimigo Espinhoso do jogo, e cria uma explosão adequada ao seu tamanho e liberta 8 Tiros Espinhos à sua volta
   * 
   * @param tempoActual Instante em que o objecto morre
   */
  public void morrer(long tempoActual) {
		for (int i = Espinho.NINE_OCLOCK; i <= Espinho.EIGHT_OCLOCK; i++) {
			getTiro().setAnimacaoTiro(new AnimacaoSprite(getTiro().getAnimacaoTiro().getTiles(), new int[] {},
				new int[] {i}, new int[] {}, 0, 1000, 0));
			((TiroInimigo)getTiro().clone()).fire(new Ponto(sprite.getPosicao(tempoActual)), tempoActual, (float)(getTiro().getVelocidade()*(i%2 == 0 ? 0.75 : 1)*obterDireccao(i)[0]), (float)(getTiro().getVelocidade()*(i%2 == 0 ? 0.75 : 1)*obterDireccao(i)[1]));
		}
  	super.morrer(tempoActual, Explosao.GRANDE);
  }

}
