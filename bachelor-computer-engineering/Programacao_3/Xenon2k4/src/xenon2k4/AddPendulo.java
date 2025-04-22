package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Prémio que oferece um componente Pendulo à Nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class AddPendulo extends AddOn {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
	 * @param nome Nome do prémio Pendulo
	 * @param imagens TileSets do prémio Pendulo
	 * @param posicao Posição na qual o prémio Pendulo vai ser colocado
	 * @param lado Indica o lado no qual o componente Pendulo vai ser colocado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o prémio Pendulo no jogo
	 * @param nivel Nivel ao qual o prémio Pendulo pertence
	 */
	public AddPendulo(String nome, TileSet imagens, Ponto posicao, int lado, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, lado, tempoActual, nivel, "componente pendulo", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},{}}, new int[] {0, 50, 0}, false);
		setComponente(new Pendulo("Pendulo" + nome, imagens, posicao, lado, tempoActual, nivel));
  }

}
