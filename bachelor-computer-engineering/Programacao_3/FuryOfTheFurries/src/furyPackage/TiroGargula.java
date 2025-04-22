package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Tiro da Gárgula
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class TiroGargula extends Tiro implements DestruidorDoTiny {

    public TiroGargula(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, AnimacaoSprite animacao) {
        super(nome, posicao, nivel, velocidade, deslocamento, animacao);
    }

    public TiroGargula(TiroGargula tiro) {
        super(tiro, tiro.getPosicao());
    }

    /**
     * Desfaz um tiro da gárgula 
     */
    public void explodir(long tempo) {
        new ExplosaoTiroGargula("Explosao" + getNome(), getSprite().getUltimaPosicao(), getNivel(), tempo);
        super.explodir(tempo);
    }

    /**
     * Lança um tiro de gárgula
     */
    public void lancar(long tempo) {
        super.lancar(tempo);
    }

    /**
     * Colide com o Tiny e mata-o
     */
    public void trataColisao(Tiny heroi, ResultadoColisao resultado) {
        heroi.morrer();
        explodir(resultado.tempoColisao);
    }

    /**
     * Trata a colisão com a corda, removendo-a
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado) {
        corda.remover(resultado.tempoColisao);
    }

}
