package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa os Componentes da Nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class Componente extends Machine {

  private Nave nave;
  private int lado;
	private int componentType;
	public static final int ASA = 1;
	public static final int PENDULO = 2;
	
	
/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do Componente
	 * @param imagens TileSets do Componente
	 * @param posicao Posi��o na qual o Componente vai ser colocado
	 * @param movimento Tipo de movimento a associar ao Componente
   * @param energia Quantidade de energia que o Componente cont�m
	 * @param hitPoints Capacidade de destrui��o do Componente
	 * @param lado Asa � qual o Componente vai ser adicionado
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o Componente no jogo
	 * @param nivel Nivel ao qual o Componente pertence
	 * @param nomeAnimacao Nome da anima��o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
	 */
  public Componente(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int energia, int hitPoints, int lado, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
		super(nome, imagens, posicao, movimento, energia, hitPoints, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
		this.lado = lado;
		setArma((Simples)nivel.cfgTiros.get("tiroSimples"));
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve o tipo de componente
   */
	public int getComponentType() {
		return componentType;
	}
  
	/**
	 * @param type Classifica o componente com um tipo
	 */
	public void setComponentType(int type) {
		componentType = type;
	}  

	/**
	 * @return Devolve a Nave � qual o componente encontra-se associado
	 */
	public Nave getNave() {
	  return nave;
	}
  
  /**
	 * @param nave Associa o componente a uma nave
	 */
	public void setNave(Nave nave) {
  	this.nave = nave;
  }

  /**
	 * @return Devolve o lado da nave a que pertence o componente
	 */
	public int getLado() {
		return lado;
  }

  /**
	 * @param lado Associa o componente a um lado da nave
	 */
	public void setLado(int lado) {
  	this.lado = lado;
  }

  
/////////////////// M�todos Gerais /////////////////////////////////////////////

  /** Actualiza o movimento do componente
   * 
   * @param tempoActual Instante em que o movimento do componente � actualizado
   * @param destino Ponto de destino
   */
  public void movimentoAcabou(long tempoActual, Ponto destino) {
  }


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////

  /** Trata a colis�o de um Premio com o Componente. Limita-se a atribuir o pr�mio � nave 
   * 
   * @param premio Premio com que o componente colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Premio premio, long tempoActual) {
		premio.trataColisao(nave, tempoActual);
  }


/////////////////// M�todo Morrer //////////////////////////////////////////////
	
  /* (non-Javadoc)
   * @see xenon2k4.Movel#morrer(long, java.lang.String)
   */
  public void morrer(long tempoActual, String nomeAnimacao) {		
		nave.getComponentes().remove(this);
		super.morrer(tempoActual, nomeAnimacao);
	}

}
