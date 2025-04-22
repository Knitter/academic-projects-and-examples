package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os prémios que oferecem tiros a uma Nave ou a um Componente.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class PowerUp extends Premio {

  private TiroMachine tiro;
  

/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do prémio
	 * @param imagens TileSets do prémio
	 * @param posicao Posição na qual o prémio vai ser colocado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o prémio no jogo
	 * @param nivel Nivel ao qual o prémio pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
  public PowerUp(String nome, TileSet imagens, Ponto posicao, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////
	
  /**
   * @param novoTiro Tiro a atribuir ao prémio AddOn
   */
  public void setTiro(TiroMachine novoTiro) {
    tiro = novoTiro;
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão de uma Machine com um PowerUp 
   * 
   * @param machine Nave ou Componente com o qual o prémio colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Machine machine, long tempoActual) {
    machine.setArma(tiro);
    morrer(tempoActual);
  }

}
