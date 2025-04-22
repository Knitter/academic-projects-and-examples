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

public abstract class Indestrutivel extends InimigoNoFire {

  private static final int INDESTRUTIVEL = -1;
  private static final int SEM_PONTUACAO = 0;

  /*Construtores*/

  public Indestrutivel(String nome, TileSet imagens, Movimento movimento, int hitPoints, long tempoActual, Nivel nivel, String nomeAnimacao, int[][] animacoes, int[] tempos, boolean opcaoAni) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, INDESTRUTIVEL, SEM_PONTUACAO, tempoActual, nivel, nomeAnimacao, animacoes, tempos, opcaoAni);
  }

  /*metodos trataColisao*/

  public void trataColisao(TiroMachine tiro, long tempoActual) {
    tiro.morrer(tempoActual);
  }

	/*metodo morrer*/

  public void morrer(long tempoActual) {
  }

}
