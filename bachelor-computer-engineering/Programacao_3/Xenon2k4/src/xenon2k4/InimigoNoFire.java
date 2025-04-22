package xenon2k4;

import jge2d.Ponto;
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

public abstract class InimigoNoFire extends Inimigo {

	/*Construtores*/

	public InimigoNoFire(String nome, TileSet imagens, Ponto posicao, Movimento movimento, int hitPoints, int energia, int pontuacao,	long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
		super(nome, imagens, posicao, movimento, hitPoints, energia, pontuacao,	tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
	}
	
	/*metodo morrer*/
	
	public void morrer(long tempoActual, String nomeAnimacao) {
		super.morrer(tempoActual, nomeAnimacao);
		nivel.inimigos.remove(this);
	}

}
