package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Explos�o de um destruidor do Tiny
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class ExplosaoDestruidores extends Explosao {

    public ExplosaoDestruidores(String nome, Ponto posicao, Nivel nivel, long tempo) {
        super(nome, posicao, nivel, tempo, new AnimacaoSprite(nivel.getImagem("explosaoDestruidor"), new int[] {}, new int[] {}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 0, 50));
    }

}
