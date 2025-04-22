package xenon2k4;

import java.awt.Color;

import jge2d.Ponto;
import jge2d.SpriteTexto;
import jge2d.jogo.movimentos.Movimento;


/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Entidade abstracta que representa todos os efeitos de texto existentes no jogo.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public abstract class TextFX extends Movel {


/////////////////// Constructors ///////////////////////////////////////////////
	
	public TextFX() {
	}

	/** Construtor
	 * 
   * @param nome Nome do objecto de texto
   * @param posicao Posição na qual o objecto de texto vai ser colocado
   * @param movimento Tipo de movimento a associar ao objecto de texto
	 * @param texto Texto a apresentar no ecrã
	 * @param fonte Fonte do texto
	 * @param estilo Estilo do texto
	 * @param tamanho Tamanho do texto
	 * @param cor Cor do texto
   * @param tempoActual Instante em que se inicia a animação e se coloca o objecto de texto no jogo
   * @param nivel Nivel ao qual o objecto de texto pertence
   */
	public TextFX(String nome, Ponto posicao, Movimento movimento, String texto, String fonte, int estilo, int tamanho, Color cor, long tempoActual, Nivel nivel) {
		this.nivel = nivel;
		sprite = new SpriteTexto(nome, this, texto, fonte, estilo, tamanho, cor);
		sprite.addSpriteMovementListener(this, "movimentoAcabou");
		setMovimento(movimento);
		nivel.mapa.addSprite(sprite);
		getMovimento().iniciaMovimento(tempoActual, sprite);
	}

}
