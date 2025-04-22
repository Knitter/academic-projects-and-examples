package furyPackage;

import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoSegmentoRectaBidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os objectos m�veis que possuem um deslocamento duplo e uma capacidade de resist�ncia
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class MovelDeslocamentoDuploResistente extends MovelDeslocamentoDuplo implements DestruidorDoTiny, DestrutivelPeloFogo, Invertivel, Reiniciavel {

    /**
     * Capacidade de resist�ncia do objecto m�vel com deslocamento duplo e resistente
     */
    private int capacidadeResistencia;

    /**
     * Armazena a posi��o de retorno para reiniciar o objecto
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
     * Mata o objecto m�vel com deslocamento duplo e resistente
     */
    public void morrer(long tempo){
        new ExplosaoDestruidores("Explosao" + getNome(), getSprite().getUltimaPosicao(), getNivel(), tempo);
        removerDoNivel();
    }

    /**
     * Inverte o sentido do movimentos do objecto m�vel com deslocamento duplo e resistente
     */
    public void inverterSentido(){
        ((MovimentoSegmentoRectaBidireccional)getSprite().getMovimento()).inverterSentido();
    }

    /**
     * Decrementa a capacidade de resist�ncia do objecto m�vel com deslocamento duplo e resistente e mata-o, caso esta tenha acabado
     */
    public void decrementarEnergia(long tempo) {
        capacidadeResistencia--;
        if (capacidadeResistencia <= 0)
            morrer(tempo);
    }

    /**
     * Reinicia o objecto m�vel com deslocamento duplo e resistente, colocando-o na sua posi��o inicial e restaurando o seu ponto de retorno
     */
    public void reiniciar(long tempo) {
        getSprite().setMovimento(new MovimentoSegmentoRectaBidireccional(getPosicao(), posicaoRetorno, getVelocidade(), tempo));
    }

    /**
     * Remove do n�vel o o objecto m�vel com deslocamento duplo e resistente
     */
    public void removerDoNivel(){
        getSprite().removeSpriteColisionListener(this, "trataColisao");
        getNivel().getMapa().removeSprite(getSprite());
    }

    /**
     * Trata a colis�o com a corda, removendo-a
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado){
        corda.remover(resultado.tempoColisao);
    }

    /**
     * Trata a colis�o com um Tiny, matando-o
     */
    public void trataColisao(Tiny heroi, ResultadoColisao resultado){
        heroi.morrer();
    }

    /**
     * Trata a colis�o com um objecto suport�vel
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
