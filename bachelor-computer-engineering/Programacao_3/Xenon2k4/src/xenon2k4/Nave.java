package xenon2k4;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Teclado;
import jge2d.TileSet;
import jge2d.jogo.movimentos.MovimentoLinear;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Nave controlada pelo jogador.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Nave extends Machine {

  private Teclado teclado;
  private boolean morreu;
  private int energiaInicial;
  private Ponto posicaoInicial;
  private int velocidade;
  private int velocidadeInicial;
  private int velocidadeDireccional;
  private static long pontuacao;
  private int ultimaTecla;
  private LinkedList componentes = new LinkedList();
  private EnergyBar energyBar;  

  public static final int NENHUMA_TECLA = 0;
	public static final String VERTICAL = "vertical";
	public static final String DIREITA = "direita";
	public static final String ESQUERDA = "esquerda";


/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param nome Nome da Nave
	 * @param imagens TileSets da Nave
	 * @param posicao Posição na qual a Nave vai ser colocada
	 * @param velocidade Velocidade que a Nave se desloca no Nivel
	 * @param tempoActual Instante em que se inicia a animação e se coloca a Nave no jogo
   * @param energia Quantidade de energia que a Nave contém
	 * @param hitPoints Capacidade de destruição da Nave
	 * @param nivel Nivel ao qual a Nave pertence
	 */
  public Nave(String nome, TileSet imagens, Ponto posicao, int velocidade, long tempoActual, int energia, int hitPoints, Nivel nivel) {
    super(nome, imagens, posicao, new MovimentoLinear(0, -velocidade, posicao), energia, hitPoints, tempoActual, nivel, VERTICAL, new int[][] {{},{4},{}}, new int[] {0, 1000, 0}, false);
    energiaInicial = energia;
    posicaoInicial = posicao;
    velocidadeInicial = velocidade; 
    teclado = new Teclado();
    sprite.adicionarAnimacao(DIREITA, new AnimacaoSprite(imagens, new int[] {5, 6},
        new int[] {7}, new int[] {6, 5}, 100, 1000, 100));
    sprite.adicionarAnimacao(ESQUERDA, new AnimacaoSprite(imagens, new int[] {3, 2},
        new int[] {1}, new int[] {2, 3}, 100, 1000, 100));
  }


/////////////////// Getters & Setters //////////////////////////////////////////

  /**
   * @return Devolve a velocidade de deslocamento da nave no nível
   */
	public int getVelocidade() {
		return velocidade;
	}
	
	/**
	 * @return Devolve a quantidade de energia inicial da nave
	 */
	public int getEnergiaInicial() {
	  return energiaInicial;
	}

  /**
	 * @param teclado Teclado a atribuir à nave
	 * @param tempoActual Instante em que se atribui o teclado
	 */
	public void setTeclado(Teclado teclado, long tempoActual) {
    this.teclado = teclado;
  }

  /**
	 * @return Devolve a pontuação actual do jogador da nave
	 */
	public long getPontuacao() {
    return pontuacao;
  }

  /**
	 * @param pontos Pontos a atribuir ao jogador da nave
	 */
	public void setPontuacao(long pontos) {
  	pontuacao = pontos;
  }
  
  /**
	 * @return Verifica se a nave foi destruida ou não
	 */
	public boolean getMorreu(){
		return morreu;
  }

  /**
	 * @return Devolve a referência da Barra de Energia 
	 */
	public EnergyBar getEnergyBar(){
	  return energyBar;
  }
  
  /** Define a última tecla que o jogador primiu
   * 
	 * @param tecla Ultima tecla primida 
	 */
	public void setUltimaTecla(int tecla) {
	  ultimaTecla = tecla;
  }

	/** Atribui um factor à velocidade da nave
	 * 
	 * @param factorV Factor a multiplicar pela velocidade direccional na nave
	 */
	public void setSpeedUp(int factorV) {
  	velocidadeDireccional *= factorV;
	}
  
	/**
	 * @param novaVelocidade Nova velocidade de deslocamento da nave
	 */
	public void setVelocidade(int novaVelocidade) {
		velocidade = novaVelocidade;
	}
	
	/**
	 * @return Devolve a lista de componentes que a nave possui
	 */
	public LinkedList getComponentes() {
		return componentes;
	}
	

/////////////////// Métodos Gerais /////////////////////////////////////////////
	
  /** Movimenta a nave e os respectivos componentes em função da tecla pressionada
   * 
   * @param tempoActual Instante em que se pretende movimentar a nave
   * @param areaVisivel Área currentemente visível para limitar os movimentos da nave
   */
	public void movimentarSprite(long tempoActual, Rectangle areaVisivel) {
		Iterator it;
		Ponto p = new Ponto(sprite.getPosicao(tempoActual));

		if (teclado != null) {
		  if (teclado.isTeclaPressionada(Teclado.DIREITA) && sprite.getPosicao(tempoActual).getX() + sprite.getWidth() < areaVisivel.width) {
				p.translate(velocidadeDireccional, 0);
				if (ultimaTecla != Teclado.DIREITA)
					sprite.setAnimacao(DIREITA, true, tempoActual);
				ultimaTecla = Teclado.DIREITA;
		  }
		  if (teclado.isTeclaPressionada(Teclado.ESQUERDA) && sprite.getPosicao(tempoActual).getX() > areaVisivel.getX()) {
				p.translate(-velocidadeDireccional, 0);
				if (ultimaTecla != Teclado.ESQUERDA)
					sprite.setAnimacao(ESQUERDA, true, tempoActual);
				ultimaTecla = Teclado.ESQUERDA;
		  }
		  if (teclado.isTeclaPressionada(Teclado.BAIXO) && sprite.getPosicao(tempoActual).getY() + sprite.getHeight() < areaVisivel.height)  
				p.translate(0, velocidadeDireccional);
		  if (teclado.isTeclaPressionada(Teclado.CIMA) && sprite.getPosicao(tempoActual).getY() > areaVisivel.getY()) 
				p.translate(0, -velocidadeDireccional);
		  if (teclado.isTeclaPressionada(Teclado.DISPARAR)) {
				dispara(tempoActual);
				it = componentes.iterator();
				while (it.hasNext())
					((Componente)it.next()).dispara(tempoActual);
		  }
		}
		p.translate(0, -velocidade);
		sprite.movimentarPara(p, tempoActual, 1000);
    
		it = componentes.iterator();
		while (it.hasNext())
			((Componente)it.next()).movimentoAcabou(tempoActual, p);
	}

  /** Reinicia a nave com as suas características originais
   * 
	 * @param tempoActual Instante pretendido para reiniciar a nave
	 * @param tiro Tiro a atribuir à nave quando ela é reiniciada
	 */
	public void reiniciar(long tempoActual, TiroMachine tiro) {
    Iterator it;
    
    morreu = false;
		velocidade = velocidadeInicial;
		velocidadeDireccional = 2 * velocidadeInicial; 
		ultimaTecla = NENHUMA_TECLA;
    setEnergia(energiaInicial);
    sprite.colocarEm(posicaoInicial, tempoActual);
    sprite.setAnimacao(VERTICAL, false, tempoActual);
    setArma(tiro);
     
    it = componentes.iterator();
    while (it.hasNext())
			nivel.mapa.removeSprite(((Componente)it.next()).sprite);    
    componentes.clear();
		energyBar = new EnergyBar(tempoActual, new MovimentoLinear(0, (float)-velocidade, new Ponto(550,5751)), Color.GREEN, nivel);
  }

  /** Adiciona uma quantidade de pontos à pontuação
   * 
	 * @param pontos Quantidade de pontos a adicionar à pontuação
	 */
	public void addPontuacao(int pontos) {
    pontuacao += pontos;
  }

	/** Verifica se a nave já possui um determinado componente numa determinada asa 
	 * 
	 * @param type Tipo de componente
	 * @param lado Lado da asa
	 * @return Devolve verdadeiro caso a nave já possua o componente
	 */
	public boolean existeComponente(int type, int lado) {
		Iterator it = componentes.iterator();
		Componente componente;
		
		while (it.hasNext()) {
			componente = (Componente)it.next();
			if (componente.getComponentType() == type && componente.getLado() == lado)
				return true;
		}
		return false;
	}

	
/////////////////// Métodos de Trata Colisão ///////////////////////////////////
		
  /* (non-Javadoc)
   * @see xenon2k4.Machine#trataColisao(xenon2k4.Inimigo, long)
   */
	public void trataColisao(Inimigo inimigo, long tempoActual) {
		super.trataColisao(inimigo, tempoActual);
		energyBar.actualizarEnergyBar(getEnergia(), energiaInicial, new Color[] {Color.GREEN, Color.YELLOW, Color.RED});
	}
	
	/* (non-Javadoc)
	 * @see xenon2k4.Machine#trataColisao(xenon2k4.TiroInimigo, long)
	 */
	public void trataColisao(TiroInimigo tiro, long tempoActual) {
		super.trataColisao(tiro, tempoActual);
		energyBar.actualizarEnergyBar(getEnergia(), energiaInicial, new Color[] {Color.GREEN, Color.YELLOW, Color.RED});
	}

  /** Trata a colisão de um Premio com a Nave 
   * 
   * @param premio Premio com que a Nave colidiu
   * @param tempoActual Instante em que colidiu
   */
	public void trataColisao(Premio premio, long tempoActual) {
    premio.trataColisao(this, tempoActual);
  }


/////////////////// Método Morrer //////////////////////////////////////////////

  /** Define que a nave já foi destruida, num determinado instante */
  public void morrer(long tempoActual) {
		morreu = true;
  }

}
