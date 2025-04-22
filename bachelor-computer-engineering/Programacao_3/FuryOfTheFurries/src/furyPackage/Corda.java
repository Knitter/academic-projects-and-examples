package furyPackage;

import furyPackage.estados.EstadoCorda;
import furyPackage.estados.EstadoCordaArrecadada;
import furyPackage.estados.EstadoCordaEnganchada;
import furyPackage.estados.EstadoCordaSolta;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoSegmentoRectaUnidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Corda
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Corda extends MovelDeslocamentoDuplo implements Removivel {

    /**
     * Comprimento máximo que a corda pode atingir
     */
    public static final int COMPRIMENTO_MAXIMO = 150;

    /**
     * Posição onde a corda foi enganchada
     */
    private Ponto pontoDeEnganche;

    /**
     * Objecto enganchado pela corda
     */
    private Enganchavel enganchado;

    /**
     * Estados possíveis em que a corda pode estar:
     * Corda arrecadada - Estado da corda guardada;
     * Corda solta - Estqdo da corda em lançamento;
     * Corda enganchada - Estado da corda enganchada.
     */
    private EstadoCorda[] estados = {new EstadoCordaArrecadada(this), new EstadoCordaSolta(this), new EstadoCordaEnganchada(this)};

    /**
     * Estado actual da corda
     */
    private int estadoActual;

    private Tiny heroi;

    public Corda(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, Tiny heroi) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        this.heroi = heroi;
        this.heroi.setCorda(this);
        estadoActual = EstadoCorda.ARRECADADA;
    }

    public Corda(Corda corda){
        this(corda.getNome(), corda.getPosicao(), corda.getNivel(), corda.getVelocidade(), corda.getDeslocamento(), corda.getHeroi());
    }

    /**
     * Lança a corda (segundo o seu estado actual)
     */
    public void lancar(Ponto destino, long tempo) {
        estados[estadoActual].lancar(destino, tempo);
        actualizarMovimentoDoDono(tempo);
    }

    /**
     * Devolve o movimento da corda
     */
    public MovimentoSegmentoRectaUnidireccional getThisMovimento() {
        return (MovimentoSegmentoRectaUnidireccional) getSprite().getMovimento();
    }

    /**
     * Remove a corda do nível
     */
    public void removerDoNivel(){
        getNivel().getMapa().removeSprite(getSprite());
    }

    /**
     * Desengancha a corda
     */
    public void desenganchar(long tempo) {
        enganchado.desenganchar(this, tempo);
        enganchado = null;
        heroi.parar(tempo);
        heroi.cair(tempo);
        remover();
    }

    /**
     * Indica ao estado da corda que esta em de ser removida
     */
    public void remover(long tempo) {
        estados[estadoActual].remover(tempo);
    }

    /**
     * Remove a corda e altera-lhe o estado de forma a que possa voltar a ser lancada
     */
    public void remover() {
        removerDoNivel();
        mudarEstado(EstadoCorda.ARRECADADA);
    }

    /**
     * Muda o estado da corda para um novo estado
     */
    public void mudarEstado(int novoEstado) {
        estadoActual = novoEstado;
    }

    /**
     * Delega o tratamento da colisão com um enganchável ao estado actual da corda
     */
    public void trataColisao(Enganchavel enganchado, ResultadoColisao resultado ) {
        estados[estadoActual].trataColisao(enganchado, resultado);
    }

    /**
     * Delega o tratamento da colisão com um suportável ao estado actual da corda
     */
    public void trataColisao(Suportavel plataforma, ResultadoColisao resultado  ){
        estados[estadoActual].trataColisao(plataforma, resultado);
    }

    /**
     * Delega o tratamento da colisão com um activável ao estado actual da corda
     */
    public void trataColisao(Activavel activavel, ResultadoColisao resultado ){
        estados[estadoActual].trataColisao(activavel, resultado);
    }

    /**
     * Sustém o movimento da corda
     */
    public void suster(long tempo) {
        heroi.parar(tempo);
    }

    /**
     * Permite que a corda siga o Tiny ao actualizar o seu movimento para que este corresponda ao movimento que o Tiny tem. Por exemplo, quando o Tiny cai ou sai de cima de uma plataforma móvel
     */
    public void actualizarMovimentoDoDono(long tempo) {
        estados[estadoActual].actualizarMovimentoDoDono(tempo);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public int getEstadoActual() {
        return estadoActual;
    }

    public EstadoCorda getEstado(int estado) {
        return estados[estado];
    }

    public Enganchavel getEnganchado() {
        return enganchado;
    }

    public void setEnganchado(Enganchavel enganchado) {
        this.enganchado = enganchado;
    }

    public Ponto getPontoDeEnganche() {
        return pontoDeEnganche;
    }

    public void setPontoDeEnganche(Ponto pontoDeEnganche) {
        this.pontoDeEnganche = pontoDeEnganche;
    }

    public Tiny getHeroi() {
        return heroi;
    }
}
