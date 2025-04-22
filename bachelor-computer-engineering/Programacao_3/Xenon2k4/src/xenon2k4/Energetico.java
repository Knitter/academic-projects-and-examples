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
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class Energetico extends Destruidor {

	private int  energia;


/////////////////// Constructors ///////////////////////////////////////////////

	public Energetico() {
	}

	/** Construtor
	 * 
   * @param nome Nome do objecto energ�tico
   * @param imagens TileSets do objecto energ�tico
   * @param posicao Posi��o na qual o objecto energ�tico vai ser colocado
   * @param movimento Tipo de movimento a associar ao objecto energ�tico
	 * @param energia Quantidade de energia que o objecto energ�tico cont�m
   * @param hitPoints Capacidade de destrui��o do objecto energ�tico
   * @param tempoActual Instante em que se inicia a anima��o e se coloca o objecto energ�tico no jogo
   * @param nivel Nivel ao qual o objecto energ�tico pertence
   * @param nomeAnimacao Nome da anima��o
   * @param animacoes Sequ�ncia de anima��es a serem apresentadas
   * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
   * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
   */
	public Energetico(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int energia, int hitPoints, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
		super(nome, imagens, posicao, movimento, hitPoints, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
		this.energia = energia;
	}
	

/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve a quantidade de energia que o objecto energ�tico cont�m
   */
	public int getEnergia() {
	  return energia;
 	}

 	/**
	 * @param energia Quantidade de energia a atribuir ao objecto energ�tico
	 */
	public void setEnergia(int energia) {
  	this.energia = energia;
 	}


/////////////////// M�todos Gerais /////////////////////////////////////////////
 
  /** Retira uma certa quantidade de energia ao objecto energ�tico
   * 
   * @param quantidade Quantidade de energia a retiriar
   */
 	public void retirarEnergia(int quantidade){
 		energia -= quantidade;
 	}
 
 	/** Verifica se o objecto energ�tico ainda cont�m energia
 	 * 
	 * @return Verdadeiro se tiver energia, falso caso contr�rio
	 */
	public boolean temEnergia(){
 		return energia > 0; 
 	}

}
