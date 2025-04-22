package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os pr�mios que oferecem tiros a uma Nave ou a um Componente.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class PowerUp extends Premio {

  private TiroMachine tiro;
  

/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do pr�mio
	 * @param imagens TileSets do pr�mio
	 * @param posicao Posi��o na qual o pr�mio vai ser colocado
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio no jogo
	 * @param nivel Nivel ao qual o pr�mio pertence
	 * @param nomeAnimacao Nome da anima��o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
	 */
  public PowerUp(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////
	
  /**
   * @param novoTiro Tiro a atribuir ao pr�mio AddOn
   */
  public void setTiro(TiroMachine novoTiro) {
    tiro = novoTiro;
  }


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////

  /** Trata a colis�o de uma Machine com um PowerUp 
   * 
   * @param machine Nave ou Componente com o qual o pr�mio colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Machine machine, long tempoActual) {
    machine.setArma(tiro);
    morrer(tempoActual);
  }

}
