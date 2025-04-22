package xenon2k4;

import jge2d.Ponto;
import jge2d.TileSet;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Classe abstracta que representa todos os pr�mios que oferecem componentes � Nave.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class AddOn extends Premio {

  private Componente componente;


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome do pr�mio
	 * @param imagens TileSets do pr�mio AddOn
	 * @param posicao Posi��o na qual o pr�mio AddOn vai ser colocado
	 * @param asa Indica a asa (lado) na qual o componente vai ser colocado
	 * @param tempoActual Instante em que se inicia a anima��o e se coloca o pr�mio AddOn no jogo
	 * @param nivel Nivel ao qual o pr�mio AddOn pertence
	 * @param nomeAnimacao Nome da anima��o
	 * @param animacoes Sequ�ncia de anima��es a serem apresentadas
	 * @param tempos Dura��o de cada sequ�ncia de anima��o (por Tile)
	 * @param opcaoAni Indica se deve terminar a anima��o actual ou n�o
	 */
  public AddOn(String nome, TileSet imagens, Ponto posicao, int asa, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, posicao, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }


/////////////////// Getters & Setters //////////////////////////////////////////
	
  /**
   * @return Devolve o componente que o pr�mio AddOn possui
   */
	public Componente getComponente() {
		return componente;
	}	

	/**
	 * @param componente Componente a atribuir ao pr�mio AddOn
	 */
	public void setComponente(Componente componente) {
		this.componente = componente;
	}


/////////////////// M�todos de Trata Colis�o ///////////////////////////////////

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
