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

public class Bola extends InimigoNoFire {

	/*Construtores*/

  public Bola(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "rebola", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},{}}, new int[] {0, 100, 0}, false);
  }

	/*metodo morrer*/

  public void morrer(long tempoActual) {
    super.morrer(tempoActual, Explosao.MEDIA);
  }

}
