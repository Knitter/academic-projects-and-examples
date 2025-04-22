package xenon2k4;

import java.awt.Color;
import java.awt.Font;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os inimigos do jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class Inimigo extends Energetico {

  private int pontos;


/////////////////// Constructors ///////////////////////////////////////////////

  public Inimigo() {
  }

  /** Construtor
   * 
	 * @param nome Nome do Inimigo
	 * @param imagens TileSets do Inimigo
	 * @param posicao Posi��o na qual o Inimigo vai ser colocado
	 * @param movimento Tipo de movimento a associar ao Inimigo
	 * @param hitPoints Capacidade de destrui��o do Inimigo
   * @param energia Quantidade de energia que o Inimigo cont�m
	 * @param pontuacao Quantidade de pontos que o Inimigo oferece quando morre
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o Inimigo no jogo
	 * @param nivel Nivel ao qual o Inimigo pertence
	 * @param nomeAnimacao Nome da anima��o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
	 */
	public Inimigo(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int hitPoints, int energia, int pontuacao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, movimento, energia, hitPoints, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
    pontos = pontuacao;
  }


/////////////////// Getters & Setters //////////////////////////////////////////
	
  /**
   * @return Devolve a quantidade de pontos que o Inimigo oferece quando morre
   */
	public int getPontos() {
	  return pontos;
	}


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////

  /** Trata a colis�o de uma Machine com o Inimigo
	 * 
	 * @param machine Machine com o qual o Inimigo colidiu
	 * @param tempoActual Instante em que colidiu
	 */
	public void trataColisao(Machine machine, long tempoActual){
  	machine.trataColisao(this, tempoActual);
  }

  /** Trata a colis�o de um Tiro da Machine com um Inimigo
   * 
	 * @param tiro Tiro da machine com o qual o inimigo colidiu
	 * @param tempoActual Instante em que colidiu
	 */
  public void trataColisao(TiroMachine tiro, long tempoActual) {
    if (temEnergia())
      retirarEnergia(tiro.getHitPoints());
    else
      morrer(tempoActual);
    tiro.morrer(tempoActual);
  }


/////////////////// M�todo Morrer //////////////////////////////////////////////
  
  /* (non-Javadoc)
   * @see xenon2k4.Movel#morrer(long, java.lang.String)
   */
  public void morrer(long tempoActual, String nomeAnimacao) {
    nivel.pontos.add(new TextoPontos("Pontos" + sprite.getNome(), sprite.getPosicao(tempoActual), new Integer(pontos).toString(), "Times New Roman", Font.PLAIN, 12, Color.WHITE, tempoActual, nivel));
  	nivel.getNave().addPontuacao(pontos);
    super.morrer(tempoActual, nomeAnimacao);
  }

}
