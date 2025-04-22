package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os prémios que oferecem componentes à Nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class AddOn extends Premio {

  private Componente componente;


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do prémio
	 * @param imagens TileSets do prémio AddOn
	 * @param posicao Posição na qual o prémio AddOn vai ser colocado
	 * @param asa Indica a asa (lado) na qual o componente vai ser colocado
	 * @param tempoActual Instante em que se inicia a animação e se coloca o prémio AddOn no jogo
	 * @param nivel Nivel ao qual o prémio AddOn pertence
	 * @param nomeAnimacao Nome da animação
	 * @param animacoes Sequência de animações a serem apresentadas
	 * @param tempos Duração de cada sequência de animação (por Tile)
	 * @param opcaoAni Indica se deve terminar a animação actual ou não
	 */
  public AddOn(String nome, TileSet imagens, Ponto posicao, int asa, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////
	
  /**
   * @return Devolve o componente que o prémio AddOn possui
   */
	public Componente getComponente() {
		return componente;
	}	

	/**
	 * @param componente Componente a atribuir ao prémio AddOn
	 */
	public void setComponente(Componente componente) {
		this.componente = componente;
	}


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /* (non-Javadoc)
   * @see xenon2k4.Premio#trataColisao(xenon2k4.Componente, long)
   */
  public void trataColisao(Componente componente, long tempoActual) {
  	trataColisao(componente.getNave(), tempoActual);
    morrer(tempoActual);
  }

  /* (non-Javadoc)
	 * @see xenon2k4.Premio#trataColisao(xenon2k4.Nave, long)
	 */
	public void trataColisao(Nave nave, long tempoActual) {
		if (nave.getComponentes().size() < 4 && !nave.existeComponente(componente.getComponentType(), componente.getLado())) {
			componente.setNave(nave);
			nave.getComponentes().add(componente);
			componente.getMovimento().iniciaMovimento(tempoActual, componente.sprite);
			nivel.mapa.addSprite(componente.sprite);
		}
		morrer(tempoActual);
  }

}
