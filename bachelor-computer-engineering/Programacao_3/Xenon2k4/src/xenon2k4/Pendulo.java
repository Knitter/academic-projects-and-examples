package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.MovimentoPendular;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Componente Pendulo</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Pendulo extends Componente {
	

/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do Componente Pendulo
	 * @param imagens TileSets do Componente Pendulo
	 * @param lado Asa à qual o Componente Pendulo vai ser adicionado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o Componente Pendulo no jogo
	 * @param nivel Nivel ao qual o Componente Pendulo pertence
	 */
	public Pendulo(String nome, TileSet imagens, Ponto posicao, int lado, long tempoActual, Nivel nivel) {
		super(nome, imagens, new Ponto(), new MovimentoPendular(25, 135 + (180 * lado), 225 + (180 * lado), 135 - (90 * lado), 96, new Ponto(nivel.getNave().sprite.getWidth() / 2 - imagens.getWidth() * lado, imagens.getHeight() / 2), nivel.getNave().sprite.getPosicao(tempoActual), 75), 500, 200, lado, tempoActual, nivel, "componete pendulo", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12},{}}, new int[] {0, 50, 0}, false);
		setComponentType(Componente.PENDULO);	
	}


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Componente#movimentoAcabou(long, jge2d.Ponto)
   */
	public void movimentoAcabou(long tempoActual, Ponto destino) {
	  ((MovimentoPendular)getMovimento()).updatePosicao(getNave().sprite.getPosicao(tempoActual), destino, tempoActual, 1000, sprite);
	}


/////////////////// Método Morrer //////////////////////////////////////////////

	/** Remove o Componente Pendulo do jogo e cria uma explosão adequada ao seu tamanho
	 * 
	 * @param tempoActual Instante em que o Componente Pendulo morre
	 */
	public void morrer(long tempoActual) {
		super.morrer(tempoActual, Explosao.PEQUENA);
	}

}
