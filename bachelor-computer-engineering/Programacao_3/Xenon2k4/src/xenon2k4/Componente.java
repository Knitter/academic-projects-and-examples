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
 * @author Sérgio Lopes
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
	 * @param posicao Posição na qual o Componente vai ser colocado
	 * @param movimento Tipo de movimento a associar ao Componente
   * @param energia Quantidade de energia que o Componente contém
	 * @param hitPoints Capacidade de destruição do Componente
	 * @param lado Asa à qual o Componente vai ser adicionado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o Componente no jogo
	 * @param nivel Nivel ao qual o Componente pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
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
	 * @return Devolve a Nave à qual o componente encontra-se associado
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

  
/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Actualiza o movimento do componente
   * 
   * @param tempoActual Instante em que o movimento do componente é actualizado
   * @param destino Ponto de destino
   */
  public void movimentoAcabou(long tempoActual, Ponto destino) {
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão de um Premio com o Componente. Limita-se a atribuir o prémio à nave 
   * 
   * @param premio Premio com que o componente colidiu
   * @param tempoActual Instante em que colidiu
   */
  public void trataColisao(Premio premio, long tempoActual) {
		premio.trataColisao(nave, tempoActual);
  }


/////////////////// Método Morrer //////////////////////////////////////////////
	
  /* (non-Javadoc)
   * @see xenon2k4.Movel#morrer(long, java.lang.String)
   */
  public void morrer(long tempoActual, String nomeAnimacao) {		
		nave.getComponentes().remove(this);
		super.morrer(tempoActual, nomeAnimacao);
	}

}
