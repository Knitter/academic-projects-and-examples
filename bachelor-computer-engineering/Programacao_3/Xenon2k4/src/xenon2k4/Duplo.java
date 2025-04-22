package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.MovimentoLinear;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Tiro Duplo da Machine.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Duplo extends TiroMachine {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
   * @param velocidade Velocidade que um tiro Duplo é disparado
	 * @param tempoDisparo Intervalo de tempo entre cada tiro Duplo disparado
   * @param capacidadeDestruicao Capacidade de destruição do tiro Duplo
   * @param imagens TileSets do tiro Duplo
   * @param nivel Nivel ao qual o tiro Duplo pertence
   */
  public Duplo(int velocidade, int tempoDisparo, int capacidadeDestruicao, TileSet imagens, Nivel nivel) {
    super(velocidade, tempoDisparo, capacidadeDestruicao, imagens, new int[][] {{},{3,4},{}}, new int[] {0, 50, 0}, nivel);
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Tiro#fire(jge2d.Ponto, long)
   */
  public void fire(Ponto ponto, long tempoActual) {
  	ponto.translate(getOffsetTiro().getX(), getOffsetTiro().getY());
		setMovimento(new MovimentoLinear(0, -getVelocidade(), ponto));
		super.fire(ponto, tempoActual);
  }

}
