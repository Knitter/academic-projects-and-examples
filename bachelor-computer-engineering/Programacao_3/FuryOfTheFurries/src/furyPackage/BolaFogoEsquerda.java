package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Bola de Fogo Esquerda
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class BolaFogoEsquerda extends BolaFogo {

    public BolaFogoEsquerda(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento) {
        super(nome, posicao, nivel, velocidade, -deslocamento, new AnimacaoSprite(nivel.getImagem("bolaFogo"), new int[] {}, new int[] {2}, new int[] {}, 0, 1000, 0));
    }

    public BolaFogoEsquerda(BolaFogo bola, Ponto posicao) {
        super(bola, new Ponto(posicao.getX(), posicao.getY() + 16));
    }

}
