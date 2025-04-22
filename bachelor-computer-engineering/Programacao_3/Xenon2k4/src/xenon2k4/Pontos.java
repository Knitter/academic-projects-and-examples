package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Aumenta a pontua��o de um jogador.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class Pontos extends Premio {

  private int pontos;
  

/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do pr�mio Pontos
	 * @param imagens TileSets do pr�mio Pontos
	 * @param posicao Posi��o na qual o pr�mio Pontos vai ser colocado
   * @param pontos Quantidade de pontos a oferecer ao jogador
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio Pontos no jogo
	 * @param nivel Nivel ao qual o pr�mio Pontos pertence
	 */
  public Pontos(String nome, TileSet imagens, Ponto posicao, int pontos, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "pontos", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
    this.pontos = pontos;
  }


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Premio#trataColisao(xenon2k4.Componente, long)
   */
  public void trataColisao(Componente componete, long tempoActual) {
		componete.getNave().addPontuacao(pontos);
		morrer(tempoActual);
  }

	/* (non-Javadoc)
	 * @see xenon2k4.Premio#trataColisao(xenon2k4.Nave, long)
	 */
	public void trataColisao(Nave nave, long tempoActual) {
    nave.addPontuacao(pontos);
    morrer(tempoActual);
  }

}
