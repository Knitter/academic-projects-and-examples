package xenon2k4;

import java.util.LinkedList;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os grupos de inimigos do jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class GrupoInimigos extends Inimigo {

  private Premio premio;
  private LinkedList elementos = new LinkedList();


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
   * @param premio Prémio que o grupo de inimigos dá ao morrer
   * @param nivel Nível a que o grupo de inimigos pertence
   */
	public GrupoInimigos(Premio premio, Nivel nivel) {
		setPremio(premio);
		this.nivel = nivel;
	}


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve os elementos do grupo
   */
  public LinkedList getElementos() {
    return elementos;
  }

  /**
	 * @return Devolve o prémio oferecido pelo grupo, caso exista
	 */
	public Premio getPremio() {
		return premio;
  }

  /**
	 * @param premio Prémio a atribuir ao grupo de inimigos
	 */
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	
	
/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Verifica se o grupo possui um prémio para oferecer
   * 
   * @return Devolve o prémio
   */
	public boolean temPremio() {
		if (premio != null)
		  return true;
		return false;
	  }

	
/////////////////// Método Morrer //////////////////////////////////////////////
	
  /** Destrói o Grupo de Inimigos e coloca o prémio, caso exista 
   * 
   * @param tempoActual Instante em que o grupo morre
   * @param ponto Posição na qual o prémio vai ser colocado
   */
	public void morrer(long tempoActual, Ponto ponto) {
	  if (temPremio()) {
	  	nivel.premios.add(premio);
	  	premio.sprite.colocarEm(ponto, tempoActual);
			nivel.mapa.addSprite(getPremio().sprite);
	  }
	  nivel.gruposInimigos.remove(this);
	}

}
