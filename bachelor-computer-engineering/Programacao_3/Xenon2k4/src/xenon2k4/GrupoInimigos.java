package xenon2k4;

import java.util.LinkedList;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os grupos de inimigos do jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author S�rgio Lopes
 * @version 1.1
 */

public abstract class GrupoInimigos extends Inimigo {

  private Premio premio;
  private LinkedList elementos = new LinkedList();


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
   * @param premio Pr�mio que o grupo de inimigos d� ao morrer
   * @param nivel N�vel a que o grupo de inimigos pertence
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
	 * @return Devolve o pr�mio oferecido pelo grupo, caso exista
	 */
	public Premio getPremio() {
		return premio;
  }

  /**
	 * @param premio Pr�mio a atribuir ao grupo de inimigos
	 */
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	
	
/////////////////// M�todos Gerais /////////////////////////////////////////////

  /** Verifica se o grupo possui um pr�mio para oferecer
   * 
   * @return Devolve o pr�mio
   */
	public boolean temPremio() {
		if (premio != null)
		  return true;
		return false;
	  }

	
/////////////////// M�todo Morrer //////////////////////////////////////////////
	
  /** Destr�i o Grupo de Inimigos e coloca o pr�mio, caso exista 
   * 
   * @param tempoActual Instante em que o grupo morre
   * @param ponto Posi��o na qual o pr�mio vai ser colocado
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
