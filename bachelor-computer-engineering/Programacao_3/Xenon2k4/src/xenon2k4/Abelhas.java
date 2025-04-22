package xenon2k4;

import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public final class Abelhas extends Abelha {

	private GrupoAbelhas grupo;

	/*Construtores*/

  public Abelhas(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, GrupoAbelhas grupo, Nivel nivel) {
		super(nome, imagens, movimento, hitPoints, energia, tempoActual, pontuacao, nivel);
		this.grupo = grupo;
  }

	/*metodo morrer*/

  public void morrer(long tempoActual) {
		grupo.getElementos().remove(this);
		if(grupo.getElementos().isEmpty()) 
		  grupo.morrer(tempoActual, sprite.getPosicao(tempoActual));
		super.morrer(tempoActual);
  }

}

