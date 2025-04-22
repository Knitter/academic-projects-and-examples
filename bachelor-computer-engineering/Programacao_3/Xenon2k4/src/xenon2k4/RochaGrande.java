package xenon2k4;

import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;
import jge2d.jogo.movimentos.MovimentoLinear;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RochaGrande extends InimigoNoFire {
	
	/*Construtores*/
	
  public RochaGrande(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "Big Calhau", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25},{}}, new int[] {0, 100, 0}, false);
  }
	
	/*metodo morrrer*/
	
  public void morrer(long tempoActual) {
    nivel.inimigos.add(new RochaMedia(sprite.getNome()+"A", (TileSet)nivel.imagens.get("inimigoRochaMedia"), new MovimentoLinear(-30, 20, sprite.getPosicao(tempoActual)), getHitPoints(), getEnergia(), tempoActual, getPontos(), nivel));
    nivel.mapa.addSprite(((RochaMedia)nivel.inimigos.getLast()).sprite);
    nivel.inimigos.add(new RochaMedia(sprite.getNome()+"B", (TileSet)nivel.imagens.get("inimigoRochaMedia"), new MovimentoLinear(30, 20, sprite.getPosicao(tempoActual)), getHitPoints(), getEnergia(), tempoActual, getPontos(), nivel));
    nivel.mapa.addSprite(((RochaMedia)nivel.inimigos.getLast()).sprite);
    super.morrer(tempoActual, Explosao.GRANDE);
  }

}
