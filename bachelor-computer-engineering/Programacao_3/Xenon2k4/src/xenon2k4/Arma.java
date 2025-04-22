package xenon2k4;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Arma para ser usada por uma Nave ou por Componentes. Possui um tiro do tipo machine configurável</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Arma {

  private TiroMachine tiro;
  private Machine machine;
  private Ponto offset;
  

/////////////////// Constructors ///////////////////////////////////////////////
  
  /** Construtor
   * 
   * @param machine Nave ou componente detentor da Arma
   */
  public Arma(Machine machine) {
    this.machine = machine;
  }


/////////////////// Getters & Setters //////////////////////////////////////////
	
  /**
   * @return Devolve o Tiro actual da arma
   */
	public TiroMachine getTiro() {
	  return tiro;
	}
	
  /**
	 * @param novoTiro Novo tiro que a Arma vai passar a ter
	 */
	public void setTiro(TiroMachine novoTiro) {
    tiro = novoTiro;
		offset = new Ponto(machine.sprite.getWidth() / 2 - tiro.getAnimacaoTiro().getTiles().getWidth() / 2, -tiro.getAnimacaoTiro().getTiles().getHeight());
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Dispara o tiro actual 
   * 
   * @param tempoActual Instante em que o tiro é disparado
   */
  public void dispara(long tempoActual) {
		tiro.setOffsetTiro(offset.getX(), offset.getY());
    ((TiroMachine) tiro.clone()).fire(new Ponto(machine.sprite.getPosicao(tempoActual)), tempoActual);
  }

}
