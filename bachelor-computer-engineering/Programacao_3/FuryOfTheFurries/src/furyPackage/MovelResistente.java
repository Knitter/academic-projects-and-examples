package furyPackage;

import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoSegmentoRectaBidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os objectos móveis resistentes
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class MovelResistente extends ObjectoMovel implements DestruidorDoTiny, DestrutivelPeloFogo, Invertivel, Reiniciavel {

    /**
     * Capacidade de resistência de um destruidor do Tiny
     */
    private int capacidadeResistencia;

    public MovelResistente() {
    }

    public MovelResistente(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, int capacidadeResistencia) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        this.capacidadeResistencia = capacidadeResistencia;
    }

    /**
     * Inverte o sentido do movimento do objecto móvel resistente
     */
    public void inverterSentido(){
        ((MovimentoSegmentoRectaBidireccional)getSprite().getMovimento()).inverterSentido();
    }

    /**
     * Mata o objecto móvel resistente
     */
    public void morrer(long tempo){
        new ExplosaoDestruidores("Explosao" + getNome(), getSprite().getUltimaPosicao(), getNivel(), tempo);
        removerDoNivel();
    }

    /**
     * Decrementa a energia do objecto móvel resistente e mata-o, caso esta tenha acabado
     */
    public void decrementarEnergia(long tempo){
        capacidadeResistencia--;
        if (capacidadeResistencia <= 0)
            morrer(tempo);
    }

    /**
     * Remove o objecto móvel resistente do nível
     */
    public void removerDoNivel(){
        getSprite().removeSpriteColisionListener(this, "trataColisao");
        getNivel().getMapa().removeSprite(getSprite());
    }

    /**
     * Trata a colisão com o Tiny, matando-o
     */
    public void trataColisao(Tiny heroi, ResultadoColisao resultado){
        heroi.morrer();
    }

    /**
     * Trata a colisão com a corda, removendo-a
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado){
        corda.remover(resultado.tempoColisao);
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
