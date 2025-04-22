package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Tiro Direito da G�rgula
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class TiroGargulaDireito extends TiroGargula {

    public TiroGargulaDireito(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento) {
        super(nome, posicao, nivel, velocidade, deslocamento, new AnimacaoSprite(nivel.getImagem("tiroGargula"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
    }

    public TiroGargulaDireito(TiroGargulaDireito tiro) {
        super(tiro);
    }

}
