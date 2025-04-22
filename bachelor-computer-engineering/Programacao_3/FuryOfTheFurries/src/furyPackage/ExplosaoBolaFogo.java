package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Explosão de uma bola de fogo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class ExplosaoBolaFogo extends Explosao{

    ExplosaoBolaFogo(String nome, Ponto posicao, Nivel nivel, long tempo) {
        super(nome, posicao, nivel, tempo, new AnimacaoSprite(nivel.getImagem("explosaoBolaFogo"), new int[] {}, new int[] {}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 0, 50));
    }
}

