package xenon2k4;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.TileSet;
import jge2d.jogo.movimentos.MovimentoLinear;
import jge2d.jogo.movimentos.MovimentoSegueAlvo;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Tiro Missil da Machine.</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class Missil extends TiroMachine {

  private Sprite alvo;
  private Random aleatorio = new Random();
  private static Hashtable animacoes = new Hashtable();
  private static final String NORTE = "fire";
  private static final String SUL = "sul";
  private static final String ESTE = "este";
  private static final String OESTE = "oeste";
  private static final String NORDESTE = "nordeste";
  private static final String NOROESTE = "noroeste";
  private static final String SUDOESTE = "sudoeste";
  private static final String SUDESTE = "sudeste";

  
/////////////////// Constructors ///////////////////////////////////////////////

  /** Construtor
   * 
	 * @param velocidade Velocidade que um tiro Missil é disparado
   * @param tempoDisparo Intervalo de tempo entre cada tiro Missil disparado
	 * @param capacidadeDestruicao Capacidade de destruição do tiro Missil
	 * @param imagens TileSets do tiro Missil
	 * @param nivel Nivel ao qual o tiro Missil pertence
	 */
  public Missil(int velocidade, int tempoDisparo, int capacidadeDestruicao, TileSet imagens, Nivel nivel) {
    super(velocidade, tempoDisparo, capacidadeDestruicao, imagens, new int[][] {{},{3},{}}, new int[] {0, 50, 0}, nivel);
    animacoes.put(SUL, new AnimacaoSprite(imagens, new int[] {}, new int[] {7}, new int[] {}, 0, 50, 0));
    animacoes.put(ESTE, new AnimacaoSprite(imagens, new int[] {}, new int[] {5}, new int[] {}, 0, 50, 0));
    animacoes.put(OESTE, new AnimacaoSprite(imagens, new int[] {}, new int[] {1}, new int[] {}, 0, 50, 0));
    animacoes.put(NORDESTE, new AnimacaoSprite(imagens, new int[] {}, new int[] {4}, new int[] {}, 0, 50, 0));
    animacoes.put(NOROESTE, new AnimacaoSprite(imagens, new int[] {}, new int[] {2}, new int[] {}, 0, 50, 0));
    animacoes.put(SUDOESTE, new AnimacaoSprite(imagens, new int[] {}, new int[] {8}, new int[] {}, 0, 50, 0));
    animacoes.put(SUDESTE, new AnimacaoSprite(imagens, new int[] {}, new int[] {6}, new int[] {}, 0, 50, 0));
   }


/////////////////// Métodos Gerais /////////////////////////////////////////////
  
  /* (non-Javadoc)
   * @see xenon2k4.Tiro#fire(jge2d.Ponto, long)
   */
  public void fire(Ponto ponto, long tempoActual) {
  	ponto.translate(getOffsetTiro().getX(), getOffsetTiro().getY());
    if((alvo = obterAlvo()) != null)
    	setMovimento(new MovimentoSegueAlvo(alvo, getVelocidade(), ponto));
    else
    	setMovimento(new MovimentoLinear(0, -getVelocidade(), ponto));
    super.fire(ponto, tempoActual);
  	sprite.adicionarAnimacao(SUL, (AnimacaoSprite)animacoes.get(SUL));
  	sprite.adicionarAnimacao(ESTE, (AnimacaoSprite)animacoes.get(ESTE));
  	sprite.adicionarAnimacao(OESTE, (AnimacaoSprite)animacoes.get(OESTE));
  	sprite.adicionarAnimacao(NORDESTE, (AnimacaoSprite)animacoes.get(NORDESTE));
  	sprite.adicionarAnimacao(NOROESTE, (AnimacaoSprite)animacoes.get(NOROESTE));
  	sprite.adicionarAnimacao(SUDOESTE, (AnimacaoSprite)animacoes.get(SUDOESTE));
  	sprite.adicionarAnimacao(SUDESTE, (AnimacaoSprite)animacoes.get(SUDESTE));
  }

 /** Quando o movimento termina o tiro calcula a nova direcção para o alvo e
  * actualiza a sua animação 
  * 
  * @param tempoActual Instante em que o movimento terminou
  */
	public void movimentoAcabou(long tempoActual) {
  	double dX = ((MovimentoSegueAlvo)getMovimento()).getDx();
  	double dY = ((MovimentoSegueAlvo)getMovimento()).getDy();
  	double cX = Math.abs(dX);
  	double cY = Math.abs(dY);
  	
  	/* 1º Quadrante */
  	if (dX > 0 && dY < 0)
  		if (cY < cX / 2)
  			sprite.setAnimacao(ESTE, false, tempoActual);
  		else
  			if (cX < cY / 2)
  				sprite.setAnimacao(NORTE, false, tempoActual);
  			else
  				sprite.setAnimacao(NORDESTE, false, tempoActual);
  	
  	/* 2º Quadrante */
  	else
	  	if (dX < 0 && dY < 0)
	  		if (cY < cX / 2)
	  			sprite.setAnimacao(OESTE, false, tempoActual);
	  		else
	  			if (cX < cY / 2)
	  				sprite.setAnimacao(NORTE, false, tempoActual);
	  			else
	  				sprite.setAnimacao(NOROESTE, false, tempoActual);
	  	
	  	/* 3º Quadrante */
	  	else 
		  	if (dX < 0 && dY > 0)
		  		if (cY < cX / 2)
		  			sprite.setAnimacao(OESTE, false, tempoActual);
		  		else
		  			if (cX < cY / 2)
		  				sprite.setAnimacao(SUL, false, tempoActual);
		  			else
		  				sprite.setAnimacao(SUDOESTE, false, tempoActual);
		  	
		  	/* 4º Quadrante */
		  	else 
			  	if (dX > 0 && dY > 0)
			  		if (cY < cX / 2)
			  			sprite.setAnimacao(ESTE, false, tempoActual);
			  		else
			  			if (cX < cY / 2)
			  				sprite.setAnimacao(SUL, false, tempoActual);
			  			else
			  				sprite.setAnimacao(SUDESTE, false, tempoActual);

  	getMovimento().movimentarSprite(tempoActual, sprite);
  }

  /** De todos os inimigos actualmente em jogo escolhe um aleatóriamente
   * 
	 * @return Devolve a sprite do inimigo escolhido
	 */
	private Sprite obterAlvo() {
  	LinkedList listaTodosInimigos = new LinkedList();
  	Iterator it, it2;
  	
  	it = nivel.inimigos.iterator();
  	while (it.hasNext()) 
  		listaTodosInimigos.add(it.next());
  	
  	it = nivel.inimigosOnFire.iterator();
  	while (it.hasNext())
  		listaTodosInimigos.add(it.next());

  	it = nivel.gruposInimigos.iterator();
  	while (it.hasNext()) {
  		it2 = ((GrupoInimigos)it.next()).getElementos().iterator();
  		while (it2.hasNext())
  			listaTodosInimigos.add(it2.next());
  	}

		if (nivel.inimigoBoss != null)
			listaTodosInimigos.add(nivel.inimigoBoss);
		
  	if (listaTodosInimigos.isEmpty())
  		return null;
  	
		return ((Inimigo)listaTodosInimigos.get(aleatorio.nextInt(listaTodosInimigos.size()))).sprite;
  }
  
  
/////////////////// Método Morrer //////////////////////////////////////////////

  /* (non-Javadoc)
	 * @see xenon2k4.Movel#morrer(long, java.lang.String)
	 */
  public void morrer(long tempoActual, String nomeAnimacao) {
    super.morrer(tempoActual, nomeAnimacao);
  }

}
