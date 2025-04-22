package furyPackage;

import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os objectos activáveis do jogo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class Activavel extends ObjectoDoNivel {

    public Activavel() {
    }

    public Activavel(String nome, Ponto posicao, Nivel nivel) {
        super(nome, posicao, nivel);
    }

    public abstract void activar(Tiny heroi, ResultadoColisao resultado);
}
