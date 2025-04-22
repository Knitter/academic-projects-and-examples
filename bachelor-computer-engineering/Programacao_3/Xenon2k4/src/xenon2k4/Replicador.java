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

public class Replicador extends InimigoNoFire {

  private String filhoNome;
  private Movimento filhoMovimento;
  private int filhoHitPoints, filhoEnergia, filhoDistancia1, filhoDistancia2, filhoRaio, filhoPontuacao, filhoNum;
  
  /*Coinstrutores*/  

  public Replicador(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao,
                    int numVermelhos, int pontuacaoVermelhos, Movimento movimentoVermelhos, int hitPointsVermelhos,
                    int energiaVermelhos, int distancia1, int distancia2, int raio, Nivel nivel) {

    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "Reprodutor", new int[][] {{},{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24},{}}, new int[] {0, 100, 0}, false);
		filhoNum = numVermelhos;
		filhoPontuacao = pontuacaoVermelhos;
		movimentoVermelhos.getPosicaoInicial().translate(imagens.getWidth() / 2, imagens.getHeight() / 2);
		filhoMovimento = movimentoVermelhos;
		filhoHitPoints = hitPointsVermelhos;
		filhoEnergia = energiaVermelhos;
		filhoDistancia1 = distancia1;
		filhoDistancia2 = distancia2;
		filhoRaio = raio;
  }

	/*metodo morrrer*/
	
  public void morrer(long tempoActual) {
    super.morrer(tempoActual, Explosao.GRANDE);
		nivel.adicionarGrupoInimigosVermelhos("GrupoVermelhos" + filhoNome, filhoMovimento, filhoHitPoints, filhoEnergia, filhoDistancia1, filhoDistancia2, filhoRaio, filhoPontuacao, filhoNum, tempoActual, "PremioPontos", 10000);
  }

}
