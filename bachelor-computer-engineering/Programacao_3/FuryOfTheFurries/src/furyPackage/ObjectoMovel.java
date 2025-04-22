package furyPackage;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa os objectos móveis que possuem atributo movimento
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class ObjectoMovel extends ObjectoComVelocidade {

    /**
     * Deslocamento do objecto num dos eixos
     */
    private double deslocamento;

    public ObjectoMovel() {
    }

    /**
     * @param deslocamento - Deslocamento do objecto
     */
    public ObjectoMovel(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento) {
        super(nome, posicao, nivel, velocidade);
        this.deslocamento = deslocamento;
    }

    public double getDeslocamento() {
        return deslocamento;
    }

}
