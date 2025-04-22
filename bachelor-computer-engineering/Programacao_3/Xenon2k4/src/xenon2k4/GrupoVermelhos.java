package xenon2k4;

import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Grupo de Inimigos Vermelhos.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class GrupoVermelhos extends GrupoInimigos {


/////////////////// Constructors ///////////////////////////////////////////////

	/** Construtor
	 * 
   * @param nome Nome do Grupo de Vermelhos
   * @param imagens TileSets do Grupo de Vermelhos
   * @param movimento Tipo de movimento a associar ao Grupo de Vermelhos
   * @param hitPoints Capacidade de destruição de cada elemento
	 * @param energia Quantidade de energia de cada elemento
   * @param distancia1 Distância em X dos vários elementos do grupo
   * @param distancia2 Distância em Y dos vários elementos do grupo
   * @param raio Raio do movimento
   * @param pontuacao Quantidade de pontos que cada elemento oferece quando morre
   * @param numInimigos Quantidade de inimigos que constituem o Grupo de Vermelhos
   * @param tempoActual Instante em que se inicia a animação e se coloca o Grupo de Vermelhos no jogo
   * @param premio Prémio a oferecer pelo Grupo de Vermelhos
   * @param nivel Nivel ao qual o Grupo de Vermelhos pertence
   */
  public GrupoVermelhos(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, int distancia1, int distancia2, int raio, int pontuacao, int numInimigos, long tempoActual, Pontos premio, Nivel nivel) {
  	super(premio, nivel);
    for (int i = 0; i < numInimigos; i++) {
      getElementos().add(new Vermelhos(nome, imagens, movimento.duplicar(movimento.getPosicaoInicial(), distancia1 * i, distancia2 * i, raio, tempoActual), hitPoints, energia, tempoActual, pontuacao, this, nivel));
      nivel.mapa.addSprite(((Vermelhos)getElementos().getLast()).sprite);
    }
  }

}
