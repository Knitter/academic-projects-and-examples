package xenon2k4;

import java.awt.Color;
import java.awt.Font;

import jge2d.SpriteTexto;
import jge2d.jogo.movimentos.Movimento;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Representação gráfica de uma Barra de Energia.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class EnergyBar extends TextFX {
	

/////////////////// Constructors ///////////////////////////////////////////////

	public EnergyBar() {
	}

	/** Construtor completo
	 * 
   * @param nome Nome da Barra de Energia
   * @param movimento Tipo de movimento a associar ao objecto de texto
	 * @param texto Texto a apresentar no ecrã
	 * @param fonte Fonte do texto
	 * @param estilo Estilo do texto
	 * @param tamanho Tamanho do texto
	 * @param cor Cor do texto
   * @param tempoActual Instante em que se inicia a animação e se coloca o objecto de texto no jogo
   * @param nivel Nivel ao qual o objecto de texto pertence
   */
	public EnergyBar(String nome, Movimento movimento, String texto, String fonte, int estilo, int tamanho, Color cor, long tempoActual, Nivel nivel) {
		super(nome, movimento.getPosicaoInicial(), movimento, texto, fonte, estilo, tamanho, cor, tempoActual,  nivel);
	}
	
	/** Construtor geral
	 * 
   * @param tempoActual Instante em que se coloca a Barra de Energia no jogo
   * @param movimento Tipo de movimento da Barra de Energia
	 * @param cor Cor inicial da Barra de Energia
   * @param nivel Nivel ao qual a Barra de Energia pertence
   */
  public EnergyBar(long tempoActual, Movimento movimento, Color cor, Nivel nivel) {
		this("Energy", movimento, "|||||||||||||||||||||||||", "Arial", Font.BOLD, 12, cor, tempoActual, nivel);
	}


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Actualiza a barra de energia
   * 
   * @param energiaActual Quantidade de energia a apresentar
   * @param energiaInicial Total de energia que o elemento pode ter. Serve de referência à Barra de Energia 
   * @param cor Conjunto de cores que definem a cor inicial, intermédia e final
   */
  public void actualizarEnergyBar(int energiaActual, int energiaInicial, Color[] cor) {
	  if(energiaActual != energiaInicial){
		  if(energiaActual >= energiaInicial * 0.90)
			  ((SpriteTexto)sprite).setTexto("||||||||||||||||||||||");	
   		else
	   		if(energiaActual >= energiaInicial * 0.80)
		   		((SpriteTexto)sprite).setTexto("||||||||||||||||||||");
   			else
	   			if(energiaActual >= energiaInicial * 0.70){
		   			((SpriteTexto)sprite).setTexto("|||||||||||||||||");
	   				((SpriteTexto)sprite).setColor(cor[1]);
  				}
   				else
	   				if(energiaActual >= energiaInicial * 0.60)
		   				((SpriteTexto)sprite).setTexto("|||||||||||||||");
   					else
	   					if(energiaActual >= energiaInicial * 0.50)
		   					((SpriteTexto)sprite).setTexto("||||||||||||");
   						else
	   						if(energiaActual >= energiaInicial * 0.40)
		   						((SpriteTexto)sprite).setTexto("||||||||||");
	   						else
		   						if(energiaActual >= energiaInicial * 0.30)
			   						((SpriteTexto)sprite).setTexto("|||||||");
		   						else
			   						if(energiaActual >= energiaInicial * 0.20){
				  						((SpriteTexto)sprite).setTexto("|||||");
				   						((SpriteTexto)sprite).setColor(cor[2]);
			  						}
			  						else
				   						if(energiaActual >= energiaInicial * 0.10)
					   						((SpriteTexto)sprite).setTexto("||");  	
   	}
   	else{
	  	((SpriteTexto)sprite).setTexto("|||||||||||||||||||||||||");
			((SpriteTexto)sprite).setColor(cor[0]);	
		}
	}

}
