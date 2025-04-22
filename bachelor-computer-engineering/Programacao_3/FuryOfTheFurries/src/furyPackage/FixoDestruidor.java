package furyPackage;

import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa objectos fixos do nível que destroem o Tiny
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class FixoDestruidor extends ObjectoDoNivel implements DestruidorDoTiny {

    public FixoDestruidor() {
    }

    public FixoDestruidor(String nome, Ponto posicao, Nivel nivel) {
        super(nome, posicao, nivel);
    }

    /**
     * Faz desaparecer a corda
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado){
        corda.remover(resultado.tempoColisao);
    }
}
