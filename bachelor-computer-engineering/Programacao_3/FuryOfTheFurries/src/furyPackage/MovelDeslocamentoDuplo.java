package furyPackage;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os objectos m�veis que possuem um segundo deslocamento
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class MovelDeslocamentoDuplo extends ObjectoMovel {

    public MovelDeslocamentoDuplo() {
    }

    /**
     * @param deslocamento - Deslocamento secund�rio do objecto
     */
    public MovelDeslocamentoDuplo(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento) {
        super(nome, posicao, nivel, velocidade, deslocamento);
    }

}
