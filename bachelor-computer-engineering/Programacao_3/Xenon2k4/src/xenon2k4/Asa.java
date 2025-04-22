package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.MovimentoRelativo;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Componente Asa</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Asa extends Componente {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
   * @param nome Nome do Componente Asa
   * @param imagens TileSets do Componente Asa
   * @param lado Asa à qual o Componente Asa vai ser adicionado
   * @param tempoActual Instante em que se inicia a animação e se coloca o Componente Asa no jogo
   * @param nivel Nivel ao qual o Componente Asa pertence
   */
	public Asa(String nome, TileSet imagens, int lado, long tempoActual, Nivel nivel) {
		super(nome, imagens, new Ponto(), new MovimentoRelativo(nivel.getNave().sprite.getPosicao(tempoActual), new Ponto(-32 + (lado * (64 + imagens.getWidth())), 0)), 500, 200, lado, tempoActual, nivel, "componete asa", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12},{}}, new int[] {0, 50, 0}, false);
		setComponentType(Componente.ASA);	
	}


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Componente#movimentoAcabou(long, jge2d.Ponto)
   */
	public void movimentoAcabou(long tempoActual, Ponto destino) {
	  ((MovimentoRelativo)getMovimento()).updatePosicao(getNave().sprite.getPosicao(tempoActual), getNave().sprite.getPosicao(tempoActual), tempoActual, 0, sprite);
	}


/////////////////// Método Morrer //////////////////////////////////////////////

  /** Remove o Componente Asa do jogo e cria uma explosão adequada ao seu tamanho
   * 
   * @param tempoActual Instante em que o Componente Asa morre
   */
	public void morrer(long tempoActual) {
		super.morrer(tempoActual, Explosao.PEQUENA);
	}

}
