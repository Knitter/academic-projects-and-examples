package xenon2k4;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os objectos visiveis no jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Figura {

  protected Nivel nivel;
  protected Sprite sprite;


/////////////////// Constructors ///////////////////////////////////////////////

  public Figura() {
  }

  /** Construtor
   * 
	 * @param nome Nome da sprite
	 * @param imagens TileSets da figura
	 * @param posicao Posição na qual a figura vai ser colocada
	 * @param tempoActual Instante em que se inicia a animação e se coloca a figura no jogo
	 * @param nivel Nivel ao qual a figura pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
 	public Figura(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    this.nivel = nivel;
    sprite = new Sprite(nome, this);
    sprite.adicionarAnimacao(nomeAnimacao, new AnimacaoSprite(imagens, animacoes[0],animacoes[1], animacoes[2], tempos[0], tempos[1], tempos[2]));
    sprite.colocarEm(posicao, tempoActual);
    sprite.setAnimacao(nomeAnimacao, opcaoAni, tempoActual);
  }

}
