package xenon2k4;

import java.awt.Color;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Restabelece toda a energia da nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Energia extends Premio {


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do prémio Energia
	 * @param imagens TileSets do prémio Energia
	 * @param posicao Posição na qual o prémio Energia vai ser colocado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o prémio Energia no jogo
	 * @param nivel Nivel ao qual o prémio Energia pertence
	 */
  public Energia(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel) {
    super(nome, imagens, posicao, tempoActual, nivel, "redbull", new int[][] {{},{1,2,3,4,5,6,7,8},{}}, new int[] {0, 50, 0}, false);
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Premio#trataColisao(xenon2k4.Componente, long)
   */
  public void trataColisao(Componente componete, long tempoActual) {
    componete.getNave().setEnergia(componete.getNave().getEnergiaInicial());
    morrer(tempoActual);
  }

  /* (non-Javadoc)
	 * @see xenon2k4.Premio#trataColisao(xenon2k4.Nave, long)
	 */
	public void trataColisao(Nave nave, long tempoActual) {
    nave.setEnergia(nave.getEnergiaInicial());
		nave.getEnergyBar().actualizarEnergyBar(nave.getEnergiaInicial(),nave.getEnergiaInicial(), new Color[] {Color.GREEN, Color.YELLOW, Color.RED});
    morrer(tempoActual);
  }

}
