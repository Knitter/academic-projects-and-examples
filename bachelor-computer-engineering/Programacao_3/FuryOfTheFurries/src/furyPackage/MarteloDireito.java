package furyPackage;

import furyPackage.estados.HabilidadeMartelo;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Martelo Direito
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class MarteloDireito extends Martelo {

    public MarteloDireito(String nome, Ponto posicao, Nivel nivel, HabilidadeMartelo habilidadeMartelo) {
        super(nome, posicao, nivel, new AnimacaoSprite(nivel.getImagem("martelo"), new int[] {}, new int[] {2}, new int[] {}, 0, 1000, 0), habilidadeMartelo, new Ponto(16, 0));
    }

    public MarteloDireito(Martelo martelo, Ponto posicao) {
        super(martelo, posicao);
    }

}
