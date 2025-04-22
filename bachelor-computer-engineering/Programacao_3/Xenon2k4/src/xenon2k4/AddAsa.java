package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Pr�mio que oferece um componente Asa � Nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public final class AddAsa extends AddOn {


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
   * @param nome Nome do pr�mio Asa
   * @param imagens TileSets do pr�mio Asa
   * @param posicao Posi��o na qual o pr�mio Asa vai ser colocado
   * @param lado Indica o lado no qual o componente Asa vai ser colocado
   * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio Asa no jogo
   * @param nivel Nivel ao qual o pr�mio Asa pertence
   */
  public AddAsa(String nome, TileSet imagens, Ponto posicao, int lado, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, lado, tempoActual, nivel, "componete asa", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12},{}}, new int[] {0, 50, 0}, false);
		setComponente(new Asa("Asa" + nome, imagens, lado, tempoActual, nivel));
  }

}
