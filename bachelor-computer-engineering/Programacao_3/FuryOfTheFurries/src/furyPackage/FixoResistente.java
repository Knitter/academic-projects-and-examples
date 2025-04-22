package furyPackage;

import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa objectos fixos do nível que destroem o Tiny e que podem ser destruídos por várias bolas de fogo, conforme a sua capacidade de resistência
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class FixoResistente extends ObjectoDoNivel implements DestrutivelPeloFogo, DestruidorDoTiny, Iteravel {
    /**
     * Capacidade de resistência dos inimigos fixos resistentes
     */
    private int capacidadeResistencia;

    public FixoResistente() {
    }

    /**
     * @param capacidadeResistencia - Define a capacidade de resistência de um destruidor do Tiny
     */
    public FixoResistente(String nome, Ponto posicao, Nivel nivel, int capacidadeResistencia) {
        super(nome, posicao, nivel);
        this.capacidadeResistencia = capacidadeResistencia;
    }

    /**
     * Mata o destruidor do Tiny
     */
    public void morrer(long tempo){
        new ExplosaoDestruidores("Explosao" + getNome(), getSprite().getUltimaPosicao(), getNivel(), tempo);
        getNivel().adicionarRemovivel(this);
    }

    /**
     * Decrementa a capacidade de resistência de um destruidor do Tiny, morrendo caso tenha chegado ao fim
     */
    public void decrementarEnergia(long tempo){
        capacidadeResistencia--;
        if (capacidadeResistencia <= 0)
            morrer(tempo);
    }

    /**
     * Remove do nível o destruidor do Tiny
     */
    public void removerDoNivel(){
        getSprite().removeSpriteColisionListener(this, "trataColisao");
        getNivel().getMapa().removeSprite(getSprite());
        getNivel().removerIteraveis(this);
    }

    /**
     * Mata o Tiny quando este colide com o destruidor do tiny
     */
    public void trataColisao(Tiny heroi, ResultadoColisao resultado){
        heroi.morrer();
    }

    /**
     * Faz desaparecer a corda
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado){
        corda.remover(resultado.tempoColisao);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public int getCapacidadeResistencia() {
        return capacidadeResistencia;
    }
}
