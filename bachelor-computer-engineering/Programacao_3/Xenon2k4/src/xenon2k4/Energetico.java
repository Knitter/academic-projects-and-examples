package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os objectos que possuem uma energia.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class Energetico extends Destruidor {

	private int  energia;


/////////////////// Constructors ///////////////////////////////////////////////

	public Energetico() {
	}

	/** Construtor
	 * 
   * @param nome Nome do objecto energético
   * @param imagens TileSets do objecto energético
   * @param posicao Posição na qual o objecto energético vai ser colocado
   * @param movimento Tipo de movimento a associar ao objecto energético
	 * @param energia Quantidade de energia que o objecto energético contém
   * @param hitPoints Capacidade de destruição do objecto energético
   * @param tempoActual Instante em que se inicia a animação e se coloca o objecto energético no jogo
   * @param nivel Nivel ao qual o objecto energético pertence
   * @param nomeAnimacao Nome da animação
   * @param animacoes Sequência de animações a serem apresentadas
   * @param tempos Duração de cada sequência de animação (por Tile)
   * @param opcaoAni Indica se deve terminar a animação actual ou não
   */
	public Energetico(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int energia, int hitPoints, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
		super(nome, imagens, posicao, movimento, hitPoints, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
		this.energia = energia;
	}
	

/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve a quantidade de energia que o objecto energético contém
   */
	public int getEnergia() {
	  return energia;
 	}

 	/**
	 * @param energia Quantidade de energia a atribuir ao objecto energético
	 */
	public void setEnergia(int energia) {
  	this.energia = energia;
 	}


/////////////////// Métodos Gerais /////////////////////////////////////////////
 
  /** Retira uma certa quantidade de energia ao objecto energético
   * 
   * @param quantidade Quantidade de energia a retiriar
   */
 	public void retirarEnergia(int quantidade){
 		energia -= quantidade;
 	}
 
 	/** Verifica se o objecto energético ainda contém energia
 	 * 
	 * @return Verdadeiro se tiver energia, falso caso contrário
	 */
	public boolean temEnergia(){
 		return energia > 0; 
 	}

}
