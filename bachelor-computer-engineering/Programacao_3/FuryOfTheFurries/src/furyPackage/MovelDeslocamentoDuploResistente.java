package furyPackage;

import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoSegmentoRectaBidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os objectos móveis que possuem um deslocamento duplo e uma capacidade de resistência
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class MovelDeslocamentoDuploResistente extends MovelDeslocamentoDuplo implements DestruidorDoTiny, DestrutivelPeloFogo, Invertivel, Reiniciavel {

    /**
     * Capacidade de resistência do objecto móvel com deslocamento duplo e resistente
     */
    private int capacidadeResistencia;

    /**
     * Armazena a posição de retorno para reiniciar o objecto
     */
    private Ponto posicaoRetorno;

    public MovelDeslocamentoDuploResistente() {
    }

    public MovelDeslocamentoDuploResistente(String nome, Ponto posicao, Ponto posicaoRetorno, Nivel nivel, double velocidade, double deslocamento, int capacidadeResistencia) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        this.capacidadeResistencia = capacidadeResistencia;
        this.posicaoRetorno = posicaoRetorno;
    }

    /**
     * Mata o objecto móvel com deslocamento duplo e resistente
     */
    public void morrer(long tempo){
        new ExplosaoDestruidores("Explosao" + getNome(), getSprite().getUltimaPosicao(), getNivel(), tempo);
        removerDoNivel();
    }

    /**
     * Inverte o sentido do movimentos do objecto móvel com deslocamento duplo e resistente
     */
    public void inverterSentido(){
        ((MovimentoSegmentoRectaBidireccional)getSprite().getMovimento()).inverterSentido();
    }

    /**
     * Decrementa a capacidade de resistência do objecto móvel com deslocamento duplo e resistente e mata-o, caso esta tenha acabado
     */
    public void decrementarEnergia(long tempo) {
        capacidadeResistencia--;
        if (capacidadeResistencia <= 0)
            morrer(tempo);
    }

    /**
     * Reinicia o objecto móvel com deslocamento duplo e resistente, colocando-o na sua posição inicial e restaurando o seu ponto de retorno
     */
    public void reiniciar(long tempo) {
        getSprite().setMovimento(new MovimentoSegmentoRectaBidireccional(getPosicao(), posicaoRetorno, getVelocidade(), tempo));
    }

    /**
     * Remove do nível o o objecto móvel com deslocamento duplo e resistente
     */
    public void removerDoNivel(){
        getSprite().removeSpriteColisionListener(this, "trataColisao");
        getNivel().getMapa().removeSprite(getSprite());
    }

    /**
     * Trata a colisão com a corda, removendo-a
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado){
        corda.remover(resultado.tempoColisao);
    }

    /**
     * Trata a colisão com um Tiny, matando-o
     */
    public void trataColisao(Tiny heroi, ResultadoColisao resultado){
        heroi.morrer();
    }

    /**
     * Trata a colisão com um objecto suportável
     */
    public void trataColisao(Plataforma plataforma, ResultadoColisao resultado){
        getSprite().getMovimento().setPosicaoActual(resultado.resultadoObjecto1.pontoArraste,resultado.tempoColisao);
        inverterSentido();
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public int getCapacidadeResistencia() {
        return capacidadeResistencia;
    }

}
