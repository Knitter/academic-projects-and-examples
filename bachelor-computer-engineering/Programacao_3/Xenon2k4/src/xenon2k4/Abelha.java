package xenon2k4;

import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> </p>
 * <p><b>Copyright:</b> ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public class Abelha extends InimigoNoFire {

	/*Construtores*/

  public Abelha(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "zzzzz", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24},{}}, new int[] {0, 100, 0}, false);
  }

	/*metodo morrer*/

  public void morrer(long tempoActual) {
    super.morrer(tempoActual, Explosao.MEDIA);
  }

}
