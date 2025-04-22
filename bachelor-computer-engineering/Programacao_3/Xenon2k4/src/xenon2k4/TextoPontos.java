package xenon2k4;

import java.awt.Color;

import jge2d.Ponto;
import jge2d.jogo.movimentos.MovimentoLinear;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Apresenta a pontuação de um inimigo quando este morre.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class TextoPontos extends TextFX {


/////////////////// Constructors ///////////////////////////////////////////////

	public TextoPontos() {
	}

	/** Construtor
	 * 
   * @param nome Nome do objecto de texto
   * @param posicao Posição na qual o objecto de texto vai ser colocado
	 * @param texto Texto a apresentar no ecrã
	 * @param fonte Fonte do texto
	 * @param estilo Estilo do texto
	 * @param tamanho Tamanho do texto
	 * @param cor Cor do texto
   * @param tempoActual Instante em que se inicia a animação e se coloca o objecto de texto no jogo
   * @param nivel Nivel ao qual o objecto de texto pertence
   */
	public TextoPontos(String nome, Ponto posicao, String texto, String fonte, int estilo, int tamanho, Color cor, long tempoActual, Nivel nivel) {
		super(nome, posicao, new MovimentoLinear(0, 0, posicao), texto, fonte, estilo, tamanho, cor, tempoActual,  nivel);
		Ponto deslocamento = new Ponto(posicao);
		deslocamento.translate(0, -75);
		sprite.movimentarPara(deslocamento, tempoActual, 1000);
	}
	

/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Elimina o texto quando terminar o seu movimento
   * 
   * @param tempoActual Instante em que o texto termina o seu movimento
   */
	public void movimentoAcabou(long tempoActual) {
		morrer(tempoActual);
	}
	

/////////////////// Método Morrer //////////////////////////////////////////////

  /** Faz desaparecer o texto
   * 
   * @param tempoActual Instante em que o texto desaparece
   */
	public void morrer(long tempoActual) {
		nivel.mapa.removeSprite(sprite);
		nivel.pontos.remove(this);
	}

}
