package furyPackage;

import java.awt.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import furyPackage.estados.Habilidade;
import jge2d.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Nivel implements INivel {
    private SpritedTileMap mapa;
    private Tiny heroi;
    private LinkedList iteraveis = new LinkedList();
    private LinkedList removiveis = new LinkedList();
    private LinkedList reiniciaveis = new LinkedList();
    private LinkedList tiros = new LinkedList();
    private Hashtable imagens = new Hashtable();
    private Hashtable portas = new Hashtable();
    private Teclado teclado;
    private boolean nivelTerminado = false;
    private Iterator it;
    private int ultimaTecla;
    private boolean desistir = false;

    public Nivel() {
    }

    public void adicionarAranha(String nome, Ponto posicaoInicial, double deslocamentoY, double velocidade, long tempo) {
        reiniciaveis.add(new Aranha(nome, posicaoInicial, this, velocidade, deslocamentoY, 3, tempo));
    }

    public void adicionarCacto(String nome, Ponto posicaoInicial, long tempo) {
        new Cacto(nome, posicaoInicial, this, tempo);
    }

    public void adicionarCampoMagneticoAmarelo(String nome, Ponto posicaoInicial, long tempo) {
        new CampoMagneticoAmarelo(nome, posicaoInicial, this, tempo, heroi.getHabilidade(Habilidade.FOGO));
    }

    public void adicionarCampoMagneticoVerde(String nome, Ponto posicaoInicial, long tempo) {
        new CampoMagneticoVerde(nome, posicaoInicial, this, tempo, heroi.getHabilidade(Habilidade.CORDA));
    }

    public void adicionarCampoMagneticoVermelho(String nome, Ponto posicaoInicial, long tempo) {
        new CampoMagneticoVermelho(nome, posicaoInicial, this, tempo, heroi.getHabilidade(Habilidade.MARTELO));
    }

    public void adicionarCanaComEspinhos(String nome, Ponto posicaoInicial, long tempo) {
        new CanaEspinhos(nome, posicaoInicial, this, tempo);
    }

    public void adicionarChave(String nome, Ponto posicaoInicial, LinkedList codigosFechadura, long tempo) {
        new Chave(nome, posicaoInicial, this, codigosFechadura, tempo);
    }

    public void adicionarCobra(String nome, Ponto posicaoInicial, double distanciaSeguranca, long tempo) {
        iteraveis.add(new Cobra(nome, posicaoInicial, this, distanciaSeguranca, 3, tempo, heroi));
    }

    public void adicionarElevador(String nome, Ponto posicaoInicial, double deslocamentoY, double velocidade, long tempo) {
        new Elevador(nome, posicaoInicial, this, deslocamentoY, velocidade, tempo);
    }

    public void adicionarEscorpiao(String nome, Ponto pontoInicial, double deslocamentoX, double velocidade, long tempo) {
        reiniciaveis.add(new Escorpiao(nome, pontoInicial, this, deslocamentoX, velocidade, 3, tempo));
    }

    public void adicionarFechadura(String nome, Ponto posicaoInicial, String codigo, String codigoPorta, long tempo) {
        new Fechadura(nome, posicaoInicial, this, codigo, (Porta)portas.get(codigoPorta.toLowerCase()), tempo);
    }

    public void adicionarGargulaDireita(String nome, Ponto posicaoInicial, int cadencia, long tempo) {
        iteraveis.add(new GargulaDireita(nome, posicaoInicial, this, 3, cadencia, tempo));
    }

    public void adicionarGargulaEsquerda(String nome, Ponto posicaoInicial, int cadencia, long tempo) {
        iteraveis.add(new GargulaEsquerda(nome, posicaoInicial, this, 3, cadencia, tempo));
    }

    public void adicionarInterruptor(String nome, Ponto posicaoInicial, String nomePorta, long tempo) {
        new Interruptor(nome, posicaoInicial, this, (Porta)portas.get(nomePorta.toLowerCase()), tempo);
    }

    public void adicionarMocho(String nome, Ponto posicaoInicial, Ponto posicaoFinal, double velocidade, long tempo) {
        reiniciaveis.add(new Mocho(nome, posicaoInicial, this, posicaoFinal, velocidade, 3, tempo));
    }

    public void adicionarMoeda(String nome, Ponto posicaoInicial, String codigoPorta, long tempo) {
        if (codigoPorta != null)
            new MoedaComPorta(nome, posicaoInicial, this, (Porta)portas.get(codigoPorta.toLowerCase()), tempo);
        else
            new Moeda(nome, posicaoInicial, this, tempo);
    }

    public void adicionarMorcego(String nome, Ponto posicaoInicial, Ponto posicaoRetorno, double velocidade, long tempo) {
        reiniciaveis.add(new Morcego(nome, posicaoInicial, this, posicaoRetorno, velocidade, 3, tempo));
    }

    public void adicionarPlataformaDestrutivelPeloMartelo(String nome, Ponto posicaoInicial, int numMarteladas, long tempo) {
        new PlataformaDestrutivelMartelo(nome, posicaoInicial, this, numMarteladas, tempo);
    }

    public void adicionarPlataformaNormal(String nome, Ponto posicaoInicial, long tempo) {
        new PlataformaFixaEnganchavel(nome, posicaoInicial, this, tempo);
    }

    public void adicionarPortaHorizontal(String nome, Ponto posicaoInicial, double velocidade, String codigo, long tempo) {
        portas.put(codigo.toLowerCase(), new PortaHorizontal(nome, posicaoInicial, this, velocidade, ((TileSet)imagens.get("plataformaPorta")).getWidth(), tempo));
    }

    public void adicionarPortaVertical(String nome, Ponto posicaoInicial, double velocidade, String codigo, long tempo) {
        portas.put(codigo.toLowerCase(), new PortaVertical(nome, posicaoInicial, this, velocidade, ((TileSet)imagens.get("plataformaPorta")).getHeight(), tempo));
    }

    public void adicionarSaida(String nome, Ponto posicaoInicial, long tempo) {
        new Saida(nome, posicaoInicial, this, tempo);
    }

    public void adicionarTeleferico(String nome, Ponto posicaoInicial, double deslocamentoX, double velocidade, long tempo) {
        new Teleferico(nome, posicaoInicial, this, deslocamentoX, velocidade, tempo);
    }

    public void adicionarTeleporte(String nome, Ponto posicaoInicial, Ponto posicaoDestino, long tempo) {
        new Teleporte(nome, posicaoInicial, this, posicaoDestino, tempo);
    }

    public ISprite adicionarTiny(String nomeObjecto, Ponto posicaoInicial, Ponto posicaoFinal, double velocidadeAndar, double velocidadeSaltar, double velocidadeAngular, double anguloMinimo, double anguloMaximo, double distanciaCentroMinima, double distanciaCentroMaxima, boolean temHabilidadeAmarela, boolean temHabilidadeVerde, boolean temHabilidadeVermelha, String habilidadeInicial, long tempoActual) {
        heroi = new Tiny(nomeObjecto, posicaoInicial, posicaoFinal, velocidadeAndar, velocidadeSaltar, velocidadeAngular, anguloMinimo, anguloMaximo, distanciaCentroMinima, distanciaCentroMaxima, temHabilidadeAmarela, temHabilidadeVerde, temHabilidadeVermelha, habilidadeInicial, tempoActual, this);
        reiniciaveis.add(heroi);
        return heroi.getSprite();
    }

    public void createTileSets(Component comp) {
        /* Tiny's */
        imagens.put("furries", new TileSet("/tiles/furries.gif", comp, 32, 32));
        imagens.put("furriesShadow", new TileSet("/tiles/furries_shadow.gif", comp, 32, 32));
        imagens.put("animacoesSeleccao", new TileSet("/tiles/animacoesSeleccao.gif", comp, 32, 32));
        /* Activáveis */
        imagens.put("moeda", new TileSet("/tiles/moeda.gif", comp, 26, 27));
        imagens.put("chave", new TileSet("/tiles/chave.GIF", comp, 32, 32));
        imagens.put("interruptor", new TileSet("/tiles/interruptor.GIF", comp, 18, 28));
        imagens.put("fechadura", new TileSet("/tiles/fechadura.GIF", comp, 32, 32));
        imagens.put("saida", new TileSet("/tiles/saida.gif", comp, 25, 31));
        imagens.put("teleporte", new TileSet("/tiles/teleporte.gif", comp, 32, 32));
        /* Plataformas */
        imagens.put("plataformaEnganchavel", new TileSet("/tiles/plataformaenganchavel.gif", comp, 64, 32));
        imagens.put("plataformaDestrutivel", new TileSet("/tiles/plataformadestrutivel.gif", comp, 32, 32));
        imagens.put("plataformaPorta", new TileSet("/tiles/plataformadaporta.GIF", comp, 32, 30));
        imagens.put("elevador", new TileSet("/tiles/elevador.gif", comp, 64, 32));
        imagens.put("teleferico", new TileSet("/tiles/teleferico.gif", comp, 64, 20));
        /* Campos Magnéticos */
        imagens.put("campoMagnetico", new TileSet("/tiles/campomagnetico.gif", comp, 32, 70));
        /* Inimigos */
        imagens.put("aranha", new TileSet("/tiles/aranha.gif", comp, 56, 38));
        imagens.put("morcego", new TileSet("/tiles/morcego.gif", comp, 58, 58));
        imagens.put("cacto", new TileSet("/tiles/cacto.gif", comp, 24, 58));
        imagens.put("mocho", new TileSet("/tiles/mocho.gif", comp, 49, 42));
        imagens.put("canaEspinhos", new TileSet("/tiles/canaComEspinhos.gif", comp, 28, 28));
        imagens.put("cobra", new TileSet("/tiles/cobra.GIF", comp, 33, 36));
        imagens.put("escorpiao", new TileSet("/tiles/escorpiao.gif", comp, 48, 44));
        imagens.put("gargula", new TileSet("/tiles/gargula.gif", comp, 16, 32));
        /* Tiros */
        imagens.put("tiroGargula", new TileSet("/tiles/tirogargula.gif", comp, 9, 8));
        imagens.put("bolaFogo", new TileSet("/tiles/bolaFogo.gif", comp, 16, 7));
        imagens.put("martelo", new TileSet("/tiles/martelo.gif", comp, 32, 32));
        /* Explosões */
        imagens.put("explosaoBolaFogo", new TileSet("/tiles/explosaopequena.gif", comp, 16, 16));
        imagens.put("explosaoDestruidor", new TileSet("/tiles/explosaomedia.gif", comp, 32, 32));
        imagens.put("explosaoGargula", new TileSet("/tiles/explosaogargula.gif", comp, 9, 16));
    }

    public long getPontuacao() {
        return heroi.getNumeroMoedasApanhadas();
    }

    public int iterar(long tempo, Rectangulo areaVisivel) {

        if (desistir)
            return DESISTIR_JOGO;

        if (nivelTerminado)
            return PASSAR_NIVEL;

        if (heroi.isMorto())
            return PERDEU_VIDA;

        verificarAreaVisivel(areaVisivel);

        it = removiveis.iterator();
        while (it.hasNext())
            removerObjecto((Removivel)it.next());
        removiveis.clear();

        it = iteraveis.iterator();
        while (it.hasNext())
            ((Iteravel)it.next()).iterar(tempo);

        return NAO_PERDEU;
    }

    public void keyPressed(Teclado teclado, int tecla, long tempo) {
        try {
            if (tecla == Teclado.DIREITA)
                heroi.moverDireita(tempo);

            if (tecla == Teclado.ESQUERDA)
                heroi.moverEsquerda(tempo);

            if (tecla == Teclado.CIMA || teclado.isTeclaPressionada(Teclado.CIMA))
                if (teclado.isTeclaPressionada(Teclado.DIREITA))
                    heroi.diagonalDireita(tempo);
                else if (teclado.isTeclaPressionada(Teclado.ESQUERDA))
                    heroi.diagonalEsquerda(tempo);
                else
                    heroi.moverCima(tempo);

            if (tecla == Teclado.BAIXO)
                heroi.moverBaixo(tempo);

            if (tecla == Teclado.DISPARAR)
                heroi.disparar(tempo);

            if (tecla == Teclado.DESISTIR)
                desistir = true;
        }
        catch (NullPointerException e) {
        }
        this.teclado = teclado;
        ultimaTecla = tecla;
    }

    public void actualizarTeclado(long tempo) {
        keyPressed(teclado, ultimaTecla, tempo);
    }

    public void keyReleased(Teclado teclado, int tecla, long tempo) {
        try {
            if (!(teclado.isTeclaPressionada(Teclado.DIREITA) || teclado.isTeclaPressionada(Teclado.ESQUERDA)))
                heroi.parar(tempo);
        }
        catch(NullPointerException e) {
        }
        this.teclado = teclado;
        ultimaTecla = 0;
    }

    public void reiniciar(long tempo) {
        it = reiniciaveis.iterator();
        while (it.hasNext())
            ((Reiniciavel)it.next()).reiniciar(tempo);
        portas.clear();
    }

    public void setMap(SpritedTileMap sprites) {
        mapa = sprites;
    }

    public SpritedTileMap getMapa() {
        return mapa;
    }

    public void removerObjecto(Removivel objecto) {
        objecto.removerDoNivel();
    }

    public void removerIteraveis(Iteravel objecto){
        iteraveis.remove(objecto);
    }

    public void removerRemovivel(Removivel removivel) {
        removiveis.remove(removivel);
    }

    public void removerTiro(Tiro tiro){
        tiros.remove(tiro);
    }

    public TileSet getImagem(String nomeImagem) {
        return (TileSet) imagens.get(nomeImagem);
    }

    public void adicionarTiro(Tiro tiro){
        tiros.add(tiro);
    }

    public void adicionarIteravel(Iteravel iteravel) {
        iteraveis.add(iteravel);
    }

    public void adicionarRemovivel(Removivel removivel) {
        removiveis.add(removivel);
    }

    public void terminarNivel() {
        nivelTerminado = true;
    }

    private void verificarAreaVisivel(Rectangulo areaVisivel){
        Rectangulo area  = new Rectangulo(areaVisivel.getX() - 100, areaVisivel.getY(), areaVisivel.getWidth() + 100, areaVisivel.getHeight());
        Tiro aux;

        Iterator it = tiros.iterator();
        while(it.hasNext()) {
            aux = (Tiro)it.next();
            if(!area.contains(aux.getSprite().getUltimaPosicao()))
                adicionarRemovivel(aux);
        }
     }
}
