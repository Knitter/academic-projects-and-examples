package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Bola de Fogo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class BolaFogo extends Tiro {

    public BolaFogo(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, AnimacaoSprite animacao) {
        super(nome, posicao, nivel, velocidade, deslocamento, animacao);
    }

    public BolaFogo(BolaFogo bola, Ponto posicao) {
        super(bola, posicao);
    }

    /**
     * Explode uma bola de fogo
     */
    public void explodir(long tempo) {
        new ExplosaoBolaFogo("Explosao" + getNome(), getSprite().getUltimaPosicao(), getNivel(), tempo);
        super.explodir(tempo);
    }

    /**
     * Lança uma bola de fogo
     */
    public void lancar(long tempo) {
        super.lancar(tempo);
    }

    /**
     * Trata a colisão de uma bola de fogo com um destruidor do tiny, reduzindo a sua capacidade de resistência
     */
    public void trataColisao(DestrutivelPeloFogo inimigo, ResultadoColisao resultado) {
        explodir(resultado.tempoColisao);
        inimigo.decrementarEnergia(resultado.tempoColisao);
    }
}
