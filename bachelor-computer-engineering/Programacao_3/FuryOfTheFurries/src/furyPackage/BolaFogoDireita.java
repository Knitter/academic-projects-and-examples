package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Bola de Fogo Direita
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class BolaFogoDireita extends BolaFogo {

    public BolaFogoDireita(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento) {
        super(nome, posicao, nivel, velocidade, deslocamento, new AnimacaoSprite(nivel.getImagem("bolaFogo"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
    }

    public BolaFogoDireita(BolaFogo bola, Ponto posicao) {
        super(bola, new Ponto(posicao.getX() + 16, posicao.getY() + 16));
    }

}
