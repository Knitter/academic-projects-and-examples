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

public class IndestrutivelGrande extends Indestrutivel {

	/*Construtores*/

  public IndestrutivelGrande(String nome, TileSet imagens, Movimento movimento, int hitPoints, long tempoActual, Nivel nivel) {
    super(nome, imagens, movimento, hitPoints, tempoActual, nivel, "MegaSuperRock", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25},{}}, new int[] {0, 100, 0}, false);
  }

}
