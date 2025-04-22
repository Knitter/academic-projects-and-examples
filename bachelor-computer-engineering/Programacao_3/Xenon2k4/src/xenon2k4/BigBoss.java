package xenon2k4;

import java.awt.Color;

import jge2d.Ponto;
import jge2d.TileSet;
import jge2d.jogo.movimentos.Movimento;
import jge2d.jogo.movimentos.MovimentoLinear;
import jge2d.jogo.movimentos.MovimentoSegmentoRecta;
import jge2d.jogo.movimentos.MovimentoSegueAlvo;

/**
 * <p><b>Title:</b> Xenon2k4</p>
 * <p><b>Description:</b> Inimigo Boss</p>
 * <p><b>Copyright:</b> IPL/ESTG(c)2004</p>
 * <p><b>Company:</b> 4thFloor</p>
 * @author Ruben Pedro
 * @author Sérgio Lopes
 * @version 1.1
 */

public final class BigBoss extends InimigoOnFire {

  private int pontuacaoCriados;
  private int inimigoAleatorio;
	private TileSet imagens = null;
  private Ponto offset, posicaoBoca;
  private Movimento movimento = null;
  private EnergyBar energyBar;
	private int energiaInicial;

  private static final int INTERVALO_TEMPO = 2000;
  private static final int NUM_INIMIGOS = 6;
  private static final int ABELHA = 0;
  private static final int BOLA = 1;
  private static final int CARACOL = 2;
  private static final int ESPINHOSO = 3;
  private static final int ROCHA_PEQUENA = 4;
  private static final int VERMELHO = 5;
  

/////////////////// Constructors ///////////////////////////////////////////////
	
	/** Construtor
	 * 
   * @param nome Nome do BigBoss
   * @param imagens TileSets do BigBoss
   * @param movimento Tipo de movimento a associar ao BigBoss
   * @param hitPoints Capacidade de destruição do BigBoss
	 * @param energia Quantidade de energia que o BigBoss contém
   * @param tempoActual Instante em que se inicia a animação e se coloca o BigBoss no jogo
   * @param pontuacao Quantidade de pontos que o BigBoss oferece quando morre
	 * @param pontuacaoCriados Quantidade de pontos que os inimigos lançados pelo Boss valem
   * @param nivel Nivel ao qual o BigBoss pertence
   */
  public BigBoss(String nome, TileSet imagens, Movimento movimento, int hitPoints, int energia, long tempoActual, int pontuacao, int pontuacaoCriados, Nivel nivel) {
    super(nome, imagens, movimento.getPosicaoInicial(), movimento, hitPoints, energia, pontuacao, tempoActual, nivel, "KILLER", new int[][] {{},{1},{}}, new int[] {0, 1000, 0}, false);
  	this.pontuacaoCriados = pontuacaoCriados;
		energyBar = new EnergyBar(tempoActual, new MovimentoLinear(0, 0/*-nivel.getNave().getVelocidade()*/, new Ponto(10, sprite.getPosicao(tempoActual).getY() + 50)), Color.RED, nivel);
		energiaInicial = energia;
  }


/////////////////// Métodos Gerais /////////////////////////////////////////////

  /** Dispara um inimigo escolhido aleatóriamente
   * 
   * @param tempoActual Instante em que dispara um inimigo
   */
  public void dispara(long tempoActual) {
  	if (getDiferencaDeTempo(tempoActual)/*tempoActual - tempoLastFire*/ > INTERVALO_TEMPO) {
    	inimigoAleatorio = getAleatorio().nextInt(NUM_INIMIGOS);
    	offset = obterOffset(inimigoAleatorio);
    	posicaoBoca = new Ponto(sprite.getPosicao(tempoActual).getX() + sprite.getWidth() / 2, sprite.getPosicao(tempoActual).getY() + sprite.getHeight() - 40);
  		posicaoBoca.translate(-offset.getX(), -offset.getY());

  		switch(getAleatorio().nextInt(3)) {
  			case 0:
  				movimento = new MovimentoLinear(-150 + getAleatorio().nextInt(300), 25 + getAleatorio().nextInt(75), posicaoBoca);
			  break;
			
  			case 1:
  				movimento = new MovimentoSegueAlvo(nivel.getNave().sprite, 100, posicaoBoca);
  			break;
			
  			case 2:
  				movimento = new MovimentoSegmentoRecta(300, 0, new Ponto(300, sprite.getPosicao(tempoActual).getY() + sprite.getHeight() - offset.getY()), 3000);
  		}

  		switch (inimigoAleatorio) {
		  	case ABELHA:
		  		nivel.adicionarInimigoAbelha("SlaveAbelha" + nivel.inimigos.size(), movimento, 50, 1200, tempoActual, pontuacaoCriados);
		  	break;
			   
		  	case BOLA:
		  		nivel.adicionarInimigoBola("SlaveBola" + nivel.inimigos.size(), movimento, 10, 1000, tempoActual, pontuacaoCriados);
		  	break;
	
		  	case CARACOL:
		  		nivel.adicionarInimigoCaracol("SlaveCaracol" + nivel.inimigosOnFire.size(), movimento, 100, 1500, tempoActual, pontuacaoCriados);
		  	break;
		  		
		  	case ESPINHOSO:
		  		nivel.adicionarInimigoEspinho("SlaveEspinhoso" + nivel.inimigosOnFire.size(), movimento, 50, 1000, tempoActual, pontuacaoCriados);
		  	break;

		  	case ROCHA_PEQUENA:
		  		nivel.adicionarInimigoRochaPequena("SlaveRochaPequena" + nivel.inimigos.size(), movimento, 100, 500, tempoActual, 250);
		  	break;
		  		
		  	case VERMELHO:
		  		nivel.adicionarInimigoVermelho("SlaveVermelho" + nivel.inimigos.size(), movimento, 50, 100, tempoActual, 150);
	    }
		setTempoLastFire(tempoActual);
    }
  }

  /** Calcula o offset do inimigo escolhido aleatóriamente
   * 
	 * @param inimigoAleatorio Inimigo aleatório cujo offset vai ser calculado
	 * @return Devolve o offset calculado
	 */
	private Ponto obterOffset(int inimigoAleatorio) {

  	switch (inimigoAleatorio) {
  		case ABELHA:
  			imagens = (TileSet)nivel.imagens.get("inimigoAbelha");
  		break;
  		
  		case BOLA:
  			imagens = (TileSet)nivel.imagens.get("inimigoBola");
  		break;
  		
  		case CARACOL:
  			imagens = (TileSet)nivel.imagens.get("inimigoCaracol");
  		break;

  		case ESPINHOSO:
  			imagens = (TileSet)nivel.imagens.get("inimigoEspinhoso");
  		break;

  		case ROCHA_PEQUENA:
  			imagens = (TileSet)nivel.imagens.get("inimigoRochaPequena");
  		break;

  		case VERMELHO:
  			imagens = (TileSet)nivel.imagens.get("inimigoVermelho");
  		break;
  		
  		default:
				return new Ponto();
  	}
  	return new Ponto(imagens.getWidth() / 2, imagens.getHeight() / 2);
  }


/////////////////// Métodos de Trata Colisão ///////////////////////////////////

  /** Trata a colisão da Nave com o Inimigo Boss
	 * 
	 * @param nave Nave com o qual o Inimigo Boss colidiu
	 * @param tempoActual Instante em que colidiu
	 */
  public void trataColisao(Nave nave, long tempoActual){
	  super.trataColisao(nave, tempoActual);
	  energyBar.actualizarEnergyBar(getEnergia(), energiaInicial, new Color[] {Color.RED, Color.RED, Color.RED});
	}
  
	/* (non-Javadoc)
	 * @see xenon2k4.Inimigo#trataColisao(xenon2k4.TiroMachine, long)
	 */
	public void trataColisao(TiroMachine tiro, long tempoActual) {
	  super.trataColisao(tiro, tempoActual);
	  energyBar.actualizarEnergyBar(getEnergia(),energiaInicial, new Color[] {Color.RED, Color.RED, Color.RED});
	}
		

/////////////////// Método Morrer //////////////////////////////////////////////

	/** Remove o Inimigo Boss do jogo e cria uma série de explosões
	 * 
	 * @param tempoActual Instante em que o Inimigo Boss morre
	 */
  public void morrer(long tempoActual) {
		for (int i = 0; i < 25; i++) {
			Explosao explode = new Explosao("BOOM!" + nivel.explosoes.size(), (TileSet)nivel.imagens.get(Explosao.GRANDE), new Ponto(sprite.getPosicao(tempoActual).getX() + getAleatorio().nextInt(sprite.getWidth()), sprite.getPosicao(tempoActual).getY() + getAleatorio().nextInt(sprite.getHeight())), tempoActual, nivel, "morrer", new int[][] {{},{},{1,2,3,4,5,6,7,8,9,10}}, new int[] {0, 0, 150}, false);
			nivel.explosoes.add(explode);
			nivel.mapa.addSprite(explode.sprite);
		}
		nivel.mapa.removeSprite(energyBar.sprite);
  	super.morrer(tempoActual, Explosao.GRANDE);
		nivel.inimigoBoss = null;
  	nivel.setPassarNivel(true);
  }
  
}
