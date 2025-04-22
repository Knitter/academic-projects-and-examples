package furyPackage;

import java.util.Iterator;
import java.util.LinkedList;
import furyPackage.estados.*;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;
import jge2d.jogo.movimentos.Movimento;
import jge2d.jogo.movimentos.MovimentoTinyLivre;
import jge2d.jogo.movimentos.MovimentoTinyPenduradoNaCorda;
import jge2d.jogo.movimentos.MovimentoTinySuportado;
import jge2d.jogo.movimentos.MovimentoVelocidadeComSentido;


/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Tiny - O Herói
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Tiny extends ObjectoComVelocidade implements Iteravel, Removivel, Reiniciavel {
    /**
     * Estado possíveis que o Tiny pode estar
     */
    private EstadoTiny[] estados;

    /**
     * Estado actual do Tiny
     */
    private int estadoActual;

    /**
     * Habilidades possíveis que o Tiny pode ter
     */
    private Habilidade[] habilidades;

    /**
     * Habilidade actualmente seleccionada
     */
    private int habilidadeActual;

    /**
     * Habilidade inicial do Tiny
     */
    private int habilidadeInicial;

    /**
     * Posição inicial do Tiny
     */
    private Ponto posicaoInicial;
    private String nomeAnimacaoAnterior;

    /**
     * Saco de chaves
     */
    private LinkedList saco = new LinkedList();

    /**
     * Número actual de moedas apanhadas pelo Tiny no nível
     */
    private int numeroMoedasApanhadas;

    /**
     * Plataforma em que o Tiny está suportado
     */
    private Suportavel plataforma;

    /**
     * Corda que o Tiny possui da habilidade corda
     */
    private Corda corda;

    /**
     * Indica se o Tiny está morto ou não
     */
    private boolean morto;

    /**
     * Indica se o Tiny está a rebolar ou não
     */
    private boolean rebolar;

    /**
     * Guarda o angulo mínimo
     */
    private double anguloMinimo;

    /**
     * Guarda o angulo máximo
     */
    private double anguloMaximo;

    /**
     * Orientações possíveis do Tiny
     * Esquerda, Direita e Parado
     */
    private Orientacao[] orientacoes = new Orientacao[] {new OrientacaoEsquerda(this), new OrientacaoParado(this), new OrientacaoDireita(this)};

    /**
     * Orientação actual do Tiny
     */
    private int orientacao = Orientacao.DIREITA;

    public Tiny(String nome, Ponto posicaoInicial, Ponto posicaoFinal, double velocidadeAndar, double velocidadeSaltar, double velocidadeAngular, double anguloMinimo, double anguloMaximo, double distanciaCentroMinima, double distanciaCentroMaxima, boolean temHabilidadeAmarela, boolean temHabilidadeVerde, boolean temHabilidadeVermelha, String habilidadeInicial, long tempoActual, Nivel nivel) {
        super(nome, posicaoInicial, nivel, velocidadeAndar);
        this.posicaoInicial = posicaoInicial;
        this.anguloMinimo = anguloMinimo;
        this.anguloMaximo = anguloMaximo;

        estados = new EstadoTiny[] {
            new EstadoTinySeleccao(this),
            new EstadoTinySuportado(this, new MovimentoTinySuportado(posicaoInicial, velocidadeAndar, tempoActual)),
            new EstadoTinyLivre(this, new MovimentoTinyLivre(posicaoInicial, posicaoFinal, velocidadeAndar, velocidadeSaltar, tempoActual)),
            new EstadoTinyPenduradoNaCorda(this, new MovimentoTinyPenduradoNaCorda(posicaoInicial, new Ponto(), anguloMinimo - 10, anguloMaximo + 10, distanciaCentroMinima, distanciaCentroMaxima, velocidadeAngular, tempoActual))
        };
        this.estadoActual = EstadoTiny.LIVRE;

        setSprite(new Sprite(nome, this, getMovimentoActual()));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        nivel.getMapa().addSprite(getSprite());

        habilidades = new Habilidade[] {
            new HabilidadeSeleccao(this),
            new HabilidadeFogo(this, temHabilidadeAmarela),
            new HabilidadeMartelo(this, temHabilidadeVermelha),
            new HabilidadeCorda(this, temHabilidadeVerde)
        };
        if (habilidadeInicial.compareToIgnoreCase("vermelha") == 0)
            habilidadeActual = Habilidade.MARTELO;
        else if (habilidadeInicial.compareToIgnoreCase("verde") == 0)
            habilidadeActual = Habilidade.CORDA;
        else
            habilidadeActual = Habilidade.FOGO;
        this.habilidadeInicial = habilidadeActual;
    }

    /**
     * Muda o estado actual do tiny
     */
    public void mudarEstadoActual(int novoEstado) {
        estadoActual = novoEstado;
    }

    /**
     * Incrementa o número de moedas que o tiny já apanhou
     */
    public void incrementarMoedasApanhadas() {
        numeroMoedasApanhadas++;
    }

    /**
     * Faz o Tiny cair quando este deixa de estar suportado
     */
    public void deixarDeEstarSuportado(long tempo) {
        cair(tempo);
    }

    /**
     * Mata o tiny
     */
    public void morrer() {
        morto = true;
    }

    /**
     * Diz à habilidade actual para disparar
     */
    public void disparar(long tempo) {
        habilidades[habilidadeActual].disparar(tempo);
    }

    /**
     * Pede ao estado para mover o tiny para cima
     */
    public void moverCima(long tempo){
        estados[estadoActual].moverCima(tempo);
    }

    /**
     * Pede ao estado para mover para baixo
     */
    public void moverBaixo(long tempo){
        estados[estadoActual].moverBaixo(tempo);
    }

    /**
     * Pede ao estado actual para deslocar o tiny para a esquerda e verifica se o tiny ainda está suportado. Caso não esteja este passa para o estado livre
     */
    public void moverEsquerda(long tempo){
        estados[estadoActual].moverEsquerda(tempo);
        orientacao = Orientacao.ESQUERDA;
        ((HabilidadeFogo)habilidades[Habilidade.FOGO]).setUltimaOrientacao(orientacao);
    }

    /**
     * Pede ao estado actual para deslocar o tiny para a direita e verifica se o tiny ainda está suportado. Caso não esteja este passa para o estado livre
     */
    public void moverDireita(long tempo){
        estados[estadoActual].moverDireita(tempo);
        orientacao = Orientacao.DIREITA;
        ((HabilidadeFogo)habilidades[Habilidade.FOGO]).setUltimaOrientacao(orientacao);
    }

    /**
     * Coloca o Tiny no estado livre e fá-lo cair
     */
    public void cair(long tempo) {
        mudarEstadoActual(EstadoTiny.LIVRE);
        ((MovimentoVelocidadeComSentido)getMovimentoActual()).setSentidoDeslocamento(getOrientacaoActual().getSentido());
        getMovimentoActual().setPosicaoActual(getSprite().getUltimaPosicao(), tempo);
        getSprite().setMovimento(getMovimentoActual());
        corda.actualizarMovimentoDoDono(tempo);
        getNivel().adicionarRemovivel(this);
    }

    /**
     * Pede ao estado para parar o tiny
     */
    public void parar(long tempo) {
        estados[estadoActual].parar(tempo);
        orientacao = Orientacao.PARADO;
    }

    /**
     * Muda a habilidade actual para uma nova habilidade
     */
    public void mudarHabilidade(int habilidade) {
        habilidadeActual = habilidade;
    }

    /**
     * Permite seleccionar a próxima habilidade disponível, caso exista
     */
    public int seleccionarProximaHabilidade() {
        int actual, inicial;
        actual = inicial = ((HabilidadeSeleccao)habilidades[habilidadeActual]).getHabilidadeSeleccionada();
        if (inicial == 0)
            return verificarHabilidadeDisponivel();
        else {
            if (actual == habilidades.length - 1)
                actual = 0;
            while (!habilidades[++actual].isDisponivel()) {
                if (actual == inicial)
                    return actual;
                if (actual == habilidades.length - 1)
                    actual = 0;
            }
            return actual;
        }
    }

    /**
     * Permite seleccionar a habilidade disponível anterior, caso exista
     */
    public int selecionarHabilidadeAnterior() {
        int actual, inicial;
        actual = inicial = ((HabilidadeSeleccao)habilidades[habilidadeActual]).getHabilidadeSeleccionada();
        if (inicial == 0)
            return verificarHabilidadeDisponivel();
        else {
            if (actual == 0)
                actual = habilidades.length;
            while (!habilidades[--actual].isDisponivel()) {
                if (actual == inicial)
                    return actual;
                if (actual == 0)
                    actual = habilidades.length;
            }
            return actual;
        }
   }

    /**
     * Verifica se existe alguma habilidade disponível
     */
    private int verificarHabilidadeDisponivel() {
        for (int i = 1; i < habilidades.length; i++)
            if (habilidades[i].isDisponivel())
                return i;
        return 0;
    }

    /**
     * Selecciona a habilidade de selecção
     */
    public void seleccionarHabilidadeSeleccao() {
        ((HabilidadeSeleccao)habilidades[Habilidade.SELECCAO]).setHabilidadeSelecionada(habilidadeActual);
        mudarHabilidade(Habilidade.SELECCAO);
    }

    /**
     * Selecciona uma nova habilidade
     */
    public void seleccionarHabilidadeActual(int habilidade) {
        habilidadeActual = habilidade;
    }

    /**
     * Adiciona uma chave ao saco de chaves do tiny
     */
    public void adicionarChave(Chave chave) {
        saco.add(chave);
    }

    /**
     * Percorre o saco de chaves e verifica se tem alguma chave que possa usar na fechadura. Em caso afirmativo pede à fechadura para abrir a porta
     */
    public void abrirFechadura(Fechadura fechadura, long tempo) {
        Iterator it;
        it = saco.iterator();
        while (it.hasNext())
            if (fechadura.verificarChave((Chave)it.next()))
                fechadura.abrirPorta(tempo);
    }

    /**
     * Reinicia o Tiny
     */
    public void reiniciar(long tempo){
        morto = false;
        reiniciarHabilidades();
        corda.remover();
        getMovimentoActual().setPosicaoActual(posicaoInicial, tempo);
        getSprite().setAnimacao(getHabilidadeActual().getAnimacaoFrente(), false, tempo);
        nomeAnimacaoAnterior = Habilidade.NOME_FRENTE;
        cair(tempo);
    }

    /**
     * Pede ao estado para mover o tiny para a diagonal direita
     */
    public void diagonalDireita(long tempo) {
        estados[estadoActual].diagonalDireita(tempo);
    }

    /**
     * Pede ao estado para mover o tiny para a diagonal esquerda
     */
    public void diagonalEsquerda(long tempo) {
        estados[estadoActual].diagonalEsquerda(tempo);
    }

    /**
     * Manda o estado actual iterar
     *
     * @param tempo long
     */
    public void iterar(long tempo) {
        estados[estadoActual].iterar(tempo);
    }

    /**
     * Se o Tiny tiver a mesma habilidade que o campo magnético que atravessou, esta é-lhe retirada, e se o Tiny estiver na habilidade de selecção e atravessar um campo magnético, este atribui-lhe automáticamente a sua respectiva habilidade
     */
    public void corrigirHabilidadeActual(int novaHabilidade, long tempo) {
        if(habilidadeActual == novaHabilidade) {
            mudarHabilidade(Habilidade.SELECCAO);
            getSprite().setAnimacao(HabilidadeSeleccao.NOME_HABILIDADE + nomeAnimacaoAnterior, false , tempo);
        }
        else if(habilidadeActual == Habilidade.SELECCAO && habilidades[novaHabilidade].isDisponivel()) {
            mudarHabilidade(novaHabilidade);
            getSprite().setAnimacao(habilidades[novaHabilidade].toString() + nomeAnimacaoAnterior, false , tempo);
        }
    }

    /**
     * Faz o Tiny parar de iterar
     */
    public void removerDoNivel() {
        getNivel().removerIteraveis(this);
    }

    /**
     * Pede a todas as habilidades para reiniciar a sua disponibilidade
     */
    private void reiniciarHabilidades() {
        habilidadeActual = habilidadeInicial;
        for (int i = 0; i < habilidades.length; i++)
            habilidades[i].reiniciarDisponibilidade();
    }

    /**
     * Diz se o Tiny encontra-se a rebolar
     */
    public void aRebolar() {
        rebolar = true;
    }

    /**
     * Pára de rebolar o Tiny
     */
    public void deixarDeRebolar() {
        rebolar = false;
    }

    /**
     * Pede ao estado actual para deixar de estar suportado
     */
    public void desSuportar(long tempo) {
        estados[estadoActual].desSuportar(tempo);
    }

    /**
     * Pede ao activável para se activar
     */
    public void trataColisao(Activavel activavel, ResultadoColisao resultado) {
        activavel.activar(this, resultado);
    }

    /**
     * Pede ao estado actual para tratar a colisão com um objecto suportável
     */
    public void trataColisao(Suportavel plataforma, ResultadoColisao resultado) {
        ((EstadoTinyComMovimento)estados[estadoActual]).trataColisao(plataforma, resultado);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public double getAnguloMaximo() {
        return anguloMaximo;
    }

    public double getAnguloMinimo() {
        return anguloMinimo;
    }

    public Corda getCorda() {
        return corda;
    }

    /**
     * Devolve o movimento actual do Tiny segundo o seu estado actual
     */
    public Movimento getMovimentoActual() {
        return ((EstadoTinyComMovimento)estados[estadoActual]).getMovimento();
    }

    public int getNumeroMoedasApanhadas() {
        return numeroMoedasApanhadas;
    }

    public Habilidade getHabilidadeActual() {
        return habilidades[habilidadeActual];
    }

    public Suportavel getPlataforma() {
        return plataforma;
    }

    public void setCorda(Corda corda) {
        this.corda = corda;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setNomeAnimacaoAnterior(String nomeAnimacao) {
        nomeAnimacaoAnterior = nomeAnimacao;
    }

    public EstadoTiny getEstadoActual() {
        return estados[estadoActual];
    }

    public EstadoTiny getEstado(int estado) {
        return estados[estado];
    }

    public void setPlataforma(Suportavel plataforma) {
        this.plataforma = plataforma;
    }

    public Habilidade getHabilidade(int indice) {
        return habilidades[indice];
    }

    public Orientacao getOrientacaoActual() {
        return orientacoes[orientacao];
    }

    public Orientacao getOrientacao(int orientacao) {
        return orientacoes[orientacao];
    }

    public int getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(int orientacao) {
        this.orientacao = orientacao;
    }

    public boolean isRebolar(){
        return rebolar;
    }
}
