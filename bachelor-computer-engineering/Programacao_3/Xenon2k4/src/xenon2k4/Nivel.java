package xenon2k4;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

import jge2d.INivel;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.SpritedTileMap;
import jge2d.Teclado;
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

public class Nivel implements INivel {

  private Nave nave;
  private Iterator it;
  private int hitPointsCenario;
  private boolean desistir;
  private boolean passarNivel;
	private int tolerancia;
	
	protected BigBoss inimigoBoss;
  protected SpritedTileMap mapa;
  protected Hashtable imagens = new Hashtable();
  protected Hashtable cfgTiros = new Hashtable();
  protected LinkedList inimigos = new LinkedList();
  protected LinkedList gruposInimigos = new LinkedList();
  protected LinkedList inimigosOnFire = new LinkedList();
  protected LinkedList premios = new LinkedList();
  protected LinkedList pontos = new LinkedList();
  protected LinkedList tiros = new LinkedList();
  protected LinkedList explosoes = new LinkedList();
	
  /*Construtores*/
	
  public Nivel() {
  }

  public void adicionarGrupoInimigosAbelhas(String nome, Movimento movimento, int capDestruicao, int capResistencia, int distancia1, int distancia2, int raio, int pontuacao, int numInimigos, long tempoActual, String nomePremio, int parametroPremio) {
		Pontos pontos = null;
		if ((nomePremio.compareTo("SEM_PREMIO") != 0))
		  pontos = new Pontos(nomePremio, (TileSet) imagens.get("premioPontos"), new Ponto(), parametroPremio, tempoActual, this);
		gruposInimigos.add(new GrupoAbelhas(nome, (TileSet)imagens.get("inimigoAbelha"), movimento, capDestruicao, capResistencia, distancia1, distancia2, raio, pontuacao, numInimigos, tempoActual, pontos, this));
  }

  public void adicionarGrupoInimigosBolas(String nome, Movimento movimento, int capDestruicao, int capResistencia, int distancia1, int distancia2, int raio, int pontuacao, int numInimigos, long tempoActual, String nomePremio, int parametroPremio) {
    Pontos pontos = null;
    if ((nomePremio.compareTo("SEM_PREMIO") != 0))
      pontos = new Pontos(nomePremio, (TileSet) imagens.get("premioPontos"), new Ponto(), parametroPremio, tempoActual, this);
    gruposInimigos.add(new GrupoBolas(nome, (TileSet)imagens.get("inimigoBola"), movimento, capDestruicao, capResistencia, distancia1, distancia2, raio, pontuacao, numInimigos, tempoActual, pontos, this));
  }

  public void adicionarGrupoInimigosVermelhos(String nome, Movimento movimento, int capDestruicao, int capResistencia, int distancia1, int distancia2, int raio, int pontuacao, int numInimigos, long tempoActual, String nomePremio, int parametroPremio) {
		Pontos pontos = null;
		if ((nomePremio.compareTo("SEM_PREMIO") != 0))
		  pontos = new Pontos(nomePremio, (TileSet) imagens.get("premioPontos"), new Ponto(), parametroPremio, tempoActual, this);
		gruposInimigos.add(new GrupoVermelhos(nome, (TileSet)imagens.get("inimigoVermelho"), movimento, capDestruicao, capResistencia, distancia1, distancia2, raio, pontuacao, numInimigos, tempoActual, pontos, this));
  }

  public void adicionarInimigoAbelha(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigos.add(new Abelha(nome, (TileSet)imagens.get("inimigoAbelha"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((Abelha)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoBola(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigos.add(new Bola(nome, (TileSet)imagens.get("inimigoBola"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((Bola)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoBoss(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao, int pontuacaoCriados) {
    inimigoBoss = new BigBoss(nome, (TileSet)imagens.get("inimigoBigBoss"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, pontuacaoCriados, this);
    mapa.addSprite(inimigoBoss.sprite);
  }

  public void adicionarInimigoCaracol(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigosOnFire.add(new Caracol(nome, (TileSet)imagens.get("inimigoCaracol"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((Caracol)inimigosOnFire.getLast()).sprite);
  }

  public void adicionarInimigoCarraca(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao, int lado) {
    inimigosOnFire.add(new Carraca(nome, (TileSet)imagens.get("inimigoCarraca"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, lado, this));
    mapa.addSprite(((Carraca)inimigosOnFire.getLast()).sprite);
  }

  public void adicionarInimigoEspinho(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigosOnFire.add(new Espinhoso(nome, (TileSet)imagens.get("inimigoEspinhoso"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((Espinhoso)inimigosOnFire.getLast()).sprite);
  }

  public void adicionarInimigoReplicador(String nome, Movimento movimento, int capDestruicao, int capResistencia,
                                         long tempoActual, int pontuacao, int numVermelhos, int pontuacaoVermelhos,
                                         Movimento movimentoVermelhos, int capDestruicaoVermelhos, int capResistenciaVermelhos,
                                         int distancia1, int distancia2, int raio) {

    inimigos.add(new Replicador(nome, (TileSet)imagens.get("inimigoReplicador"),movimento, capDestruicao, capResistencia,
                                         tempoActual, pontuacao, numVermelhos, pontuacaoVermelhos, movimentoVermelhos, capDestruicaoVermelhos, capResistenciaVermelhos,
                                         distancia1, distancia2, raio, this));
    mapa.addSprite(((Replicador)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoRochaGrande(String nome, Movimento movimento,  int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigos.add(new RochaGrande(nome, (TileSet)imagens.get("inimigoRochaGrande"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((RochaGrande)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoRochaIndestrutivelGrande(String nome, Movimento movimento, int capDestruicao, long tempoActual) {
    inimigos.add(new IndestrutivelGrande(nome, (TileSet)imagens.get("inimigoIndestrutivelGrande"), movimento, capDestruicao, tempoActual, this));
    mapa.addSprite(((IndestrutivelGrande)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoRochaIndestrutivelMedia(String nome, Movimento movimento, int capDestruicao, long tempoActual) {
    inimigos.add(new IndestrutivelMedia(nome, (TileSet)imagens.get("inimigoIndestrutivelMedio"), movimento, capDestruicao, tempoActual, this));
    mapa.addSprite(((IndestrutivelMedia)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoRochaIndestrutivelPequena(String nome, Movimento movimento, int capDestruicao, long tempoActual) {
    inimigos.add(new IndestrutivelPequena(nome, (TileSet)imagens.get("inimigoIndestrutivelPequena"), movimento, capDestruicao, tempoActual, this));
    mapa.addSprite(((IndestrutivelPequena)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoRochaMedia(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigos.add(new RochaMedia(nome, (TileSet)imagens.get("inimigoRochaMedia"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((RochaMedia)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoRochaPequena(String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigos.add(new RochaPequena(nome, (TileSet)imagens.get("inimigoRochaPequena"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((RochaPequena)inimigos.getLast()).sprite);
  }

  public void adicionarInimigoVermelho(java.lang.String nome, Movimento movimento, int capDestruicao, int capResistencia, long tempoActual, int pontuacao) {
    inimigos.add(new Vermelho(nome, (TileSet)imagens.get("inimigoVermelho"), movimento, capDestruicao, capResistencia, tempoActual, pontuacao, this));
    mapa.addSprite(((Vermelho)inimigos.getLast()).sprite);
  }

  public void adicionarPremioComponenteAsa(String nome, Ponto posicao, int asa, long tempoActual) {
    premios.add(new AddAsa(nome, (TileSet)imagens.get("premioComponenteAsa"), posicao, asa,tempoActual, this));
    mapa.addSprite(((AddAsa)premios.getLast()).sprite);
  }

  public void adicionarPremioComponenteMovel(java.lang.String nome, Ponto posicao, int asa, long tempoActual) {
    premios.add(new AddPendulo(nome, (TileSet)imagens.get("premioComponentePendulo"), posicao, asa, tempoActual, this));
    mapa.addSprite(((AddPendulo)premios.getLast()).sprite);
  }

  public void adicionarPremioEnergia(String nome, Ponto posicao, long tempoActual) {
    premios.add(new Energia(nome, (TileSet)imagens.get("premioEnergia"), posicao, tempoActual, this));
    mapa.addSprite(((Energia)premios.getLast()).sprite);
  }

  public void adicionarPremioLaser(String nome, Ponto posicao, long tempoActual) {
    premios.add(new PowerLaser(nome, (TileSet)imagens.get("premioLaser"), posicao, tempoActual, this));
    mapa.addSprite(((PowerLaser)premios.getLast()).sprite);
  }

  public void adicionarPremioMissil(String nome, Ponto posicao, long tempoActual) {
    premios.add(new PowerMissil(nome, (TileSet)imagens.get("premioPowerUpMissil"), posicao, tempoActual, this));
    mapa.addSprite(((PowerMissil)premios.getLast()).sprite);
  }

  public void adicionarPremioPontos(String nome, Ponto posicao, int pontos, long tempoActual) {
    premios.add(new Pontos(nome, (TileSet)imagens.get("premioPontos"), posicao, pontos, tempoActual, this));
    mapa.addSprite(((Pontos)premios.getLast()).sprite);
  }

  public void adicionarPremioTiroDuplo(String nome, Ponto posicao, long tempoActual) {
    premios.add(new PowerDuplo(nome, (TileSet)imagens.get("premioPowerUpDuplo"), posicao, tempoActual, this));
    mapa.addSprite(((PowerDuplo)premios.getLast()).sprite);
  }

  public void adicionarPremioVelocidade(String nome, Ponto posicao, int factor, long tempoActual) {
    premios.add(new SpeedUp(nome, (TileSet)imagens.get("premioSpeedUp"), posicao, factor, tempoActual, this));
    mapa.addSprite(((SpeedUp)premios.getLast()).sprite);
  }

  public Sprite colocarNave(Ponto posicao, int velocidade, long tempoActual, int capResistencia, int capDestruicao) {
    nave = new Nave("X-b3n-knitter", (TileSet)imagens.get("nave"), posicao, velocidade, tempoActual, capResistencia, capDestruicao, this);
    mapa.addSprite(nave.sprite);
    return nave.sprite;
  }

  public void configurarTiroDuplo(int velocidade, int tempoDisparo, int capacidadeDestruicao) {
    cfgTiros.put("tiroDuplo", new Duplo(velocidade, tempoDisparo, capacidadeDestruicao, (TileSet)imagens.get("tiroDuplo"), this));
  }

  public void configurarTiroEspinho(int velocidade, int capacidadeDestruicao) {
  	cfgTiros.put("tiroEspinho", new Espinho(velocidade, capacidadeDestruicao, (TileSet)imagens.get("tiroEspinho"), (TileSet)imagens.get("inimigoEspinhoso"), this));
  }

  public void configurarTiroLaser(int velocidade, int tempoDisparo, int capacidadeDestruicao) {
    cfgTiros.put("tiroLaser", new Laser(velocidade, tempoDisparo, capacidadeDestruicao, (TileSet)imagens.get("tiroLaser"), this));
  }

  public void configurarTiroMetal(int velocidade, int capacidadeDestruicao) {
    cfgTiros.put("tiroMetal", new Metal(velocidade, capacidadeDestruicao, (TileSet)imagens.get("tiroMetal"), this));
  }

  public void configurarTiroMissil(int velocidade, int tempoDisparo, int capacidadeDestruicao) {
    cfgTiros.put("tiroMissil", new Missil(velocidade, tempoDisparo, capacidadeDestruicao, (TileSet)imagens.get("tiroMissil"), this));
  }

  public void configurarTiroSimples(int velocidade, int tempoDisparo, int capacidadeDestruicao) {
    cfgTiros.put("tiroSimples", new Simples(velocidade, tempoDisparo, capacidadeDestruicao, (TileSet)imagens.get("tiroSimples"), this));
  }

  public void createTileSets(Component componente) {
    imagens.put("nave", new TileSet("/tiles/ship1.gif", componente, 64, 64));
    imagens.put("inimigoBola", new TileSet("/tiles/inimigobola.gif", componente, 32, 32));
    imagens.put("inimigoAbelha", new TileSet("/tiles/inimigoabelha.gif", componente, 64, 32));
    imagens.put("premioSpeedUp", new TileSet("/tiles/premiovelocidade.gif", componente, 32, 32));
    imagens.put("premioPontos", new TileSet("/tiles/premiopontos.gif", componente, 32, 32));
    imagens.put("premioEnergia", new TileSet("/tiles/premioenergia.gif", componente, 32, 32));
    imagens.put("premioPowerUpDuplo", new TileSet("/tiles/premiotiroduplo.gif", componente, 32, 32));
    imagens.put("premioPowerUpMissil", new TileSet("/tiles/premiomissil.gif", componente, 32, 32));
    imagens.put("premioLaser", new TileSet("/tiles/premiolaser.gif", componente, 32, 32));
    imagens.put("inimigoRochaPequena", new TileSet("/tiles/inimigorochapequeno.gif", componente, 32, 32));
    imagens.put("inimigoCaracol", new TileSet("/tiles/inimigocaracol.gif", componente, 64, 64));
    imagens.put("inimigoCarraca", new TileSet("/tiles/inimigocarraca.gif", componente, 64, 64));
    imagens.put("inimigoEspinhoso", new TileSet("/tiles/inimigoespinho.gif", componente, 64, 64));
    imagens.put("inimigoVermelho", new TileSet("/tiles/inimigovermelho.gif", componente, 16, 16));
    imagens.put("inimigoRochaGrande", new TileSet("/tiles/inimigorochagrande.gif", componente, 96, 96));
    imagens.put("inimigoIndestrutivelGrande", new TileSet("/tiles/inimigoindgrande.gif", componente, 96, 96));
    imagens.put("inimigoIndestrutivelMedio", new TileSet("/tiles/inimigoindmedio.gif", componente, 64, 64));
    imagens.put("inimigoIndestrutivelPequena", new TileSet("/tiles/inimigoindpequeno.gif", componente, 32, 32));
    imagens.put("inimigoRochaMedia", new TileSet("/tiles/inimigorochamedio.gif", componente, 64, 64));
    imagens.put("premioComponenteAsa", new TileSet("/tiles/componenteasa.gif", componente, 32, 64));
    imagens.put("premioComponentePendulo", new TileSet("/tiles/componentemovel.gif", componente, 32, 32));
    imagens.put("inimigoReplicador", new TileSet("/tiles/inimigoreplicador.gif", componente, 96, 96));
    imagens.put("inimigoBigBoss", new TileSet("/tiles/inimigoboss.gif", componente, 351, 273));
    imagens.put("tiroSimples", new TileSet("/tiles/tirosimplesduplo.gif", componente, 16, 16));
    imagens.put("tiroDuplo", new TileSet("/tiles/tirosimplesduplo.gif", componente, 16, 16));
    imagens.put("tiroLaser", new TileSet("/tiles/tirolaser.gif", componente, 3, 64));
    imagens.put("tiroMissil", new TileSet("/tiles/tiromissil.gif", componente, 32, 32));
    imagens.put("explosaoPequena", new TileSet("/tiles/explosaopequena.gif", componente, 16, 16));
    imagens.put("explosaoMedia", new TileSet("/tiles/explosaomedia.gif", componente, 32, 32));
    imagens.put("explosaoGrande", new TileSet("/tiles/explosaogrande.gif", componente, 64, 64));
    imagens.put("tiroMetal", new TileSet("/tiles/tirometal.gif", componente, 16, 16));
    imagens.put("tiroEspinho", new TileSet("/tiles/tiroespinho.gif", componente, 16, 16));
  }

  public void fimDoScroll(long tempoActual) {
  	if (inimigoBoss == null)
  		passarNivel = true;
  	nave.setVelocidade(0);
  	tolerancia = 100;
		nave.getEnergyBar().setMovimento(new MovimentoLinear(0, 0, nave.getEnergyBar().sprite.getPosicao(tempoActual)));
		nave.getEnergyBar().getMovimento().iniciaMovimento(tempoActual, nave.getEnergyBar().sprite);
  }

  public long getPontuacao() {
    return nave.getPontuacao();
  }

  public int iterar(long actualTime, Rectangle areaVisivel) {
		removerObjectos(inimigos.iterator(), areaVisivel, actualTime);
		removerObjectos(inimigosOnFire.iterator(), areaVisivel, actualTime);
		removerObjectos(premios.iterator(), areaVisivel, actualTime);
		removerObjectos(tiros.iterator(), areaVisivel, actualTime);

		it = gruposInimigos.iterator();
		while (it.hasNext())
			removerObjectos(((GrupoInimigos)it.next()).getElementos().iterator(), areaVisivel, actualTime);

		it = explosoes.iterator();
		Explosao e;
		while (it.hasNext()) {
		  e = (Explosao) it.next();
		  if (e.sprite.getAnimacaoActual() == null) {
				mapa.removeSprite(e.sprite);
				it.remove();
		  }
		}

    it = inimigosOnFire.iterator();
    while (it.hasNext())
    	((Armado) it.next()).dispara(actualTime);

    if(inimigoBoss != null)
    	inimigoBoss.dispara(actualTime);

  	nave.movimentarSprite(actualTime, areaVisivel);

    if (nave.getMorreu()) {
      reiniciar(actualTime);
      return PERDEU_VIDA;
    }

    if (desistir) {
    	nave.setPontuacao(0);
    	return DESISTIR_JOGO;
    }

    if (passarNivel && !existemInimigos())
			return PASSAR_NIVEL;

    return NAO_PERDEU;
  }

  public void keyPressed(Teclado teclado, int tecla, long tempoActual) {
  	if (nave != null)
  		nave.setTeclado(teclado, tempoActual);
 		if (teclado != null && teclado.isTeclaPressionada(Teclado.DESISTIR))
 			desistir = true;
  }

  public void keyReleased(Teclado teclado, int tecla, long tempoActual) {
    if (nave != null && teclado != null && (tecla == Teclado.ESQUERDA || tecla == Teclado.DIREITA)) {
    	nave.setUltimaTecla(Nave.NENHUMA_TECLA);
    	nave.sprite.setAnimacao(Nave.VERTICAL, true, tempoActual);
    }
  }

  public void reiniciar(long tempoActual) {
		Iterator it2;

		it = inimigos.iterator();
		while (it.hasNext())
		  mapa.removeSprite(((Inimigo)it.next()).sprite);
		inimigos.clear();

		it = inimigosOnFire.iterator();
		while (it.hasNext())
		  mapa.removeSprite(((Armado)it.next()).sprite);
		inimigosOnFire.clear();
		
		it = gruposInimigos.iterator();
		while (it.hasNext()) {
			it2 = ((GrupoInimigos)it.next()).getElementos().iterator();
			while (it2.hasNext()) 
				mapa.removeSprite(((Inimigo)it2.next()).sprite);
		}
		gruposInimigos.clear();

    it = premios.iterator();
    while (it.hasNext())
      mapa.removeSprite(((Premio)it.next()).sprite);
    premios.clear();

    it = pontos.iterator();
    while (it.hasNext())
      mapa.removeSprite(((TextoPontos)it.next()).sprite);
    pontos.clear();

    it = tiros.iterator();
    while (it.hasNext())
      mapa.removeSprite(((Tiro)it.next()).sprite);
    tiros.clear();

		it = explosoes.iterator();
		while (it.hasNext())
		  mapa.removeSprite(((Explosao)it.next()).sprite);
		explosoes.clear();
		
		if (inimigoBoss != null) {
			mapa.removeSprite(inimigoBoss.sprite);
			inimigoBoss = null;
		}

		desistir = false;
		passarNivel = false;
		tolerancia = 300;
		
		if (nave.getEnergyBar() != null)
			mapa.removeSprite(nave.getEnergyBar().sprite);

		nave.reiniciar(tempoActual, (Simples)cfgTiros.get("tiroSimples"));
  }

	/*getters & setters*/

  public void setMap(SpritedTileMap sprites) {
    mapa = sprites;
  }

  public int getHitPointsCenario() {
    return hitPointsCenario;
  }

  public void setScenarioColisionValue(int capacidadeDestruicao) {
		hitPointsCenario = capacidadeDestruicao;
  }
  
  public Nave getNave() {
	  return nave;
  }

  public void setNave(Nave nave) {
	  this.nave = nave;
  }

  public void setDesistir(boolean opcao) {
  	desistir = opcao;
  }
  
  public void setPassarNivel(boolean opcao) {
  	passarNivel = opcao;
  }

	/*metodos gerais*/
	
	private boolean existemInimigos() {
		if (inimigos.isEmpty() && inimigosOnFire.isEmpty())
			return false;
		return true;
	}
  
  private void removerObjectos(Iterator iteradorLista, Rectangle areaVisivel, long actualTime) {
  	Figura objecto;
  	while (iteradorLista.hasNext()) {
  		objecto = (Figura)iteradorLista.next();
  		if (objecto.sprite.getPosicao(actualTime).getY() > areaVisivel.height + tolerancia ||
  				objecto.sprite.getPosicao(actualTime).getY() < areaVisivel.getY() - tolerancia ||
					objecto.sprite.getPosicao(actualTime).getX() > areaVisivel.width + tolerancia || 
					objecto.sprite.getPosicao(actualTime).getX() < areaVisivel.getX() - tolerancia) {

  			objecto.sprite.removeSpriteColisionListener(this, "trataColisao");
  			mapa.removeSprite(objecto.sprite);
  			iteradorLista.remove();
  		}
  	}
  }

}
